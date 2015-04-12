/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.ldap.services;

import com.uhsarp.billrive.ldap.domain.User;

/**
 *
 * @author MSN
 */
public interface LdapService {

    boolean updatePassword(User user);

    boolean updateAccount(User user);

    boolean createAccount(User user);

    boolean deleteAccount(User user);

}
