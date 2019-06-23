package it.urial.rps.game;

import java.util.Scanner;

import it.urial.rps.game.player.Bot;
import it.urial.rps.game.player.Moves;
import it.urial.rps.game.player.Player;
import it.urial.rps.utils.Utils;

public class GameManager {
	
	public static void startGame(Game game) {
		System.out.println("Hey! Welcome to the RPS Game made by @de_cifris !");
		System.out.println("Type your IGN (In Game Name)");
		
		Bot bot = new Bot();
		
		Scanner scanner = new Scanner(System.in);
		String out;
		
		Player player = new Player(scanner.nextLine());
		System.out.println("Alright " + player.getName() + " let's play together!");
		System.out.println("Type a number between 0 and 2 (ROCK=0, PAPER=1, SCISSORS=2)");
		while(!(out = scanner.nextLine()).equals("$")) {
			if(Utils.isNumber(out)) {
				game.setState(GameState.WAITING_FOR_MOVE);
				int move = Integer.parseInt(out);
				
				if(move >= 0 && move < 3) {
					Moves player1 = getMovesById(move);
					Moves bot1 = bot.randomMove();
					
					int result = getWinner(player1, bot1);
					
					switch(result) {
					case 1: break;
					case 2: game.addScore(player); break;
					case 3: game.addScore(bot); break;
					}
					
					game.setState(GameState.RESULT);
					System.out.println("You: " + player1 + "\nBot: " + bot1);
					System.out.println(result == 1 ? "Draw!" : result == 2 ? "You won!" : "You lost!");
					System.out.println("Score: (You)" + game.getScore(player) + " VS (Bot)" + game.getScore(bot));
					System.out.println("\nType \"$\" to quit.");
				} else {
					System.out.println("NO! Wronged range number 0-2 (ROCK=0, PAPER=1, SCISSORS=2)");
				}
			} else {
				System.out.println("NO! Just type a number! (ROCK=0, PAPER=1, SCISSORS=2)");
			}
		}
		
		game.setState(GameState.END);
		scanner.close();
	}
	
	public static Moves getMovesById(int id) {
		Moves move = null;
		for(Moves moves : Moves.values()) {
			if(moves.getId() == id) move = moves;
		}
		
		return move;
	}
	
	private static int getWinner(Moves player, Moves bot) {
		int winner = 0;
		
		if(player.equals(bot)) {
			winner = 1; //DRAW
		} else if(!player.equals(bot)) {
			if((player.equals(Moves.PAPER) && bot.equals(Moves.ROCK))
					|| (player.equals(Moves.ROCK) && bot.equals(Moves.SCISSORS))
					|| (player.equals(Moves.SCISSORS) && bot.equals(Moves.PAPER))) {
				winner = 2; //WIN
			} else {
				winner = 3; //LOSE
			}
		}
		
		return winner;
	}
	
}
