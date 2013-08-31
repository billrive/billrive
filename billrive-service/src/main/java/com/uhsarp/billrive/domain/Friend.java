/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author uhsarp
 */

@Entity
@Table(name="\"user\"")
public class Friend  implements GenericObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    Long id;
    String fName;
    String lName;
    String email;
    String mName;
    String title;
    @Transient
    boolean userActive;

    public Friend() {
    }

    public Friend(Long id, String firstName, String lastName, String emailId, boolean userActive) {
        this.id = id;
        this.fName = firstName;
        this.lName = lastName;
        this.email = emailId;
        this.userActive = userActive;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isUserActive() {
        return userActive;
    }

    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    
}
