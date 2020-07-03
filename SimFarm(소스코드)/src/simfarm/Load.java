package simfarm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Load {	
	public Load(){
		try {
			FileReader in = new FileReader("save/save.txt");
			char [] c = new char [1024];
			String [] s = new String [36];
			int n = in.read(c);
			int j = 0;
			for(int i = 0; i < s.length; i++){
				while(j < n){
					if(c[j] == '\n'){
						j++;
						break;
					}
					if(s[i] == null){
						s[i] = Character.toString(c[j]);
					}
					else{
						s[i] += c[j];
					}
					j++;
				}
			}
			in.close();
			Player player = new Player();
			for(int i = 0; i <player.loadintdata.length; i++){
				player.loadintdata[i] = Integer.parseInt(s[i]);
			}
			for(int i = 0; i<player.loadbooleandata.length; i++){
				player.loadbooleandata[i] = Boolean.parseBoolean(s[i+player.loadintdata.length-1]);
			}
			player.LoadData();
			player.RestartThread();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
