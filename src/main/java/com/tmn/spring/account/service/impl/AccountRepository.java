/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.service.impl;

import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.service.AccountService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author roofimon
 */
public class AccountRepository implements AccountService {

    private static Logger logger = Logger.getLogger(AccountRepository.class);
    
    private HashMap<String, Account> repository;

    public AccountRepository() {
        repository = new HashMap<String, Account>();
        Account firstAccount = new Account("1122334455", "Twin Panichsombat", 500.00);
        Account secondAccount = new Account("6677889900", "Twin Panichsombat", 500.00);
        repository.put(firstAccount.getCode(), firstAccount);
        repository.put(secondAccount.getCode(), secondAccount);
    }

    public Account getAccountById(String accountId) {
        return repository.get(accountId);
    }

    public void addNewAccount(Account newAccount) {
        repository.put(newAccount.getCode(), newAccount);
    }

    @Override
    public void updateAccount(Account targetAccount) {
        repository.put(targetAccount.getCode(), targetAccount);
    }

    @Override
    public void removeAccount(String accountId) {
        repository.remove(accountId);
    }

    @Override
    public List<Account> getAllAccount() {
        logger.info("this is a sample log message.");
        return new ArrayList<Account>(repository.values());
    }

    @Override
    public void createAccount(Account newAccount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Account getAccountByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
