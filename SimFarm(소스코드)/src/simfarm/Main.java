package simfarm;

import java.awt.EventQueue;

import javax.swing.JLabel;

import simfarmgui.CreditorDialog;
import simfarmgui.MenuScreen;
import simfarmgui.Sound;


public class Main extends Thread{
	JLabel lblMoney;
	JLabel lblTime;
	public Main(JLabel lblMoney, JLabel lblTime){
		this.lblMoney = lblMoney;
		this.lblTime = lblTime;
	}
	public void ChangeLabel(){
		lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
		lblTime.setText(Integer.toString(Player.playtime/360) + "년 " + Integer.toString((Player.playtime%360)/30) 
						+ "월 " + Integer.toString((Player.playtime%360)%30) + "일");
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuScreen frame = new MenuScreen();
					frame.setVisible(true);
					new Sound("sound/menu.wav",true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void run(){
		while(true){
			try{
				if(Player.playtime == 360){ //1년이 되었는지 확인
					if(Player.money >= Player.debt){ //가진돈이 남은 빚보다 많으면 해피엔딩
						Player.debt = 0;
						new CreditorDialog(true, Player.debt);
					}
					else ////가진돈이 남은 빚보다 많으면 해피엔딩
						new CreditorDialog(false, Player.debt);
				}
				else if(Player.playtime%30 == 0){ //1달이 지낫는지 확인 
					if(Player.money >= 800000){ //가진돈이 한달 납부금액인 800000보다 많으면 게임 계속진행
						Player.money -= 800000;
						Player.debt -= 800000;
						new CreditorDialog(true, 800000);
						ChangeLabel();
					}
					else //부족하면 배드엔딩
						new CreditorDialog(false, 800000);
				}
				
				Thread.sleep(20000); //20초당 하루
				Player.playtime++;
			}
			catch(InterruptedException e){
				return;
			}
			ChangeLabel();
		}
	}
}
