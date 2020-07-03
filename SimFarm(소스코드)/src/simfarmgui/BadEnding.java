package simfarmgui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import simfarm.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BadEnding extends JPanel {

	public void paintComponent(Graphics g){ 
		ImageIcon icon = new ImageIcon("image/background/¹èµå¾Øµù.jpg");
		Image img = icon.getImage();
		super.paintComponent(g); 
		g.drawImage(img,0,0,getWidth(),getHeight(),this); 
	}
	
	public BadEnding() {
		Sound.clip.close();
		new Sound("sound/¹èµå¾Øµù.wav",true);
		setBounds(-8, 0, 800, 600);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBA54\uB274\uB85C \uB3CC\uC544\uAC00\uAE30");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.clip.close();
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MainScreen.th.interrupt();
				Player.Initialization();
				MenuScreen.contentPane.add(MenuScreen.firstpanel);
				new Sound("sound/menu.wav",true);
				MenuScreen.firstpanel.setVisible(true);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblNewLabel.setBounds(471, 485, 300, 62);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE5A\uC744 \uAC1A\uC9C0 \uBABB\uD558\uC5EC \uBE5A\uC7C1\uC774\uC5D0\uAC8C \uC7A1\uD600\uAC14\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(12, 419, 776, 56);
		add(lblNewLabel_1);

	}

}
