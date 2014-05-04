/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework.impl;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.uhsarp.billrive.dao.framework.GroupDAO;
import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.webservices.rest.BillController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prashanth Batchu
 */
@Repository("groupDAO")
@Transactional
public class GroupDAOImpl implements GroupDAO{

     private static final Logger logger_c = Logger.getLogger(GroupDAOImpl.class);
  
     @PersistenceContext
	private EntityManager em;
     
    public Group find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    /**
     *
     * @param id
     * @return
     */
   
    public Long findGroupId(Long userId) {
      
        List<Long> groupIds= (List<Long>) em.createNativeQuery("SELECT groups_id FROM billrivedbtest.usergroupmap where id="+userId).getResultList();
        Long groupId = groupIds.get(0).longValue();
        return  groupId;
    }

    public Group[] find(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group getReference(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group[] getReferences(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void persist(Group... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group merge(Group group) {
          if (group.getId()!= null) {
            return em.merge(group);    
    }
       else
           return null;
    }

    public Group[] merge(Group... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group save(Group group) {
        if (group.getId() == null) {
            try {
                em.merge(group);
            } catch (Exception e) {
                logger_c.debug(e);
            }

            return group;
        }
        return em.merge(group);
    }

    public Group[] save(Group... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean remove(Group t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Group... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removeById(Long groupId) {
             Query q = em.createQuery("delete from Group g  WHERE g.id=" + groupId);
        int deleted = q.executeUpdate();
        if (deleted > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void removeByIds(Long... ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> findAll() {
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

    public boolean isAttached(Group t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void refresh(Group... ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void flush() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Group t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Filter getFilterFromExample(Group t, ExampleOptions eo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group findGroupByGroupId(Long groupId) {
      Query q =  em.createQuery("select g from Group g  WHERE g.id="+groupId);    
      
      Group group = (Group) q.getSingleResult();
        return group;
    }

    public List<Group> getGroups(Long userId) {
      Query q = em.createQuery(" select distinct g from Group g where g.ownerId="+userId);
      List groups = q.getResultList();
      return groups;
        
    }
    
    public List<Long> findUsersByGroupId(Long groupId) {
        List<Number> tempList = (List<Number>)em.createNativeQuery("SELECT user_id FROM billrivedbtest.usergroupmap u WHERE u.groups_id = :groupId")
                .setParameter("groupId", groupId)
                .getResultList();
        List<Long> userIds = new ArrayList<Long>();
        for(Iterator<Number> i = tempList.iterator(); i.hasNext();) {
            userIds.add(i.next().longValue());
        }
        return userIds;
    }
    
}
