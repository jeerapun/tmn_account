/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.application.hibernate;

import com.tmn.spring.account.enumerates.TransactionType;
import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.model.TransactionHistory;
import com.tmn.spring.account.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.Session;

/**
 *
 * @author roofimon
 */
public class App {
    
    public static void run() throws ParseException
    {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        
        Calendar cal1 = new GregorianCalendar(2008, 01, 01);
       
        session.beginTransaction();
        Account newAccount = new Account();

        
        newAccount.setCode("1122334455");
        newAccount.setName("roofimon");
        newAccount.setBalance(new Double(100));
        
        TransactionHistory firstTransaction = new TransactionHistory(new SimpleDateFormat("MM/dd/yy").parse("05/18/12"), new Double(10), TransactionType.DEPOSIT);
        TransactionHistory secondTransaction = new TransactionHistory(new Date(), new Double(5), TransactionType.TRANSFER);
       
        newAccount.getTransactionHistory().add(firstTransaction);
        newAccount.getTransactionHistory().add(secondTransaction);
        
        System.out.println("Before Save: "+newAccount.getTransactionHistory().size());

        
        Account newnewAccount = new Account();
        newnewAccount.setCode("6677889900");
        newnewAccount.setName("manon");
        newnewAccount.setBalance(new Double(100));
        
        newnewAccount.getTransactionHistory().add(firstTransaction);
        newnewAccount.getTransactionHistory().add(secondTransaction);
        
        
        Account thirdAccount = new Account();
        thirdAccount.setCode("1234567890");
        thirdAccount.setName("jeerapun");
        thirdAccount.setBalance(new Double(1000));
        
        thirdAccount.getTransactionHistory().add(firstTransaction);
        thirdAccount.getTransactionHistory().add(secondTransaction);
        
        
        session.save(newAccount);
        session.save(newnewAccount);
        session.save(thirdAccount);
        
        session.getTransaction().commit();
        System.out.println("End Run Test");
    }
    
    public static void main(String[] args) throws ParseException {
        run();
    }
}
