package simfarm;

import javax.swing.JOptionPane;

public class Store {
	private final int [] animalPrice = {1000, 2500, 5000, 7500, 10000}; //동물 가격
	private final int [] animalSellPrice = {700, 2000, 4000, 6000, 8000}; //동물 판매 가격
	private final int [] animalMadePrice = {500, 1000, 2500, 5000, 7500}; //동물 생산품 판매 가격
	private final int [] producePrice = {1000, 2500, 5000, 7500, 10000}; //작물 가격
	private final int [] produceSellPrice = {700, 2000, 4000, 6000, 8000}; //작물 판매가격
	private final int [] produceMadePrice = {500, 1000, 2500, 5000, 7500}; //작물 생산품 판매 가격
	private final int [] etcPrice = {25000, 50000, 50000};
	private final int [] landPrice = {100000, 200000};
	Farm farm = new Farm();
	Field field = new Field();
	
	public void BuyAnimalSelet(int select, int num){
		for(int i = 0; i < num; i++){
			farm.StartThread(select);
		}
		Inventory.animalNum[select] += num;
		Player.money -= animalPrice[select-1]*num;
	}
	
	public void BuyProduceSelet(int select, int num){
		Inventory.produceNum[select] += num;
		Inventory.produceNum[0] += num;
		Player.money -= producePrice[select-1]*num;
	}
	
	public void BuyEtcSelet(int selet){
		switch(selet){
		case 1:
			Inventory.evolutionstone[0] = true;
			Player.money -= etcPrice[0];
			break;
		case 2:
			Inventory.evolutionstone[1] = true;
			Player.money -= etcPrice[1];
			break;
		case 3:
			Randomtool();
			Player.money -= etcPrice[2];
			break;
		case 4:
			if(Player.landsize == 1){
				Player.landsize = 2;
				field.ChangeNum();
				farm.ChangeNum();
				Player.money -= landPrice[0];
			}
			else if(Player.landsize == 2){
				Player.landsize = 3;
				field.ChangeNum();
				farm.ChangeNum();
				Player.money -= landPrice[1];
			}
			break;
		}
	}
	
	public int BuygetPrice(String str, int i){
		switch(str){
		case "animal":
			return animalPrice[i];
		case "produce":
			return producePrice[i];
		case "etc":
			return etcPrice[i];
		case "land":
			return landPrice[i];
		default:
			return 0;	
		}
			
	}

