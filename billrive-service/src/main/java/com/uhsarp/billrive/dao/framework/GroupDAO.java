/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.uhsarp.billrive.domain.Group;

/**
 *
 * @author uhsarp
 */
public interface GroupDAO extends GenericDAO<Group,Long>{
      Long findGroupId(Long userId);
}
