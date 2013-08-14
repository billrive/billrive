/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

/**
 *
 * @author uhsarp
 */
@Repository("mySqlDao")
public class MySqlDao  {

  @Resource(name="entityManagerFactory")
  private  EntityManagerFactory factory;
//    @Resource(name="sessionFactory")
//    @Autowired
//    @Qualifier("sessionFactory")
//    SessionFactory sessionFactory;
  
  public List<Bill> getBills(){
     
      EntityManager em = factory.createEntityManager();
        try {
             Query q = em.createQuery("select t from Bill t");
             List<Bill> todoList = q.getResultList();
             return q.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
      
  }
    
    public void saveBill(){
        
//         factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager em = factory.createEntityManager();
    
    Query q = em.createQuery("select t from Bill t");
    List<Bill> todoList = q.getResultList();
    for (Bill todo : todoList) {
      System.out.println(todo);
    }
    System.out.println("Size: " + todoList.size());

    // Create new todo
    em.getTransaction().begin();
//  Bill bill = new Bill("Costco", new DateTime(), 6L, "Costo bill", 6L, 3L);
//   Bill bill = todoList.get(0);
//   bill.set
//    em.persist(bill);
    em.getTransaction().commit();

    em.close();
    
        
      
        
  
    
    }
    
}
