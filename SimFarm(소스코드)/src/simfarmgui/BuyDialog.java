package simfarmgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simfarm.Farm;
import simfarm.Field;
import simfarm.Inventory;
import simfarm.Player;
import simfarm.Store;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class BuyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lblMoney;
	JLabel changenum;
	public BuyDialog(String str, JLabel Money, JLabel lblnum) {
		lblMoney = Money;
		changenum = lblnum;
		setBounds(250, 250, 382, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Store store = new Store();
		
		if(str.equals("1�ܰ� ��ȭ��") || str.equals("2�ܰ� ��ȭ��") || str.equals("���") || str.equals("��Ȯ��")){
			JLabel lblNewLabel = new JLabel("�����Ͻðڽ��ϱ�?");
			lblNewLabel.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 82, 366, 29);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel(str);
			lblNewLabel_1.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 31, 366, 29);
			contentPanel.add(lblNewLabel_1);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("\uD655\uC778");
					okButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							switch(str){
							case "1�ܰ� ��ȭ��":
								if(Player.money < store.BuygetPrice("etc", 0)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Inventory.evolutionstone[0] == true){
									JOptionPane.showMessageDialog(null, "�̹� ������ ��ʴϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyEtcSelet(1);
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "2�ܰ� ��ȭ��":
								if(Player.money < store.BuygetPrice("etc", 1)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Inventory.evolutionstone[1] == true){
									JOptionPane.showMessageDialog(null, "�̹� ������ ��ʴϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyEtcSelet(2);
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "���":
								if(Player.money < store.BuygetPrice("etc", 2)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyEtcSelet(3);
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "��Ȯ��":
								if(Player.landsize == 1){
									if(Player.money < store.BuygetPrice("land", 0)){
										JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
										break;
									}
								}
								else if(Player.landsize == 2){
									if(Player.money < store.BuygetPrice("land", 0)){
										JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
										break;
									}
								}
								else if(Player.landsize == 3){
									JOptionPane.showMessageDialog(null, "�ִ�� Ȯ�� �Ͽ����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyEtcSelet(4);
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							}
							dispose();
						}
					});
					okButton.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 20));
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("\uCDE8\uC18C");
					cancelButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							dispose();
						}
					});
					cancelButton.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 20));
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
		else{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(194, 31, 52, 29);
			contentPanel.add(spinner);
			
			JLabel lblNewLabel = new JLabel("�����Ͻðڽ��ϱ�?");
			lblNewLabel.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 82, 366, 29);
			contentPanel.add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel(str);
			lblNewLabel_1.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(62, 31, 130, 29);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("��");
			lblNewLabel_2.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 30));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(244, 31, 30, 29);
			contentPanel.add(lblNewLabel_2);
			
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("\uD655\uC778");
					okButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							switch(str){
							case "��":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("animal", 0)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Farm.maxNum[Player.landsize-1] < Inventory.animalNum[0]+(int)spinner.getValue()){
									JOptionPane.showMessageDialog(null, "������ ���ڸ��� �����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyAnimalSelet(1, (int)spinner.getValue());
								changenum.setText("�� " + Integer.toString(Inventory.animalNum[1]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "����":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("animal", 1)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Farm.maxNum[Player.landsize-1] < Inventory.animalNum[0]+(int)spinner.getValue()){
									JOptionPane.showMessageDialog(null, "������ ���ڸ��� �����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyAnimalSelet(2, (int)spinner.getValue());
								changenum.setText("���� " + Integer.toString(Inventory.animalNum[2]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "��":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("animal", 2)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Farm.maxNum[Player.landsize-1] < Inventory.animalNum[0]+(int)spinner.getValue()){
									JOptionPane.showMessageDialog(null, "������ ���ڸ��� �����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyAnimalSelet(3, (int)spinner.getValue());
								changenum.setText("�� " + Integer.toString(Inventory.animalNum[3]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "��":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("animal", 3)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Farm.maxNum[Player.landsize-1] < Inventory.animalNum[0]+(int)spinner.getValue()){
									JOptionPane.showMessageDialog(null, "������ ���ڸ��� �����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyAnimalSelet(4, (int)spinner.getValue());
								changenum.setText("�� " + Integer.toString(Inventory.animalNum[4]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "�罿":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("animal", 4)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								if(Farm.maxNum[Player.landsize-1] < Inventory.animalNum[0]+(int)spinner.getValue()){
									JOptionPane.showMessageDialog(null, "������ ���ڸ��� �����ϴ�.", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyAnimalSelet(5, (int)spinner.getValue());
								changenum.setText("�罿 " + Integer.toString(Inventory.animalNum[5]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "����":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("produce", 0)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyProduceSelet(1, (int)spinner.getValue());
								changenum.setText("���ھ��� " + Integer.toString(Inventory.produceNum[1]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "���":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("produce", 1)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyProduceSelet(2, (int)spinner.getValue());
								changenum.setText("��پ��� " + Integer.toString(Inventory.produceNum[2]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "����":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("produce", 2)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyProduceSelet(3, (int)spinner.getValue());
								changenum.setText("���̾��� " + Integer.toString(Inventory.produceNum[3]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "�丶��":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("produce", 3)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyProduceSelet(4, (int)spinner.getValue());
								changenum.setText("�丶�侾�� " + Integer.toString(Inventory.produceNum[4]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							case "ȣ��":
								if(Player.money < (int)spinner.getValue()*store.BuygetPrice("produce", 4)){
									JOptionPane.showMessageDialog(null, "���� �����մϴ�", "���źҰ�", JOptionPane.ERROR_MESSAGE); 
									break;
								}
								store.BuyProduceSelet(5, (int)spinner.getValue());
								changenum.setText("ȣ�ھ��� " + Integer.toString(Inventory.produceNum[5]));
								lblMoney.setText("���� �ݾ� : " + Integer.toString(Player.money));
								break;
							}
							dispose();
						}
					});
					okButton.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 20));
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("\uCDE8\uC18C");
					cancelButton.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							dispose();
						}
					});
					cancelButton.setFont(new Font("210 ī�����丮 R", Font.PLAIN, 20));
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
		setVisible(true);
	}
}
