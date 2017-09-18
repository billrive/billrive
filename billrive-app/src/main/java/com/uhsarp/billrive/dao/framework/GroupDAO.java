/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao.framework;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.uhsarp.billrive.domain.Group;
import java.util.List;

/**
 *
 * @author Prashanth Batchu
 */
public interface GroupDAO extends CrudRepository<Group,Long>{
      Long findGroupId(Long userId);
      Group findGroupByGroupId(Long groupId);
      List<Group> getGroups(Long userId);
      List<Long> findUsersByGroupId(Long groupId);
    }

