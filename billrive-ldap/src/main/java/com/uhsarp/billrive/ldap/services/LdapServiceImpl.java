/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uhsarp.billrive.ldap.services;

import com.uhsarp.billrive.ldap.domain.User;
import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.Entries;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldap.ErrorResultException;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LinkedHashMapEntry;
import org.forgerock.opendj.ldap.TreeMapEntry;
import org.forgerock.opendj.ldap.requests.ModifyRequest;
import org.forgerock.opendj.ldap.responses.Result;
import org.springframework.stereotype.Service;

/**
 *
 * @author MSN
 */
@Service("ldapService")
public class LdapServiceImpl implements LdapService {

    Result updatePassword(User user) {
        Entry entry = new LinkedHashMapEntry("dc=example1,dc=com");
        final LDAPConnectionFactory factory = new LDAPConnectionFactory(host, port);
        Connection connection = null;
        try {
            connection = factory.getConnection();
            connection.bind(adminDN, adminPwd);
            Entry old = TreeMapEntry.deepCopyOfEntry(entry);
            entry = entry.replaceAttribute("password", user);
            ModifyRequest request = Entries.diffEntries(old, entry);
            Result status = connection.modify(request);
            return status;
        } catch (final ErrorResultException e) {
            System.err.println(e.getMessage());
            System.exit(e.getResult().getResultCode().intValue());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    Result updateAccount(User user) {
        Entry entry = new LinkedHashMapEntry("dc=example1,dc=com");
        final LDAPConnectionFactory factory = new LDAPConnectionFactory(host, port);
        Connection connection = null;
        try {
            connection = factory.getConnection();
            connection.bind(adminDN, adminPwd);
            Entry old = TreeMapEntry.deepCopyOfEntry(entry);
            entry = entry.replaceAttribute("mail", user);
            entry.replaceAttribute("fname", user);
            entry.replaceAttribute("lname", user);
            entry.replaceAttribute("userId", user);
            entry.replaceAttribute("phone", user);
            ModifyRequest request = Entries.diffEntries(old, entry);
            Result status = connection.modify(request);
            return status;
        } catch (final ErrorResultException e) {
            System.err.println(e.getMessage());
            System.exit(e.getResult().getResultCode().intValue());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    Result createAccount(User user) {
        Entry entry = new LinkedHashMapEntry("dc=example1,dc=com");
        entry.addAttribute("fname", user);
        entry.addAttribute("lname", user);
        entry.addAttribute("password", user);
        entry.addAttribute("userId", user);
        entry.addAttribute("mail", user);
        entry.addAttribute("phone", user);

        final LDAPConnectionFactory factory = new LDAPConnectionFactory(host, port);
        Connection connection = null;
        try {
            connection = factory.getConnection();
            connection.bind(adminDN, adminPwd);
            Result status;
            status = connection.add(entry);
            return status;

        } catch (final ErrorResultException e) {
            System.err.println(e.getMessage());
            System.exit(e.getResult().getResultCode().intValue());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    Result deleteAccount(User user) {
        Entry entry = new LinkedHashMapEntry("dc=example1,dc=com");

        final LDAPConnectionFactory factory = new LDAPConnectionFactory(host, port);
        Connection connection = null;
        try {
            connection = factory.getConnection();
            // Bind as a user who has the right to delete entries.
            connection.bind(adminDN, adminPwd);

            Result status = connection.delete("dc=example1,dc=com");
            return status;
        } catch (final ErrorResultException e) {
            System.err.println(e.getMessage());
            System.exit(e.getResult().getResultCode().intValue());

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}
