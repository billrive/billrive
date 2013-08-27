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
@Table(name="\"user\"")
public class User  implements GenericObject{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    private String mName;
    private String title;
    private String email;
    @Transient
    private List<Bill> bills = new ArrayList<Bill>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "usergroupmap", 
            joinColumns = { @JoinColumn(name = "user_id")}, 
            inverseJoinColumns={@JoinColumn(name="groups_id")}) 
    private List<Group> groups = new ArrayList<Group>();
    
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = User.class)
    @JoinTable(name = "userfriendmap", 
            joinColumns = { @JoinColumn(name = "user_id")}, 
            inverseJoinColumns={@JoinColumn(name="friend_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> friends = new ArrayList<User>();
 
    public User(){
    	
    }
    
	public User(Long id, String fName, String lName, String mName, String title,
			String email, List<Bill> userBills ) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.mName = mName;
		this.title = title;
		this.email = email;
		this.bills = userBills;
		
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getUsers() {
        return friends;
    }

    public void setUsers(List<User> friends) {
        this.friends = friends;
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

//    @OneToMany(cascade=CascadeType.ALL,mappedBy="groupId")
//    @LazyCollection(LazyCollectionOption.FALSE)
	public List<Bill> getUserBills() {
		return bills;
	}

	public void setUserBills(List<Bill> userBills) {
		this.bills = userBills;
	}
  
}
