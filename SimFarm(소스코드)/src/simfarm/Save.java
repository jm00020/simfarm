package simfarm;

import java.io.FileWriter;
import java.io.IOException;

public class Save {
	public Save(){
		try {
			FileWriter fout = new FileWriter("save/save.txt");
			String s;
			s = Integer.toString(Player.playtime);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Player.helper);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Player.landsize);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Player.money);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Player.debt);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[0]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[1]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[2]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[3]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[4]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animalNum[5]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[0]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[1]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[2]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[3]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[4]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.produceNum[5]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animade[0]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animade[1]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animade[2]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animade[3]);;
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.animade[4]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.promade[0]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.promade[1]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.promade[2]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.promade[3]);
			fout.write(s);
			fout.write("\n");
			s = Integer.toString(Inventory.promade[4]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.helperevolution[0]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.helperevolution[1]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.tool[0]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.tool[1]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.tool[2]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.tool[3]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Player.tool[4]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Inventory.evolutionstone[0]);
			fout.write(s);
			fout.write("\n");
			s = Boolean.toString(Inventory.evolutionstone[1]);
			fout.write(s);
			fout.write("\n");
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
