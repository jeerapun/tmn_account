/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.controller;

import com.tmn.spring.account.enumerates.TransactionType;
import com.tmn.spring.account.model.Account;
import com.tmn.spring.account.service.impl.AccountHibernateImpl;
import com.tmn.spring.account.model.TransactionHistory;
import com.tmn.spring.account.service.AccountService;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
@WebServlet(name = "DepositController", urlPatterns = {"/DepositController"})
public class DepositController extends HttpServlet {

    private static Logger logger = Logger.getLogger(DepositController.class);

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String amountString = request.getParameter("amount");
        Double amount = Double.valueOf(amountString);
        
        AccountService accountService = new AccountHibernateImpl();
        
        Account account = accountService.getAccountByCode(code);
        TransactionHistory newTransaction = new TransactionHistory(new Date(), amount, TransactionType.DEPOSIT);
        account.addTransactionHistory(newTransaction);
        
        logger.debug("Account: "+account.getCode()+" Current Balance:"+account.getBalance().toString());
        account.deposit(amount);
        logger.debug("Account: "+account.getCode()+" Current Balance:"+account.getBalance().toString());
        
        accountService.updateAccount(account);
        request.setAttribute("account", account);
        String nextJSP = "/accountInfo.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         AccountService accountService = new AccountHibernateImpl();
        //processRequest(request, response);
        String code = request.getParameter("code");
        Account account = accountService.getAccountByCode(code);
        
        logger.debug("Target Account:"+account.getTransactionHistory().size());
        
        request.setAttribute("code", code);
        request.setAttribute("account", account);
        String nextJSP = "/deposit.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
