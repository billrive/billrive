/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author uhsarp
 */
@Entity
@Table(name="groups")
public class Group  implements GenericObject{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 4125241775878842292L;
	
	private int id;
	private String description;
	
	private Set<Bill> gBills = new HashSet<Bill>();
	
	public Group(){
		
	}

	public Group(int id, String description, Set<Bill> gBills) {
		super();
		this.id = id;
		this.description = description;
		this.gBills = gBills;
	}


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="groupBills")
	public Set<Bill> getgBills() {
		return gBills;
	}

	public void setgBills(Set<Bill> gBills) {
		this.gBills = gBills;
	}
	
	
    
}
