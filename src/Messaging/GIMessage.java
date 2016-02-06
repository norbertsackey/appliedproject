/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messaging;

 import com.smsgh.ApiHost;
    import com.smsgh.BasicAuth;
    import com.smsgh.HttpRequestException;
    import com.smsgh.MessageResponse;
    import com.smsgh.MessagingApi;
/**
 *
 * @author Norbit
 */
public class GIMessage {
   
        public static void main(String[] args) {

            BasicAuth auth = new BasicAuth("phtrulfw", "cftwssah");
            ApiHost host = new ApiHost(auth);
            // Instance of the Messaging API
            MessagingApi messagingApi = new MessagingApi(host);

            try {
                MessageResponse response = messagingApi.sendQuickMessage("+233274766048", "+233274009398", "Hello THe JAVA SDK R2 Test is ongoing... ", "123");

                System.out.println("Server Response Status " + response.getStatus());
            } catch (HttpRequestException ex) {
                System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
                System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
            }

        }
    }
    

