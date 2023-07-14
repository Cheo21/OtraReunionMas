/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Sala;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author jg211
 */
public class SalaDao extends AbstractDao<Sala> {
    
    
    
    public SalaDao(){
        settClass(Sala.class);
    }
    
    
    
    public List<Sala> findSalasParaNQuery(int n){
    String qlString = "Select s FROM "+ Sala.class.getSimpleName() + " WHERE s.capacidad >= ?1";
    Query query = getEntityManager().createQuery(qlString);
    query.setParameter(1, n);
    return query.getResultList();
    
    }
    
    
    
    
    public List<Sala> findSalasParanNCriteria(int n){
    
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(Sala.class);
        Root<Sala> root  = criteriaQuery.from(Sala.class);
        criteriaQuery.select(root).where(cb.ge(root.get("capacidad"), n));
        Query query = getEntityManager().createQuery(criteriaQuery);
        
        return query.getResultList();
    
    
    }
    
    
    
    public List<Sala> findSalasDecuadasParanNCriteria(int n){
    
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(Sala.class);
        Root<Sala> root  = criteriaQuery.from(Sala.class);
        
        Predicate capacidadMinima= cb.ge(root.get("capacidad"), n);
        Predicate capacidadMaxima = cb.lessThanOrEqualTo(root.get("capacidad"), n);
        Predicate rangoCapacidad = cb.and(capacidadMaxima, capacidadMinima);
        
        
        
        criteriaQuery.select(root).where(rangoCapacidad);
        Query query = getEntityManager().createQuery(criteriaQuery);
        
        return query.getResultList();
    
    
    }
    
}
