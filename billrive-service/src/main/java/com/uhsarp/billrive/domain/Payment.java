/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

import org.joda.time.DateTime;

/**
 *
 * @author uhsarp
 */
public class Payment {

    public Payment(int payerId, int receiverId, int transactionAmount, String paymentDescription, DateTime transactionDate) {
        this.payerId = payerId;
        this.receiverId = receiverId;
        this.transactionAmount = transactionAmount;
        this.paymentDescription = paymentDescription;
        this.transactionDate = transactionDate;
    }

    public Payment(int userId, int receiverId, int transactionAmount, DateTime transactionDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

    public DateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(DateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    private int payerId;
    private int receiverId;
    private int transactionAmount;
    private String paymentDescription;
    DateTime transactionDate;
    
    
            
    
}
