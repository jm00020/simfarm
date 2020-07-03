package simfarmgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simfarm.Save;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaveDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public SaveDialog() {
		setBounds(300, 300, 350, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uC800\uC7A5\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
			lblNewLabel.setBounds(12, 25, 310, 57);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						new Save();
						JOptionPane.showMessageDialog(null, "데이터를 저장하였습니다.", "저장", JOptionPane.INFORMATION_MESSAGE); 
						dispose();
					}
				});
				okButton.setFont(new Font("210 카툰스토리 R", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
