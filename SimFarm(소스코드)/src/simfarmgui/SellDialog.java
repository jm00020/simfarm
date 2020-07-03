package simfarmgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import simfarm.Farm;
import simfarm.Inventory;
import simfarm.Player;
import simfarm.Store;

public class SellDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lblMoney;
	JLabel changenum;
	public SellDialog(String str, JLabel Money, JLabel lblnum) {
		lblMoney = Money;
		changenum = lblnum;
		setBounds(250, 250, 382, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Store store = new Store();
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setBounds(194, 31, 52, 29);
			contentPanel.add(spinner);
			
			JLabel lblNewLabel = new JLabel("판매하시겠습니까?");
			lblNewLabel.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 82, 366, 29);
			contentPanel.add(lblNewLabel);
		
			JLabel lblNewLabel_1 = new JLabel(str);
			lblNewLabel_1.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(62, 31, 130, 29);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("개");
			lblNewLabel_2.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 30));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(244, 31, 30, 29);
			contentPanel.add(lblNewLabel_2);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uD655\uC778");
				okButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						switch(str){
						case "닭":
							if(Inventory.animalNum[1] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "닭이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAnimalSelet(1, (int)spinner.getValue());
							changenum.setText("닭 " + Integer.toString(Inventory.animalNum[1]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "돼지":
							if(Inventory.animalNum[2] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "돼지가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAnimalSelet(2, (int)spinner.getValue());
							changenum.setText("돼지 " + Integer.toString(Inventory.animalNum[2]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "양":
							if(Inventory.animalNum[3] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "양이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAnimalSelet(3, (int)spinner.getValue());
							changenum.setText("양 " + Integer.toString(Inventory.animalNum[3]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "소":
							if(Inventory.animalNum[4] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "소가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAnimalSelet(4, (int)spinner.getValue());
							changenum.setText("소 " + Integer.toString(Inventory.animalNum[4]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "사슴":
							if(Inventory.animalNum[5] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "사슴이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAnimalSelet(5, (int)spinner.getValue());
							changenum.setText("사슴 " + Integer.toString(Inventory.animalNum[5]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "달걀":
							if(Inventory.animade[0] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "달걀이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(0, (int)spinner.getValue());
							changenum.setText("달걀 " + Integer.toString(Inventory.animade[1]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "고기":
							if(Inventory.animade[1] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "고기가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(1, (int)spinner.getValue());
							changenum.setText("고기 " + Integer.toString(Inventory.animade[1]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "양털":
							if(Inventory.animade[2] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "양털이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(2, (int)spinner.getValue());
							changenum.setText("양털 " + Integer.toString(Inventory.animade[2]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "우유":
							if(Inventory.animade[3] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "우유가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(3, (int)spinner.getValue());
							changenum.setText("양털 " + Integer.toString(Inventory.animade[3]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "녹용":
							if(Inventory.animade[4] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "녹용이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(4, (int)spinner.getValue());
							changenum.setText("녹용 " + Integer.toString(Inventory.animade[4]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "감자씨앗":
							if(Inventory.produceNum[1] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "감자씨앗이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellProduceSelet(1, (int)spinner.getValue());
							changenum.setText("감자씨앗 " + Integer.toString(Inventory.produceNum[1]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "당근씨앗":
							if(Inventory.produceNum[2] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "당근씨앗이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellProduceSelet(2, (int)spinner.getValue());
							changenum.setText("당근씨앗 " + Integer.toString(Inventory.produceNum[2]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "오이씨앗":
							if(Inventory.produceNum[3] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "오이씨앗이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellProduceSelet(3, (int)spinner.getValue());
							changenum.setText("오이씨앗 " + Integer.toString(Inventory.produceNum[3]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "토마토씨앗":
							if(Inventory.produceNum[4] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "토마토씨앗이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellProduceSelet(4, (int)spinner.getValue());
							changenum.setText("토마토씨앗 " + Integer.toString(Inventory.produceNum[4]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "호박씨앗":
							if(Inventory.produceNum[5] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "당근씨앗이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellProduceSelet(5, (int)spinner.getValue());
							changenum.setText("호박씨앗 " + Integer.toString(Inventory.produceNum[5]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "감자":
							if(Inventory.promade[0] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "감자가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(0, (int)spinner.getValue());
							changenum.setText("감자 " + Integer.toString(Inventory.animade[0]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "당근":
							if(Inventory.promade[1] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "당근이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(1, (int)spinner.getValue());
							changenum.setText("당근 " + Integer.toString(Inventory.animade[1]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "오이":
							if(Inventory.promade[2] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "오이가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(2, (int)spinner.getValue());
							changenum.setText("오이 " + Integer.toString(Inventory.animade[2]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "토마토":
							if(Inventory.promade[3] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "토마토가 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(3, (int)spinner.getValue());
							changenum.setText("토마토 " + Integer.toString(Inventory.animade[3]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						case "호박":
							if(Inventory.promade[4] < (int)spinner.getValue()){
								JOptionPane.showMessageDialog(null, "호박이 부족합니다", "판매불가", JOptionPane.ERROR_MESSAGE); 
								break;
							}
							store.SellAniMade(4, (int)spinner.getValue());
							changenum.setText("호박 " + Integer.toString(Inventory.animade[4]));
							lblMoney.setText("소유 금액 : " + Integer.toString(Player.money));
							break;
						}
						MainScreen.storescreen.repaint();
						dispose();
					}
				});
				okButton.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
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
				cancelButton.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
}
