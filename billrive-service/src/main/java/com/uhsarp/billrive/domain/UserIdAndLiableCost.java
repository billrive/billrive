/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.domain;

/**
 *
 * @author uhsarp
 */
public class UserIdAndLiableCost {
    
    private final Double userId;
    private final Double liableCost;

    public UserIdAndLiableCost(Double aKey, Double aValue)
    {
        userId   = aKey;
        liableCost = aValue;
    }

    public Double userId()   { return userId; }
    public Double liableCost() { return liableCost; }
    
}
