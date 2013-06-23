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
    String desc;
    int idOwner;
    List<Integer> lsMemberIds;

    public int getIdGroup() {
        return idGroup;
    }

    public Group(int idGroup, String title, String desc, int idOwner, List<Integer> lsMemberIds) {
        this.idGroup = idGroup;
        this.title = title;
        this.desc = desc;
        this.idOwner = idOwner;
        this.lsMemberIds = lsMemberIds;
    }

    public Group(int groupId, int userId) {
        this.idGroup = groupId;
        this.idOwner = userId;
        //this.idGroup = ??? Create a new Id
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


    public List<Integer> getLsMembers() {
        return lsMemberIds;
    }

    public void setLsMembers(List<Integer> lsMembers) {
        this.lsMemberIds = lsMembers;
    }

    
}
