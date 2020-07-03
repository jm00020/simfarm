package simfarm;

public class Inventory {
	static public int [] animalNum = {0,0,0,0,0,0}; //보유 동물의 수 {전체, 닭, 돼지, 양, 소, 사슴}
	static public int [] produceNum = {0,0,0,0,0,0}; //보유 작물의 수 {전체, 감자, 당근, 오이, 토마토, 호박}
	static public boolean [] evolutionstone = {false, false}; //진화석 보유 유무
	static public int [] animade = {0, 0, 0, 0, 0}; //동물 생산품 수
	static public int [] promade = {0, 0, 0, 0, 0}; //식물 생산품 수
}
