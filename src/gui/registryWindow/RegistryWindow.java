package gui.registryWindow;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import constant.Constant;
import constant.ConstantGui;
import controller.GameController;

@SuppressWarnings("serial")
public class RegistryWindow extends JDialog {
	private JButton ima;
	private JTextField nickName;
	private JButton add;
	private JLabel profileIcon;
	private GameController controller;
	private String urlImage;

	public RegistryWindow(GameController controller) {
		this.controller = controller;
		this.setSize(215, 250);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4, 1));
		this.initDialog();

	}

	private void initDialog() {
		this.profileIcon = new JLabel();
		this.profileIcon.setIcon(new ImageIcon(ConstantGui.DF_USER_ICO));
		this.add(this.profileIcon);

		this.nickName = new JTextField("New User");
		this.add(this.nickName);

		this.ima = new JButton("Agregar imagen");
		this.ima.setActionCommand(Constant.ATION_SHOW_IMA);
		this.ima.addActionListener(this.controller);
		this.add(this.ima);
		this.add = new JButton("AgregarJugador");
		this.add.setActionCommand(Constant.ACTION_REGISTRY);
		this.add.addActionListener(this.controller);
		this.add(this.add);
	}

	public void addProfileIcon(String url) {
		ImageIcon icon = new ImageIcon(url);
		this.profileIcon.setIcon(icon);
		this.revalidate();
	}

	public void showPreview() {
		this.urlImage = this.getImageFile();
		this.addProfileIcon(this.urlImage);
	}

	public String getInfoPlayer() {
		this.urlImage += "," + this.nickName.getText();
		this.clear();
		return this.urlImage;
	}

	private void clear() {
		this.setVisible(false);
		this.nickName.setText("NickName");
		this.addProfileIcon(ConstantGui.DF_USER_ICO);

	}

	public String getImageFile() {
		String img = null;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE file", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		chooser.setFileHidingEnabled(false);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			img = chooser.getSelectedFile().getAbsolutePath();
		}
		return img;
	}

}
