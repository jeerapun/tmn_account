/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.jms;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author Jeerapu
 */
public class LogsRabbitMQ {
    private static final String EXCHANGE_NAME = "test_topic_logs";

    public static void main(String[] argv)
                  throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routeKey = "jeerapun.critical";
        String message =  "Error 500 Internal Server Error";
         
        
        channel.basicPublish(EXCHANGE_NAME, routeKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routeKey + "':'" + message + "'");
        
        routeKey = "lazy.xxx";
        message =  "Test Lazy";
         
        
        channel.basicPublish(EXCHANGE_NAME, routeKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routeKey + "':'" + message + "'");
        
        routeKey = "ccp.critical";
        message =  "Error 404 Not Found!";
         
        
        channel.basicPublish(EXCHANGE_NAME, routeKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routeKey + "':'" + message + "'");
        
         routeKey = "ldap.xxx";
         message =  "Error 405 Not Found!";
         
        
        channel.basicPublish(EXCHANGE_NAME, routeKey, null, message.getBytes());
        System.out.println(" [x] Sent '" + routeKey + "':'" + message + "'");
        
        //channel.close();
        connection.close();
    }
  
    private static String getMessage(String[] strings){
      if (strings.length < 1)
          return "Hello World!";
      return joinStrings(strings, " ");
    }
  
    private static String joinStrings(String[] strings, String delimiter) {
      int length = strings.length;
      if (length == 0) return "";
      StringBuilder words = new StringBuilder(strings[0]);
      for (int i = 1; i < length; i++) {
          words.append(delimiter).append(strings[i]);
      }
      return words.toString();
      }
}
