package es.ubu.lsi.server;
import java.rmi.RemoteException;

import es.ubu.lsi.common.*;

/**
 * Interfaz ChatServidor
 */
public interface ChatServer {
	
	/** 
	 * metodo que inicia servidor
	 */
	public void startup();
	
	/**
	 * metodo para envio de mensajes
	 * @param message
	 */
	public void broadcast(ChatMessage message)throws RemoteException;
	
	/**
	 * metodo que apaga servidor
	 */
	public void shutdown();
	
	
	public void remove (int id) throws RemoteException;
	
	
	
}
