/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.LinkedList;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("neo4jDAO")
public class Neo4jDAO implements GenericDAO {

    public LinkedList<Bill> getBills(double userId) {
        LinkedList<Bill> rtnval = new LinkedList<Bill>();
        Bill bill = new Bill((double)1,"Walmart", new DateTime(2013,2,3,1,1), userId, "Sample Notes", null, userId);
        Bill bill1 = new Bill((double)2,"Costco", new DateTime(2014,2,3,1,1), userId, "Second sample Notes", null, userId);
        
        rtnval.add(bill);
        return rtnval;
    }
    
}
