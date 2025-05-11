package com.sistemasdistribuidos.epo2_v6.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Configuración de WebSocket para la aplicación.
 * Define los endpoints, el broker de mensajes y la asociación del usuario autenticado con los mensajes.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registra el endpoint WebSocket principal de la aplicación usando SockJS.
     *
     * @param registry registro de endpoints STOMP.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();  // Endpoint para conectarse con SockJS
    }

    /**
     * Configura el broker de mensajes utilizado para enrutar los mensajes dentro de la aplicación.
     *
     * @param config configuración del broker de mensajes.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/queue");       // Para mensajes privados
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user"); // Para direccionar mensajes a usuarios concretos
    }

    /**
     * Configura el canal de entrada del cliente para asociar el usuario autenticado a cada mensaje STOMP.
     *
     * @param registration registro del canal entrante.
     */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptor() {
            @Override
            public org.springframework.messaging.Message<?> preSend(org.springframework.messaging.Message<?> message, org.springframework.messaging.MessageChannel channel) {
                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                if (auth != null) {
                    accessor.setUser(auth);
                }
                return message;
            }
        });
    }
}

