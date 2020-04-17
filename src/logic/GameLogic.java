package logic;

import java.util.Random;
import constant.Constant;
import entity.Card;
import entity.Player;
import gui.PanelNext.MiniProfilePanel;
import gui.gameWindow.ProfilePanel;
import structure.CircularList;
import structure.MyLinkedList;
import structure.Node;
import structure.Stack;

public class GameLogic {
	private CircularList<Player> playerList;
	private Stack<Card> deck;
	private Card cardOntable;
	private Node<Player> auctualPlayer;

	public GameLogic() {
		this.deck = new Stack<Card>();
		this.playerList = new CircularList<Player>();
		this.createDeck();
		this.unSort(10, 10);
		this.addDefaultUser();
		this.cardOntable = this.deck.pop();
	}

	public void createDeck() {
		for (int i = 0; i < Constant.TYPE_COLOR.length; i++) {
			for (int j = 0; j < Constant.CANT_OF_CARD; j++) {
				this.deck.push(new Card(Constant.TYPE_COLOR[i], (byte) j));
			}
		}
	}

	public void addDefaultUser() {
		for (int i = 0; i < 3; i++) {
			Node<Player> auxPlayer = new Node<Player>(new Player("Default " + i,
					new ProfilePanel("Default " + i, new MiniProfilePanel("/ima/" + i + ".png")), this.initHand() ));
			this.playerList.add(auxPlayer);
		}
		this.auctualPlayer = this.playerList.getHead();
	}

	private Node<Card> initHand() {
		MyLinkedList<Card> auxHand = new MyLinkedList<Card>();
		for (int i = 0; i < 5; i++) {
			auxHand.add(this.deck.pop());
		}
		return auxHand.getHead();
	}

	public void addPlayer(String[] info) {
		MiniProfilePanel auxMiniProPanel = new MiniProfilePanel(info[0]);
		this.playerList.add(new Node<Player>(new Player(info[1], new ProfilePanel(info[1], auxMiniProPanel), this.initHand())));
		this.auctualPlayer = this.playerList.getHead();
	}
	
	public void putACard() {
		Node<Card> auxCard = this.auctualPlayer.getInfo().getHand();
		while (auxCard != null) {
			if (auxCard.getInfo().getNumberCard() == this.cardOntable.getNumberCard() || auxCard.getInfo().getColorCard() == this.cardOntable.getColorCard()) {
				this.cardOntable = auxCard.getInfo();
				this.auctualPlayer.getInfo().delete(auxCard.getInfo());
				return;
			}
			auxCard = auxCard.getNext();
		}
	}

	public Player nextTurn() {
		Player exit = this.auctualPlayer.getInfo();
		this.auctualPlayer = this.auctualPlayer.getNext();
		return exit;
	}
	
	public void askCard() throws Exception {
		if (!this.deck.isEmpty()) 
			this.auctualPlayer.getInfo().addCard(this.deck.pop());
		else 
			throw new Exception("Deck Agotado");
	}
	
	public Node<Card> getHand() {
		return this.auctualPlayer.getInfo().getHand();
	}
	
	public void setCardOnTheTable(Card newCard) {
		this.cardOntable = newCard;
	}
	
	public Card getCardOntable() {
		return cardOntable;
	}

	@SuppressWarnings("unchecked")
	public void unSort(int times, int size) {
		Random random = new Random();
		Stack<Card>[] auxDeck = new Stack[size];
		for (int i = 0; i < auxDeck.length; i++) {
			auxDeck[i] = new Stack<Card>();
		}
		while (!(this.deck.isEmpty())) {
			auxDeck[random.nextInt(auxDeck.length)].push(this.deck.pop());
		}
		for (int i = 0; i < auxDeck.length; i++) {
			while (!auxDeck[i].isEmpty()) {
				this.deck.push(auxDeck[i].pop());
			}
		}
		if (times != 0) {
			times--;
			this.unSort(times, size);
		}
	}

}
