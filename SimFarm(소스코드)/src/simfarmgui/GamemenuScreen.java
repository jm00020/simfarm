package simfarmgui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingConstants;

import simfarm.Inventory;
import simfarm.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//인벤토리 구형!!!!
public class GamemenuScreen extends JPanel {
	JPanel characterstate;
	JPanel helperstate;
	
	JScrollPane scroll;
	
	public void paintComponent(Graphics g){ 
		ImageIcon icon = new ImageIcon("image/background/menubackground.jpg");
		Image img = icon.getImage();
       	super.paintComponent(g); 
        g.drawImage(img,0,0,getWidth(),getHeight(),this); 
        }; 

	/**
	 * @wbp.parser.constructor
	 */
	public GamemenuScreen(JPanel panel) {
		setBounds(0, 42, 800, 548);
		setLayout(null);
		
		scroll = new JScrollPane();
		scroll.setBounds(0,0, 600, 520);
		
		JPanel menu = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/gamemenu.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		menu.setBounds(600, 0, 200, 548);
		menu.setLayout(null);
		
		JLabel lblMneu = new JLabel("\uBA54     \uB274");
		lblMneu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMneu.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 50));
		lblMneu.setBounds(0, 33, 200, 62);
		menu.add(lblMneu);
		
		JLabel lblCharacter = new JLabel("\uC8FC\uC778\uACF5 \uC815\uBCF4");
		lblCharacter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CharacterState();
				removeAll();
				add(menu);
				add(characterstate);
				repaint();
			}
		});
		lblCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacter.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblCharacter.setBounds(0, 128, 200, 32);
		menu.add(lblCharacter);
		
		JLabel lblHelper = new JLabel("\uB3C4\uC6B0\uBBF8 \uC815\uBCF4");
		lblHelper.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				HelperState();
				removeAll();
				add(menu);
				add(helperstate);
				repaint();
			}
		});
		lblHelper.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelper.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblHelper.setBounds(0, 193, 200, 32);
		menu.add(lblHelper);
		
		JLabel lblInven = new JLabel("\uC778\uBCA4\uD1A0\uB9AC");
		lblInven.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				removeAll();
				add(scroll);
				Inventory();
				add(menu);
				repaint();
			}
		});
		lblInven.setHorizontalAlignment(SwingConstants.CENTER);
		lblInven.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblInven.setBounds(0, 258, 200, 32);
		menu.add(lblInven);
		
		JLabel lblSave = new JLabel("\uC800\uC7A5\uD558\uAE30");
		lblSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SaveDialog();
			}
		});
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblSave.setBounds(0, 323, 200, 32);
		menu.add(lblSave);
		
		JLabel lblExit = new JLabel("\uAC8C\uC784\uC885\uB8CC");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "저장하시 않고 종료하시면 플레이 기록이 사라집니다.\n정말 종료하시겠습니까?", "종료", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					setVisible(false);
					MenuScreen.contentPane.removeAll();
					MainScreen.th.interrupt();
					Player.Initialization();
					MenuScreen.contentPane.add(MenuScreen.firstpanel);
					MenuScreen.firstpanel.setVisible(true);
				}
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblExit.setBounds(0, 388, 200, 32);
		menu.add(lblExit);
		
		JLabel label = new JLabel("\uB2EB\uAE30");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				panel.setVisible(true);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		label.setBounds(0, 453, 200, 32);
		menu.add(label);
			
		add(menu);
		
		setVisible(true);
	}

	public GamemenuScreen(JTabbedPane panel) {
		setBounds(0, 42, 800, 548);
		setLayout(null);
		
		scroll = new JScrollPane();
		scroll.setBounds(0,0, 600, 520);
		
		JPanel menu = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/gamemenu.jpg");
				Image img = icon.getImage();
		       	super.paintComponent(g); 
		        g.drawImage(img,0,0,getWidth(),getHeight(),this); 
		        }
		};
		menu.setBounds(600, 0, 200, 548);
		menu.setLayout(null);
		
		JLabel lblMneu = new JLabel("\uBA54     \uB274");
		lblMneu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMneu.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 50));
		lblMneu.setBounds(0, 33, 200, 62);
		menu.add(lblMneu);
		
		JLabel lblCharacter = new JLabel("\uC8FC\uC778\uACF5 \uC815\uBCF4");
		lblCharacter.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CharacterState();
				removeAll();
				add(menu);
				add(characterstate);
				repaint();
			}
		});
		lblCharacter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharacter.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblCharacter.setBounds(0, 128, 200, 32);
		menu.add(lblCharacter);
		
		JLabel lblHelper = new JLabel("\uB3C4\uC6B0\uBBF8 \uC815\uBCF4");
		lblHelper.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				HelperState();
				removeAll();
				add(menu);
				add(helperstate);
				repaint();
			}
		});
		lblHelper.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelper.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblHelper.setBounds(0, 193, 200, 32);
		menu.add(lblHelper);
		
		JLabel lblInven = new JLabel("\uC778\uBCA4\uD1A0\uB9AC");
		lblInven.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				removeAll();
				add(scroll);
				Inventory();
				add(menu);
				repaint();
			}
		});
		lblInven.setHorizontalAlignment(SwingConstants.CENTER);
		lblInven.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblInven.setBounds(0, 258, 200, 32);
		menu.add(lblInven);
		
		JLabel lblSave = new JLabel("\uC800\uC7A5\uD558\uAE30");
		lblSave.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new SaveDialog();
			}
		});
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblSave.setBounds(0, 323, 200, 32);
		menu.add(lblSave);
		
		JLabel lblExit = new JLabel("\uAC8C\uC784\uC885\uB8CC");
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "저장하시 않고 종료하시면 플레이 기록이 사라집니다.\n정말 종료하시겠습니까?", "종료", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0){
					setVisible(false);
					MenuScreen.contentPane.removeAll();
					MainScreen.th.interrupt();
					Player.Initialization();
					MenuScreen.contentPane.add(MenuScreen.firstpanel);
					MenuScreen.firstpanel.setVisible(true);
				}
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblExit.setBounds(0, 388, 200, 32);
		menu.add(lblExit);
		
		JLabel label = new JLabel("\uB2EB\uAE30");
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				panel.setVisible(true);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		label.setBounds(0, 453, 200, 32);
		menu.add(label);
			
		add(menu);
		
		setVisible(true);
	}
	
	public void CharacterState() {
		characterstate = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/주인공상태.jpg");
				Image img = icon.getImage();
		       	super.paintComponent(g); 
		        g.drawImage(img,0,0,getWidth(),getHeight(),this); 
		        }
		};
		characterstate.setBounds(0, 0, 600, 548);
		characterstate.setLayout(null);
		
		JLabel hatex = new JLabel("감자의 성장 시간을 25% 빠르게 합니다.");
		hatex.setForeground(Color.WHITE);
		hatex.setHorizontalAlignment(SwingConstants.CENTER);
		hatex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		hatex.setBounds(70, 480, 400, 20);
		characterstate.add(hatex);
		hatex.setVisible(false);
		
		JPanel hat = new JPanel();
		if(Player.tool[0] == true){
			hat = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/tool/모자.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			hat.setBackground(new Color(255,0,0,0));
			hat.setBounds(95, 70, 132, 90);
			hat.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent arg0) {
					characterstate.add(hatex);
					hatex.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					hatex.setVisible(false);
					characterstate.remove(hatex);
				}
			});
		}
		
		characterstate.add(hat);
		
		JLabel shirtsex = new JLabel("당근의 성장 시간을 25% 빠르게 합니다.");
		shirtsex.setForeground(Color.WHITE);
		shirtsex.setHorizontalAlignment(SwingConstants.CENTER);
		shirtsex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		shirtsex.setBounds(70, 480, 400, 20);
		characterstate.add(shirtsex);
		shirtsex.setVisible(false);
		
		JPanel shirts = new JPanel();
		if(Player.tool[1] == true){
			shirts = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/tool/상의.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			shirts.setBackground(new Color(255,0,0,0));
			shirts.setBounds(72, 198, 180, 150);
			shirts.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent arg0) {
					characterstate.add(shirtsex);
					shirtsex.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					shirtsex.setVisible(false);
					characterstate.remove(shirtsex);
				}
			});
		}
	
		characterstate.add(shirts);
		
		JLabel pantsex = new JLabel("오이의 성장 시간을 25% 빠르게 합니다.");
		pantsex.setForeground(Color.WHITE);
		pantsex.setHorizontalAlignment(SwingConstants.CENTER);
		pantsex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		pantsex.setBounds(70, 480, 400, 20);
		characterstate.add(pantsex);
		pantsex.setVisible(false);
		
		JPanel pants= new JPanel();
		if(Player.tool[2] == true){
			pants = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/tool/하의.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			pants.setBackground(new Color(255,0,0,0));
			pants.setBounds(105, 300, 100, 170);
			pants.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent arg0) {
					characterstate.add(pantsex);
					pantsex.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					pantsex.setVisible(false);
					characterstate.remove(shirtsex);
				}
			});
		}
		characterstate.add(pants);
		
		JLabel shovelsex = new JLabel("토마토의 성장 시간을 25% 빠르게 합니다.");
		shovelsex.setForeground(Color.WHITE);
		shovelsex.setHorizontalAlignment(SwingConstants.CENTER);
		shovelsex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		shovelsex.setBounds(70, 480, 400, 20);
		characterstate.add(shovelsex);
		shovelsex.setVisible(false);
		
		JPanel shovels = new JPanel();
		if(Player.tool[3] == true){
			shovels = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/tool/오른쪽장비(삽).png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			shovels.setBackground(new Color(255,0,0,0));
			shovels.setBounds(220, 130, 50, 318);
			shovels.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent arg0) {
					characterstate.add(shovelsex);
					shovelsex.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					shovelsex.setVisible(false);
					characterstate.remove(shovelsex);
				}
			});
		}
		characterstate.add(shovels);
		
		JLabel rakeex = new JLabel("호박의 성장 시간을 25% 빠르게 합니다.");
		rakeex.setForeground(Color.WHITE);
		rakeex.setHorizontalAlignment(SwingConstants.CENTER);
		rakeex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		rakeex.setBounds(70, 480, 400, 20);
		characterstate.add(rakeex);
		rakeex.setVisible(false);
		
		JPanel rake = new JPanel();
		if(Player.tool[4] == true){
			rake = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/tool/왼쪽장비(창).png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			rake.setBackground(new Color(255,0,0,0));
			rake.setBounds(60, 128, 50, 318);
			rake.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent arg0) {
					characterstate.add(rakeex);
					rakeex.setVisible(true);
				}
				public void mouseExited(MouseEvent e) {
					rakeex.setVisible(false);
					characterstate.remove(rakeex);
				}
			});
		}
		characterstate.add(rake);
		
		JLabel lblmoney = new JLabel("소유 금액 : " + Integer.toString(Player.money)+ "원");
		lblmoney.setForeground(Color.WHITE);
		lblmoney.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblmoney.setBounds(300, 80, 200, 32);
		characterstate.add(lblmoney);
		
		JLabel lbltime = new JLabel("플레이 시간 : " + Integer.toString(Player.playtime/360) + "년 " + Integer.toString((Player.playtime%360)/30) 
								+ "월 " + Integer.toString((Player.playtime%360)%30) + "일");
		lbltime.setForeground(Color.WHITE);
		lbltime.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lbltime.setBounds(300, 130, 250, 32);
		characterstate.add(lbltime);
		
		JLabel lbldebt = new JLabel("남은 빚 : " + Integer.toString(Player.debt) + "원");
		lbldebt.setForeground(Color.WHITE);
		lbldebt.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lbldebt.setBounds(300, 180, 250, 32);
		characterstate.add(lbldebt);
		
		JLabel lblhelper = new JLabel();
		if(Player.helper == 1){
			if(Player.helperevolution[1] == true)
				lblhelper.setText("도우미 : 닭도우미(3단계)");
			else if(Player.helperevolution[0] == true)
				lblhelper.setText("도우미 : 닭도우미(2단계)");
			else
				lblhelper.setText("도우미 : 닭도우미(1단계)");
		}
		else if(Player.helper == 2){
			if(Player.helperevolution[1] == true)
				lblhelper.setText("도우미 : 돼지도우미(3단계)");
			else if(Player.helperevolution[0] == true)
				lblhelper.setText("도우미 : 돼지도우미(2단계)");
			else
				lblhelper.setText("도우미 : 돼지도우미(1단계)");
		}
		else if(Player.helper == 3){
			if(Player.helperevolution[1] == true)
				lblhelper.setText("도우미 : 양도우미(3단계)");
			else if(Player.helperevolution[0] == true)
				lblhelper.setText("도우미 : 양도우미(2단계)");
			else
				lblhelper.setText("도우미 : 양도우미(1단계)");
		}
		else if(Player.helper == 4){
			if(Player.helperevolution[1] == true)
				lblhelper.setText("도우미 : 소도우미(3단계)");
			else if(Player.helperevolution[0] == true)
				lblhelper.setText("도우미 : 소도우미(2단계)");
			else
				lblhelper.setText("도우미 : 소도우미(1단계)");
		}
		else if(Player.helper == 5){
			if(Player.helperevolution[1] == true)
				lblhelper.setText("도우미 : 사슴도우미(3단계)");
			else if(Player.helperevolution[0] == true)
				lblhelper.setText("도우미 : 사슴도우미(2단계)");
			else
				lblhelper.setText("도우미 : 사슴도우미(1단계)");
		}
		lblhelper.setForeground(Color.WHITE);
		lblhelper.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblhelper.setBounds(300, 230, 250, 32);
		characterstate.add(lblhelper);
		
		JLabel lbllandsize = new JLabel();
		if(Player.landsize == 3)
			lbllandsize.setText("땅의 크기 : 3단계(밭 25개, 동물 50마리)");
		else if(Player.landsize == 2)
			lbllandsize.setText("땅의 크기 : 2단계(밭 16개, 동물 25마리)");
		else 
			lbllandsize.setText("땅의 크기 : 1단계(밭 9개, 동물 10마리)");
		lbllandsize.setForeground(Color.WHITE);
		lbllandsize.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 18));
		lbllandsize.setBounds(300, 280, 350, 32);
		characterstate.add(lbllandsize);
		
		JLabel lbltool = new JLabel("장비 수 : 0갠");
		int j = 0;
		for(int i = 0; i < 5; i++ ){
			if(Player.tool[i] == true){
				j++;
			}
		}
		lbltool.setText("장비 수 : " + Integer.toString(j) + "개");
		lbltool.setForeground(Color.WHITE);
		lbltool.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lbltool.setBounds(300, 330, 350, 32);
		characterstate.add(lbltool);
		
		JLabel lblaninum = new JLabel("동물 수 : " + Integer.toString(Inventory.animalNum[0]) + "마리");
		lblaninum.setForeground(Color.WHITE);
		lblaninum.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblaninum.setBounds(300, 380, 350, 32);
		characterstate.add(lblaninum);
		
		JLabel lblpronum = new JLabel("작물 수 : " + Integer.toString(Inventory.produceNum[0]) + "개");
		lblpronum.setForeground(Color.WHITE);
		lblpronum.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		lblpronum.setBounds(300, 430, 350, 32);
		characterstate.add(lblpronum);
		
	}
	
	public void HelperState(){
		helperstate = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/choicehelperbackground.jpg");
				Image img = icon.getImage();
		       	super.paintComponent(g); 
		        g.drawImage(img,0,0,getWidth(),getHeight(),this); 
		        }
		};
		helperstate.setBounds(0, 0, 600, 548);
		helperstate.setLayout(null);
		JLabel helper = new JLabel();
		JLabel ex = new JLabel();
		if(Player.helper == 1){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭3).png");
				helper.setIcon(icon);
				ex.setText("닭을 키울 때 달걀을 50% 더 빨리 획득 가능");
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭2).png");
				helper.setIcon(icon);
				ex.setText("닭을 키울 때 달걀을 25% 더 빨리 획득 가능");
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/야차모(닭1).png");
				helper.setIcon(icon);
				ex.setText("닭을 키울 때 달걀을 10% 더 빨리 획득 가능");
			}
		}
		else if(Player.helper == 2){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지3).png");
				helper.setIcon(icon);
				ex.setText("돼지를 키울 때 고기를 50% 더 빨리 획득 가능");
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지2).png");
				helper.setIcon(icon);
				ex.setText("돼지를 키울 때 고기를 25% 더 빨리 획득 가능");
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/뚜구리(돼지1).png");
				helper.setIcon(icon);
				ex.setText("돼지를 키울 때 고기를 10% 더 빨리 획득 가능");
			}
		}
		else if(Player.helper == 3){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/메리프(양3).png");
				helper.setIcon(icon);
				ex.setText("양을 키울 때 털을 50% 더 빨리 획득 가능");
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/메리프(양2).png");
				helper.setIcon(icon);
				ex.setText("양을 키울 때 털을 25% 더 빨리 획득 가능");
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/메리프(양1).png");
				helper.setIcon(icon);
				ex.setText("양을 키울 때 털을 10% 더 빨리 획득 가능");
			}
		}
		else if(Player.helper == 4){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소3).png");
				helper.setIcon(icon);
				ex.setText("소를 키울 때 우유 50% 더 빨리 획득 가능");
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소2).png");
				helper.setIcon(icon);
				ex.setText("소를 키울 때 우유 25% 더 빨리 획득 가능");
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/밀탱크(소1).png");
				helper.setIcon(icon);
				ex.setText("소를 키울 때 우유 10% 더 빨리 획득 가능");
			}
		}
		else if(Player.helper == 5){
			if(Player.helperevolution[1] == true){
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴3).png");
				helper.setIcon(icon);
				ex.setText("사슴을 키울 때 녹용 50% 더 빨리 획득 가능");
			}
			else if(Player.helperevolution[0] == true){
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴2).png");
				helper.setIcon(icon);
				ex.setText("사슴을 키울 때 녹용 25% 더 빨리 획득 가능");
			}
			else{
				ImageIcon icon = new ImageIcon("image/helper/사철록(사슴1).png");
				helper.setIcon(icon);
				ex.setText("사슴을 키울 때 녹용 10% 더 빨리 획득 가능");
			}
		}
		helper.setBounds(200, 50, 300, 300);
		ex.setHorizontalAlignment(SwingConstants.CENTER);
		ex.setForeground(Color.BLACK);
		ex.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
		ex.setBounds(70, 350, 500, 32);
		
		helperstate.add(helper);
		helperstate.add(ex);
	}
	
	public void Inventory(){
		JPanel inventory = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/inventorybackground.jpg");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		
		JLabel lblinven = new JLabel("인벤토리");
		lblinven.setHorizontalAlignment(SwingConstants.CENTER);
		lblinven.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblinven.setBounds(107, 10, 363, 61);
		inventory.add(lblinven);
	
		
		JPanel chickenicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/chicken.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		chickenicon.setBackground(new Color(255,0,0,0));
		chickenicon.setBounds(86, 96, 30, 30);
		inventory.add(chickenicon);
		
		JLabel lblchicken = new JLabel("닭 " + Integer.toString(Inventory.animalNum[1]));
		lblchicken.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblchicken.setBounds(128, 96, 190, 30);
		inventory.add(lblchicken);
		
		JPanel eggicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/달걀.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		eggicon.setBackground(new Color(255,0,0,0));
		eggicon.setBounds(325, 96, 30, 30);
		inventory.add(eggicon);
		
		JLabel lblegg = new JLabel("달걀 " + Integer.toString(Inventory.animade[0]));
		lblegg.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblegg.setBounds(367, 96, 190, 30);
		inventory.add(lblegg);
		
		JPanel pigicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/pig.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pigicon.setBackground(new Color(255,0,0,0));
		pigicon.setBounds(86, 156, 30, 30);
		inventory.add(pigicon);
		
		JLabel lblpig = new JLabel("돼지 " + Integer.toString(Inventory.animalNum[2]));
		lblpig.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblpig.setBounds(128, 156, 190, 30);
		inventory.add(lblpig);
		
		JPanel meaticon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/고기.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		meaticon.setBackground(new Color(255,0,0,0));
		meaticon.setBounds(325, 156, 30, 30);
		inventory.add(meaticon);
		
		JLabel lblmeat = new JLabel("고기 " + Integer.toString(Inventory.animade[1]));
		lblmeat.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblmeat.setBounds(367, 156, 190, 30);
		inventory.add(lblmeat);
		
		JPanel sheepicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/sheep.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		sheepicon.setBackground(new Color(255,0,0,0));
		sheepicon.setBounds(86, 211, 30, 30);
		inventory.add(sheepicon);
		
		JLabel lblsheep = new JLabel("양 " + Integer.toString(Inventory.animalNum[3]));
		lblsheep.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblsheep.setBounds(128, 211, 190, 30);
		inventory.add(lblsheep);
		
		JPanel woolicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/양털.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		woolicon.setBackground(new Color(255,0,0,0));
		woolicon.setBounds(325, 211, 30, 30);
		inventory.add(woolicon);
		
		JLabel lblwool = new JLabel("양털 " + Integer.toString(Inventory.animade[2]));
		lblwool.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblwool.setBounds(367, 211, 190, 30);
		inventory.add(lblwool);
		
		JPanel cowicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/cow.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cowicon.setBackground(new Color(255,0,0,0));
		cowicon.setBounds(86, 271, 30, 30);
		inventory.add(cowicon);
		
		JLabel lblcow = new JLabel("소 " + Integer.toString(Inventory.animalNum[4]));
		lblcow.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblcow.setBounds(128, 271, 190, 30);
		inventory.add(lblcow);
		
		JPanel milkicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/우유.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		milkicon.setBackground(new Color(255,0,0,0));
		milkicon.setBounds(325, 271, 30, 30);
		inventory.add(milkicon);
		
		JLabel lblmilk = new JLabel("우유 " + Integer.toString(Inventory.animade[3]));
		lblmilk.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblmilk.setBounds(367, 271, 190, 30);
		inventory.add(lblmilk);
		
		JPanel deericon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/deer.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		deericon.setBackground(new Color(255,0,0,0));
		deericon.setBounds(86, 326, 30, 30);
		inventory.add(deericon);
		
		JLabel lbldeer = new JLabel("사슴 " + Integer.toString(Inventory.animalNum[5]));
		lbldeer.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lbldeer.setBounds(128, 326, 190, 30);
		inventory.add(lbldeer);
		
		JPanel hornicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/animal/녹용.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		hornicon.setBackground(new Color(255,0,0,0));
		hornicon.setBounds(325, 326, 30, 30);
		inventory.add(hornicon);
		
		JLabel lblhorn = new JLabel("녹용 " + Integer.toString(Inventory.animade[4]));
		lblhorn.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblhorn.setBounds(367, 326, 190, 30);
		inventory.add(lblhorn);
		
		JPanel potatoseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/감자씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		potatoseedicon.setBackground(new Color(255,0,0,0));
		potatoseedicon.setBounds(86, 386, 30, 30);
		inventory.add(potatoseedicon);
		
		JLabel lblpotatoseed = new JLabel("감자씨앗 " + Integer.toString(Inventory.produceNum[1]));
		lblpotatoseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblpotatoseed.setBounds(128, 386, 190, 30);
		inventory.add(lblpotatoseed);
		
		JPanel potatoicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/감자.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		potatoicon.setBackground(new Color(255,0,0,0));
		potatoicon.setBounds(325, 386, 30, 30);
		inventory.add(potatoicon);
		
		JLabel lblpotato = new JLabel("감자 " + Integer.toString(Inventory.promade[0]));
		lblpotato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblpotato.setBounds(367, 386, 190, 30);
		inventory.add(lblpotato);
		
		JPanel carrotseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/당근씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		carrotseedicon.setBackground(new Color(255,0,0,0));
		carrotseedicon.setBounds(86, 446, 30, 30);
		inventory.add(carrotseedicon);
		
		JLabel lblcarrotseed = new JLabel("당근씨앗 " + Integer.toString(Inventory.produceNum[2]));
		lblcarrotseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblcarrotseed.setBounds(128, 446, 190, 30);
		inventory.add(lblcarrotseed);
		
		JPanel carroticon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/당근.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		carroticon.setBackground(new Color(255,0,0,0));
		carroticon.setBounds(325, 446, 30, 30);
		inventory.add(carroticon);
		
		JLabel lblcarrot = new JLabel("당근 " + Integer.toString(Inventory.promade[1]));
		lblcarrot.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblcarrot.setBounds(367, 446, 190, 30);
		inventory.add(lblcarrot);
		
		JPanel cucumberseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/오이씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cucumberseedicon.setBackground(new Color(255,0,0,0));
		cucumberseedicon.setBounds(86, 506, 30, 30);
		inventory.add(cucumberseedicon);
		
		JLabel lblcucumberseed = new JLabel("오이씨앗 " + Integer.toString(Inventory.produceNum[3]));
		lblcucumberseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblcucumberseed.setBounds(128, 506, 190, 30);
		inventory.add(lblcucumberseed);
		
		JPanel cucumbericon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/오이.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		cucumbericon.setBackground(new Color(255,0,0,0));
		cucumbericon.setBounds(325, 506, 30, 30);
		inventory.add(cucumbericon);
		
		JLabel lblcucumber = new JLabel("오이 " + Integer.toString(Inventory.promade[2]));
		lblcucumber.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblcucumber.setBounds(367, 506, 190, 30);
		inventory.add(lblcucumber);
		
		JPanel tomatoseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/토마토씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		tomatoseedicon.setBackground(new Color(255,0,0,0));
		tomatoseedicon.setBounds(86, 566, 30, 30);
		inventory.add(tomatoseedicon);
		
		JLabel lbltomatoseed = new JLabel("토마토씨앗 " + Integer.toString(Inventory.produceNum[4]));
		lbltomatoseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lbltomatoseed.setBounds(128, 566, 190, 30);
		inventory.add(lbltomatoseed);
		
		JPanel tomatoicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/토마토.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		tomatoicon.setBackground(new Color(255,0,0,0));
		tomatoicon.setBounds(325, 566, 30, 30);
		inventory.add(tomatoicon);
		
		JLabel lbltomato = new JLabel("토마토 " + Integer.toString(Inventory.promade[3]));
		lbltomato.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lbltomato.setBounds(367, 566, 190, 30);
		inventory.add(lbltomato);
		
		JPanel pumpkinseedicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/호박씨앗.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pumpkinseedicon.setBackground(new Color(255,0,0,0));
		pumpkinseedicon.setBounds(86, 626, 30, 30);
		inventory.add(pumpkinseedicon);
		
		JLabel lblpumpkinseed = new JLabel("호박씨앗 " + Integer.toString(Inventory.produceNum[5]));
		lblpumpkinseed.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblpumpkinseed.setBounds(128, 626, 190, 30);
		inventory.add(lblpumpkinseed);
		
		JPanel pumpkinicon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/호박.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		pumpkinicon.setBackground(new Color(255,0,0,0));
		pumpkinicon.setBounds(325, 626, 30, 30);
		inventory.add(pumpkinicon);
		
		JLabel lblpumpkin = new JLabel("호박 " + Integer.toString(Inventory.promade[4]));
		lblpumpkin.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
		lblpumpkin.setBounds(367, 626,190, 30);
		inventory.add(lblpumpkin);
		inventory.setPreferredSize(new Dimension(580,660));
		inventory.setLayout(null);
		
		JPanel stone1icon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/stone/1단계.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		stone1icon.setBackground(new Color(255,0,0,0));
		stone1icon.setBounds(86, 686, 30, 30);
		inventory.add(stone1icon);
		
		JLabel lblstone1 = new JLabel();
		if(Inventory.evolutionstone[0] == true)
			lblstone1.setText("1단계 진화석 있음");
		else 
			lblstone1.setText("1단계 진화석 없음");
		lblstone1.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 25));
		lblstone1.setBounds(128, 686, 190, 30);
		inventory.add(lblstone1);
		
		JPanel stone2icon = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/stone/2단계.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			}
		};
		stone2icon.setBackground(new Color(255,0,0,0));
		stone2icon.setBounds(325, 686, 30, 30);
		inventory.add(stone2icon);
		
		JLabel lblstone2 = new JLabel();
		if(Inventory.evolutionstone[1] == true)
			lblstone2.setText("2단계 진화석 있음");
		else
			lblstone2.setText("2단계 진화석 없음");
		lblstone2.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 25));
		lblstone2.setBounds(367, 686,190, 30);
		inventory.add(lblstone2);
		inventory.setPreferredSize(new Dimension(580,720));
		inventory.setLayout(null);
		
		scroll.setViewportView(inventory);
	}
	
}


