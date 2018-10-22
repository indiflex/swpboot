package com.jade.swpboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.jade.swpboot.handler.ReplyEchoHandler;

@Configuration
@EnableWebSocket
public class SbpWebSocketConfig implements WebSocketConfigurer {
  
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(new ReplyEchoHandler(), "/replyEcho").setAllowedOrigins("*"); // pure websocket
		registry.addHandler(new ReplyEchoHandler(), "/replyEcho").setAllowedOrigins("*").withSockJS();
	}
	
}
