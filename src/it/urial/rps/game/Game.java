package it.urial.rps.game;

import java.util.HashMap;

import it.urial.rps.game.player.Player;

public class Game {
	
	private HashMap<Player, Integer> scores = new HashMap<Player, Integer>();
	
	private GameState state = GameState.LOBBY;
	
	/**
	 * 
	 * @return Game's state
	 */
	public GameState getState() {
		return state;
	}
	
	/**
	 * Set game's state
	 * @param state new game's state
	 */
	public void setState(GameState state) {
		this.state = state;
	}
	
	/**
	 * 
	 * @param player
	 * @return player's score
	 */
	public int getScore(Player player) {
		return scores.containsKey(player) ? scores.get(player) : 0;
	}
	
	/**
	 * 
	 * @param player Player or bot
	 * @param score new score
	 */
	public void setScore(Player player, int score) {
		scores.put(player, score);
	}
	
	/**
	 * 
	 * @param player player or bot
	 */
	public void addScore(Player player) {
		scores.put(player, getScore(player)+1);
	}
	
}
