package simfarm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import simfarmgui.MainScreen;

public class Animal {

	static protected int select;
	public Animal(int select){
		Animal.select = select;
	}
	
	static synchronized protected JPanel [] AnimalGui(int num){
		JPanel [] panel = new JPanel [2];
		
		switch(select){
		case 1:
			panel[0] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/animal/chicken.png");
					Image img = icon.getImage();
					super.paintComponent(g); 
					g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			}; 
			panel[1] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/�߻���.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			break;
		case 2:
			panel[0] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/animal/pig.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			}; 
			panel[1] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/��������.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			break;
		case 3:
			panel[0] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/animal/sheep.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			}; 
			panel[1] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/�����.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			break;
		case 4:
			panel[0] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/animal/cow.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			}; 
			panel[1] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/�һ���.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			break;
		case 5:
			panel[0] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/animal/deer.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			}; 
			panel[1] = new JPanel(){
				public void paintComponent(Graphics g){ 
					ImageIcon icon = new ImageIcon("image/icon/�罿����.png");
					Image img = icon.getImage();
	               	super.paintComponent(g); 
	                g.drawImage(img,0,0,getWidth(),getHeight(),this); 
				} 
			};
			break;
		}
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		else if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
		
		panel[0].setBackground(new Color(255,0,0,0));
		MainScreen.farmscreen.add(panel[0]);
		
		panel[1].setBackground(new Color(255,0,0,0));
		MainScreen.farmscreen.add(panel[1]);
		panel[1].setVisible(false);
		
		MainScreen.farmscreen.repaint();
		
		return panel;
	}

	protected boolean showbubbles(Animal animal, JPanel bubbles){
		bubbles.setVisible(true);
		MainScreen.farmscreen.repaint();
		MouseAdapter l = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				bubbles.setVisible(false);
				MainScreen.farmscreen.repaint();
				Inventory.animade[select-1]++;
				synchronized(animal){
					animal.notify();
				}
			}	
		};
		bubbles.addMouseListener(l);
		if(bubbles.isVisible() == true){
			synchronized(animal){
				try {
					animal.wait();
				} catch (InterruptedException e1) {
					return false;
				}
			}
		}
		bubbles.removeMouseListener(l);
		return true;
	}

	protected void ReDraw(){};
	
	protected void DelDraw(){};
	
	protected void NumChange(int n){};
}

class Chicken extends Animal implements Runnable{
	int num;
	JPanel [] panel;
	public Chicken(int select, int num){
		super(select);
		this.num = num;
	}
	
