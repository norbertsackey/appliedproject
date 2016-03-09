/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messaging;

import java.text.SimpleDateFormat;
import com.smsgh.ApiHost;
import com.smsgh.BasicAuth;
import com.smsgh.HttpRequestException;
import com.smsgh.MessageResponse;
import com.smsgh.MessagingApi;
import com.smsgh.*;
import java.util.Calendar;

/**
 *
 * @author Jacque
 */
public class MessageOut {

    protected String sender;
    protected String[] recipients = null;
    protected String content;
    protected String timestamp;
    protected String subject;

    public static String clientID = "phtrulfw";
    public static String clientSecret = "cftwssah";

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public void setRecipients(String[] recipients) {
        this.recipients = recipients;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void sendMessage(String recipient) {
        

    }

    

    public void sendMessages() {

        for (int i = 0; i < this.recipients.length; i++) {
          this.sendMessage(this.recipients[i]);
            //System.out.println(this.recipients[i]);
          //; +233274009398;+233265751444
            try {
                Thread.sleep(10000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public MessageOut() {

    }

    public MessageOut(String sender, String [] recipients, String content, String subject) {
        this.sender = sender;
        this.recipients = recipients;
        this.content = content;
        this.timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());;
        this.subject = subject;

    }

    ;
    
    public static void main(String[] args) {
      

    }

}
