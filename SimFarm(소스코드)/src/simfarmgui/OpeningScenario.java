package simfarmgui;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OpeningScenario extends JPanel{
	int i = 0;

	public void paintComponent(Graphics g){ 
		ImageIcon icon = new ImageIcon("image/background/scenariobackground.jpg");
		Image img = icon.getImage();
       	super.paintComponent(g); 
        g.drawImage(img,0,-20,getWidth(),getHeight(),this); 
	}; 
	
	public OpeningScenario() {
		setBounds(-8, 0, 800, 600);
		setLayout(null);
		
		JLabel lblSkip = new JLabel("skip");
		lblSkip.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Sound.clip.close();
				setVisible(false);
				MenuScreen.contentPane.removeAll();
				new Sound("sound/menu.wav",true);
				MenuScreen.contentPane.add(new ChoicehelperScreen());
			}
		});
		lblSkip.setForeground(new Color(153, 255, 255));
		lblSkip.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkip.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 40));
		lblSkip.setBounds(656, 30, 97, 48);
		add(lblSkip);
		JPanel [] panel = new JPanel[3];
		panel[0] = new JPanel() { 
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/scenario1.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel[0].setBounds(200, 120, 400, 330);
		add(panel[0]);
		panel[0].setLayout(null);
		
		JLabel lblStript1 = new JLabel("\uADF8\uB294 \uC798\uB098\uAC00\uB294 \uD68C\uC0AC\uC758 \uC0AC\uC7A5\uC774\uC600\uB2E4. \uADF8\uB7EC\uB358 \uC5B4\uB290 \uB0A0...");
		lblStript1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStript1.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 18));
		lblStript1.setBounds(0, 288, 400, 42);
		panel[0].add(lblStript1);
		setVisible(true);
		
		panel[1] = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/scenario2.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel[1].setBounds(200, 120, 400, 330);
		panel[1].setLayout(null);
		
		JLabel lblStript2 = new JLabel("그의 회사는 부도가 나고 그는 큰 빚을 지게 된다.");
		lblStript2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStript2.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 18));
		lblStript2.setBounds(0, 288, 400, 42);
		panel[1].add(lblStript2);
		
		panel[2] =  new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/background/menubackground.jpg");
				Image img = icon.getImage();
               	super.paintComponent(g); 
                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
          } 
		}; 
		panel[2].setBounds(200, 120, 400, 330);
		panel[2].setLayout(null);
		
		JLabel lblStript3 = new JLabel("그는 빚을 갚기 위해 아버지의 농장을 운영하기 시작한다.");
		lblStript3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStript3.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 18));
		lblStript3.setBounds(0, 288, 400, 42);
		panel[2].add(lblStript3);
		
		JLabel lblClick = new JLabel("Click");
		lblClick.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(i == 2){
					Sound.clip.close();
					setVisible(false);
					MenuScreen.contentPane.removeAll();
					new Sound("sound/menu.wav",true);
					MenuScreen.contentPane.add(new ChoicehelperScreen());
					return ;
				}
				panel[i].setVisible(false);
				remove(panel[i]);
				add(panel[++i]);
				panel[i].setVisible(true);
				if(i == 2){
					lblClick.setText("Start");
					add(lblClick);
				}
			}
		});
		lblClick.setForeground(new Color(153, 255, 255));
		lblClick.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 18));
		lblClick.setHorizontalAlignment(SwingConstants.CENTER);
		lblClick.setBounds(599, 422, 57, 15);
		add(lblClick);
		setVisible(true);
	}

}
