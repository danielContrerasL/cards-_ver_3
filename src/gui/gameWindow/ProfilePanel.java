package gui.gameWindow;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import gui.PanelNext.MiniProfilePanel;

@SuppressWarnings("serial")
public class ProfilePanel extends JPanel {

	private MiniProfilePanel pictuarePanel;
	private String nickName;
	private JLabel cardInHand;
	private JRadioButton auto;
	
	
	private Border border;
	private GridBagConstraints c;
	
	public ProfilePanel(String nickName, MiniProfilePanel pictuarePanel) {
		this.nickName = nickName;
		this.pictuarePanel = pictuarePanel;
		this.border = BorderFactory.createRaisedBevelBorder();
		this.setLayout(new GridBagLayout());
		this.initLayout();
		this.initButton();
		this.initLableCard();
		this.initRadioButton();
	}
	
	public String getName() {
		return this.nickName;
	}
	
	public void initLayout() {
		this.c = new GridBagConstraints();
		this.c.fill = GridBagConstraints.BOTH;
		this.c.weightx = 1;
		this.c.gridheight = 1;
		this.c.weighty = 0.01;
		for (int i = 0; i < 12; i++) {
			this.c.gridx = i;
			this.c.gridy = i;
			this.add(new JLabel(), this.c);
		}
	}
	
	public void initButton() {
		this.c.gridx = 3;
		this.c.gridy = 1;
		this.c.gridwidth = 6;
		this.c.gridheight = 6;
		TitledBorder title;
		title = BorderFactory.createTitledBorder(this.nickName);
		this.pictuarePanel.setBorder(title);
		this.add(this.pictuarePanel, this.c);
	}
	
	
	public void initLableCard() {
		this.cardInHand = new JLabel();
		this.cardInHand.setText("Cartas en mano: 5");
		this.cardInHand.setBorder(this.border);
		this.c.gridx = 4;
		this.c.gridy = 7;
		this.c.gridwidth = 4;
		this.c.gridheight = 1;
		this.add(this.cardInHand, this.c);
	}
	
	public void initRadioButton() {
		this.auto = new JRadioButton("Auto");
		this.auto.setToolTipText("Jugara automaticamente");
		this.c.gridx = 5;
		this.c.gridy = 8;
		this.c.gridwidth = 3;
		this.c.gridheight = 1;
		this.add(this.auto, this.c);
	}

	public MiniProfilePanel getPictuarePanel() {
		return pictuarePanel;
	}
	
	
	public void updatecardInHand(int num) {
		this.cardInHand.setText("Cartas en mano " + String.valueOf(num));
	}
	
	
	
	
}
