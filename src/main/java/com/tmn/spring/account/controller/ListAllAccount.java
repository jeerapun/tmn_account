/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.controller;

import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.service.impl.AccountHibernateImpl;
import com.tmn.spring.account.service.AccountService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author roofimon
 */
@WebServlet(name = "ListAllAccount", urlPatterns = {"/ListAllAccount"})
public class ListAllAccount extends HttpServlet {
    private static Logger logger = Logger.getLogger(ListAllAccount.class);

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub        
        logger.info("Start Fetch All Acclount in ListAllAccount");
        //AccountService accountService = new AccountHibernateImpl();
        ApplicationContext beanFactory = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AccountService accountService = (AccountService)beanFactory.getBean("accountService");//new AccountHibernateImpl();
        List<Account> allAccount = accountService.getAllAccount();
        
        request.setAttribute("allAccount", allAccount);
        logger.debug("Account Size: "+allAccount.size());
        String nextJSP = "/listAllAccount.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
