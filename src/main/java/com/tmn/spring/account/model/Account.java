/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.model;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class Account {

    private static Logger logger = Logger.getLogger(Account.class);
    String code;
    String name;
    Double balance;
    SortedSet transactionHistory;

    public void addTransactionHistory(TransactionHistory transactioHistory){
        this.transactionHistory.add(transactioHistory);
    }
    
    public Account() {
    }

    public Account(String accountId, String accountName, Double balance) {

        this.code = accountId;
        this.name = accountName;
        this.balance = balance;
        this.transactionHistory = new TreeSet();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount) {
        this.balance = this.balance + amount;
    }

    
    public SortedSet getTransactionHistory() {
        logger.debug("getTransactionHistory");
        if (this.transactionHistory == null) {
            this.transactionHistory = new TreeSet();
        }
        return transactionHistory;
    }

    public void setTransactionHistory(SortedSet transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}