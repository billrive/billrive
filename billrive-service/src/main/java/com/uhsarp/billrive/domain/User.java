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
 * @author Prashanth Batchu
 */
@Entity
@Table(name="\"user\"")
public class User  implements GenericObject {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String fName;
    private String lName;
    private String mName;
    private String title;
    private String email;
    private String password;
    @Column(columnDefinition = "BIT", length = 1)
    private boolean enabled;
  
    
//    @Transient
//    private List<Bill> bills = new ArrayList<Bill>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usergroupmap", 
            joinColumns = { @JoinColumn(name = "user_id")}, 
            inverseJoinColumns={@JoinColumn(name="groups_id")}) 
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Group> groups = new ArrayList<Group>();
    
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = Friend.class)
//    @Transient
    @JoinTable(name = "userfriendmap", 
            joinColumns = { @JoinColumn(name = "user_id")}, 
            inverseJoinColumns={@JoinColumn(name="friend_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Friend> friends = new ArrayList<Friend>();
 
    public User(){
    	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Bill> getBills() {
//        return bills;
//    }
//
//    public void setBills(List<Bill> bills) {
//        this.bills = bills;
//    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
	
    
  
}
