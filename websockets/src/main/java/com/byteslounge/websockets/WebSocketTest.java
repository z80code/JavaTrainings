package com.byteslounge.websockets;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


/**
 * The TCP connection between the client and the server is established after the occurrence of a handshake over the HTTP protocol. It's easy to observe the handshake by using some HTTP traffic debugger. As soon as we create the WebSocket instance in the client the following request and respective server response will occur:
 *
 * Note: we will only include HTTP headers that are relevant to the websockets handshake
 * 
 * Request:
 * 
 * GET /byteslounge/websocket HTTP/1.1
 * Connection: Upgrade
 * Upgrade: websocket
 * Sec-WebSocket-Key: wVlUJ/tu9g6EBZEh51iDvQ==
 * Response:
 * 
 * HTTP/1.1 101 Web Socket Protocol Handshake
 * Upgrade: websocket
 * Sec-WebSocket-Accept: 2TNh+0h5gTX019lci6mnvS66PSY=
 * Note that the client is requesting the protocol to be upgraded to the WebSocket protocol by using Connection: Upgrade and Upgrade: websocket HTTP headers. The server response states that the client request was accepted and it will change protocol to WebSocket (using HTTP status code 101):
 * HTTP/1.1 101 Web Socket Protocol Handshake
 *
 */

@ServerEndpoint("/websocket")
public class WebSocketTest {

	@OnMessage
    public void onMessage(String message, Session session) 
    	throws IOException, InterruptedException {
		
		// Print the client message for testing purposes
		System.out.println("Received: " + message);
		
		// Send the first message to the client
		session.getBasicRemote().sendText("This is the first server message");
		
		// Send 3 messages to the client every 5 seconds
		int sentMessages = 0;
		while(sentMessages < 3){
			Thread.sleep(5000);
			session.getBasicRemote().
				sendText("This is an intermediate server message. Count: " 
					+ sentMessages);
			sentMessages++;
		}
		
		// Send a final message to the client
		session.getBasicRemote().sendText("This is the last server message");
    }
	
	@OnOpen
    public void onOpen () {
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose () {
    	System.out.println("Connection closed");
    }
}
