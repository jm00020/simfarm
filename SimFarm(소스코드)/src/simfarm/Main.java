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
		lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
		lblTime.setText(Integer.toString(Player.playtime/360) + "�� " + Integer.toString((Player.playtime%360)/30) 
						+ "�� " + Integer.toString((Player.playtime%360)%30) + "��");
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
				if(Player.playtime == 360){ //1���� �Ǿ����� Ȯ��
					if(Player.money >= Player.debt){ //�������� ���� ������ ������ ���ǿ���
						Player.debt = 0;
						new CreditorDialog(true, Player.debt);
					}
					else ////�������� ���� ������ ������ ���ǿ���
						new CreditorDialog(false, Player.debt);
				}
				else if(Player.playtime%30 == 0){ //1���� �������� Ȯ�� 
					if(Player.money >= 800000){ //�������� �Ѵ� ���αݾ��� 800000���� ������ ���� �������
						Player.money -= 800000;
						Player.debt -= 800000;
						new CreditorDialog(true, 800000);
						ChangeLabel();
					}
					else //�����ϸ� ��忣��
						new CreditorDialog(false, 800000);
				}
				
				Thread.sleep(20000); //20�ʴ� �Ϸ�
				Player.playtime++;
			}
			catch(InterruptedException e){
				return;
			}
			ChangeLabel();
		}
	}
}
