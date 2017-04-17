package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {
	
	private AIPlayer aiPlayer;
	private Deck deck;
	private List<Card> playingDeck;
	
	public Game() {
		// TODO Auto-generated constructor stub
		aiPlayer = new AIPlayer();
		
		deck = new Deck();
		playingDeck = deck.getDeck();
	}
		
	double playerCardsPower = 0;
	double aiCardsPower = 0;

	List<Card> playerCards;
	List<Card> aiCards;
	List<Card> cardsTochange = new ArrayList<>();

	int playerStack = 0;
	int aiStack = 0;
	int pot = 0;
	int bigB = 0;
	int smallB = 0;
	int roundCounter = 0;
	int playerDesicion = 0;
	int cardIndexToChange = 0;
	int playerBet = 0;
	int aiBet = 0;

	boolean aiChecks = false;
	boolean playerChecks = false;
	boolean playerIsDealer = false;
	boolean dealerDefined = false;
	boolean gameIsOn = true;

	public void gamePlay() {
		
		System.out.println("Input your starting stack. default should be like 1000");

		playerStack = Main.scanner.nextInt();
		aiStack = playerStack;

		bigB = playerStack / 25;
		smallB = playerStack / 50;

		long seed = System.nanoTime();

		System.out.println("Game starts now! Lets shuffle up and deal!");

		System.out.println("Now we define who is dealer by bigger card");

		while (!dealerDefined) {
			seed = System.nanoTime();
//			playingDeck.addAll(deck.getDeck());
			Collections.shuffle(playingDeck, new Random(seed));
			System.out.println("Player card is ");
			ShowCard.showOneCard(playingDeck.get(0));
			System.out.println("AI card is ");
			ShowCard.showOneCard(playingDeck.get(1));
			if (playingDeck.get(0).getValue() > playingDeck.get(1).getValue()) {
				playerIsDealer = true;
				System.out.println("Dealer is player");
				dealerDefined = true;
			} else if (playingDeck.get(0).getValue() < playingDeck.get(1).getValue()) {
				playerIsDealer = false;
				System.out.println("Dealer is AI");
				dealerDefined = true;
			}
		}

		// playingDeck.clear();
		
		while (gameIsOn) {
			roundCounter++;
			if (roundCounter == 10) {
				bigB *= 2;
				smallB *= 2;
				roundCounter = 0;
			}
			
			
//			playingDeck.clear();
			playingDeck.removeAll(playingDeck);
			Deck deck2 = new Deck();
			
			for (Card card : deck2.getDeck()) {
				System.out.print(card);
			}
			System.out.println("-------------");
			
//			playingDeck.addAll(deck2.getDeck());
			playingDeck = deck2.getDeck();
			seed = System.nanoTime();
			Collections.shuffle(playingDeck, new Random(seed));
			System.out.println("Playing deck: ");
			for (Card card : playingDeck) {
				System.out.print(card);
			}
			
			/*
			 * 	aiCards = new ArrayList<Card>();
				playerCards = new ArrayList<Card>();
			 * ���� ��������� �� ��� ������ ����� ����������� playingDeck,
			 * ��� �������� � ��� ������������ �� ���������� (����� �� 2)
			 * !������� �� ������� � ������
			 * 
			 */
			
			aiCards = new ArrayList<Card>();
			playerCards = new ArrayList<Card>();

			if (playerIsDealer) {
				
				playerStack -= smallB;
				aiStack -= bigB;
				pot = bigB + smallB;
				System.out.println("small blind = " + smallB + " and big blind = " + bigB);
				System.out.println("Pot = " + pot);
				System.out.println("Your stack = " + playerStack);
				System.out.println("AI stack = " + aiStack);
				System.out.println();

				aiCards.add(playingDeck.get(0));
				playerCards.add(playingDeck.get(1));
				aiCards.add(playingDeck.get(2));
				playerCards.add(playingDeck.get(3));
				aiCards.add(playingDeck.get(4));
				playerCards.add(playingDeck.get(5));
				aiCards.add(playingDeck.get(6));
				playerCards.add(playingDeck.get(7));
				aiCards.add(playingDeck.get(8));
				playerCards.add(playingDeck.get(9));

				playingDeck.remove(9); // we must remove in a oposite order
				playingDeck.remove(8);
				playingDeck.remove(7);
				playingDeck.remove(6);
				playingDeck.remove(5);
				playingDeck.remove(4);
				playingDeck.remove(3);
				playingDeck.remove(2);
				playingDeck.remove(1);
				playingDeck.remove(0);

				// ShowCard.showFiveCards(aiCards);
				// System.out.println("--------------");
				System.out.println("Your cards:");
				// ShowCard.showFiveCards(playerCards);
				DefineCombination.defineCombanation(playerCards, true);
				ShowCard.showFiveCards(playerCards);

				System.out.println("Your move: 1 - to call " + smallB + " chips; 2 - raise; 9 - fold");
				playerDesicion = Main.scanner.nextInt();
				switch (playerDesicion) {
				case 1: // player calls from SB
				{
					playerStack -= smallB;
					pot += smallB;

					aiPlayer.aiChangeCards(aiCards);
					// ai changes cards

					System.out.println("How many cards do you want to change (0-5)");
					int numberOfCardsToChangeByPlayer = Main.scanner.nextInt();
					playerChangeCards(numberOfCardsToChangeByPlayer);

					System.out.println("Your cards after exchange:");
					DefineCombination.defineCombanation(playerCards, true);
					ShowCard.showFiveCards(playerCards);

					bettingRaund(false);

					// aiBet = aiPlayer.aiDesicionCheckBetFold(aiCards, 0,
					// bigB); // ai
					// // first
					// // to
					// // act
					//
					// // ai makes a move
					//
					// playerMoveAfterAI();

				}
					break;

				case 2: // player raises
				{
					aiBet = 0;
					bettingRaundBeforeChange(true);

					aiPlayer.aiChangeCards(aiCards);
					// ai changes cards

					System.out.println("How many cards do you want to change (0-5)");
					int numberOfCardsToChangeByPlayer = Main.scanner.nextInt();
					playerChangeCards(numberOfCardsToChangeByPlayer);

					System.out.println("Your cards after exchange:");
					DefineCombination.defineCombanation(playerCards, true);
					ShowCard.showFiveCards(playerCards);

					bettingRaund(false);

					// System.out.println("How much is your raise?");
					// playerBet = Main.scanner.nextInt();
					//
					// // ai makes a decision
					//
					// aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet,
					// bigB);

				}
					break;
				case 9:
					aiStack += pot;
					pot = 0;
					break;
				default:
					break;
				}
				
			} else {
//				playingDeck.addAll(deck.getDeck());
////				playingDeck = deck.getDeck();
//				Collections.shuffle(playingDeck, new Random(seed));
				
				playerStack -= bigB;
				aiStack -= smallB;
				pot = smallB + bigB;
				System.out.println("small blind = " + smallB + " and big blind = " + bigB);
				System.out.println("Pot = " + pot);
				System.out.println("Your stack = " + playerStack);
				System.out.println("AI stack = " + aiStack);
				System.out.println();

				playerCards.add(playingDeck.get(0));
				aiCards.add(playingDeck.get(1));
				playerCards.add(playingDeck.get(2));
				aiCards.add(playingDeck.get(3));
				playerCards.add(playingDeck.get(4));
				aiCards.add(playingDeck.get(5));
				playerCards.add(playingDeck.get(6));
				aiCards.add(playingDeck.get(7));
				playerCards.add(playingDeck.get(8));
				aiCards.add(playingDeck.get(9));

				playingDeck.remove(9);
				playingDeck.remove(8);
				playingDeck.remove(7);
				playingDeck.remove(6);
				playingDeck.remove(5);
				playingDeck.remove(4);
				playingDeck.remove(3);
				playingDeck.remove(2);
				playingDeck.remove(1);
				playingDeck.remove(0);

				// ShowCard.showFiveCards(aiCards);
				//
				// System.out.println("--------------");
				System.out.println("Your cards:");
				// ShowCard.showFiveCards(playerCards);
				DefineCombination.defineCombanation(playerCards, true);
				ShowCard.showFiveCards(playerCards);

			}

			
			if (playerIsDealer) {
				playerIsDealer = false;
			} else {
				playerIsDealer = true;
			}
//			gameIsOn = false;

		}

	}
	
	

	public void playerChangeCards(int changePlayerCards) {
		switch (changePlayerCards) {
		case 0:
			break;
		case 1:
			System.out.println("Input which card to change (0-4)");
			cardIndexToChange = Main.scanner.nextInt();

			playerCards.remove(cardIndexToChange);
			playerCards.add(playingDeck.get(0));
			playingDeck.remove(0);

			break;
		case 2:
			System.out.println("Input which card to change (0-4)");

			for (int i = 0; i < 2; i++) {
				cardIndexToChange = Main.scanner.nextInt();
				cardsTochange.add(playerCards.get(cardIndexToChange));
			}
			playerCards.removeAll(cardsTochange);
			for (int i = 0; i < 2; i++) {
				playerCards.add(playingDeck.get(i));
			}
			playingDeck.remove(1);
			playingDeck.remove(0);

			break;
		case 3:
			System.out.println("Input which card to change (0-4)");

			for (int i = 0; i < 3; i++) {
				cardIndexToChange = Main.scanner.nextInt();
				cardsTochange.add(playerCards.get(cardIndexToChange));
			}
			playerCards.removeAll(cardsTochange);
			for (int i = 0; i < 3; i++) {
				playerCards.add(playingDeck.get(i));
			}
			playingDeck.remove(2);
			playingDeck.remove(1);
			playingDeck.remove(0);

			break;
		case 4:
			System.out.println("Input which card to change (0-4)");

			for (int i = 0; i < 4; i++) {
				cardIndexToChange = Main.scanner.nextInt();
				cardsTochange.add(playerCards.get(cardIndexToChange));
			}
			playerCards.removeAll(cardsTochange);
			for (int i = 0; i < 4; i++) {
				playerCards.add(playingDeck.get(i));
			}
			playingDeck.remove(3);
			playingDeck.remove(2);
			playingDeck.remove(1);
			playingDeck.remove(0);

			break;
		case 5:
			playerCards.clear();
			for (int i = 0; i < 5; i++) {
				playerCards.add(playingDeck.get(i));
			}
			playingDeck.remove(4);
			playingDeck.remove(3);
			playingDeck.remove(2);
			playingDeck.remove(1);
			playingDeck.remove(0);

			break;

		default:
			break;
		}
	}
	public void aiChangeCards(List<Card> aiCards) {

		int aiCombinationPower = DefineCombination.defineCombanation(aiCards, false);
		Random random = new Random();
		double randomDecision = random.nextDouble(); // this will make ai play spontaneous
		if (aiCombinationPower >= 4) {
			System.out.println("AI will not change any card");
		} else if (aiCombinationPower == 3) {
			
			if (randomDecision < 0.7) {
				Card setCard = new Card(null, 0, null, null);
				for (int i = 0; i < aiCards.size() - 1; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						setCard = aiCards.get(i);
					}
				}
				Iterator<Card> iterator = aiCards.iterator();
				while (iterator.hasNext()) {
					Card card = (Card) iterator.next();
					if (card.getValue() != setCard.getValue()) {
						iterator.remove();
					}
				}
				
				aiCards.add(playingDeck.get(0));
				aiCards.add(playingDeck.get(1));
				
				playingDeck.remove(1);
				playingDeck.remove(0);
				System.out.println("AI changed 2 cards");
			} else {
				System.out.println("AI will not change any card");
			}
			
		} else if (aiCombinationPower == 2) {
			
			if (randomDecision < 0.8) {
				Card cardFromPair = null;
				Card cardFromSecondPair = null;
				boolean twoPairs = false;
				
				for (int i = 0; i < 4; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						cardFromPair = aiCards.get(i);
					}
				}
				
				for (int i = 0; i < 4; i++) {
					if (aiCards.get(i).getValue() == aiCards.get(i+1).getValue()) {
						if (aiCards.get(i).getValue() != cardFromPair.getValue()) {
							twoPairs = true;
							cardFromSecondPair = aiCards.get(i);
						}
					}
				}
				
				if (twoPairs) {
					Iterator<Card> iterator = aiCards.iterator();
					while (iterator.hasNext()) {
						Card card = (Card) iterator.next();
						if (card.getValue() != cardFromPair.getValue() && card.getValue() != cardFromSecondPair.getValue()) {
							iterator.remove();
						}
					}
					aiCards.add(playingDeck.get(0));
					playingDeck.remove(0);
					System.out.println("AI changed 1 card");
				} else {
					Iterator<Card> iterator = aiCards.iterator();
					while (iterator.hasNext()) {
						Card card = (Card) iterator.next();
						if (card.getValue() != cardFromPair.getValue()) {
							iterator.remove();
						}
					}
					aiCards.add(playingDeck.get(0));
					aiCards.add(playingDeck.get(1));
					aiCards.add(playingDeck.get(2));
					
					playingDeck.remove(2);
					playingDeck.remove(1);
					playingDeck.remove(0);
					System.out.println("AI changed 3 cards");
				}
			} else {
				System.out.println("AI will not change any card");
			}		
			
		} else if (aiCombinationPower < 2) {
//			Card hiCard = aiCards.get(4);
			
			aiCards.remove(3);
			aiCards.remove(2);
			aiCards.remove(1);
			aiCards.remove(0);
			
			aiCards.add(playingDeck.get(0));
			aiCards.add(playingDeck.get(1));
			aiCards.add(playingDeck.get(2));
			aiCards.add(playingDeck.get(3));
			
			playingDeck.remove(3);
			playingDeck.remove(2);
			playingDeck.remove(1);
			playingDeck.remove(0);
			
			System.out.println("AI changed 4 cards");
			
		}
	
	}
	public void bettingRaundBeforeChange(boolean playerStarts) {
		// regulates betting till the end
		boolean gameIsOn = true;
		// int playerBetting = 0;
		// int aiBetting = 0;
		playerBet = 0;
		while (gameIsOn) {
			if (playerStarts) {
				playerBet = playerMoveAfterAI();
				if (playerBet > 0) {
					aiBet = aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
					if (aiBet == playerBet) {
						// defineWinner();
						gameIsOn = false;
					} else if (aiBet < 0) {
						playerStack += pot;
						pot = 0;
						gameIsOn = false;
					}
				}
				// } else if (playerBet == 0 && aiBet == 0) {
				//
				// }

			} else {
				aiBet = aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
				if (aiBet == playerBet) {
					// defineWinner();
					gameIsOn = false;
				} else if (aiBet > playerBet) {
					playerBet = playerMoveAfterAI();
					if (playerBet == 0) {
						gameIsOn = false;
					}
				} else if (aiBet < 0) {
					playerStack += pot;
					pot = 0;
					gameIsOn = false;
				}
			}
		}

		// return true;

	}

	public boolean bettingRaund(boolean playerStarts) {// regulates betting till
														// the end
		boolean gameIsOn = true;
		// int playerBetting = 0;
		// int aiBetting = 0;
		playerBet = 0;
		while (gameIsOn) {
			if (playerStarts) {
				playerBet = playerMoveAfterAI();
				if (playerBet > 0) {
					aiBet = aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
					if (aiBet == playerBet) {
						defineWinner();
						gameIsOn = false;
					} else if (aiBet < 0) {
						playerStack += pot;
						pot = 0;
						gameIsOn = false;
					}
				}
				// } else if (playerBet == 0 && aiBet == 0) {
				//
				// }

			} else {
				aiBet = aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
				if (aiBet == playerBet) {
					defineWinner();
					gameIsOn = false;
				} else if (aiBet > playerBet) {
					playerBet = playerMoveAfterAI();
					if (playerBet == 0) {
						gameIsOn = false;
					}
				} else if (aiBet < 0) {
					playerStack += pot;
					pot = 0;
					gameIsOn = false;
				}
			}
		}

		return true;
	}

	public int playerMoveAfterAI() {
		if (aiBet == 0) {
			System.out.println("Your move: 1 check " + "; 2 - raise; 9 - fold");
			int playerMoveInt = Main.scanner.nextInt();
			switch (playerMoveInt) {
			case 1:
				defineWinner(); // show dowm
				return 0;

			// break;
			case 2:
				System.out.println("What is your raise?");
				playerBet = Main.scanner.nextInt();
				// aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
				return playerBet;
			// ai to fold or call

			// break;
			case 9:
				System.out.println("Player folds");
				aiStack += pot; // start new game
				pot = 0;
				return 0;
			// break;
			default:
				break;
			}
		} else if (aiBet > 0) {
			System.out.println("Your move: 1 call " + "; 2 - raise; 9 - fold");
			int playerMoveInt = Main.scanner.nextInt();
			switch (playerMoveInt) {
			case 1:
				playerStack -= aiBet;
				pot += aiBet;
				defineWinner();
				return 0;
			// break;
			case 2:
				System.out.println("What is your raise?");
				playerBet = Main.scanner.nextInt();
				// aiPlayer.aiDesicionCheckBetFold(aiCards, playerBet, bigB);
				return playerBet;
			// ai to fold or call

			// break;
			case 9:
				System.out.println("Player folds");
				aiStack += pot;
				pot = 0;
				return 0;
			// start new game
			// break;
			}
		}
		return 0;
	}

	public void defineWinner() {
		int winner = showDown(playerCards, aiCards);

		if (winner == 1) {
			playerStack += pot;
			pot = 0;
		} else if (winner == 2) {
			aiStack += pot;
			pot = 0;
		} else if (winner == 0) {
			playerStack += (pot / 2);
			aiStack += (pot / 2);
			pot = 0;
		}
	}

	public int showDown(List<Card> playerCards, List<Card> aiCards) { // returns
																		// who
																		// is a
																		// winner
		System.out.println("Your cards");
		playerCardsPower = DefineCombination.defineCombanation(playerCards, true);
		ShowCard.showFiveCards(playerCards);

		System.out.println("AI cards");
		aiCardsPower = DefineCombination.defineCombanation(aiCards, true);
		ShowCard.showFiveCards(aiCards);

		if (playerCardsPower > aiCardsPower) {
			System.out.println("Player wins");
			return 1;
		} else if (playerCardsPower < aiCardsPower) {
			System.out.println("AI wins");
			return 2;
		} else {
			System.out.println("Split pot");
			return 0;
		}
	}
}
