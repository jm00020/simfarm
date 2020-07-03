package simfarmgui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import simfarm.Player;

public class ChoicehelperScreen extends JPanel {
	JPanel choice;
	JPanel chickenex;
	JPanel pigex;
	JPanel sheepex;
	JPanel cowex;
	JPanel deerex;

	public ChoicehelperScreen() {
		setBounds(-8, 0, 800, 600);
		setLayout(null);
		choice = new JPanel(){
			public void paintComponent(Graphics g){ 
			ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
			Image img = icon.getImage();
	       	super.paintComponent(g); 
	        g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		choice.setBounds(-8, 0, 800, 600);
		choice.setLayout(null);
		
		ChickenEx();
		PigEx();
		SheepEx();
		CowEx();
		DeerEx();
		
		ImageIcon [] image = {new ImageIcon("image/helper/¾ßÂ÷¸ð(´ß1).png"),
							  new ImageIcon("image/helper/¶Ñ±¸¸®(µÅÁö1).png"),
							  new ImageIcon("image/helper/¸Þ¸®ÇÁ(¾ç1).png"),
							  new ImageIcon("image/helper/¹ÐÅÊÅ©(¼Ò1).png"),
							  new ImageIcon("image/helper/»çÃ¶·Ï(»ç½¿1).png")
		};
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC6B0\uBBF8 \uC120\uD0DD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 99));
		lblNewLabel.setBounds(147, 35, 506, 100);
		choice.add(lblNewLabel);
		
		JLabel lblChicken = new JLabel(image[0]);
		lblChicken.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choice.setVisible(false);
				remove(choice);
				add(chickenex);
				chickenex.setVisible(true);
			}
		});
		lblChicken.setBounds(87, 188, 150, 150);
		choice.add(lblChicken);
		
		JLabel lblPig = new JLabel(image[1]);
		lblPig.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choice.setVisible(false);
				remove(choice);
				add(pigex);
				pigex.setVisible(true);
			}
		});
		lblPig.setBounds(324, 188, 150, 150);
		choice.add(lblPig);
		
		JLabel lblsheep = new JLabel(image[2]);
		lblsheep.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choice.setVisible(false);
				remove(choice);
				add(sheepex);
				sheepex.setVisible(true);
			}
		});
		lblsheep.setBounds(561, 188, 150, 150);
		choice.add(lblsheep);
		
		JLabel lblCow = new JLabel(image[3]);
		lblCow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choice.setVisible(false);
				remove(choice);
				add(cowex);
				cowex.setVisible(true);
			}
		});
		lblCow.setBounds(197, 354, 150, 150);
		choice.add(lblCow);
		
		JLabel lblDeer = new JLabel(image[4]);
		lblDeer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choice.setVisible(false);
				remove(choice);
				add(deerex);
				deerex.setVisible(true);
			}
		});
		lblDeer.setBounds(458, 354, 150, 150);
		choice.add(lblDeer);
		
		add(choice);
	}
	
	public void ChickenEx(){
		chickenex = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		chickenex.setBounds(-8, 0, 800, 600);
		chickenex.setLayout(null);
		
		ImageIcon image = new ImageIcon("image/helper/´ßÁøÈ­°úÁ¤.png");
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(110, 140, 600, 170);
		chickenex.add(lblimage);
		
		JLabel lblexplanation = new JLabel("´ßÀ» Å°¿ï ¶§ ´Þ°¿À» 10%(->25%->50%)´õ »¡¸® È¹µæ °¡´É");
		lblexplanation.setForeground(Color.BLACK);
		lblexplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblexplanation.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 20));
		lblexplanation.setBounds(110, 320, 600, 100);
		chickenex.add(lblexplanation);
		
		JLabel lblselect = new JLabel("¼±ÅÃ");
		lblselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Player.helper = 1;
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MenuScreen.contentPane.add(new MainScreen());
			}
		});
		lblselect.setForeground(Color.BLACK);
		lblselect.setHorizontalAlignment(SwingConstants.CENTER);
		lblselect.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblselect.setBounds(627, 410, 129, 40);
		chickenex.add(lblselect);
		
		JLabel lblexit = new JLabel("³ª°¡±â");
		lblexit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				chickenex.setVisible(false);
				remove(chickenex);
				add(choice);
				choice.setVisible(true);
			}
		});
		lblexit.setForeground(Color.BLACK);
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblexit.setBounds(627, 480, 129, 40);
		chickenex.add(lblexit);
	}
	
	public void PigEx(){
		pigex = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		pigex.setBounds(-8, 0, 800, 600);
		pigex.setLayout(null);
		
		ImageIcon image = new ImageIcon("image/helper/µÅÁöÁøÈ­°úÁ¤.png");
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(110, 140, 600, 170);
		pigex.add(lblimage);
		
		JLabel lblexplanation = new JLabel("µÅÁö¸¦ Å°¿ï ¶§ °í±â¸¦ 10%(->25%->50%)´õ »¡¸® È¹µæ °¡´É");
		lblexplanation.setForeground(Color.BLACK);
		lblexplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblexplanation.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 20));
		lblexplanation.setBounds(110, 320, 600, 100);
		pigex.add(lblexplanation);
		
		JLabel lblselect = new JLabel("¼±ÅÃ");
		lblselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Player.helper = 2;
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MenuScreen.contentPane.add(new MainScreen());
			}
		});
		lblselect.setForeground(Color.BLACK);
		lblselect.setHorizontalAlignment(SwingConstants.CENTER);
		lblselect.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblselect.setBounds(627, 410, 129, 40);
		pigex.add(lblselect);
		
		JLabel lblexit = new JLabel("³ª°¡±â");
		lblexit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pigex.setVisible(false);
				remove(pigex);
				add(choice);
				choice.setVisible(true);
			}
		});
		lblexit.setForeground(Color.BLACK);
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblexit.setBounds(627, 480, 129, 40);
		pigex.add(lblexit);
	}

	public void SheepEx(){
		sheepex = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		sheepex.setBounds(-8, 0, 800, 600);
		sheepex.setLayout(null);
		
		ImageIcon image = new ImageIcon("image/helper/¾çÁøÈ­°úÁ¤.png");
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(110, 140, 600, 170);
		sheepex.add(lblimage);
		
		JLabel lblexplanation = new JLabel("¾çÀ» Å°¿ï ¶§ ÅÐÀ» 10%(->25%->50%)´õ »¡¸® È¹µæ °¡´É");
		lblexplanation.setForeground(Color.BLACK);
		lblexplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblexplanation.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 20));
		lblexplanation.setBounds(110, 320, 600, 100);
		sheepex.add(lblexplanation);
		
		JLabel lblselect = new JLabel("¼±ÅÃ");
		lblselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Player.helper = 3;
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MenuScreen.contentPane.add(new MainScreen());
			}
		});
		lblselect.setForeground(Color.BLACK);
		lblselect.setHorizontalAlignment(SwingConstants.CENTER);
		lblselect.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblselect.setBounds(627, 410, 129, 40);
		sheepex.add(lblselect);
		
		JLabel lblexit = new JLabel("³ª°¡±â");
		lblexit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				sheepex.setVisible(false);
				remove(sheepex);
				add(choice);
				choice.setVisible(true);
			}
		});
		lblexit.setForeground(Color.BLACK);
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblexit.setBounds(627, 480, 129, 40);
		sheepex.add(lblexit);
	}
	
	public void CowEx(){
		cowex = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		cowex.setBounds(-8, 0, 800, 600);
		cowex.setLayout(null);
		
		ImageIcon image = new ImageIcon("image/helper/¼ÒÁøÈ­°úÁ¤.png");
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(110, 140, 600, 170);
		cowex.add(lblimage);
		
		JLabel lblexplanation = new JLabel("¼Ò¸¦ Å°¿ï ¶§ ¿ìÀ¯¸¦ 10%(->25%->50%)´õ »¡¸® È¹µæ °¡´É");
		lblexplanation.setForeground(Color.BLACK);
		lblexplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblexplanation.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 20));
		lblexplanation.setBounds(110, 320, 600, 100);
		cowex.add(lblexplanation);
		
		JLabel lblselect = new JLabel("¼±ÅÃ");
		lblselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Player.helper = 4;
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MenuScreen.contentPane.add(new MainScreen());
			}
		});
		lblselect.setForeground(Color.BLACK);
		lblselect.setHorizontalAlignment(SwingConstants.CENTER);
		lblselect.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblselect.setBounds(627, 410, 129, 40);
		cowex.add(lblselect);
		
		JLabel lblexit = new JLabel("³ª°¡±â");
		lblexit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cowex.setVisible(false);
				remove(cowex);
				add(choice);
				choice.setVisible(true);
			}
		});
		lblexit.setForeground(Color.BLACK);
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblexit.setBounds(627, 480, 129, 40);
		cowex.add(lblexit);
	}
	
	public void DeerEx(){
		deerex = new JPanel(){
			public void paintComponent(Graphics g){
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
			}
		};
		deerex.setBounds(-8, 0, 800, 600);
		deerex.setLayout(null);
		
		ImageIcon image = new ImageIcon("image/helper/»ç½¿ÁøÈ­°úÁ¤.png");
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(110, 140, 600, 170);
		deerex.add(lblimage);
		
		JLabel lblexplanation = new JLabel("»ç½¿À» Å°¿ï ¶§ ³ì¿ëÀ» 10%(->25%->50%)´õ »¡¸® È¹µæ °¡´É");
		lblexplanation.setForeground(Color.BLACK);
		lblexplanation.setHorizontalAlignment(SwingConstants.CENTER);
		lblexplanation.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 20));
		lblexplanation.setBounds(110, 320, 600, 100);
		deerex.add(lblexplanation);
		
		JLabel lblselect = new JLabel("¼±ÅÃ");
		lblselect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Player.helper = 5;
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				MenuScreen.contentPane.add(new MainScreen());
			}
		});
		lblselect.setForeground(Color.BLACK);
		lblselect.setHorizontalAlignment(SwingConstants.CENTER);
		lblselect.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblselect.setBounds(627, 410, 129, 40);
		deerex.add(lblselect);
		
		JLabel lblexit = new JLabel("³ª°¡±â");
		lblexit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				deerex.setVisible(false);
				remove(deerex);
				add(choice);
				choice.setVisible(true);
			}
		});
		lblexit.setForeground(Color.BLACK);
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
		lblexit.setBounds(627, 480, 129, 40);
		deerex.add(lblexit);
	}
	
}
