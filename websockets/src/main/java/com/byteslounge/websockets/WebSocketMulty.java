package com.byteslounge.websockets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//http://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/

@ServerEndpoint("/websockmulty")
public class WebSocketMulty {

  //private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
  private static Set<Session> clients = new HashSet<Session>();
	  
	
  @OnMessage
  public void onMessage(String message, Session session) {
    
    synchronized(clients){
      // Iterate over the connected sessions
      // and broadcast the received message
     
    	for(Session client : clients){
        if (!client.equals(session)){
        
        	try {
        		client.getBasicRemote().sendText(message);
        	} catch(IOException ex) {
        		System.out.println("client error");
        		clients.remove(client);
        	}
        }
      }
    }
    
  }
  
  private static int nextId;
  @OnOpen
  public void onOpen (Session session) {
  // Add session to the connected sessions set
	session.getUserProperties().put("username", "user_"+nextId++);
    
	  synchronized(clients) {
		clients.add(session);
	  }
	
  }

  @OnClose
  public void onClose (Session session) {
    // Remove session from the connected sessions set
	  synchronized(clients) {
		  clients.remove(session);
	  }
	  
    System.out.println("client disconnected: " + session.getUserProperties().get("username"));
  }
  
  @OnError
  public void onError(Session session, Throwable thr) {
	  System.out.println("error socket, maybe someone disconnected");
  }

}
