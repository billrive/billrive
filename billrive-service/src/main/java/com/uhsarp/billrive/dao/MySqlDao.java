/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uhsarp
 */
@Repository("mySqlDao")
public class MySqlDao  {
     private static final String PERSISTENCE_UNIT_NAME = "billrive";
  private static EntityManagerFactory factory;
//    @Resource(name="sessionFactory")
//    @Autowired
//    @Qualifier("sessionFactory")
//    SessionFactory sessionFactory;
    
    public void saveBill(){
        
         factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    
    Query q = em.createQuery("select t from Bill t");
    List<Bill> todoList = q.getResultList();
    for (Bill todo : todoList) {
      System.out.println(todo);
    }
    System.out.println("Size: " + todoList.size());

    // Create new todo
    em.getTransaction().begin();
  Bill bill = new Bill("Costco", new DateTime(), 2L, "Costo bill", 2L, 1L);
//   Bill bill = todoList.get(0);
//   bill.set
    em.persist(bill);
    em.getTransaction().commit();

    em.close();
    
        
      
        
  
    
    }
    
}
