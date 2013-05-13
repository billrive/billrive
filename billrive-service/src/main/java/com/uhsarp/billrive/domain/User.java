/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;
import java.util.ArrayList;
import java.util.List;

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
    List<Bill> bills = new ArrayList<Bill>();
    ArrayList<Payment> payments = new ArrayList<Payment>();
    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Group> groups = new ArrayList<Group>();

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

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Friend> friends) {
        this.friends = friends;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    
            
    
    
    
    
}
