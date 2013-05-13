/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("neo4jDAO")
public class Neo4jDAO implements GenericDAO {

    public List<Bill> getBills(double userId) {
        List<Bill> rtnval = new ArrayList<Bill>();
        BillFinances billFinances = new BillFinances();
        
        BillItemEntry billItemEntry = new BillItemEntry();
        ArrayList<UserIdAndLiableCost> userIdAndLiableCost = new ArrayList<UserIdAndLiableCost>();
        
        
        Bill bill = new Bill((double)1,"Walmart", new DateTime(2013,2,3,1,1), userId, "Sample Notes", null, userId);
        Bill bill1 = new Bill((double)2,"Costco", new DateTime(2014,2,3,1,1), userId, "Second sample Notes", null, userId);
        
        rtnval.add(bill);
        return rtnval;
    }
    
}
