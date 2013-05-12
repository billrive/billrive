/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;
import java.util.LinkedList;

/**
 *
 * @author uhsarp
 */
public class User {
    
    private double id;
    private String fName;
    private String lName;
    private String mName;
    private String title;
    private String email;
    private Settings settings;
    LinkedList<Bill> bills = new LinkedList<Bill>();
    LinkedList<Payment> payments = new LinkedList<Payment>();
    LinkedList<Friend> friends = new LinkedList<Friend>();
    LinkedList<Group> groups = new LinkedList<Group>();

    public double getId() {
        return id;
    }

    public void setId(double id) {
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

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public LinkedList<Bill> getBills() {
        return bills;
    }

    public void setBills(LinkedList<Bill> bills) {
        this.bills = bills;
    }

    public LinkedList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(LinkedList<Payment> payments) {
        this.payments = payments;
    }

    public LinkedList<Friend> getFriends() {
        return friends;
    }

    public void setFriends(LinkedList<Friend> friends) {
        this.friends = friends;
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<Group> groups) {
        this.groups = groups;
    }
    
            
    
    
    
    
}
