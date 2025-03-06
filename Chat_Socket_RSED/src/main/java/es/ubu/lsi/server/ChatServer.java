package es.ubu.lsi.server;
import es.ubu.lsi.common.*;

/**
 * Interfaz ChatServidor
 */
public interface ChatServer {
	
	/** 
	 * metodo que inicia servidor
	 */
	public void start();
	
	/**
	 * metodo para envio de mensajes
	 * @param message
	 */
	public void difusionMessage(ChatMessage message);
	
	/**
	 * metodo que apaga servidor
	 */
	public void stop();
	
	
	
}
