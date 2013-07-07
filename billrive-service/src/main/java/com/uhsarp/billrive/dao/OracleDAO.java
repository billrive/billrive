/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.dao;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.Group;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sravan
 */
@Repository("oracleDAO")
public class OracleDAO{

    public List<Bill> getBills(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Group> getGroups(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
