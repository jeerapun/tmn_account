/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.service.impl;

import com.tmn.spring.account.model.Account;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class AccountJdbc {

    private static Logger logger = Logger.getLogger(AccountJdbc.class);
    Connection conn = null;

    public AccountJdbc() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://192.168.3.1:9101/Users/roofimon/Development/h2/database/test_ing", "sa", "");
        } catch (Exception error) {
            logger.error("An Exception: " + error.toString());
        }
    }

    public List<Account> getAllAccount() throws SQLException {
        List<Account> allAccount = new ArrayList<Account>();
        Statement stmt = null;
        String query = "select code, name, balance from account";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Account account;
            while (rs.next()) {
                account = new Account();
                String code = rs.getString("code");
                String name = rs.getString("name");
                BigDecimal price = rs.getBigDecimal("balance");
                account.setCode(code);
                account.setName(name);
                account.setBalance(new Double(price.doubleValue()));
                allAccount.add(account);
                logger.debug(code + "\t" + name
                        + "\t" + price + "\t");
                
            }

        } catch (SQLException e) {
            logger.error(e.toString());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return allAccount;
    }
}
