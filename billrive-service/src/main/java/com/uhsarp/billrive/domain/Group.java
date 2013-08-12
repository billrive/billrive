/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name = "groups")
public class Group implements GenericObject {

   
    String title;
    /**
     *
     */
    private static final long serialVersionUID = 4125241775878842292L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Transient
    private Set<Bill> gBills = new HashSet<Bill>();

    public Group() {
    }


    public Group(Long id, String description, Set<Bill> gBills) {
        super();
        this.id = id;
        this.description = description;
        this.gBills = gBills;
    }

    public Group( String title, String desc, Long idOwner, List<Friend> lsMembers) {
        
        this.title = title;
//        this.desc = desc;
        this.ownerId = idOwner;
        this.lsMembers = lsMembers;
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

    public Set<Bill> getgBills() {
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
    Long ownerId;
    @Transient
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

    public void setgBills(Set<Bill> gBills) {
        this.gBills = gBills;
    }
}
