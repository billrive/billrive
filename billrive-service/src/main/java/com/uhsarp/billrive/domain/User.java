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
//@Entity
//@Table(name="user")
public class User  implements GenericObject{
    
    private int id;
    private String fName;
    private String lName;
    private String mName;
    private String title;
    private String email;
    
    private List<Bill> bills = new ArrayList<Bill>();
    

    public User(){
    	
    }
    
	public User(int id, String fName, String lName, String mName, String title,
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

	public List<Bill> getUserBills() {
		return bills;
	}

	public void setUserBills(List<Bill> userBills) {
		this.bills = userBills;
	}
  
}
