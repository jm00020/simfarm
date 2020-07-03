package simfarm;

import simfarmgui.MainScreen;

public class Player {
	static public int playtime = 1; //�÷��� �ð�
	static public int helper = 0; //����� ��ȣ
	static public int landsize = 1; //���� ũ�� (1�ܰ� ��9��, ���� 10����/2�ܰ� �� 16�� ���� 25����/3�ܰ� �� 25�� ���� 50����)
	static public int money = 400000; //���� ��� �ʱ��ڱ� ����
	static public int debt  = 10000000; //���� �� �ʱ� �� õ����
	static public boolean [] helperevolution = {false, false}; //����� ��ȭ�� �ߴ��� ����
	static public boolean [] tool = {false, false, false, false, false}; //����� ����(����, ����, ����, ��, ����)
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
		playtime = 1; //�÷��� �ð�
		helper = 0; //����� ��ȣ
		landsize = 1; //���� ũ�� (1�ܰ� ��9��, ���� 10����/2�ܰ� �� 16�� ���� 25����/3�ܰ� �� 25�� ���� 50����)
		money = 300000; //���� ��� �ʱ��ڱ� ����
		debt  = 10000000; //���� �� �ʱ� �� õ����
		for(int i = 0; i < 6; i++){
			Inventory.animalNum[i] = 0; 
			Inventory.produceNum[i] = 0; 
		}
		for(int i = 0; i < 5; i++)
			Player.tool[i] = false;
		for(int i = 0; i < 2; i++){
			Inventory.evolutionstone[i] = false; //��ȭ�� ���� ����
			helperevolution[i]= false; //����� ��ȭ�� �ߴ��� ����
		}
	}
}
