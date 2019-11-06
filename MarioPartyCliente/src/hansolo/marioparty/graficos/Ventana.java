package hansolo.marioparty.graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import marioparty.cliente.Cliente;

public class Ventana extends Thread {
	//private String title;
	private int width = 1000;
	private int height = 768;

	private Cliente cliente;
	private String nombre;

	private JFrame frame;
	private Canvas canvas;

	public Ventana() {
		createDisplay();
	}

	public void createDisplay() {
		// creación y configuración del jframe

		
		frame = new JFrame("Mario Party - Han Solo");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false); // que no se pueda modificar el tamaño
		frame.setLocationRelativeTo(null); // que se abra en el centro de la pantalla
		frame.setVisible(true); // que se pueda ver

		// creación y configuración del canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
		
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

	@Override
	public void run() {

//		while (!cliente.isClosed()) {
//			String mensajeRecibido = cliente.recibirMensaje();
//
//			if (mensajeRecibido.contains("/salir")) {
//				cliente.cerrarSocket();
//				break;
//			} else {
//				// textArea.append(mensajeRecibido + "\n");
//			}
//		}
//		// System.out.println("Saliste del chat");
//		frame.dispose();
//		System.exit(1);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana ventana = new Ventana();
					ventana.getFrame().setVisible(true);
					ventana.start();
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		});

	}
}
