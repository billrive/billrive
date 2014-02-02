/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services;

import com.uhsarp.billrive.domain.Group;
import java.util.List;

/**
 *
 * @author Prashanth Batchu
 */

    public interface GroupService {

     List<Group> getGroups(Long userId);

     Group getGroupById(Long id);

     Group addGroup(Group group_p);

     Group editGroup(Group group_p);

     Boolean deleteGroup(Long groupId_p);
}

