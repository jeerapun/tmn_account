/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmn.spring.account.jms;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 *
 * @author Jeerapu
 */
public class SendRabbitMQ {
  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv)
      throws java.io.IOException {
      //step 1.create connection
      System.out.println("step 1.create connection");
      ConnectionFactory factory = new ConnectionFactory();
      factory.setHost("localhost");
      Connection connection = factory.newConnection();
      Channel channel = connection.createChannel();
      //step 2.create message into queue connection
      System.out.println("step 2.create message into queue connection");
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      argv = new String[3];
      argv[0] = "one1";
      argv[1] = "two2";
      argv[2] = "tree3";
      
      String message = getMessage(argv);
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      System.out.println(" [x] Sent '" + message + "'");
      //step 3.closed connection
      channel.close();
      connection.close();
     System.out.println("step 3.begin closed connection");
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
