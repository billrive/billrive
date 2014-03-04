/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services.impl;


import com.uhsarp.billrive.dao.framework.GroupDAO;
import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.services.GroupService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prashanth Batchu
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService{
    
   @Resource(name="groupDAO")
   GroupDAO groupDAO;

   //Returns the list of Gropus for a particular userId 
   public List<Group> getGroups(Long userId) {
       
       List<Group> grps;
       grps = groupDAO.getGroups(userId);
        
       return grps;
        
    }

    public List<Long> getUsersInGroup(Long groupId) {
        return groupDAO.findUsersByGroupId(groupId);
    }
 
    public Group getGroupById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group addGroup(Group group_p) {
        return groupDAO.save(group_p);
    }

    public Group editGroup(Group group_p) {
       return  groupDAO.merge(group_p);
    }

    public Boolean deleteGroup(Long groupId_p) {
       Boolean deleted= groupDAO.removeById(groupId_p);
       if(deleted)
           return true;
       else
            return false;
    }
   

}
