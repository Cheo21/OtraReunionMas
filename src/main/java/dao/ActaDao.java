/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Acta;
import entidades.Reunion;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author jg211
 */
public class ActaDao extends AbstractDao<Acta> {
    
    public ActaDao(){
    super.settClass(Acta.class);
    }

    @Override
    public Optional<Acta> get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    
    public List<Acta> findActasReunionesAntiguasQuery(){
    
    String querySql = "Select a FROM "+ Acta.class.getSimpleName() +" a WHERE a.runion.fecha < :ayer";
    
    LocalDateTime  ayer = LocalDateTime.now().minus(1, ChronoUnit.DAYS);
    Query query = getEntityManager().createQuery(querySql);
    query.setParameter("ayer", ayer);
    return query.getResultList();
    
    }
    
    
    public List<Acta> findActasReunionesAntiguasCriteria(){
    
    
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(Acta.class);
        Root<Acta> rootActa  = criteriaQuery.from(Acta.class);
        Join<Acta, Reunion> joinReunion = rootActa.join("reunion", JoinType.INNER);
      
        Predicate fechaAyer = cb.lessThan(joinReunion.get("fecha"), LocalDateTime.now().minus(1, ChronoUnit.DAYS));
        
        criteriaQuery.where(fechaAyer);
        
        Query query = getEntityManager().createQuery(criteriaQuery);
        return query.getResultList();
    
    
    }
    
    
}
