/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.ldap.webservices.rest;

import com.uhsarp.billrive.ldap.domain.User;
import com.uhsarp.billrive.ldap.services.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MSN
 */
@RestController
@RequestMapping("/userController")
public class LdapController {

    @Autowired
    LdapService ldapService;
    
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateAccount(User user) throws Exception {
        boolean status =ldapService.updateAccount(user);
        return status;
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    @ResponseBody
    public boolean createAccount(User user) throws Exception {
        boolean status = ldapService.createAccount(user);
        return status;
    }

    @RequestMapping(value = "/updatePassowrd/", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean updatePassword(User user) throws Exception {
        boolean status=ldapService.updatePassword(user);
        return status;
    }
   //@RequestMapping(value = "/deleteAccount/{userId}/{password}", method = RequestMethod.DELETE)
    @RequestMapping(value = "/deleteAccount/", method = RequestMethod.DELETE)
    @ResponseBody
   // public boolean deleteAccount(@PathVariable("userId") int userId,@PathVariable("password") String password) throws Exception {
       public boolean deleteAccount(User user) throws Exception {
            boolean status=ldapService.deleteAccount(user);
        return status;
    }  
    
}
