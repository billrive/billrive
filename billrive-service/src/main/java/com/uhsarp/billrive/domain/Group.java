/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name = "\"groups\"")
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
    @OneToMany(cascade=CascadeType.ALL,mappedBy="groupId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Bill> gBills = new ArrayList<Bill>();
    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        mappedBy = "groups",
        targetEntity = User.class
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    List<User> users;

    public Group() {
    }


    public Group(Long id, String description, List<Bill> gBills) {
        super();
        this.id = id;
        this.description = description;
        this.gBills = gBills;
    }

    public Group( String title, String desc, Long idOwner, List<User> lsMembers) {
        
        this.title = title;
//        this.desc = desc;
        this.ownerId = idOwner;
        this.users = lsMembers;
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
   


    public String getGroupId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setgBills(List<Bill> gBills) {
        this.gBills = gBills;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
}
