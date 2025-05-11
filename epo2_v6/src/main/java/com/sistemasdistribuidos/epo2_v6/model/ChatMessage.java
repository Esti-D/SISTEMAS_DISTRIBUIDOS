package com.sistemasdistribuidos.epo2_v6.model;

/**
 * Representa un mensaje de chat entre dos usuarios.
 * Utilizada en la comunicación WebSocket para enviar y recibir mensajes privados.
 */
public class ChatMessage {
    /** Nombre de usuario del emisor del mensaje. */
    private String from;
    /** Nombre de usuario del destinatario del mensaje. */
    private String to;
    /** Contenido textual del mensaje. */
    private String content;

    /**
     * Obtiene el nombre del emisor.
     *
     * @return el nombre del usuario que envió el mensaje.
     */
    public String getFrom() {

        return from;
    }
    /**
     * Establece el nombre del emisor del mensaje.
     *
     * @param from el nombre del usuario que envía el mensaje.
     */
    public void setFrom(String from) {

        this.from = from;
    }
    /**
     * Obtiene el nombre del destinatario.
     *
     * @return el nombre del usuario que recibirá el mensaje.
     */
    public String getTo() {

        return to;
    }
    /**
     * Establece el nombre del destinatario del mensaje.
     *
     * @param to el nombre del usuario que debe recibir el mensaje.
     */
    public void setTo(String to) {

        this.to = to;
    }

    /**
     * Obtiene el contenido del mensaje.
     *
     * @return el texto del mensaje enviado.
     */
    public String getContent() {

        return content;
    }

    /**
     * Establece el contenido del mensaje.
     *
     * @param content el texto del mensaje a enviar.
     */
    public void setContent(String content) {

        this.content = content;
    }
}