	public void run() {
		panel  = AnimalGui(num); //���忡 ������ ũ���� �׸�
		while(true){
			try{
				if(Player.helper == 1){ //�� ����̸� �����Ͽ��� �� Ȯ��
					if(Player.helperevolution[1] == true) //2�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(5000);
					else if(Player.helperevolution[0] == true) //1�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(7500);
					else //��ȭ ���� �ʾ��� ���
						Thread.sleep(9000);
				}
				else
					Thread.sleep(10000); //�λ깰 �������� �⺻ 10��
				
				if(false == showbubbles(this, panel[1])){ //�λ깰�� �����Ͽ��ٰ� ȭ�鿡 ǥ��
					return;
				}
				
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
	
	protected void ReDraw(){
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
	}
	
	protected void DelDraw(){
		panel[0].setVisible(false);
		panel[0].removeAll();
		panel[1].setVisible(false);
		panel[1].removeAll();
	}
	
	protected void NumChange(int n){
		num = n;
	};
	
}

class Pig extends Animal implements Runnable{
	int num;
	JPanel [] panel;
	public Pig(int select, int num) {
		super(select);
		this.num = num;
	}
	
	public void run() {
		panel = AnimalGui(num);
		while(true){
			try{
				if(Player.helper == 2){ //���� ����̸� �����Ͽ��� �� Ȯ��
					if(Player.helperevolution[1] == true) //2�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(15000);
					else if(Player.helperevolution[0] == true) //1�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(22500);
					else //��ȭ ���� �ʾ��� ���
						Thread.sleep(27000);
				}
				else
					Thread.sleep(30000); //�λ깰 �������� 30��
			
				if(false ==showbubbles(this, panel[1])){
					return;
				}
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
	
	protected void ReDraw(){
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
	}
	
	protected void DelDraw(){
		panel[0].setVisible(false);
		panel[0].removeAll();
		panel[1].setVisible(false);
		panel[1].removeAll();
	}
	
	protected void NumChange(int n){
		num = n;
	};
}

class Sheep extends  Animal implements Runnable{
	int num;
	JPanel [] panel;
	public Sheep(int select, int num) {
		super(select);
		this.num = num;
	}

	public void run() {
		panel = AnimalGui(num);
		while(true){
			try{
				if(Player.helper == 3){ //�� ����̸� �����Ͽ��� �� Ȯ��
					if(Player.helperevolution[1] == true) //2�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(30000);
					else if(Player.helperevolution[0] == true) //1�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(45000);
					else //��ȭ ���� �ʾ��� ���
						Thread.sleep(54000);
				}
				else
					Thread.sleep(60000); //�λ깰 �������� �⺻ 1��
			
				if(false ==showbubbles(this, panel[1])){
					return;
				}
			}	
			catch(InterruptedException e){
				return;
			}
		}
	}
	
	protected void ReDraw(){
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
	}
	
	protected void DelDraw(){
		panel[0].setVisible(false);
		panel[0].removeAll();
		panel[1].setVisible(false);
		panel[1].removeAll();
	}
	
	protected void NumChange(int n){
		num = n;
	};
}

class Cow extends Animal implements Runnable{
	int num;
	JPanel [] panel;
	public Cow(int select, int num) {
		super(select);
		this.num = num;
	}

	public void run() {
		panel = AnimalGui(num);
		while(true){
			try{
				if(Player.helper == 4){ //�� ����̸� �����Ͽ��� �� Ȯ��
					if(Player.helperevolution[1] == true) //2�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(60000);
					else if(Player.helperevolution[0] == true) //1�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(90000);
					else //��ȭ ���� �ʾ��� ���
						Thread.sleep(108000);
				}
				else
					Thread.sleep(120000); //�λ깰 �������� �⺻ 2��
			
				if(false ==showbubbles(this, panel[1])){
					return;
				}
			}
			catch(InterruptedException e){
				return;
			}	
		}
	}
	
	protected void ReDraw(){
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
	}
	
	protected void DelDraw(){
		panel[0].setVisible(false);
		panel[0].removeAll();
		panel[1].setVisible(false);
		panel[1].removeAll();
	}
	
	protected void NumChange(int n){
		num = n;
	};
}

class Deer extends Animal implements Runnable{
	int num;
	JPanel [] panel;
	public Deer(int select, int num) {
		super(select);
		this.num = num;
	}

	public void run() {
		panel = AnimalGui(num);
		while(true){
			try{
				if(Player.helper == 5){ //�罿 ����̸� �����Ͽ��� �� Ȯ��
					if(Player.helperevolution[1] == true) //2�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(150000);
					else if(Player.helperevolution[0] == true) //1�ܰ� ��ȭ �Ͽ����� Ȯ��
						Thread.sleep(225000);
					else //��ȭ ���� �ʾ��� ���
						Thread.sleep(270000);
				}
				else
					Thread.sleep(300000); //�λ깰 �������� �⺻ 5��
				
				if(false ==showbubbles(this, panel[1])){
					return;
				}
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
	
	protected void ReDraw(){
		if(Player.landsize == 1){
			panel[0].setBounds((num%5)*160+30, (num/5)*200+10, 120, 120);
			panel[1].setBounds(panel[0].getX()+70, panel[0].getY()-10, 60, 60);
		}
		if(Player.landsize == 2){
			panel[0].setBounds((num%9)*80+40, (num/9)*120+10, 80, 80);
			panel[1].setBounds(panel[0].getX()+40, panel[0].getY()-10, 40, 40);
		}
		else if(Player.landsize == 3){
			panel[0].setBounds((num%10)*80+10, (num/10)*90+10, 70, 70);
			panel[1].setBounds(panel[0].getX()+30, panel[0].getY()-10, 30, 30);
		}
	}
	
	protected void DelDraw(){
		panel[0].setVisible(false);
		panel[0].removeAll();
		panel[1].setVisible(false);
		panel[1].removeAll();
	}
	
	protected void NumChange(int n){
		num = n;
	};
	
}