/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.services;

import com.uhsarp.billrive.dao.GenericDAO;
import com.uhsarp.billrive.domain.Group;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("groupService")
public class GroupService {
    
    @Resource(name= "neo4jDAO")
    GenericDAO genericDAO;
    
    public void deleteGroup(String groupId_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group updateGroup(Group group_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Group getGroupById(String groupId_p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Group createGroup(int groupId, int userId) {
        Group rtnval=genericDAO.createGroup( groupId, userId);
        return rtnval;
    }

    public List<Group> getGroups(int userId) {
        List<Group> rtnval = new ArrayList<Group>();
        rtnval=genericDAO.getGroups(userId);
        return rtnval;
    }
    
    public Group activateFriends(List<Integer> friendIds, int groupId)
    {
        Group groupObj = null;
        groupObj=genericDAO.activateFriends(friendIds, groupId);
        return groupObj;
    }
 
    public Group deactivateFriends(List<Integer> friendIds, int groupId)
    {
        Group groupObj = null;
        groupObj=genericDAO.deactivateFriends(friendIds, groupId);
        return groupObj;
    }

}
