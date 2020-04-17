package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import constant.Constant;
import gui.gameWindow.GameWindow;
import gui.registryWindow.RegistryWindow;
import logic.GameLogic;

public class GameController implements ActionListener {

	private GameWindow gameWindow;
	private RegistryWindow registryWindow;
	private GameLogic gameLogic;

	public GameController() {
		this.gameLogic = new GameLogic();
		this.openWindow();
	}

	private void openWindow() {
		this.gameWindow = new GameWindow(this);
		this.gameWindow.setActualCard(this.gameLogic.getCardOntable());
		this.gameWindow.setVisible(true);
	}

	private void openRegistryWindow() {
		if (this.registryWindow == null) {
			this.registryWindow = new RegistryWindow(this);
		}
		this.registryWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.actionPerformedAction(e);
		this.actionPerformedOpen(e);

	}

	private void actionPerformedOpen(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constant.OPEN_REGISTRY:
			this.openRegistryWindow();
			break;
		}

	}

	private void actionPerformedAction(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Constant.ATION_SHOW_IMA:
			this.registryWindow.showPreview();
			break;
		case Constant.ACTION_REGISTRY:
			this.gameLogic.addPlayer(this.registryWindow.getInfoPlayer().split(",")); 
			break;
			
		case Constant.ACTION_NEXT_PLAYER:
			this.gameWindow.updateProfilePanel(this.gameLogic.nextTurn().getProfilePanel());
			this.gameWindow.showCard(this.gameLogic.getHand());
			break;
			
		case Constant.ATION_ASK_BUTTON:
			try {
				this.gameLogic.askCard();
				this.gameWindow.showCard(this.gameLogic.getHand());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this.gameWindow, e1.getMessage(), e1.getMessage(), JOptionPane.ERROR_MESSAGE);
			}; 
			break;
		case Constant.ATION_PUT_BUTTON:
			this.gameLogic.putACard();
			this.gameWindow.showCard(this.gameLogic.getHand());
			break;
		}
	}

}
