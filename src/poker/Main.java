package poker;

import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.gamePlay();
	}

}
