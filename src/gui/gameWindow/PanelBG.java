package gui.gameWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import constant.ConstantGui;
import entity.Card;

@SuppressWarnings("serial")
public class PanelBG extends JPanel {

	private Card actualcard;
	private Image bg = new ImageIcon(getClass().getResource(ConstantGui.BACKGROUNG)).getImage();

	public void setActualcard(Card actualcard) {
		this.actualcard = actualcard;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x = (int) (this.getWidth() * 0.4);
		int y = (int) (this.getHeight() * 0.2);
		int w = (int) (this.getWidth() * 0.2);
		int h = (int) (this.getHeight() * 0.6);
		if (this.actualcard != null){
			g.setColor(this.actualcard.getColorCard());
			g.fillRect(x, y, w, h);
			g.setColor(Color.BLACK);
			g.drawString(String.valueOf(this.actualcard.getNumberCard()), (int)this.getWidth()/2, (int)this.getHeight()/2);
		}
	}
}
