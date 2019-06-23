package it.urial.rps.game.player;

public enum Moves {
	
	ROCK(0),
	PAPER(1),
	SCISSORS(2);
	
	private int id;
	
	private Moves(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return Move's ID
	 */
	public int getId() {
		return this.id;
	}
	
}
