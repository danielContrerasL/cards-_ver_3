package gui.PanelNext;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MiniProfilePanel extends JPanel {

	private String root;
	private Image bg;

	public MiniProfilePanel() {
	}

	public MiniProfilePanel(String root) {
		if (root.charAt(1) != 'i') {
			this.bg = new ImageIcon(root).getImage();
		} else {
			this.bg = new ImageIcon(getClass().getResource(root)).getImage();
		}
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public void updatePanel() {
		this.bg = new ImageIcon(getClass().getResource(this.root)).getImage();
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.bg, 20, 20, this.getWidth() - 30, this.getHeight() -30, this);
	}

}
