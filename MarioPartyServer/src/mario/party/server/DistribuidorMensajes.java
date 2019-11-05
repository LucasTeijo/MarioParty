package mario.party.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class DistribuidorMensajes extends Thread{
	
	private Socket cliente;
	private List<Socket> clientes;
	private DataInputStream input;
	private DataOutputStream output;

	public DistribuidorMensajes(Socket cliente, List<Socket> clientes) {
		this.clientes = clientes;
		this.cliente = cliente;

		try {
			input = new DataInputStream(cliente.getInputStream());
			output = new DataOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			System.out.println("No se puedo establecer la entrada/salida");
		}
	}

}
