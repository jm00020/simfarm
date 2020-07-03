package simfarmgui;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simfarm.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreditorDialog extends JDialog {

	public CreditorDialog(boolean live, int debt) {
		Sound.clip.close();
		new Sound("sound/ºúÀïÀÌµîÀå.wav",true);
		setBounds(100, 100, 565, 465);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/background/Creditor.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				}
			};
			panel.setBounds(0, 0, 549, 427);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel_1.setBackground(new Color(255,0,0,0));
				panel_1.setBounds(0, 0, 549, 384);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("\uBE5A  \uC7C1  \uC774  \uB4F1  \uC7A5");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setForeground(Color.WHITE);
					label.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 40));
					label.setBounds(0, 21, 549, 52);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("\uB3C8\uC744 \uAC1A\uC73C\uC154\uC57C \uD569\uB2C8\uB2E4.");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setForeground(Color.WHITE);
					label.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 25));
					label.setBounds(0, 279, 549, 38);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("\uAC1A\uC73C\uC2E4 \uAE08\uC561\uC740 "+ Integer.toString(debt) + "\uC6D0 \uC785\uB2C8\uB2E4.");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setForeground(Color.WHITE);
					label.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 25));
					label.setBounds(0, 327, 549, 38);
					panel_1.add(label);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 384, 549, 43);
				panel_1.setBackground(new Color(255,0,0,0));
				panel.add(panel_1);
				panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton button = new JButton("\uC608");
					button.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if(live){
								JOptionPane.showMessageDialog(null, "ÇÑ´Þ Ä¡ ºúÀ» °±À¸¼Ì½À´Ï´Ù.\n °ÔÀÓÀ¸·Î µ¹¾Æ°©´Ï´Ù.", "GAME GO", JOptionPane.WARNING_MESSAGE);
								if(debt != 800000){
									dispose();
									MenuScreen.contentPane.removeAll();
									MenuScreen.contentPane.add(new HappyEnding());
									MenuScreen.contentPane.repaint();
								}
								Sound.clip.close();
								dispose();
								new Sound("sound/menu.wav",true);
							}
							else{
								JOptionPane.showMessageDialog(null, "µ·ÀÌ ºÎÁ·ÇÕ´Ï´Ù", "GAME OVER", JOptionPane.WARNING_MESSAGE);
								dispose();
								MenuScreen.contentPane.removeAll();
								MenuScreen.contentPane.add(new BadEnding());
								MenuScreen.contentPane.repaint();
							}
							
						}
					});
					button.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 25));
					button.setActionCommand("OK");
					panel_1.add(button);
				}
			}
		}
		setVisible(true);
	}

}
