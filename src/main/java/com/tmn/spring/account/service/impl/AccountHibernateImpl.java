/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.service.impl;

import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.service.AccountService;
import com.tmn.spring.account.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author roofimon
 */
public class AccountHibernateImpl implements AccountService {

    @Override
    public List<Account> getAllAccount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Account> accounts = session.createQuery("from Account").list();
        return accounts;
    }

    @Override
    public Account getAccountByCode(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = (Account) session.load(Account.class, code);
        return account;
    }

    @Override
    public void updateAccount(Account targetAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(targetAccount);
        session.getTransaction().commit();
    }

    @Override
    public void removeAccount(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Account account = (Account) session.load(Account.class, code);
        session.delete(account);
        session.getTransaction().commit();
    }

    @Override
    public void createAccount(Account newAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newAccount);
        session.getTransaction().commit();
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
