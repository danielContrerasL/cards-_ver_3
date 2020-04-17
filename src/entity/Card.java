package entity;

import java.awt.Color;
/**
 * 
 * @author Daniel Felipe Contreras Lopez
 *
 * daniel.contreras@uptc.edu.co
 * cldfrkr@hotmail.com
 */
public class Card {

	public static int cont;
	private int id;
	private Color colorCard;
	private byte numberCard;

	public Card(Color colorCard, byte numberCard) {
		this.colorCard = colorCard;
		this.numberCard = numberCard;
		this.id = Card.cont++;
	}

	public Color getColorCard() {
		return colorCard;
	}

	public byte getNumberCard() {
		return numberCard;
	}

	public int getId() {
		return id;
	}
	
	

}
