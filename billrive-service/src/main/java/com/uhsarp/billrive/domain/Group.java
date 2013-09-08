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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Bill> bills = new ArrayList<Bill>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", targetEntity = Payment.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Payment> payments = new ArrayList<Payment>();
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Friend.class)
    @JoinTable(name = "usergroupmap",
            joinColumns = {
        @JoinColumn(name = "groups_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "user_id")})
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Friend> users;

    public Group() {
    }

    public Group(Long id, String description, List<Bill> bills) {
        super();
        this.id = id;
        this.description = description;
        this.bills = bills;
    }

    public Group(String title, String desc, Long ownerId, List<Friend> users) {

        this.title = title;
//        this.desc = desc;
        this.ownerId = ownerId;
        this.users = users;
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

//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

//    String desc;

    public String getGroupId() {
        return null;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Friend> getFriends() {
        return users;
    }

    public void setFriends(List<Friend> users) {
        this.users = users;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Friend> getUsers() {
        return users;
    }

    public void setUsers(List<Friend> users) {
        this.users = users;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
