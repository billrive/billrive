/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uhsarp.billrive.dao.framework.impl;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.uhsarp.billrive.dao.framework.PaymentDAO;
import com.uhsarp.billrive.domain.Payment;
import com.uhsarp.billrive.webservices.rest.BillController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pperi
 */
@Repository("Payment")
@Transactional
public class PaymentDAOImpl implements PaymentDAO {
    private static final Logger logger_c = Logger.getLogger(PaymentDAOImpl.class);
  
     @PersistenceContext
	private EntityManager em;
     
    public Payment merge(Payment payment) {
        if (payment.getId()!= null) {
            return em.merge(payment);    
        }
        else {
           return null;
        }
    }
    
    @Transactional
    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            try {
                em.persist(payment);
            } catch (Exception e) {
                logger_c.debug(e);
            }

            return payment;
        }
        return em.merge(payment);
    }
    
    public Payment find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Payment[] find(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Payment getReference(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Payment[] getReferences(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void persist(Payment... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Payment[] merge(Payment... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Payment[] save(Payment... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public boolean remove(Payment t) {

        return false;
    }

    public void remove(Payment... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public boolean removeById(Long PaymentId) {

        Query q = em.createQuery("delete from Payment b  WHERE b.id=" + PaymentId);
        int deleted = q.executeUpdate();
        if (deleted > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void removeByIds(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public List<Payment> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public <RT> List<RT> search(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public <RT> RT searchUnique(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public int count(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public <RT> SearchResult<RT> searchAndCount(ISearch is) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public boolean isAttached(Payment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void refresh(Payment... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Payment t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Payment t, ExampleOptions eo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }
    
}
