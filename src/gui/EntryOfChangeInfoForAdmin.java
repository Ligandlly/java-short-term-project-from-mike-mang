package gui;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import gui.colors.PrimaryColor;

public class EntryOfChangeInfoForAdmin extends JFrame {
	private JTextField textField;
	public EntryOfChangeInfoForAdmin() {
		setSize(new Dimension(700, 433));
		getContentPane().setLayout(null);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(null);
		cardPanel.setBackground(Color.WHITE);
		cardPanel.setBounds(173, 123, 354, 21);
		getContentPane().add(cardPanel);
		
		JLabel cardLabel = new JLabel("一卡通", SwingConstants.CENTER);
		cardLabel.setOpaque(true);
		cardLabel.setForeground(Color.WHITE);
		cardLabel.setBackground(new Color(64, 116, 52));
		cardLabel.setBounds(0, 0, 66, 21);
		cardPanel.add(cardLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setColumns(20);
		textField.setBorder(new LineBorder(new PrimaryColor()));
		textField.setBounds(65, 0, 290, 21);
		cardPanel.add(textField);
		
		JButton nameButton = new JButton("修改");
		nameButton.setOpaque(true);
		nameButton.setForeground(new Color(64, 116, 52));
		nameButton.setBorder(new LineBorder(new PrimaryColor()));
		nameButton.setBackground(Color.WHITE);
		nameButton.setActionCommand("");
		nameButton.setBounds(315, 267, 70, 21);
		getContentPane().add(nameButton);
	}
}
