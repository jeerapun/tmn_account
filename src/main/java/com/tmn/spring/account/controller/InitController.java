/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.controller;

import com.tmn.spring.account.application.hibernate.App;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.Logger;

/**
 *
 * @author Jeerapu
 */
public class InitController extends HttpServlet {
    private Logger log = Logger.getLogger(InitController.class);
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates. 
        log.info("### start InitController ##");
        try
        {
          App.run();
        }catch(Exception e)
        {
            log.error("init error", e);
        }
        
        log.info("### finish InitController ###");
    }

    
}
