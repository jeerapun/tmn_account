/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.model;

import com.tmn.spring.account.enumerates.TransactionType;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
public class TransactionHistory implements Comparable<TransactionHistory>{
    private static Logger logger = Logger.getLogger(TransactionHistory.class);
    private Long transactionNumber;
    private Date transactionDate;
    private Double amount;
    private TransactionType code;

    public TransactionHistory(){
        
    }
    
    public TransactionHistory(Date transactionDate,Double amount,TransactionType code) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.code = code;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the code
     */
    public TransactionType getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(TransactionType code) {
        this.code = code;
    }

    /**
     * @return the transactionNumber
     */
    public Long getTransactionNumber() {
        
        return transactionNumber;
    }

    /**
     * @param transactionNumber the transactionNumber to set
     */
    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }    
    
    public int compareTo(TransactionHistory that){
      final int BEFORE = -1;
      final int AFTER = 1;

      if (that == null) {
         return BEFORE;
      }

      Comparable thisTransactionHistory = this.getTransactionDate().getTime();
      Comparable thatTransactionHistory = that.getTransactionDate().getTime();
        
      logger.debug("Comparing: "+this.getTransactionDate().getTime()+" with "+that.getTransactionDate().getTime());
      
      if(thisTransactionHistory == null) {
         return AFTER;
      } else if(thatTransactionHistory == null) {
         return BEFORE;
      } else {
         return thisTransactionHistory.compareTo(thatTransactionHistory);
      }
   }


}
