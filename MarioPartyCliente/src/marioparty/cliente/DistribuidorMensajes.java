package marioparty.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class DistribuidorMensajes extends Thread {
	private Socket cliente;
	private List<Socket> clientes;

	private DataInputStream in;
	private DataOutputStream out;

	public DistribuidorMensajes(Socket cliente, List<Socket> clientes) {
		this.cliente = cliente;
		this.clientes = clientes;

		try {
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			System.out.println("Error al vincular la I/O");
		}
	}
//simplemente copie lo de Diego, hay que ver como hacer con los mensajes
//	@Override
//	public void run() {
//
//		while (!cliente.isClosed()) {
//
//			String mensaje = null;
//
//			try {
//				// Lee el input del cliente
//				mensaje = in.readUTF();
//
//				// Si el mensaje contiene /salir, me indico a mi que tengo que salir y los
//				// usuarios que alguien salio
//				if (mensaje.contains("/salir")) {
//					clientes.remove(cliente);
//					distribuirMensaje("un cliente salio del chat");
//					out.writeUTF("/salir");
//					return;
//				}
//
//				distribuirMensaje(mensaje);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	private void distribuirMensaje(String mensaje) {
//
//		for (Socket socket : clientes) {
//			if (socket != this.cliente) {
//				try {
//					DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//					out.writeUTF(mensaje);
//				} catch (IOException e) {
//					System.out.println("No se pudo enviar el mensaje");
//				}
//			}
//		}
//	}
}
