package gui.gameWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import constant.Constant;
import constant.ConstantGui;
import controller.GameController;
import entity.Card;
import gui.PanelNext.MiniProfilePanel;
import structure.Node;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	private ProfilePanel jPanelProfile;
	private PanelBG bg;
	private JPanel panelHand;
	private JPanel panelNextPlayer ;
	private GridBagConstraints c;
	
	private JMenuBar jMenuBar;
	private JMenu jMenuRegistryCapsule;
	private JMenuItem jMenuRegistry;
	
	private MiniProfilePanel defaultUser;
	private JButton askButton;
	private JButton putCard;
	private int cardInHand;
	
	private GameController controller;

	public GameWindow(GameController controller) {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(850, 500));
		this.controller = controller;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		this.initMenuBar();

		this.c = new GridBagConstraints();
		this.c.fill = GridBagConstraints.BOTH;
		this.c.weightx = 1;
		this.c.gridheight = 1;
		this.c.weighty = 0.01;

		for (int i = 0; i < 12; i++) {
			this.c.gridx = i;
			this.c.gridy = i;
			this.add(new JLabel(), c);
		}
		
		this.defaultUser = new MiniProfilePanel(ConstantGui.DF_USER_ICO);
		this.jPanelProfile = new ProfilePanel("Panda", this.defaultUser);
		this.c.gridx = 0;
		this.c.gridy = 0;
		this.c.gridwidth = 4;
		this.c.gridheight = 10;
		this.add(this.jPanelProfile, this.c);
		
		this.bg = new PanelBG();
		this.c.gridx = 4;
		this.c.gridy = 0;
		this.c.gridwidth = 6;
		this.c.gridheight = 8;
		this.add(this.bg, this.c);


		JPanel p3 = new JPanel();
		this.c.gridx = 10;
		this.c.gridy = 0;
		this.c.gridwidth = 3;
		this.c.gridheight = 10;
		p3.setBackground(Color.BLUE);
		this.add(p3, this.c);

		this.panelHand = new JPanel();
		this.c.gridx = 4;
		this.c.gridy = 8;
		this.c.gridwidth = 6;
		this.c.gridheight = 4;
		this.panelHand.setLayout(new GridLayout(1, 5));
		this.add(this.panelHand, this.c);

		this.panelNextPlayer = new JPanel();
		this.c.gridx = 10;
		this.c.gridy = 10;
		this.c.gridwidth = 3;
		this.c.gridheight = 2;
		this.panelNextPlayer.setLayout(new GridLayout(1, 1));
		JButton jBNextPlayer = new JButton("Siguiente . . .");
		jBNextPlayer.setActionCommand(Constant.ACTION_NEXT_PLAYER);
		jBNextPlayer.addActionListener(controller);
		this.panelNextPlayer.add(jBNextPlayer);
		this.add(this.panelNextPlayer, this.c);
		
		this.askButton = new JButton("Pedir");
		this.askButton.setActionCommand(Constant.ATION_ASK_BUTTON);
		this.askButton.addActionListener(controller);
		this.c.gridx = 1;
		this.c.gridy = 10;
		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.add(this.askButton, this.c);
		
		this.putCard = new JButton("Poner");
		this.putCard.setActionCommand(Constant.ATION_PUT_BUTTON);
		this.putCard.addActionListener(controller);
		this.c.gridx = 1;
		this.c.gridy = 11;
		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.add(this.putCard, this.c);
	}
	
	private void initMenuBar() {
		this.jMenuBar = new JMenuBar();
		this.jMenuRegistryCapsule = new JMenu("Juego");
		this.jMenuRegistry = new JMenuItem("Jugador Nuevo");
		this.jMenuRegistry.setActionCommand(Constant.OPEN_REGISTRY);
		this.jMenuRegistry.addActionListener(this.controller);
		this.jMenuRegistryCapsule.add(this.jMenuRegistry);
		this.jMenuBar.add(this.jMenuRegistryCapsule);
		this.setJMenuBar(this.jMenuBar);
	}
	
	public void showCard(Node<Card> hand) {
		this.calculateGrid(hand);
		Node<Card> aux = hand;
		this.panelHand.removeAll();
		this.cardInHand = 0;
		while (aux !=null) {
			JButton auxButton = new JButton(String.valueOf(aux.getInfo().getNumberCard()));
			auxButton.setBackground(aux.getInfo().getColorCard());
			this.panelHand.add(auxButton);
			this.cardInHand++;
			aux = aux.getNext();
		}
		this.panelHand.revalidate();
	}
	
	private void calculateGrid(Node<Card> hand){
		Node<Card> aux = hand;
		int cont = 0;
		while (aux !=null) {
			cont++;
			aux = aux.getNext();
		}
		int row = (cont / 3) == 0?1:(cont / 3);
		int col = (cont / 7) == 0?1:(cont / 7);
		panelHand.setLayout(new GridLayout(row, col));
	}
	
	public void updateProfilePanel(ProfilePanel actualProfile) {
		this.remove(this.jPanelProfile);
		this.jPanelProfile = actualProfile;
		this.jPanelProfile.updatecardInHand(this.cardInHand);
		this.c.gridx = 0;
		this.c.gridy = 0;
		this.c.gridwidth = 4;
		this.c.gridheight = 10;
		this.add(this.jPanelProfile, this.c);
		this.jPanelProfile.setVisible(true);
		this.jPanelProfile.revalidate();
		this.repaint();
	}
	
	public void setActualCard(Card actualcard) {
		this.bg.setActualcard(actualcard);
	}
	
}
