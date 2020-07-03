package simfarm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import simfarmgui.MainScreen;

public class Produce {
	protected JPanel panel;
	protected JPanel produce = new JPanel();
	protected JPanel bubbles = new JPanel();
	protected MouseAdapter l;
	public Produce(JPanel panel, MouseAdapter l){
		this.panel = panel;
		this.l = l;
	}
	
	public void ProduceGui(){
		panel.removeMouseListener(l);
		produce = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/�ڶ�� ��.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			} 
		};
		produce.setBackground(new Color(255,0,0,0));
		produce.setBounds(5, 5, panel.getWidth()-10, panel.getHeight()-10);
		panel.add(produce);
		MainScreen.fieldscreen.repaint();
	}
	
	public void EndGui(String name){
		panel.removeAll();
		MainScreen.fieldscreen.repaint();
		produce = new JPanel(){
			public void paintComponent(Graphics g){ 
				ImageIcon icon = new ImageIcon("image/produce/���ڶ�.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			} 
		};
		produce.setBackground(new Color(255,0,0,0));
		produce.setBounds(5, 5, panel.getWidth()-10, panel.getHeight()-10);
		switch(name){
		case "����":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/���ڻ���.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "���":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/��ٻ���.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "����":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/���̻���.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "�丶��":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/�丶�����.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "ȣ��":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/ȣ�ڻ���.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		}
		
		panel.add(produce);
		MainScreen.fieldscreen.repaint();
	}

	public void Harvest(Produce thread, String name, MouseAdapter l){
		MouseAdapter l2 = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				MainScreen.fieldscreen.repaint();
				switch(name){
				case "����":
					Inventory.promade[0]++;
					break;
				case "���":
					Inventory.promade[1]++;
					break;
				case "����":
					Inventory.promade[2]++;
					break;
				case "�丶��":
					Inventory.promade[3]++;
					break;
				case "ȣ��":
					Inventory.promade[4]++;
					break;
				}
				synchronized(thread){
					thread.notify();
				}
			}	
		};
		panel.addMouseListener(l2);
		if(panel.isVisible() == true){
			synchronized(thread){
				try {
					thread.wait();
				} catch (InterruptedException e1) {
					return;
				}
			}
		}
		panel.removeMouseListener(l2);
		panel.addMouseListener(l);
	}
	
	public void ReDraw(JPanel panel){
		produce.setBounds(5, 5, panel.getWidth()-10, panel.getHeight()-10);
		bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
	}
}

class Potato extends Produce implements Runnable{
	public Potato(JPanel panel, MouseAdapter l){
		super(panel, l);
	}
	public void run() {
		ProduceGui(); //��翡 �ش� �Ĺ��� �׸��� �׸�
		try{
			if(Player.tool[0] == true){ //���� ������ �ִ��� Ȯ��
				Thread.sleep(7500);
			}
			else
				Thread.sleep(10000); //�λ깰 �������� �⺻ 10��
			EndGui(Thread.currentThread().getName()); //������ ���Ѹ���� �λ깰�� �����Ǿ��ٰ� ȭ�鿡 ǥ��
			Harvest(this, Thread.currentThread().getName(), l); //�÷��̾ ��Ȯ�Ͽ����� Ȯ���ϰ� ����
		}
		catch(InterruptedException e){
			return;
		}
	}
}

class Carrot extends Produce implements Runnable{
	public Carrot(JPanel panel, MouseAdapter l){
		super(panel, l);
	}
	public void run() {
		ProduceGui();
		try{
			if(Player.tool[1] == true){ //��� ������ �ִ��� Ȯ��
				Thread.sleep(22500);
			}
			else
				Thread.sleep(30000); //�λ깰 �������� 30��
			EndGui(Thread.currentThread().getName());
			Harvest(this, Thread.currentThread().getName(), l);
		}
		catch(InterruptedException e){
			return;
		}
	}
}

class Cucumber extends Produce implements Runnable{
	public Cucumber(JPanel panel, MouseAdapter l){
		super(panel, l);
	}
	public void run() {
		ProduceGui();
		try{
			if(Player.tool[2] == true){ //���� ������ �ִ��� Ȯ��
				Thread.sleep(45000);
			}
			else
				Thread.sleep(60000); //�λ깰 �������� 1��
			EndGui(Thread.currentThread().getName());
			Harvest(this, Thread.currentThread().getName(), l);
		}
		catch(InterruptedException e){
			return;
		}
	}
}

class Tomato extends Produce implements Runnable{
	public Tomato(JPanel panel, MouseAdapter l){
		super(panel, l);
	}
	public void run() {
		ProduceGui();
		try{
			if(Player.tool[3] == true){ //���� ������ �ִ��� Ȯ��
				Thread.sleep(90000);
			}
			else
				Thread.sleep(120000); //�λ깰 �������� 2��
			EndGui(Thread.currentThread().getName());
			Harvest(this, Thread.currentThread().getName(), l);
		}
		catch(InterruptedException e){
			return;
		}
	}
}

class Pumpkin extends Produce implements Runnable{
	public Pumpkin(JPanel panel, MouseAdapter l){
		super(panel, l);
	}
	public void run() {
		ProduceGui();
		try{
			if(Player.tool[4] == true){ //���� ������ �ִ��� Ȯ��
				Thread.sleep(225000);
			}
			else
				Thread.sleep(300000); //�λ깰 �������� 5��
			EndGui(Thread.currentThread().getName());
			Harvest(this, Thread.currentThread().getName(), l);
		}
		catch(InterruptedException e){
			return;
		}
	}
}