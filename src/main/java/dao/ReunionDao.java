package dao;



import entidades.Persona;
import entidades.Reunion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class ReunionDao extends AbstractDao<Reunion>{

    public ReunionDao(){
        settClass(Reunion.class);
    }

    public Reunion proximaReunion(){
        String qlString = "SELECT r FROM "+Reunion.class.getSimpleName()+" r WHERE r.fecha > CURRENT_TIMESTAMP ORDER BY r.fecha";
        Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
        return (Reunion) query.getSingleResult();
    }
    
    public List<Reunion> reunionesMayana(){
        String qlString = "SELECT r FROM " + Reunion.class.getSimpleName()+ " r WHERE (r.fecha between ?1 and ?2)";
        Query query = getEntityManager().createQuery(qlString);
        LocalDate mayana = LocalDate.now().plus(1, ChronoUnit.DAYS);
        query.setParameter(1, mayana.atStartOfDay());
        query.setParameter(2,mayana.plus(1, ChronoUnit.DAYS).atStartOfDay());
        return query.getResultList();


    }
    
//  Tipado seguro: TypedQuery<T> proporciona un mecanismo de tipado seguro para las consultas.
//  Esto significa que puedes especificar el tipo de objeto que esperas recibir como resultado de
//  la consulta. Por ejemplo, si esperas que la consulta devuelva una lista de entidades de tipo
//  Person, puedes declarar la consulta como TypedQuery<Person>. Esto permite que el compilador realice
//  comprobaciones de tipo en tiempo de compilación y te brinda una mayor seguridad en la
//  manipulación de los resultados de la consulta. En contraste, la interfaz Query no proporciona
//  tipado seguro y requiere que realices conversiones de tipos manualmente.
    
    	public List<Reunion> reunionesParticipante(String numEmple) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Reunion> criteriaQuery = cb.createQuery(Reunion.class);

		Root<Persona> fromPersona = criteriaQuery.from(Persona.class);
		criteriaQuery.where(cb.equal(fromPersona.get("numeroEmpleado"), numEmple));

		Join<Persona, Reunion> joinReunion = fromPersona.join("reuniones", JoinType.INNER);

		CriteriaQuery<Reunion> cq = criteriaQuery.multiselect(joinReunion);
		TypedQuery<Reunion> query = getEntityManager().createQuery(cq);
		return query.getResultList();
	}
}