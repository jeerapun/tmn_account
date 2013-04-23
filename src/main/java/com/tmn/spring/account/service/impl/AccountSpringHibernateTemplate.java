package com.tmn.spring.account.service.impl;

import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.service.AccountService;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: roofimon
 * Date: 3/7/13 AD
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountSpringHibernateTemplate  implements AccountService {
    
    private HibernateTemplate hibernateTemplate;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void createAccount(Account newAccount) {
       this.hibernateTemplate.save(newAccount);
    }

    @Override
    public Account getAccountByCode(String code) {
       
        return  this.hibernateTemplate.get(Account.class, code);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Account> getAllAccount() {
        return this.hibernateTemplate.loadAll(Account.class);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAccount(String code) {
        this.hibernateTemplate.delete(this.getAccountByCode(code));
    }

    @Override
    public void updateAccount(Account targetAccount) {
        this.hibernateTemplate.merge(targetAccount);
    }
}
