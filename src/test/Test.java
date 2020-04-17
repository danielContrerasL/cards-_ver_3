package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Test extends JFrame{
	private JPanel jPanel;
	
	public Test() {
		this.setSize(500,500);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(new Dimension(550, 550));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.initWindow();
	}
	
	private void initWindow() {
		this.jPanel = new JPanel();
		this.jPanel.setBackground(Color.WHITE);
		this.jPanel.setLayout(new BoxLayout(this.jPanel, BoxLayout.Y_AXIS));
		for (int i = 0; i < 50; i++) {
			JButton b = new JButton("hola mundo " + i);
			b.setAlignmentX(CENTER_ALIGNMENT);
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jPanel.removeAll();
//					jPanel.revalidate();
					jPanel.repaint();
//					jPanel.repaint();
//					jPanel.validate();
				}
			});
			this.jPanel.add(b);
		}
		JScrollPane jScrollPane = new JScrollPane(this.jPanel);
		this.add(jScrollPane, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) {
		new Test().setVisible(true);
	}

}
