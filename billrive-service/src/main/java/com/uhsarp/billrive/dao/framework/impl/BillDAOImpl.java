/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework.impl;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.uhsarp.billrive.dao.framework.BillDAO;
import com.uhsarp.billrive.domain.Bill;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanth Batchu
 */
@Repository("billDAO")
@Transactional
public class BillDAOImpl  implements BillDAO{
//public class BillDAOImpl extends JpaConfig  implements BillDAO{

        @PersistenceContext
	private EntityManager em;
    
    public Bill find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill[] find(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill getReference(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill[] getReferences(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Bill... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill merge(Bill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Bill[] merge(Bill... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
    public Bill save(Bill bill) {
        bill.getBillSimpleEntry().setBillId(null);
        if (bill.getId() == null) {
			em.persist(bill);
                        em.flush();
                        em.close();
			return bill;
		} else {
			return em.merge(bill);
		}
    }

    public Bill[] save(Bill... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean remove(Bill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Bill... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removeById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeByIds(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Bill> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <RT> List<RT> search(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <RT> RT searchUnique(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int count(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <RT> SearchResult<RT> searchAndCount(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isAttached(Bill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void refresh(Bill... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Bill t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Bill t, ExampleOptions eo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Bill> getBillsByGroupId(Long groupId) {
       return em.createQuery("select t from Bill t WHERE t.groupId = :groupId")
//       return this.getEntityManager().createQuery("select t from Bill t WHERE t.groupId = :groupId")
                .setParameter("groupId", groupId)
                .getResultList();
          
        
    }
    
}
