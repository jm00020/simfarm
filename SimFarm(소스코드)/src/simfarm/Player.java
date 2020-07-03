package simfarm;

import simfarmgui.MainScreen;

public class Player {
	static public int playtime = 1; //플레이 시간
	static public int helper = 0; //도우미 번호
	static public int landsize = 1; //땅의 크기 (1단계 밭9개, 동물 10마리/2단계 밭 16개 동물 25마리/3단계 밭 25개 동물 50마리)
	static public int money = 400000; //보유 재산 초기자금 만원
	static public int debt  = 10000000; //가진 빚 초기 빚 천만원
	static public boolean [] helperevolution = {false, false}; //도우미 진화를 했는지 유무
	static public boolean [] tool = {false, false, false, false, false}; //장비보유 유무(모자, 셔츠, 바지, 삽, 갈퀴)
	int [] loadintdata = new int [27];
	boolean [] loadbooleandata = new boolean[9];
	
	public Player(){
	}
	public void LoadData(){
		playtime = loadintdata[0];
		helper = loadintdata[1];
		landsize = loadintdata[2];
		money = loadintdata[3];
		debt = loadintdata[4];
		Inventory.animalNum[0] = loadintdata[5];
		Inventory.animalNum[1] = loadintdata[6];
		Inventory.animalNum[2] = loadintdata[7];
		Inventory.animalNum[3] = loadintdata[8];
		Inventory.animalNum[4] = loadintdata[9];
		Inventory.animalNum[5] = loadintdata[10];
		Inventory.produceNum[0] = loadintdata[11];
		Inventory.produceNum[1] = loadintdata[12];
		Inventory.produceNum[2] = loadintdata[13];
		Inventory.produceNum[3] = loadintdata[14];
		Inventory.produceNum[4] = loadintdata[15];
		Inventory.produceNum[5] = loadintdata[16];
		Inventory.animade[0] = loadintdata[17];
		Inventory.animade[1] = loadintdata[18];
		Inventory.animade[2] = loadintdata[19];
		Inventory.animade[3] = loadintdata[20];
		Inventory.animade[4] = loadintdata[21];
		Inventory.promade[0] = loadintdata[22];
		Inventory.promade[1] = loadintdata[23];
		Inventory.promade[2] = loadintdata[24];
		Inventory.promade[3] = loadintdata[25];
		Inventory.promade[4] = loadintdata[26];
		helperevolution[0] = loadbooleandata[0];
		helperevolution[1] = loadbooleandata[1];
		tool[0] = loadbooleandata[2];
		tool[1] = loadbooleandata[3];
		tool[2] = loadbooleandata[4];
		tool[3] = loadbooleandata[5];
		tool[4] = loadbooleandata[6];
		Inventory.evolutionstone[0] = loadbooleandata[7];
		Inventory.evolutionstone[1] = loadbooleandata[8];
	}
	public void RestartThread(){
		Inventory.animalNum[0] = 0;
		Farm farm = new Farm();
		new MainScreen();
		for(int i = 0; i < Inventory.animalNum[1]; i++){
			farm.StartThread(1);
		}
		for(int i = 0; i < Inventory.animalNum[2]; i++){
			farm.StartThread(2);
		}
		for(int i = 0; i < Inventory.animalNum[3]; i++){
			farm.StartThread(3);
		}
		for(int i = 0; i < Inventory.animalNum[4]; i++){
			farm.StartThread(4);
		}
		for(int i = 0; i < Inventory.animalNum[5]; i++){
			farm.StartThread(5);
		}
	}
	static public void Initialization(){
		playtime = 1; //플레이 시간
		helper = 0; //도우미 번호
		landsize = 1; //땅의 크기 (1단계 밭9개, 동물 10마리/2단계 밭 16개 동물 25마리/3단계 밭 25개 동물 50마리)
		money = 300000; //보유 재산 초기자금 만원
		debt  = 10000000; //가진 빚 초기 빚 천만원
		for(int i = 0; i < 6; i++){
			Inventory.animalNum[i] = 0; 
			Inventory.produceNum[i] = 0; 
		}
		for(int i = 0; i < 5; i++)
			Player.tool[i] = false;
		for(int i = 0; i < 2; i++){
			Inventory.evolutionstone[i] = false; //진화석 보유 유무
			helperevolution[i]= false; //도우미 진화를 했는지 유무
		}
	}
}
