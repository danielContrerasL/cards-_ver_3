package entity;

import gui.PanelNext.MiniProfilePanel;
import gui.gameWindow.ProfilePanel;
import structure.MyLinkedList;
import structure.Node;

public class Player {
	
	public static int currentId;
	private int id;
	private String name;
	private ProfilePanel profilePanel;
	private MyLinkedList<Card> hand;

	public Player(String name, ProfilePanel profilePanel, Node<Card> hand) {
		this.name = name;
		this.profilePanel = profilePanel;
		this.id = Player.currentId++;
		this.hand = new MyLinkedList<Card>();
		this.hand.add(hand);
	}
	
	public Node<Card> getHand() {
		return this.hand.getHead();
	}

	public void addCard(Card card) {
		this.hand.add(card);
	}

	public void delete(Card card) {
		this.hand.delete(card);
	}

	public int getCantCardInHand() {
		return this.hand.getSize();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ProfilePanel getProfilePanel() {
		return profilePanel;
	}
	
	public MiniProfilePanel getPicture() {
		return this.profilePanel.getPictuarePanel();
	}

}
