package it.urial.rps.game.player;

import java.util.Random;

import it.urial.rps.game.GameManager;

public class Bot extends Player {
	
	public Bot() {
		super("Bot");
	}
	
	public Moves randomMove() {
		int random = new Random().ints(0, 3).findFirst().getAsInt();
		return GameManager.getMovesById(random);
	}
	
}
