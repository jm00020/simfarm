package simfarmgui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import simfarm.Animal;
import simfarm.Field;
import simfarm.Inventory;
import simfarm.Main;
import simfarm.Player;
import simfarm.Produce;
import simfarm.Store;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MainScreen extends JPanel {
	public static Thread th;
	public static JPanel panel_base;
	public static JPanel panel_bord;
	public static JPanel farmscreen;
	public static JPanel fieldscreen;
	public static JTabbedPane storescreen;
	public static JPanel evolutionscreen;
	JLabel lblMoney;
	
	public MainScreen() {
		setLayout(null);
		setBounds(-8, 0, 800, 600);
		panel_base = new JPanel();
		panel_base.setLayout(null);
		panel_base.setBounds(-8, 0, 800, 600);
		
		FarmScreen();
		FieldScreen();
		StoreScreen();
		EvolutionScreen();
		
		JPanel panel_menubar = new JPanel(){ 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/menubar.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_menubar.setBounds(0, 0, 800, 43);
		panel_base.add(panel_menubar);
		panel_menubar.setLayout(null);
		
		lblMoney = new JLabel("소유 금액 : " + Integer.toString(Player.money));
		lblMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoney.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblMoney.setBounds(0, 11, 245, 23);
		panel_menubar.add(lblMoney);
		
		JLabel lblTime = new JLabel(Integer.toString(Player.playtime/360) + "년 " + Integer.toString((Player.playtime%360)/30) 
								+ "월 " + Integer.toString((Player.playtime%360)%30) + "일");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblTime.setBounds(302, 11, 220, 23);
		panel_menubar.add(lblTime);
		
		JButton btnNewButton = new JButton("\uBA54 \uB274");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				JPanel gmenu = new JPanel();
				if(panel_bord.isVisible() == true){
					gmenu = new GamemenuScreen(panel_bord);
					panel_bord.setVisible(false);
				}
				else if(farmscreen.isVisible() == true)	{
					gmenu = new GamemenuScreen(farmscreen);
					farmscreen.setVisible(false);
				}
				else if(fieldscreen.isVisible() == true){
					gmenu = new GamemenuScreen(fieldscreen);
					fieldscreen.setVisible(false);
				}
				else if(storescreen.isVisible() == true){
					gmenu = new GamemenuScreen(storescreen);
					storescreen.setVisible(false);
				}
				else if(evolutionscreen.isVisible()  == true){
					gmenu = new GamemenuScreen(evolutionscreen);
					evolutionscreen.setVisible(false);
				}
				panel_base.add(gmenu);
				gmenu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		btnNewButton.setBounds(691, 10, 97, 24);
		panel_menubar.add(btnNewButton);
		
		Main start = new Main(lblMoney, lblTime); //메인 쓰레드 시작
		th = new Thread(start);
		th.start();
		
		panel_bord = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/menubackground.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_bord.setLayout(null);
		panel_bord.setBounds(0, 42, 800, 548);
		panel_base.add(panel_bord);
		
		JPanel panel_animal = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/animal.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_animal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel_bord.setVisible(false);
				panel_base.add(farmscreen);
				farmscreen.setVisible(true);
			}
		});
		panel_animal.setBounds(103, 46, 200, 200);
		panel_bord.add(panel_animal);
		
		JPanel panel_field = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/field.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_field.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel_bord.setVisible(false);
				panel_base.add(fieldscreen);
				fieldscreen.setVisible(true);
			}
		});
		panel_field.setBounds(472, 46, 200, 200);
		panel_bord.add(panel_field);
		
		JPanel panel_store = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/store.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_store.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StoreScreen();
				panel_bord.setVisible(false);
				panel_base.add(storescreen);
				storescreen.setVisible(true);
			}
		});
		panel_store.setBounds(103, 301, 200, 200);
		panel_bord.add(panel_store);
		
		JPanel panel_evolution = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/evolution.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel_evolution.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				EvolutionScreen();
				panel_bord.setVisible(false);
				panel_base.add(evolutionscreen);
				evolutionscreen.setVisible(true);
			}
		});
		panel_evolution.setBounds(472, 301, 200, 200);
		panel_bord.add(panel_evolution);
		
		JLabel lblNewLabel = new JLabel("\uC0C1   \uC810");
		lblNewLabel.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 274, 57, 26);
		panel_bord.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC9C4\uD654\uC7A5");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		label.setBounds(544, 274, 57, 26);
		panel_bord.add(label);
		
		JLabel label_1 = new JLabel("\uB18D   \uC7A5");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		label_1.setBounds(175, 23, 57, 26);
		panel_bord.add(label_1);
		
		JLabel label_2 = new JLabel("\uB17C   \uBC2D");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		label_2.setBounds(544, 23, 57, 26);
		panel_bord.add(label_2);
		
		add(panel_base);
	}

	public void FarmScreen() {
		farmscreen = new JPanel(){ 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/animalbackground.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		farmscreen.setBounds(0, 42, 800, 530);
		farmscreen.setLayout(null);
		
		JLabel lblExit = new JLabel("\uB098\uAC00\uAE30");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				farmscreen.setVisible(false);
				panel_base.remove(farmscreen);
				panel_bord.setVisible(true);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblExit.setBounds(627, 460, 129, 40);
		farmscreen.add(lblExit);
		
		farmscreen.setVisible(false);
	}
	
	public void FieldScreen(){
		fieldscreen = new JPanel(){ 
			public void paintComponent(Graphics g){
				ImageIcon icon;
				if(Player.landsize == 1) //땅확장 유무에 따라 땅의 크기가 달라짐
					icon = new ImageIcon("image/background/fieldbackground(1단계).png");
				else if(Player.landsize == 2)
					icon = new ImageIcon("image/background/fieldbackground(2단계).png");
				else
					icon = new ImageIcon("image/background/fieldbackground(3단계).png");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		fieldscreen.setBounds(8, 42, 800, 520);
		fieldscreen.setLayout(null);
		MouseAdapter l;
		for(int i = 0; i < Field.fieldNum[Player.landsize-1]; i++){
			int position = i;
			Field.field[i] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/밭.jpg");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			l = new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					new FieldDialog((JPanel) e.getSource(), position, this);
				}
			};
			Field.field[i].addMouseListener(l);
			Field.currentpro[i] = new Produce(Field.field[i], l);
			if(Player.landsize == 1)
				Field.field[i].setBounds(255 * (i%3) + 35,138 * (i/3) + 12, 220, 130);
			else if(Player.landsize == 2)
				Field.field[i].setBounds(192 * (i%4) + 27,111 * (i/4) + 8, 170, 102);
			else
				Field.field[i].setBounds(155 * (i%5) + 22, 91 * (i/5) + 7, 135, 85);
			Field.field[i].setLayout(null);
			fieldscreen.add(Field.field[i]);
		}
		
		JLabel lblExit = new JLabel("\uB098\uAC00\uAE30");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fieldscreen.setVisible(false);
				panel_base.remove(fieldscreen);
				panel_bord.setVisible(true);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblExit.setBounds(627, 460, 129, 40);
		fieldscreen.add(lblExit);
		
		fieldscreen.setVisible(false);
	}
	
	public void StoreScreen(){
		storescreen = new JTabbedPane(JTabbedPane.RIGHT);
		storescreen.setBounds(0, 42, 800, 520);
		storescreen.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		
		JLabel lblsellchicken = new JLabel("닭 " + Integer.toString(Inventory.animalNum[1]));
		JLabel lblsellpig = new JLabel("돼지 " + Integer.toString(Inventory.animalNum[2]));
		JLabel lblsellsheep = new JLabel("양 " + Integer.toString(Inventory.animalNum[3]));
		JLabel lblsellcow = new JLabel("소 " + Integer.toString(Inventory.animalNum[4]));
		JLabel lblselldeer = new JLabel("사슴 " + Integer.toString(Inventory.animalNum[5]));
		JLabel lblpotatoseed = new JLabel("감자씨앗 " + Integer.toString(Inventory.produceNum[1]));
		JLabel lblcarrotseed = new JLabel("당근씨앗 " + Integer.toString(Inventory.produceNum[2]));
		JLabel lblcucumberseed = new JLabel("오이씨앗 " + Integer.toString(Inventory.produceNum[3]));
		JLabel lbltomatoseed = new JLabel("토마토씨앗 " + Integer.toString(Inventory.produceNum[4]));
		JLabel lblpumpkinseed = new JLabel("호박씨앗 " + Integer.toString(Inventory.produceNum[5]));
		
		JPanel buyscreen = new JPanel(){ 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/storebackground.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		buyscreen.setLayout(null);
		
		JLabel lblExit = new JLabel("\uB098\uAC00\uAE30");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				storescreen.setVisible(false);
				panel_base.remove(storescreen);
				panel_bord.setVisible(true);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblExit.setBounds(582, 460, 129, 40);
		buyscreen.add(lblExit);
		
		JLabel chicken = new JLabel("닭을 구입합니다. 가격은 1000원");
		chicken.setForeground(Color.WHITE);
		chicken.setHorizontalAlignment(SwingConstants.CENTER);
		chicken.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		chicken.setBounds(0, 130, 300, 20);
		buyscreen.add(chicken);
		chicken.setVisible(false);
		
		ImageIcon image = new ImageIcon("image/animal/chicken.png");
		JLabel lblchicken = new JLabel(image);
		lblchicken.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(chicken);
				chicken.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				chicken.setVisible(false);
				buyscreen.remove(chicken);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("닭", lblMoney, lblsellchicken);
			}
		});
		lblchicken.setBounds(75, 0, 120, 120);
		buyscreen.add(lblchicken);
		
		JLabel pig = new JLabel("돼지를 구입합니다. 가격은 2500원");
		pig.setForeground(Color.WHITE);
		pig.setHorizontalAlignment(SwingConstants.CENTER);
		pig.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pig.setBounds(120, 130, 300, 20);
		buyscreen.add(pig);
		pig.setVisible(false);
		
		image = new ImageIcon("image/animal/pig.png");
		JLabel lblpig = new JLabel(image);
		lblpig.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(pig);
				pig.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				pig.setVisible(false);
				buyscreen.remove(pig);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("돼지", lblMoney, lblsellpig);
			}
		});
		lblpig.setBounds(195, 0, 120, 120);
		buyscreen.add(lblpig);
		
		JLabel sheep = new JLabel("양을 구입합니다. 가격은 5000원");
		sheep.setForeground(Color.WHITE);
		sheep.setHorizontalAlignment(SwingConstants.CENTER);
		sheep.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		sheep.setBounds(240, 130, 300, 20);
		buyscreen.add(sheep);
		sheep.setVisible(false);
		
		image = new ImageIcon("image/animal/sheep.png");
		JLabel lblsheep = new JLabel(image);
		lblsheep.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(sheep);
				sheep.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				sheep.setVisible(false);
				buyscreen.remove(sheep);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("양", lblMoney, lblsellsheep);
			}
		});
		lblsheep.setBounds(315, 0, 120, 120);
		buyscreen.add(lblsheep);
		
		JLabel cow = new JLabel("소를 구입합니다. 가격은 7500원");
		cow.setForeground(Color.WHITE);
		cow.setHorizontalAlignment(SwingConstants.CENTER);
		cow.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		cow.setBounds(360, 130, 300, 20);
		buyscreen.add(cow);
		cow.setVisible(false);
		
		image = new ImageIcon("image/animal/cow.png");
		JLabel lblcow = new JLabel(image);
		lblcow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(cow);
				cow.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				cow.setVisible(false);
				buyscreen.remove(cow);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("소", lblMoney, lblsellcow);
			}
		});
		lblcow.setBounds(435, 0, 120, 120);
		buyscreen.add(lblcow);
		
		JLabel deer = new JLabel("사슴을 구입합니다. 가격은 10000원");
		deer.setForeground(Color.WHITE);
		deer.setHorizontalAlignment(SwingConstants.CENTER);
		deer.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		deer.setBounds(440, 130, 300, 20);
		buyscreen.add(deer);
		deer.setVisible(false);
		
		image = new ImageIcon("image/animal/deer.png");
		JLabel lbldeer = new JLabel(image);
		lbldeer.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(deer);
				deer.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				deer.setVisible(false);
				buyscreen.remove(deer);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("사슴", lblMoney, lblselldeer);
			}
		});
		lbldeer.setBounds(555, 0, 120, 120);
		buyscreen.add(lbldeer);
		
		JLabel potato = new JLabel("감자씨앗을 구입합니다. 가격은 1000원");
		potato.setForeground(Color.WHITE);
		potato.setHorizontalAlignment(SwingConstants.CENTER);
		potato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		potato.setBounds(10, 285, 350, 20);
		buyscreen.add(potato);
		potato.setVisible(false);
		
		image = new ImageIcon("image/produce/감자씨앗.png");
		JLabel lblpotato = new JLabel(image);
		lblpotato.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(potato);
				potato.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				potato.setVisible(false);
				buyscreen.remove(potato);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("감자", lblMoney, lblpotatoseed);
			}
		});
		lblpotato.setBounds(75, 160, 120, 120);
		buyscreen.add(lblpotato);
		
		JLabel carrot = new JLabel("당근씨앗을 구입합니다. 가격은 2500원");
		carrot.setForeground(Color.WHITE);
		carrot.setHorizontalAlignment(SwingConstants.CENTER);
		carrot.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		carrot.setBounds(120, 285, 350, 20);
		buyscreen.add(carrot);
		carrot.setVisible(false);
		
		image = new ImageIcon("image/produce/당근씨앗.png");
		JLabel lblcarrot = new JLabel(image);
		lblcarrot.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(carrot);
				carrot.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				carrot.setVisible(false);
				buyscreen.remove(carrot);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("당근", lblMoney, lblcarrotseed);
			}
		});
		lblcarrot.setBounds(195, 160, 120, 120);
		buyscreen.add(lblcarrot);
		
		JLabel cucumber = new JLabel("오이씨앗을 구입합니다. 가격은 5000원");
		cucumber.setForeground(Color.WHITE);
		cucumber.setHorizontalAlignment(SwingConstants.CENTER);
		cucumber.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		cucumber.setBounds(240, 285, 350, 20);
		buyscreen.add(cucumber);
		cucumber.setVisible(false);
		
		image = new ImageIcon("image/produce/오이씨앗.png");
		JLabel lblcucumber = new JLabel(image);
		lblcucumber.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(cucumber);
				cucumber.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				cucumber.setVisible(false);
				buyscreen.remove(cucumber);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("오이", lblMoney, lblcucumberseed);
			}
		});
		lblcucumber.setBounds(315, 160, 120, 120);
		buyscreen.add(lblcucumber);
		
		JLabel tomato = new JLabel("토마토씨앗을 구입합니다. 가격은 7500원");
		tomato.setForeground(Color.WHITE);
		tomato.setHorizontalAlignment(SwingConstants.CENTER);
		tomato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		tomato.setBounds(360, 285, 350, 20);
		buyscreen.add(tomato);
		tomato.setVisible(false);
		
		image = new ImageIcon("image/produce/토마토씨앗.png");
		JLabel lbltomato = new JLabel(image);
		lbltomato.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(tomato);
				tomato.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				tomato.setVisible(false);
				buyscreen.remove(tomato);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("토마토", lblMoney, lbltomatoseed);
			}
		});
		lbltomato.setBounds(435, 160, 120, 120);
		buyscreen.add(lbltomato);
		
		JLabel pumpkin = new JLabel("호박씨앗을 구입합니다. 가격은 10000원");
		pumpkin.setForeground(Color.WHITE);
		pumpkin.setHorizontalAlignment(SwingConstants.CENTER);
		pumpkin.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pumpkin.setBounds(400, 285, 350, 20);
		buyscreen.add(pumpkin);
		pumpkin.setVisible(false);
		
		image = new ImageIcon("image/produce/호박씨앗.png");
		JLabel lblpumpkin = new JLabel(image);
		lblpumpkin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(pumpkin);
				pumpkin.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				pumpkin.setVisible(false);
				buyscreen.remove(pumpkin);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("호박", lblMoney, lblpumpkinseed);
			}
		});
		lblpumpkin.setBounds(555, 160, 120, 120);
		buyscreen.add(lblpumpkin);
		
		JLabel stone1 = new JLabel("도우미 1단께 진화석을 구입합니다. 가격은 25000원");
		stone1.setForeground(Color.WHITE);
		stone1.setHorizontalAlignment(SwingConstants.CENTER);
		stone1.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		stone1.setBounds(0, 440, 500, 20);
		buyscreen.add(stone1);
		stone1.setVisible(false);
		
		image = new ImageIcon("image/stone/1단계.png");
		JLabel lbl1 = new JLabel(image);
		lbl1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(stone1);
				stone1.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				stone1.setVisible(false);
				buyscreen.remove(stone1);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("1단계 진화석", lblMoney, null);
			}
		});
		lbl1.setBounds(75, 320, 120, 120);
		buyscreen.add(lbl1);
		
		JLabel stone2 = new JLabel("도우미 2단께 진화석을 구입합니다. 가격은 50000원");
		stone2.setForeground(Color.WHITE);
		stone2.setHorizontalAlignment(SwingConstants.CENTER);
		stone2.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		stone2.setBounds(120, 440, 500, 20);
		buyscreen.add(stone2);
		stone2.setVisible(false);
		
		image = new ImageIcon("image/stone/2단계.png");
		JLabel lbl2 = new JLabel(image);
		lbl2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(stone2);
				stone2.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				stone2.setVisible(false);
				buyscreen.remove(stone2);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("2단계 진화석", lblMoney, null);
			}
		});
		lbl2.setBounds(235, 320, 120, 120);
		buyscreen.add(lbl2);
		
		JLabel tool  = new JLabel("도구를 구입합니다. 다섯가지 도구중 랜덤으로 구입합니다. 가격은 50000원");
		tool.setForeground(Color.WHITE);
		tool.setHorizontalAlignment(SwingConstants.CENTER);
		tool.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		tool.setBounds(100, 440, 600, 20);
		buyscreen.add(tool);
		tool.setVisible(false);
		
		image = new ImageIcon("image/stone/장비.png");
		JLabel lbltool = new JLabel(image);
		lbltool.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(tool);
				tool.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				tool.setVisible(false);
				buyscreen.remove(tool);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("장비", lblMoney, null);
			}
		});
		lbltool.setBounds(395, 320, 120, 120);
		buyscreen.add(lbltool);
		
		JLabel land  = new JLabel("땅을 확장합니다.(2번확장가능) 가격은 100000원(->200000원)");
		land.setForeground(Color.WHITE);
		land.setHorizontalAlignment(SwingConstants.CENTER);
		land.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		land.setBounds(150, 440, 600, 20);
		buyscreen.add(land);
		land.setVisible(false);
		
		image = new ImageIcon("image/stone/확장.png");
		JLabel lblland = new JLabel(image);
		lblland.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				buyscreen.add(land);
				land.setVisible(true);
			}
			public void mouseExited(MouseEvent e) {
				land.setVisible(false);
				buyscreen.remove(land);
			}
			public void mouseClicked(MouseEvent e) {
				new BuyDialog("땅확장", lblMoney, null);
			}
		});
		lblland.setBounds(555, 320, 120, 120);
		buyscreen.add(lblland);
		
		storescreen.addTab("구매", null, buyscreen, null);
		
		//======================================================================================
		
		JScrollPane sell = new JScrollPane();
		JPanel inventory = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/inventorybackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		
		JLabel lblinven = new JLabel("판  매");
		lblinven.setHorizontalAlignment(SwingConstants.CENTER);
		lblinven.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblinven.setBounds(200, 10, 363, 61);
		inventory.add(lblinven);
	
		JPanel chickenbord = new JPanel();
		chickenbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				chickenbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				chickenbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("닭", lblMoney, lblsellchicken);
				sell.repaint();
			}
		});
		chickenbord.setBounds(86,96,300,35);
		chickenbord.setBackground(new Color(255,0,0,0));
		chickenbord.setLayout(null);
		inventory.add(chickenbord);
		
		JPanel chickenicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/chicken.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		chickenicon.setBounds(1, 1, 30, 30);
		chickenicon.setBackground(new Color(255,0,0,0));
		chickenbord.add(chickenicon);
		
		lblsellchicken.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellchicken.setBounds(40, 1, 120, 30);
		chickenbord.add(lblsellchicken);
		
		JLabel chickenprice = new JLabel("개당 700원");
		chickenprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		chickenprice.setBounds(170, 1, 130, 30);
		chickenbord.add(chickenprice);
		
		JLabel lblegg = new JLabel("달걀 " + Integer.toString(Inventory.animade[0]));
		JPanel eggbord = new JPanel();
		eggbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				eggbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				eggbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("달걀", lblMoney, lblegg);
			}
		});
		eggbord.setBounds(400,96,300,35);
		eggbord.setBackground(new Color(255,0,0,0));
		eggbord.setLayout(null);
		inventory.add(eggbord);
		
		JPanel eggicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/달걀.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		eggicon.setBackground(new Color(255,0,0,0));
		eggicon.setBounds(1, 1, 30, 30);
		eggbord.add(eggicon);
		
		lblegg.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblegg.setBounds(40, 1, 120, 30);
		eggbord.add(lblegg);
		
		JLabel eggprice = new JLabel("개당 500원");
		eggprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		eggprice.setBounds(170, 1, 130, 30);
		eggbord.add(eggprice);
		
		JPanel pigbord = new JPanel();
		pigbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				pigbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				pigbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("돼지", lblMoney, lblpig);
			}
		});
		pigbord.setBounds(86,156,300,35);
		pigbord.setBackground(new Color(255,0,0,0));
		pigbord.setLayout(null);
		inventory.add(pigbord);
		
		JPanel pigicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/pig.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pigicon.setBackground(new Color(255,0,0,0));
		pigicon.setBounds(1, 1, 30, 30);
		pigbord.add(pigicon);
		
		lblsellpig.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellpig.setBounds(40, 1, 120, 30);
		pigbord.add(lblsellpig);
		
		JLabel pigprice = new JLabel("개당 2000원");
		pigprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pigprice.setBounds(170, 1, 130, 30);
		pigbord.add(pigprice);
		
		JLabel lblmeat = new JLabel("고기 " + Integer.toString(Inventory.animade[1]));
		JPanel meatbord = new JPanel();
		meatbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				meatbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				meatbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("고기", lblMoney, lblmeat);
			}
		});
		meatbord.setBounds(400,156,300,35);
		meatbord.setBackground(new Color(255,0,0,0));
		meatbord.setLayout(null);
		inventory.add(meatbord);
		
		JPanel meaticon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/고기.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		meaticon.setBackground(new Color(255,0,0,0));
		meaticon.setBounds(1, 1, 30, 30);
		meatbord.add(meaticon);
		
		lblmeat.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblmeat.setBounds(40, 1, 120, 30);
		meatbord.add(lblmeat);
		
		JLabel meatprice = new JLabel("개당 1000원");
		meatprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		meatprice.setBounds(170, 1, 130, 30);
		meatbord.add(meatprice);
		
		JPanel sheepbord = new JPanel();
		sheepbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				sheepbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				sheepbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("양", lblMoney, lblsheep);
			}
		});
		sheepbord.setBounds(86,211,300,35);
		sheepbord.setBackground(new Color(255,0,0,0));
		sheepbord.setLayout(null);
		inventory.add(sheepbord);
		
		JPanel sheepicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/sheep.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		sheepicon.setBackground(new Color(255,0,0,0));
		sheepicon.setBounds(1, 1, 30, 30);
		sheepbord.add(sheepicon);
		
		lblsellsheep.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellsheep.setBounds(40, 1, 120, 30);
		sheepbord.add(lblsellsheep);
		
		JLabel sheepprice = new JLabel("개당 4000원");
		sheepprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		sheepprice.setBounds(170, 1, 130, 30);
		sheepbord.add(sheepprice);
		
		JLabel lblwool = new JLabel("양털 " + Integer.toString(Inventory.animade[2]));
		JPanel woolbord = new JPanel();
		woolbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				woolbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				woolbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("양털", lblMoney, lblwool);
			}
		});
		woolbord.setBounds(400, 211,300,35);
		woolbord.setBackground(new Color(255,0,0,0));
		woolbord.setLayout(null);
		inventory.add(woolbord);
		
		JPanel woolicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/양털.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		woolicon.setBackground(new Color(255,0,0,0));
		woolicon.setBounds(1, 1, 30, 30);
		woolbord.add(woolicon);
		
		lblwool.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblwool.setBounds(40, 1, 120, 30);
		woolbord.add(lblwool);
		
		JLabel woolprice = new JLabel("개당 2500원");
		woolprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		woolprice.setBounds(170, 1, 130, 30);
		woolbord.add(woolprice);
		
		JPanel cowbord = new JPanel();
		cowbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				cowbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				cowbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("소", lblMoney, lblcow);
			}
		});
		cowbord.setBounds(86,271,300,35);
		cowbord.setBackground(new Color(255,0,0,0));
		cowbord.setLayout(null);
		inventory.add(cowbord);
		
		JPanel cowicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/cow.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cowicon.setBackground(new Color(255,0,0,0));
		cowicon.setBounds(1, 1, 30, 30);
		cowbord.add(cowicon);
		
		lblsellcow.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellcow.setBounds(40, 1, 120, 30);
		cowbord.add(lblsellcow);
		
		JLabel cowprice = new JLabel("개당 6000원");
		cowprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		cowprice.setBounds(170, 1, 130, 30);
		cowbord.add(cowprice);
		
		JLabel lblmilk = new JLabel("우유 " + Integer.toString(Inventory.animade[3]));
		JPanel milkbord = new JPanel();
		milkbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				milkbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				milkbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("우유", lblMoney, lblmilk);
			}
		});
		milkbord.setBounds(400,271,300,35);
		milkbord.setBackground(new Color(255,0,0,0));
		milkbord.setLayout(null);
		inventory.add(milkbord);
		
		JPanel milkicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/우유.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		milkicon.setBackground(new Color(255,0,0,0));
		milkicon.setBounds(1, 1, 30, 30);
		milkbord.add(milkicon);
		
		lblmilk.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblmilk.setBounds(40, 1, 120, 30);
		milkbord.add(lblmilk);
		
		JLabel milkprice = new JLabel("개당 5000원");
		milkprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		milkprice.setBounds(170, 1, 130, 30);
		milkbord.add(milkprice);
		
		JPanel deerbord = new JPanel();
		deerbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				deerbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				deerbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("사슴", lblMoney, lbldeer);
			}
		});
		deerbord.setBounds(86,326,300,35);
		deerbord.setBackground(new Color(255,0,0,0));
		deerbord.setLayout(null);
		inventory.add(deerbord);
		
		JPanel deericon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/deer.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		deericon.setBackground(new Color(255,0,0,0));
		deericon.setBounds(1, 1, 30, 30);
		deerbord.add(deericon);
		
		lblselldeer.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblselldeer.setBounds(40, 1, 130, 30);
		deerbord.add(lblselldeer);
		
		JLabel deerprice = new JLabel("개당 8000원");
		deerprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		deerprice.setBounds(170, 1, 130, 30);
		deerbord.add(deerprice);
		
		JLabel lblhorn = new JLabel("녹용 " + Integer.toString(Inventory.animade[4]));
		JPanel hornbord = new JPanel();
		hornbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				hornbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				hornbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("녹용", lblMoney, lblhorn);
			}
		});
		hornbord.setBounds(400,326,300,35);
		hornbord.setBackground(new Color(255,0,0,0));
		hornbord.setLayout(null);
		inventory.add(hornbord);
		
		JPanel hornicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/녹용.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		hornicon.setBackground(new Color(255,0,0,0));
		hornicon.setBounds(1, 1, 30, 30);
		hornbord.add(hornicon);
		
		lblhorn.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblhorn.setBounds(40, 1, 130, 30);
		hornbord.add(lblhorn);
		
		JLabel hornprice = new JLabel("개당 7500원");
		hornprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		hornprice.setBounds(170, 1, 130, 30);
		hornbord.add(hornprice);
		
		JPanel potatoseedbord = new JPanel();
		potatoseedbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				potatoseedbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				potatoseedbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("감자씨앗", lblMoney, lblpotatoseed);
			}
		});
		potatoseedbord.setBounds(86,386,300,35);
		potatoseedbord.setBackground(new Color(255,0,0,0));
		potatoseedbord.setLayout(null);
		inventory.add(potatoseedbord);
		
		JPanel potatoseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/감자씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		potatoseedicon.setBackground(new Color(255,0,0,0));
		potatoseedicon.setBounds(1, 1, 30, 30);
		potatoseedbord.add(potatoseedicon);
		
		
		lblpotatoseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblpotatoseed.setBounds(40, 1, 120, 30);
		potatoseedbord.add(lblpotatoseed);
		
		JLabel potatoseedprice = new JLabel("개당 700원");
		potatoseedprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		potatoseedprice.setBounds(170, 1, 130, 30);
		potatoseedbord.add(potatoseedprice);
		
		JLabel lblsellpotato = new JLabel("감자 " + Integer.toString(Inventory.promade[0]));
		JPanel potatobord = new JPanel();
		potatobord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				potatobord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				potatobord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("감자", lblMoney, lblsellpotato);
			}
		});
		potatobord.setBounds(400,386,300,35);
		potatobord.setBackground(new Color(255,0,0,0));
		potatobord.setLayout(null);
		inventory.add(potatobord);
		
		JPanel potatoicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/감자.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		potatoicon.setBackground(new Color(255,0,0,0));
		potatoicon.setBounds(1, 1, 30, 30);
		potatobord.add(potatoicon);
		
		lblsellpotato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellpotato.setBounds(40, 1, 120, 30);
		potatobord.add(lblsellpotato);
		
		JLabel potatoprice = new JLabel("개당 500원");
		potatoprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		potatoprice.setBounds(170, 1, 130, 30);
		potatobord.add(potatoprice);
		
		JPanel carrotseedbord = new JPanel();
		carrotseedbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				carrotseedbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				carrotseedbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("당근씨앗", lblMoney, lblcarrotseed);
			}
		});
		carrotseedbord.setBounds(86,446,300,35);
		carrotseedbord.setBackground(new Color(255,0,0,0));
		carrotseedbord.setLayout(null);
		inventory.add(carrotseedbord);
		
		JPanel carrotseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/당근씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		carrotseedicon.setBackground(new Color(255,0,0,0));
		carrotseedicon.setBounds(1,1, 30, 30);
		carrotseedbord.add(carrotseedicon);
		
		lblcarrotseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblcarrotseed.setBounds(40, 1, 120, 30);
		carrotseedbord.add(lblcarrotseed);
		
		JLabel carrotseedprice = new JLabel("개당 2000원");
		carrotseedprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		carrotseedprice.setBounds(170, 1, 130, 30);
		carrotseedbord.add(carrotseedprice);
		
		JLabel lblsellcarrot = new JLabel("당근 " + Integer.toString(Inventory.promade[1]));
		JPanel carrotbord = new JPanel();
		carrotbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				carrotbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				carrotbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("당근", lblMoney, lblsellcarrot);
			}
		});
		carrotbord.setBounds(400,446,300,35);
		carrotbord.setBackground(new Color(255,0,0,0));
		carrotbord.setLayout(null);
		inventory.add(carrotbord);
		
		JPanel carroticon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/당근.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		carroticon.setBackground(new Color(255,0,0,0));
		carroticon.setBounds(1, 1, 30, 30);
		carrotbord.add(carroticon);
		
		lblsellcarrot.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellcarrot.setBounds(40, 1, 120, 30);
		carrotbord.add(lblsellcarrot);
		
		JLabel carrotprice = new JLabel("개당 1000원");
		carrotprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		carrotprice.setBounds(170, 1, 130, 30);
		carrotbord.add(carrotprice);
		
		JPanel cucumberseedbord = new JPanel();
		cucumberseedbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				cucumberseedbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				cucumberseedbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("오이씨앗", lblMoney, lblcucumberseed);
			}
		});
		cucumberseedbord.setBounds(86,506,300,35);
		cucumberseedbord.setBackground(new Color(255,0,0,0));
		cucumberseedbord.setLayout(null);
		inventory.add(cucumberseedbord);
		
		JPanel cucumberseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/오이씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cucumberseedicon.setBackground(new Color(255,0,0,0));
		cucumberseedicon.setBounds(1, 1, 30, 30);
		cucumberseedbord.add(cucumberseedicon);
		
		lblcucumberseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblcucumberseed.setBounds(40, 1, 120, 30);
		cucumberseedbord.add(lblcucumberseed);
		
		JLabel cucumberseedprice = new JLabel("개당 4000원");
		cucumberseedprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		cucumberseedprice.setBounds(170, 1, 130, 30);
		cucumberseedbord.add(cucumberseedprice);
		
		JLabel lblsellcucumber = new JLabel("오이 " + Integer.toString(Inventory.promade[2]));
		JPanel cucumberbord = new JPanel();
		cucumberbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				cucumberbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				cucumberbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("오이", lblMoney, lblsellcucumber);
			}
		});
		cucumberbord.setBounds(400,506,300,35);
		cucumberbord.setBackground(new Color(255,0,0,0));
		cucumberbord.setLayout(null);
		inventory.add(cucumberbord);
		
		JPanel cucumbericon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/오이.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cucumbericon.setBackground(new Color(255,0,0,0));
		cucumbericon.setBounds(1, 1, 30, 30);
		cucumberbord.add(cucumbericon);
		
		lblsellcucumber.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellcucumber.setBounds(40, 1, 120, 30);
		cucumberbord.add(lblsellcucumber);
		
		JLabel cucumberprice = new JLabel("개당 2500원");
		cucumberprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		cucumberprice.setBounds(170, 1, 130, 30);
		cucumberbord.add(cucumberprice);
		
		JPanel tomatoseedbord = new JPanel();
		tomatoseedbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				tomatoseedbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				tomatoseedbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("토마토씨앗", lblMoney, lbltomatoseed);
			}
		});
		tomatoseedbord.setBounds(86,566,300,35);
		tomatoseedbord.setBackground(new Color(255,0,0,0));
		tomatoseedbord.setLayout(null);
		inventory.add(tomatoseedbord);
		
		JPanel tomatoseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/토마토씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		tomatoseedicon.setBackground(new Color(255,0,0,0));
		tomatoseedicon.setBounds(1, 1, 30, 30);
		tomatoseedbord.add(tomatoseedicon);
		
		lbltomatoseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lbltomatoseed.setBounds(40, 1, 120, 30);
		tomatoseedbord.add(lbltomatoseed);
		
		JLabel tomatoseedprice = new JLabel("개당 6000원");
		tomatoseedprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		tomatoseedprice.setBounds(170, 1, 130, 30);
		tomatoseedbord.add(tomatoseedprice);
		
		JLabel lblselltomato = new JLabel("토마토 " + Integer.toString(Inventory.promade[3]));
		JPanel tomatobord = new JPanel();
		tomatobord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				tomatobord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				tomatobord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("토마토", lblMoney, lblselltomato);
			}
		});
		tomatobord.setBounds(400,566,300,35);
		tomatobord.setBackground(new Color(255,0,0,0));
		tomatobord.setLayout(null);
		inventory.add(tomatobord);
		
		JPanel tomatoicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/토마토.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		tomatoicon.setBackground(new Color(255,0,0,0));
		tomatoicon.setBounds(1, 1, 30, 30);
		tomatobord.add(tomatoicon);
		
		lblselltomato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblselltomato.setBounds(40, 1, 120, 30);
		tomatobord.add(lblselltomato);
		
		JLabel tomatoprice = new JLabel("개당 5000원");
		tomatoprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		tomatoprice.setBounds(170, 1, 130, 30);
		tomatobord.add(tomatoprice);
		
		JPanel pumpkinseedbord = new JPanel();
		pumpkinseedbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				pumpkinseedbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				pumpkinseedbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("호박씨앗", lblMoney, lblpumpkinseed);
			}
		});
		pumpkinseedbord.setBounds(86,626,300,35);
		pumpkinseedbord.setBackground(new Color(255,0,0,0));
		pumpkinseedbord.setLayout(null);
		inventory.add(pumpkinseedbord);
		
		JPanel pumpkinseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/호박씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pumpkinseedicon.setBackground(new Color(255,0,0,0));
		pumpkinseedicon.setBounds(1, 1, 30, 30);
		pumpkinseedbord.add(pumpkinseedicon);
		
		lblpumpkinseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblpumpkinseed.setBounds(40, 1, 120, 30);
		pumpkinseedbord.add(lblpumpkinseed);
		
		JLabel pumpkinseedprice = new JLabel("개당 8000원");
		pumpkinseedprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pumpkinseedprice.setBounds(170, 1, 130, 30);
		pumpkinseedbord.add(pumpkinseedprice);
		
		JLabel lblsellpumpkin = new JLabel("호박 " + Integer.toString(Inventory.promade[4]));
		JPanel pumpkinbord = new JPanel();
		pumpkinbord.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				pumpkinbord.setBorder(new LineBorder(new Color(0, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				pumpkinbord.setBorder(new LineBorder(new Color(255,255,255)));
			}
			public void mouseClicked(MouseEvent e) {
				new SellDialog("호박", lblMoney, lblsellpumpkin);
			}
		});
		pumpkinbord.setBounds(400,626,300,35);
		pumpkinbord.setBackground(new Color(255,0,0,0));
		pumpkinbord.setLayout(null);
		inventory.add(pumpkinbord);
		
		JPanel pumpkinicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/호박.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pumpkinicon.setBackground(new Color(255,0,0,0));
		pumpkinicon.setBounds(1, 1, 30, 30);
		pumpkinbord.add(pumpkinicon);
		
		lblsellpumpkin.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblsellpumpkin.setBounds(40, 1, 120, 30);
		pumpkinbord.add(lblsellpumpkin);
		
		JLabel pumpkinprice = new JLabel("개당 7500원");
		pumpkinprice.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pumpkinprice.setBounds(170, 1, 130, 30);
		pumpkinbord.add(pumpkinprice);
		
		inventory.setPreferredSize(new Dimension(580,680));
		inventory.setLayout(null);
		
		sell.setViewportView(inventory);
			
		storescreen.addTab("판매", null, sell, null);
		storescreen.setVisible(false);
	}
	
	public void EvolutionScreen(){
		evolutionscreen = new JPanel(){ 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/evolutionbackground.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		evolutionscreen.setBounds(0, 42, 800, 520);
		evolutionscreen.setLayout(null);
		
		JLabel helper = new JLabel();
		if(Player.helper == 1){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭3).png");
				helper.setIcon(icon);
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭2).png");
				helper.setIcon(icon);
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭1).png");
				helper.setIcon(icon);
			}
		}
		else if(Player.helper == 2){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지3).png");
				helper.setIcon(icon);
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지2).png");
				helper.setIcon(icon);
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지1).png");
				helper.setIcon(icon);
			}
		}
		else if(Player.helper == 3){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/메리프(양3).png");
				helper.setIcon(icon);
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/메리프(양2).png");
				helper.setIcon(icon);
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/메리프(양1).png");
				helper.setIcon(icon);
			}
		}
		else if(Player.helper == 4){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소3).png");
				helper.setIcon(icon);
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소2).png");
				helper.setIcon(icon);
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소1).png");
				helper.setIcon(icon);
			}
		}
		else if(Player.helper == 5){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴3).png");
				helper.setIcon(icon);
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴2).png");
				helper.setIcon(icon);
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴1).png");
				helper.setIcon(icon);
			}
		}
		helper.setBounds(130, 50, 300, 300);
		evolutionscreen.add(helper);
		
		JLabel plus = new JLabel();
		if(Player.helperevolution[1] == false){
			ImageIcon icon = new ImageIcon("image/stone/plus.png");
			plus.setIcon(icon);
			plus.setBounds(350, 150, 150, 150);
			evolutionscreen.add(plus);
		}
		evolutionscreen.add(plus);
		
		JLabel stone = new JLabel();
		if(Player.helperevolution[1] == true){
			helper.setBounds(280, 50, 300, 300);
		}
		else if(Player.helperevolution[0] == true && Inventory.evolutionstone[1] == true){
			ImageIcon icon = new ImageIcon("image/stone/2단계.png");
			stone.setIcon(icon);
		}
		else if(Inventory.evolutionstone[0] == true && Player.helperevolution[0] == false){
			ImageIcon icon = new ImageIcon("image/stone/1단계.png");
			stone.setIcon(icon);
		}
		stone.setBounds(550, 150, 150, 150);
		evolutionscreen.add(stone);
		
		JLabel lblExit = new JLabel("\uB098\uAC00\uAE30");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				evolutionscreen.setVisible(false);
				panel_base.remove(evolutionscreen);
				panel_bord.setVisible(true);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblExit.setBounds(627, 460, 129, 40);
		evolutionscreen.add(lblExit);
		
		JLabel lblFusion = new JLabel("조합");
		lblFusion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(Player.helperevolution[1] == true){
					JOptionPane.showMessageDialog(null, "최대 진화를 하셨습니다.","진화불가", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(Player.helperevolution[1] == false && Inventory.evolutionstone[1] == true && Player.helperevolution[0] == true){
					if(Player.helper == 1){
						ImageIcon icon = new ImageIcon("image/helper/야차모(닭3).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 2){
						ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지3).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 3){
						ImageIcon icon = new ImageIcon("image/helper/메리프(양3).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 4){
						ImageIcon icon = new ImageIcon("image/helper/밀탱크(소3).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 5){
						ImageIcon icon = new ImageIcon("image/helper/사철록(사슴3).png");
						helper.setIcon(icon);
					}
					if(Inventory.evolutionstone[1] == true){
						ImageIcon icon = new ImageIcon("image/helper/2단계.png");
						stone.setIcon(icon);
					}
					helper.setBounds(280, 50, 300, 300);
					evolutionscreen.remove(plus);
					evolutionscreen.remove(stone);
					evolutionscreen.repaint();
					Player.helperevolution[1] = true;
					return;
				}
				else if(Player.helperevolution[1] == false && Inventory.evolutionstone[1] == false && Player.helperevolution[0] == true){
					JOptionPane.showMessageDialog(null, "2단계 진화석이 없습니다.","진화불가", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				else if(Inventory.evolutionstone[0] == true){
					if(Player.helper == 1){
						ImageIcon icon = new ImageIcon("image/helper/야차모(닭2).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 2){
						ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지2).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 3){
						ImageIcon icon = new ImageIcon("image/helper/메리프(양2).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 4){
						ImageIcon icon = new ImageIcon("image/helper/밀탱크(소2).png");
						helper.setIcon(icon);
					}
					else if(Player.helper == 5){
						ImageIcon icon = new ImageIcon("image/helper/사철록(사슴2).png");
						helper.setIcon(icon);
					}
					if(Inventory.evolutionstone[1] == true){
						ImageIcon icon = new ImageIcon("image/stone/2단계.png");
						stone.setIcon(icon);
					}
					else{
						evolutionscreen.remove(stone);
					}
					evolutionscreen.repaint();
					Player.helperevolution[0] = true;
					return;
				}
				else{
					JOptionPane.showMessageDialog(null, "1단계 진화석이 없습니다.","진화불가", JOptionPane.ERROR_MESSAGE); 
					return;
				}
			}
		});
		lblFusion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFusion.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblFusion.setBounds(627, 400, 129, 40);
		evolutionscreen.add(lblFusion);
		
		evolutionscreen.setVisible(false);
	}

	
}
