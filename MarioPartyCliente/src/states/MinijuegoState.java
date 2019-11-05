package states;

import java.awt.Color;
import java.awt.Graphics;

import hansolo.mario.Juego;

public class MinijuegoState extends State {

	public MinijuegoState(Juego juego) {
		super(juego);
	}

	@Override
	public void calcular() {

	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.drawString("MINIJUEGO STATE", 500, 500);
	}

}
