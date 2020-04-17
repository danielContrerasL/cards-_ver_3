package gui.PanelNext;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Player;

@SuppressWarnings("serial")
public class PanelNext extends JPanel{
	
	private MiniProfilePanel profilePanel;
	private JLabel nick;
	
	
	public PanelNext(Player player) {
		this.setLayout(new GridLayout(2, 1));
		this.profilePanel = player.getProfilePanel().getPictuarePanel();
		this.add(this.profilePanel);
		this.nick = new JLabel(player.getName());
		this.add(this.nick);
		
	}
}
