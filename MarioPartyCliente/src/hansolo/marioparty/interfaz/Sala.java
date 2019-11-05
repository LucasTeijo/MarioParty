package hansolo.marioparty.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hansolo.mario.Juego;
import hansolo.marioparty.graficos.Ventana;
import marioparty.cliente.Cliente;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sala {

	private JFrame frame;
	private JPanel contentPane;
	private int WIDTH = 410;
	private int HEIGHT = 310;

	private JLabel lblJugadores;
	private JTextPane textPane;
	private JButton btnSalirButton;
	private Cliente cliente;


	public Sala(String nombre1) {
		init(nombre1);
		String nombre = JOptionPane.showInputDialog("Ingresar nombre");

		this.cliente = new Cliente(nombre);
	}

	private void init(String nombreSala) {
		
		frame = new JFrame(nombreSala);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		lblJugadores = new JLabel("JUGADORES");
		lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(31, 22, 138, 32);
		lblJugadores.setVisible(true);

		contentPane.add(lblJugadores);

		textPane = new JTextPane();
		textPane.setBounds(41, 52, 138, 198);
		textPane.setEditable(false);

		contentPane.add(textPane);

		btnSalirButton = new JButton("Salir de la sala");
		btnSalirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tocaste salir");
			}
		});
		btnSalirButton.setBounds(241, 182, 120, 23);
		contentPane.add(btnSalirButton);

		JButton btnComenzarButton = new JButton("Comenzar");
		btnComenzarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana ventana = new Ventana();
				Juego juego = new Juego(ventana);
				frame.setVisible(false);
			}
		});
		btnComenzarButton.setBounds(239, 216, 122, 23);
		contentPane.add(btnComenzarButton);
	}

	public static void main(String[] args) {
		Sala sala = new Sala("SALA 1");
	}
}
