package simfarm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import simfarmgui.FieldDialog;
import simfarmgui.MainScreen;

public class Field {
	public static final int [] fieldNum = {9, 16, 25};
	public static JPanel [] field = new JPanel[fieldNum[Player.landsize-1]];
	static Thread[] produce = new Thread [fieldNum[Player.landsize-1]];
	public static Produce [] currentpro = new Produce[fieldNum[Player.landsize-1]];
	
	public void ChangeNum(){
		if(Player.landsize == 2){
			Thread [] thchange = produce;
			JPanel [] change = field;
			Produce [] prochange = currentpro;
			currentpro = new Produce[fieldNum[1]];
			field = new JPanel[fieldNum[1]];
			produce = new Thread[fieldNum[1]];
			for(int i = 0; i< fieldNum[0]; i++){
				field[i] = change[i];
				produce[i] = thchange[i];
				currentpro[i] = prochange[i];
			}
			ReDraw();
		}
		else if(Player.landsize == 3){
			Produce [] prochange = currentpro;
			Thread [] thchange = produce;
			JPanel [] change = field;
			currentpro = new Produce[fieldNum[2]];
			produce = new Thread[fieldNum[2]];
			field = new JPanel[fieldNum[2]];
			for(int i = 0; i< fieldNum[1]; i++){
				field[i] = change[i];
				produce[i] = thchange[i];
				currentpro[i] = prochange[i];
			}
			ReDraw();
		}
	}
	
	public void ReDraw(){
		if(Player.landsize == 2){
			MouseAdapter l;
			for(int i = 0; i < fieldNum[Player.landsize-1]; i++){
				if(i > fieldNum[Player.landsize-2]-1 ){
					int position = i;
					field[i] = new JPanel(){
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
					field[i].addMouseListener(l);
					currentpro[i] = new Produce(field[i], l);
				}
				field[i].setBounds(192 * (i%4) + 27,111 * (i/4) + 8, 170, 102);
				field[i].setLayout(null);
				currentpro[i].ReDraw(field[i]);
				MainScreen.fieldscreen.add(field[i]);
			}
		}
		else if(Player.landsize == 3){
			MouseAdapter l;
			for(int i = 0; i < fieldNum[Player.landsize-1]; i++){
				if(i > fieldNum[Player.landsize-2]-1){
					int position = i;
					field[i] = new JPanel(){
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
					field[i].addMouseListener(l);
					currentpro[i] = new Produce(field[i], l);
				}
				field[i].setBounds(155 * (i%5) + 22, 91 * (i/5) + 7, 135, 85);
				field[i].setLayout(null);
				currentpro[i].ReDraw(field[i]);
				MainScreen.fieldscreen.add(field[i]);
			}
		}
	}
	
	public void StartThread(int select, int position, JPanel panel, MouseAdapter l) {
		switch(select){
		case 1:
			Potato potato= new Potato(panel, l);
			produce[position] = new Thread(potato, "감자");
			produce[position].start();
			Inventory.produceNum[0]--;
			Inventory.produceNum[1]--;
			currentpro[position]  = potato;
			break;
		case 2:
			Carrot carrot = new Carrot(panel, l);
			produce[position] = new Thread(carrot, "당근");
			produce[position].start();
			Inventory.produceNum[0]--;
			Inventory.produceNum[2]--;
			currentpro[position] = carrot;
			break;
		case 3:
			Cucumber cucumber = new Cucumber(panel, l);
			produce[position] = new Thread(cucumber, "오이");
			produce[position].start();
			Inventory.produceNum[0]--;
			Inventory.produceNum[3]--;
			currentpro[position] = cucumber;
			break;
		case 4:
			Tomato tomato = new Tomato(panel, l);
			produce[position] = new Thread(tomato, "토마토");
			produce[position].start();
			Inventory.produceNum[0]--;
			Inventory.produceNum[4]--;
			currentpro[position] = tomato;
			break;
		case 5:
			Pumpkin pumpkin = new Pumpkin(panel, l);
			produce[position] = new Thread(pumpkin, "호박");
			produce[position].start();
			Inventory.produceNum[0]--;
			Inventory.produceNum[5]--;
			currentpro[position] = pumpkin;
			break;
		}
	}

	
}
