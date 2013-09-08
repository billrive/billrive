/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework.impl;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanth Batchu
 */

@Component("jpaConfig")
public class JpaConfig {
    
  @Resource(name="entityManager")
  private  EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


  

}
