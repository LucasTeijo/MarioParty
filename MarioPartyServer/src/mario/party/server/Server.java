package mario.party.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



public class Server {
	private final int CANTIDAD_CLIENTES = 60;
	private final static int PUERTO = 5010;

	private ServerSocket server;
	private Socket cliente;

	private List<Socket> clientes;

	public Server() {
		clientes = new ArrayList<Socket>();

		try {
			server = new ServerSocket(PUERTO);
			System.out.println("Esperando conexion de cliente");

			for (int i = 0; i < CANTIDAD_CLIENTES; i++) {
				// Metodo bloqueante a la espera de un cliente
				cliente = server.accept();
				System.out.println("Se acepto el cliente numero " + i);
				clientes.add(cliente);

				// Hilo que distribuye los mensajes
				DistribuidorMensajes hilo = new DistribuidorMensajes(cliente, clientes);
				hilo.start();
			}

		} catch (IOException e) {
			System.out.println("No se pudo crear el servidor");
		}

		cerrarClientes();
		try {
			server.close();
		} catch (IOException e) {
			System.out.println("Problema al cerrar el servidor");
		}
	}
	
	private void cerrarClientes() {

		for (Socket socket : clientes) {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el socket");
			}
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
	}
}
