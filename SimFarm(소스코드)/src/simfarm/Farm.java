package simfarm;

public class Farm {
	static public int [] maxNum = {10, 25, 30};
	static public Thread [] animal = new Thread [maxNum[Player.landsize-1]];;
	static public Animal [] currentani  = new Animal [maxNum[Player.landsize-1]];
	Farm(){
	}
	
	public void StartThread(int select){
		switch(select){
		case 1:
			Chicken chicken = new Chicken(select, Inventory.animalNum[0]);
			animal[Inventory.animalNum[0]] = new Thread(chicken, "´ß");
			animal[Inventory.animalNum[0]].start();
			currentani[Inventory.animalNum[0]] = chicken;
			Inventory.animalNum[0]++;
			break;
		case 2:
			Pig pig = new Pig(select, Inventory.animalNum[0]);
			animal[Inventory.animalNum[0]] = new Thread(pig, "µÅÁö");
			animal[Inventory.animalNum[0]].start();
			currentani[Inventory.animalNum[0]] = pig;
			Inventory.animalNum[0]++;
			break;
		case 3:
			Sheep sheep = new Sheep(select, Inventory.animalNum[0]);
			animal[Inventory.animalNum[0]] = new Thread(sheep, "¾ç");
			animal[Inventory.animalNum[0]].start();
			currentani[Inventory.animalNum[0]] = sheep;
			Inventory.animalNum[0]++;
			break;
		case 4:
			Cow cow = new Cow(select, Inventory.animalNum[0]);
			animal[Inventory.animalNum[0]] = new Thread(cow, "¼Ò");
			animal[Inventory.animalNum[0]].start();
			currentani[Inventory.animalNum[0]] = cow;
			Inventory.animalNum[0]++;
			break;
		case 5:
			Deer deer = new Deer(select, Inventory.animalNum[0]);
			animal[Inventory.animalNum[0]] = new Thread(deer, "»ç½¿");
			animal[Inventory.animalNum[0]].start();
			currentani[Inventory.animalNum[0]] = deer;
			Inventory.animalNum[0]++;
			break;
		}
	}
	
	public void ChangeNum(){
		if(Player.landsize == 2){
			Thread [] change = animal;
			Animal [] anichage = currentani;
			animal = new Thread[maxNum[Player.landsize-1]];
			currentani = new Animal [maxNum[Player.landsize-1]];
			for(int i =0; i < maxNum[Player.landsize-1]; i++){
				for(; i < Inventory.animalNum[0] ; i++){
					animal[i] = change[i];
					currentani[i] = anichage[i];
					currentani[i].ReDraw();
				}
				animal[i] = new Thread();
			}
		}
		else if(Player.landsize == 3){
			Thread [] change = animal;
			Animal [] anichage = currentani;
			animal = new Thread[maxNum[Player.landsize-1]];
			currentani = new Animal [maxNum[Player.landsize-1]];
			for(int i =0; i < maxNum[Player.landsize-1]; i++){
				for(; i < Inventory.animalNum[0] ; i++){
					animal[i] = change[i];
					currentani[i] = anichage[i];
					currentani[i].ReDraw();
				}
				animal[i] = new Thread();
			}
		}
	}
	
	
}
