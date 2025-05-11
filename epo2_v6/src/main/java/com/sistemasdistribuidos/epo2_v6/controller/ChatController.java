package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.security.Principal;

/**
 * Controlador encargado de gestionar el envío de mensajes privados entre usuarios mediante WebSocket.
 */
@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * Maneja los mensajes recibidos desde el cliente en el canal /app/chat
     * y los envía de forma privada al destinatario especificado.
     *
     * @param mensaje   el mensaje recibido, con información del emisor, receptor y contenido.
     * @param principal el usuario autenticado que está enviando el mensaje.
     */
    @MessageMapping("/chat")
    public void enviarMensaje(ChatMessage mensaje, Principal principal) {
        System.out.println(" Receptor destino (getTo): " + mensaje.getTo());
        System.out.println(" Emisor (getFrom): " + mensaje.getFrom());

        // Enviar al usuario destinatario en su cola privada
        messagingTemplate.convertAndSendToUser(
                mensaje.getTo(), "/queue/messages", mensaje
        );
    }
}