	public void SellAnimalSelet(int select, int num){
		switch (select){
		case 1:
			for(int i = 0; i < num; ){
				if(Farm.animal[i].getName().equals("닭")){
					Farm.currentani[i].DelDraw();
					Farm.animal[i].interrupt();
					for(int j = i; j < Inventory.animalNum[0]-1; j++){
						Farm.currentani[j] = Farm.currentani[j+1];
						Farm.currentani[j+1].NumChange(j);
						Farm.animal[j] = Farm.animal[j+1];
					}
					Inventory.animalNum[0]--;
					Farm.animal[Inventory.animalNum[0]] = new Thread();
					Farm.currentani[Inventory.animalNum[0]] = null;
					i++;
				}	
			}
			for(int i = 0; i < Inventory.animalNum[0]; i++)
				Farm.currentani[i].ReDraw();

			Inventory.animalNum[select] -= num;
			Player.money += animalSellPrice[select-1]*num;
			break;
		case 2:
			for(int i = 0; i < num; ){
				if(Farm.animal[i].getName().equals("돼지")){
					Farm.currentani[i].DelDraw();
					Farm.animal[i].interrupt();
					for(int j = i; j < Inventory.animalNum[0]-1; j++){
						Farm.currentani[j] = Farm.currentani[j+1];
						Farm.currentani[j+1].NumChange(j);
						Farm.animal[j] = Farm.animal[j+1];
					}
					Inventory.animalNum[0]--;
					Farm.animal[Inventory.animalNum[0]] = new Thread();
					Farm.currentani[Inventory.animalNum[0]] = null;
					i++;
				}	
			}
			for(int i = 0; i < Inventory.animalNum[0]; i++)
				Farm.currentani[i].ReDraw();

			Inventory.animalNum[select] -= num;
			Player.money += animalSellPrice[select-1]*num;
			break;
		case 3:
			for(int i = 0; i < num; ){
				if(Farm.animal[i].getName().equals("닭")){
					Farm.currentani[i].DelDraw();
					Farm.animal[i].interrupt();
					for(int j = i; j < Inventory.animalNum[0]-1; j++){
						Farm.currentani[j] = Farm.currentani[j+1];
						Farm.currentani[j+1].NumChange(j);
						Farm.animal[j] = Farm.animal[j+1];
					}
					Inventory.animalNum[0]--;
					Farm.animal[Inventory.animalNum[0]] = new Thread();
					Farm.currentani[Inventory.animalNum[0]] = null;
					i++;
				}	
			}
			for(int i = 0; i < Inventory.animalNum[0]; i++)
				Farm.currentani[i].ReDraw();

			Inventory.animalNum[select] -= num;
			Player.money += animalSellPrice[select-1]*num;
			break;
		case 4:
			for(int i = 0; i < num; ){
				if(Farm.animal[i].getName().equals("닭")){
					Farm.currentani[i].DelDraw();
					Farm.animal[i].interrupt();
					for(int j = i; j < Inventory.animalNum[0]-1; j++){
						Farm.currentani[j] = Farm.currentani[j+1];
						Farm.currentani[j+1].NumChange(j);
						Farm.animal[j] = Farm.animal[j+1];
					}
					Inventory.animalNum[0]--;
					Farm.animal[Inventory.animalNum[0]] = new Thread();
					Farm.currentani[Inventory.animalNum[0]] = null;
					i++;
				}	
			}
			for(int i = 0; i < Inventory.animalNum[0]; i++)
				Farm.currentani[i].ReDraw();

			Inventory.animalNum[select] -= num;
			Player.money += animalSellPrice[select-1]*num;
			break;
		case 5:
			for(int i = 0; i < num; ){
				if(Farm.animal[i].getName().equals("닭")){
					Farm.currentani[i].DelDraw();
					Farm.animal[i].interrupt();
					for(int j = i; j < Inventory.animalNum[0]-1; j++){
						Farm.currentani[j] = Farm.currentani[j+1];
						Farm.currentani[j+1].NumChange(j);
						Farm.animal[j] = Farm.animal[j+1];
					}
					Inventory.animalNum[0]--;
					Farm.animal[Inventory.animalNum[0]] = new Thread();
					Farm.currentani[Inventory.animalNum[0]] = null;
					i++;
				}	
			}
			for(int i = 0; i < Inventory.animalNum[0]; i++)
				Farm.currentani[i].ReDraw();

			Inventory.animalNum[select] -= num;
			Player.money += animalSellPrice[select-1]*num;
			break;
		}
	}

	public void SellAniMade(int select, int num){
		Inventory.animade[select] -= num;
		Player.money += animalMadePrice[select]*num;
	}
	
	public void SellProduceSelet(int select, int num){
		Inventory.produceNum[select] -= num;
		Inventory.produceNum[0] -= num;
		Player.money += produceSellPrice[select-1]*num;
	}
	
	public void SellProMade(int select, int num){
		Inventory.promade[select] -= num;
		Player.money += produceMadePrice[select]*num;
	}
	
	public void Randomtool(){
		int random = (int)(Math.random()*5);
		if(Player.tool[random] == true){
			switch(random){
			case 0:
				JOptionPane.showMessageDialog(null, "안타깝네요.\n 또 모자가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "안타깝네요.\n 또 상의가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "안타깝네요.\n 또 하의가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "안타깝네요.\n 또 삽이 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "안타깝네요.\n 또 갈퀴가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
		else if(Player.tool[random] == false){
			switch(random){
			case 0:
				JOptionPane.showMessageDialog(null, "축하합니다.\n 모자가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "축하합니다.\n 상의가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "축하합니다.\n 하의가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "축하합니다.\n 삽이 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "축하합니다.\n 갈퀴가 나왔어요.", null, JOptionPane.WARNING_MESSAGE);
				break;
			}
			Player.tool[random] = true;
		}
	}
	
}
