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
				ImageIcon icon = new ImageIcon("image/produce/자라는 중.png");
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
				ImageIcon icon = new ImageIcon("image/produce/다자람.png");
				Image img = icon.getImage();
				super.paintComponent(g); 
				g.drawImage(img,0,0,getWidth(),getHeight(),this); 
			} 
		};
		produce.setBackground(new Color(255,0,0,0));
		produce.setBounds(5, 5, panel.getWidth()-10, panel.getHeight()-10);
		switch(name){
		case "감자":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/감자생산.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "당근":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/당근생산.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "오이":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/오이생산.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "토마토":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/토마토생산.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			bubbles.setBackground(new Color(255,0,0,0));
			bubbles.setBounds(panel.getWidth()-60, 0, 60, 60);
			panel.add(bubbles);
			break;
		case "호박":
			bubbles = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/호박생산.png");
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
				case "감자":
					Inventory.promade[0]++;
					break;
				case "당근":
					Inventory.promade[1]++;
					break;
				case "오이":
					Inventory.promade[2]++;
					break;
				case "토마토":
					Inventory.promade[3]++;
					break;
				case "호박":
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
		ProduceGui(); //논밭에 해당 식물의 그림을 그림
		try{
			if(Player.tool[0] == true){ //감자 도구가 있는지 확인
				Thread.sleep(7500);
			}
			else
				Thread.sleep(10000); //부산물 생성까지 기본 10초
			EndGui(Thread.currentThread().getName()); //성장을 다한모습과 부산물이 생성되었다고 화면에 표현
			Harvest(this, Thread.currentThread().getName(), l); //플레이어가 수확하였는지 확인하고 진행
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
			if(Player.tool[1] == true){ //당근 도구가 있는지 확인
				Thread.sleep(22500);
			}
			else
				Thread.sleep(30000); //부산물 생성까지 30초
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
			if(Player.tool[2] == true){ //오이 도구가 있는지 확인
				Thread.sleep(45000);
			}
			else
				Thread.sleep(60000); //부산물 생성까지 1분
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
			if(Player.tool[3] == true){ //오이 도구가 있는지 확인
				Thread.sleep(90000);
			}
			else
				Thread.sleep(120000); //부산물 생성까지 2분
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
			if(Player.tool[4] == true){ //오이 도구가 있는지 확인
				Thread.sleep(225000);
			}
			else
				Thread.sleep(300000); //부산물 생성까지 5분
			EndGui(Thread.currentThread().getName());
			Harvest(this, Thread.currentThread().getName(), l);
		}
		catch(InterruptedException e){
			return;
		}
	}
}