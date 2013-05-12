/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import java.util.LinkedList;
import org.springframework.stereotype.Service;

/**
 *
 * @author uhsarp
 */
@Service("neo4jDAO")
public class Neo4jDAO implements GenericDAO {

    public LinkedList<Bill> getBills(double userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
