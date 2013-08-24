/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name = "groups")
public class Group implements GenericObject {

   
   
    /**
     *
     */
    private static final long serialVersionUID = 4125241775878842292L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    String title;
    @Column(columnDefinition = "TEXT")
    private String description;
 
    
    Long ownerId;
    @Transient
    private List<Bill> gBills = new ArrayList<Bill>();
    @Transient
    List<Friend> members;

    public Group() {
    }


    public Group(Long id, String description, List<Bill> gBills) {
        super();
        this.id = id;
        this.description = description;
        this.gBills = gBills;
    }

    public Group( String title, String desc, Long idOwner, List<Friend> lsMembers) {
        
        this.title = title;
//        this.desc = desc;
        this.ownerId = idOwner;
        this.members = lsMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="groupBills")

    public List<Bill> getgBills() {
        return gBills;
    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    public Long getIdOwner() {
        return ownerId;
    }

    public void setIdOwner(Long idOwner) {
        this.ownerId = idOwner;
    }
//    String desc;
   

    public List<Friend> getLsMembers() {
        return members;
    }

    public void setLsMembers(List<Friend> lsMembers) {
        this.members = lsMembers;
    }

    public String getGroupId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setgBills(List<Bill> gBills) {
        this.gBills = gBills;
    }
}
