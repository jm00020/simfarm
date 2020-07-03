package simfarmgui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simfarm.Load;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuScreen extends JFrame {

	public static JPanel contentPane;
	public static JPanel firstpanel;

	public MenuScreen() {
		setTitle("SimFarm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(50, 50,800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon("image/background/menubackground.jpg");
		Image img = icon.getImage();
		
		firstpanel = new JPanel() { 
			public void paintComponent(Graphics g){ 
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		firstpanel.setBounds(-8, 0, 800, 600);
		firstpanel.setLayout(null);
		
		JLabel label = new JLabel("SimFarm");
		label.setForeground(Color.DARK_GRAY);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.BOLD, 99));
		label.setBounds(164, 91, 471, 82);
		firstpanel.add(label);
		
		JLabel lblNew_game = new JLabel("new game");
		lblNew_game.setForeground(Color.DARK_GRAY);
		lblNew_game.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				lblNew_game.setForeground(Color.YELLOW);
			}
			public void mouseExited(MouseEvent e) {
				lblNew_game.setForeground(Color.DARK_GRAY);
			}
			public void mouseClicked(MouseEvent e) {
				firstpanel.setVisible(false);
				remove(firstpanel);
				Sound.clip.close();
				new Sound("sound/scenario.wav",true);
				add(new OpeningScenario());
			}
		});
		lblNew_game.setHorizontalAlignment(SwingConstants.CENTER);
		lblNew_game.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.BOLD, 30));
		lblNew_game.setBounds(321, 304, 158, 49);
		firstpanel.add(lblNew_game);
		
		JLabel lblLoad = new JLabel("load");
		lblLoad.setForeground(Color.DARK_GRAY);
		lblLoad.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				lblLoad.setForeground(Color.YELLOW);
			}
			public void mouseExited(MouseEvent e) {
				lblLoad.setForeground(Color.DARK_GRAY);
			}
			public void mouseClicked(MouseEvent e) {
				new Load();
				firstpanel.setVisible(false);
				remove(firstpanel);
				add(new MainScreen());
			}
		});
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.BOLD, 30));
		lblLoad.setBounds(321, 376, 158, 49);
		firstpanel.add(lblLoad);
		
		JLabel lblExit = new JLabel("exit");
		lblExit.setForeground(Color.DARK_GRAY);
		lblExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.YELLOW);
			}
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.DARK_GRAY);
			}
			public void mouseClicked(MouseEvent e) {
				Sound.clip.close();
				System.exit(0);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.BOLD, 30));
		lblExit.setBounds(321, 446, 158, 49);
		firstpanel.add(lblExit);
		
		contentPane.add(firstpanel);
		
	}
}
