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
import com.uhsarp.billrive.dao.framework.BalanceDAO;
import com.uhsarp.billrive.domain.Balance;
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
@Repository("BalanceDAO")
@Transactional
public class BalanceDAOImpl implements BalanceDAO{
    
    private static final Logger logger_c = Logger.getLogger(BalanceDAOImpl.class);
  
     @PersistenceContext
	private EntityManager em;
     
    public Balance merge(Balance balance) {
        if (balance.getId()!= null) {
            return em.merge(balance);    
        }
        else {
           return null;
        }
    }
    
    @Transactional
    public Balance save(Balance balance) {
        if (balance.getId() == null) {
            try {
                em.persist(balance);
            } catch (Exception e) {
                logger_c.debug(e);
            }

            return balance;
        }
        return em.merge(balance);
    }
    
    public Balance find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Balance[] find(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Balance getReference(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Balance[] getReferences(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void persist(Balance... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Balance[] merge(Balance... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Balance[] save(Balance... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public boolean remove(Balance t) {

        return false;
    }

    public void remove(Balance... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public boolean removeById(Long balanceId) {

        Query q = em.createQuery("delete from Balance b  WHERE b.id=" + balanceId);
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

    public List<Balance> findAll() {
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

    public boolean isAttached(Balance t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void refresh(Balance... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Balance t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Balance t, ExampleOptions eo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated  methods, choose Tools | Templates.
    }
    
    public List<Balance> getBalances(Long userId) {
        return em.createQuery("SELECT b FROM Balance b WHERE b.userId_gets = :userId OR b.userId_gives = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }
}
