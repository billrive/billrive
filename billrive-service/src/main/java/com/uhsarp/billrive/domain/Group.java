/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.List;

/**
 *
 * @author uhsarp
 */
public class Group {
    
    int idGroup;
    String title;

    public int getIdGroup() {
        return idGroup;
    }

    public Group(int idGroup, String title, String desc, int idOwner, List<Friend> lsMembers) {
        this.idGroup = idGroup;
        this.title = title;
        this.desc = desc;
        this.idOwner = idOwner;
        this.lsMembers = lsMembers;
    }



    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
    String desc;
    int idOwner;
    List<Friend> lsMembers;

    public List<Friend> getLsMembers() {
        return lsMembers;
    }

    public void setLsMembers(List<Friend> lsMembers) {
        this.lsMembers = lsMembers;
    }
    public String getGroupId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
