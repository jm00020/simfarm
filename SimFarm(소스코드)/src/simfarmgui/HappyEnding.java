package simfarmgui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import simfarm.Player;
import java.awt.Color;

public class HappyEnding extends JPanel {

	public void paintComponent(Graphics g){ 
		ImageIcon icon = new ImageIcon("image/background/ÇØÇÇ¾Øµù.jpg");
		Image img = icon.getImage();
		super.paintComponent(g); 
		g.drawImage(img,0,0,getWidth(),getHeight(),this); 
	}
	
	public HappyEnding() {
		Sound.clip.close();
		new Sound("sound/ÇØÇÇ¾Øµù.wav",true);
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
		lblNewLabel.setBounds(470, 485, 300, 62);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD95\uD558\uD569\uB2C8\uB2E4. \uBE5A\uC744 \uB2E4 \uAC1A\uC558\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_1.setForeground(new Color(255, 192, 203));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(12, 419, 776, 56);
		add(lblNewLabel_1);
	}

}
