package es.ubu.lsi.client;

import es.ubu.lsi.common.ChatMessage;

/**
 * Interfaz ChatClient
 *   
 */
public interface ChatClient {

	/**
	 * start
	 * 
	 * Arranca el cliente
	 * 
	 * @return true (si todo correcto) false (si falla algo)
	 */
	public boolean start();
	
	/**
	 * envio de mensajes desde cliente
	 * 
	 * @param msg
	 */
	public void sendMessage(ChatMessage msg);
	
	/**
	 * Cierre de conexión
	 */
	public void disconnect();
	
	
}
