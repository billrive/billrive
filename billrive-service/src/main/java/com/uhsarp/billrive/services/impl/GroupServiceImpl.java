/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services.impl;


import com.uhsarp.billrive.dao.framework.GroupDAO;
import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.services.GroupService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prashanth Batchu
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService{
    
   @Resource(name= "groupDAO")
   GroupDAO groupDAO;

    public List<Group> getGroups(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group getGroupById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group addGroup(Group group_p) {
        return groupDAO.save(group_p);
    }

    public Group editGroup(Group group_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean deleteGroup(Long groupId_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
