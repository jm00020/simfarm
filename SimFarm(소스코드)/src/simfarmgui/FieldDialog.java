package simfarmgui;

import simfarm.Field;
import simfarm.Inventory;
import simfarm.Produce;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FieldDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Field field = new Field();

	public FieldDialog(JPanel panel, int position, MouseAdapter l) {
		setBounds(100, 100, 590, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\uD0A4\uC6B8 \uC791\uBB3C\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 30));
			label.setBounds(0, 28, 574, 41);
			contentPanel.add(label);
		}
		{
			JPanel potato = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/°¨ÀÚ¾¾¾Ñ.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			potato.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(Inventory.produceNum[1] < 1){
						JOptionPane.showMessageDialog(null, "°¨ÀÚ¾¾¾ÑÀÌ ¾ø½À´Ï´Ù",null, JOptionPane.ERROR_MESSAGE); 
						return;
					}
					field.StartThread(1, position, panel, l);
					dispose();
				}
			});
			potato.setBounds(8, 79, 105, 126);
			contentPanel.add(potato);
		}
		{
			JPanel carrot = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/´ç±Ù¾¾¾Ñ.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			carrot.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(Inventory.produceNum[2] < 1){
						JOptionPane.showMessageDialog(null, "´ç±Ù¾¾¾ÑÀÌ ¾ø½À´Ï´Ù",null, JOptionPane.ERROR_MESSAGE); 
						return;
					}
					field.StartThread(2, position, panel, l);
					dispose();
				}
			});
			carrot.setBounds(121, 79, 105, 126);
			contentPanel.add(carrot);
		}
		{
			JPanel cucumber = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/¿ÀÀÌ¾¾¾Ñ.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			cucumber.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(Inventory.produceNum[3] < 1){
						JOptionPane.showMessageDialog(null, "¿ÀÀÌ¾¾¾ÑÀÌ ¾ø½À´Ï´Ù",null, JOptionPane.ERROR_MESSAGE); 
						return;
					}
					field.StartThread(3, position, panel, l);
					dispose();
				}
			});
			cucumber.setBounds(234, 79, 105, 126);
			contentPanel.add(cucumber);
		}
		{
			JPanel tomato = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/Åä¸¶Åä¾¾¾Ñ.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			tomato.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(Inventory.produceNum[4] < 1){
						JOptionPane.showMessageDialog(null, "Åä¸¶Åä¾¾¾ÑÀÌ ¾ø½À´Ï´Ù",null, JOptionPane.ERROR_MESSAGE); 
						return;
					}
					field.StartThread(4, position, panel, l);
					dispose();
				}
			});
			tomato.setBounds(347, 79, 105, 126);
			contentPanel.add(tomato);
		}
		{
			JPanel pumpkin = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/produce/È£¹Ú¾¾¾Ñ.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			pumpkin.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(Inventory.produceNum[5] < 1){
						JOptionPane.showMessageDialog(null, "È£¹Ú¾¾¾ÑÀÌ ¾ø½À´Ï´Ù",null, JOptionPane.ERROR_MESSAGE); 
						return;
					}
					field.StartThread(5, position, panel, l);
					dispose();
				}
			});
			pumpkin.setBounds(460, 79, 105, 126);
			contentPanel.add(pumpkin);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\uCDE8\uC18C");
				cancelButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("210 Ä«Å÷½ºÅä¸® R", Font.PLAIN, 19));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
