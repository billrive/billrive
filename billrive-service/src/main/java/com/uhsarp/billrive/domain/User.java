/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
//@Entity
//@Table(name="user")
public class User  implements GenericObject{
    
    private int id;
    private String fName;
    private String lName;
    private String mName;
    private String title;
    private String email;
    
    private Set<Bill> userBills = new HashSet<Bill>();
    private Set<BillFinances> userBillFinances = new HashSet<BillFinances>();
    

    public User(){
    	
    }
    
	public User(int id, String fName, String lName, String mName, String title,
			String email, Set<Bill> userBills, Set<BillFinances> userBillFinances) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.mName = mName;
		this.title = title;
		this.email = email;
		this.userBills = userBills;
		this.userBillFinances = userBillFinances;
	}




	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="userBill")
	public Set<Bill> getUserBills() {
		return userBills;
	}

	public void setUserBills(Set<Bill> userBills) {
		this.userBills = userBills;
	}

//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="billFinanceOfUser")
	public Set<BillFinances> getUserBillFinances() {					 
		return userBillFinances;
	}

	public void setUserBillFinances(Set<BillFinances> userBillFinances) {
		this.userBillFinances = userBillFinances;
	}
    
            
    
    
    
    
}
