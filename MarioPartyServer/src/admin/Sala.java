package admin;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hansolo.marioparty.Juego;
import admin.Usuario;

public class Sala {

	private final int maxJugadores = 4;
	private List<Usuario> usuarios;
	private String nombre;
	private Juego juego;

	public Sala(Usuario usuario, String nombre) {
		usuarios.add(usuario);
		this.nombre = nombre;
		// redibujo la ventana del usuario
	}

	public void unirseASala(Usuario usuario) {
		JFrame frame = new JFrame();
		if (usuarios.size() < maxJugadores)
			usuarios.add(usuario);
		// redibujo la ventana del usuario
		else
			JOptionPane.showMessageDialog(frame, "La sala esta llena");
	}

	public void salir(Usuario usuario) {
		usuarios.remove(usuario);
		// redibujo la ventana del usuario
		// if (juego.isEjecutando())
		// hay que eliminar al jugador sin terminar la partida

	}

	public void iniciarPartida() {
		juego = new Juego("Mario party", 1000, 768/* usuarios */);
		juego.start();
	}

}
