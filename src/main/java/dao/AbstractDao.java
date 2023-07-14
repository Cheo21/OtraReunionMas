package dao;



import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import util.EntityManagerUtil;

public abstract class AbstractDao<T> implements Dao<T>{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    //Referencia de la clase que hace implementa esta clase, pudiendo tener metadata de la case
    //como nombre de clase, nombre de metodos, constructores y demas
    private Class<T> tClass;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> gettClass() {
        return tClass;
    }




    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }

    /**
     * @param id
     * @return
     */
    
    public Optional<T> get(int id) {
        return Optional.ofNullable(entityManager.find(tClass, id));
    }

    /**
     * @return
     */
    @Override
    public List<T> getAll() {
        String qlString = "FROM "+ tClass.getSimpleName()+ " r";
        Query query = entityManager.createQuery(qlString);
        return query.getResultList();
    }
    //Eje
    /**
     * @param t
     */
    @Override
    public void save(T t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));
    }

    /**
     * @param t
     */
    @Override
    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    /**
     * @param t
     */
    @Override
    public void delete(T t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));
    }


    /* se le manda una funcion como parametro, la misma ejecuta la funcion (puede ser cualquiera del crud, esto porque
        para todas las funciones se tiene que evaluar lo siguiente)

     */
    private void executeInsideTransaction(Consumer<EntityManager> action){
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin(); //Marca un inicion en la transaccion, como un check point si todo explota
            action.accept(entityManager); //ejecuta la accion que paso por parametro
            tx.commit(); //si la linea anterior no lanza una excepcion todo los cambios se vuelven permanetes
        }catch (RuntimeException e){
            tx.rollback(); //Una excepcion se vuelve atras todo
            throw e;
        }
    }
}