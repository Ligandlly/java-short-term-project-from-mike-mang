package gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Message.Message;
import UserModel.UserModel;
import client.TheClient;
import gui.colors.PrimaryColor;
import user.User;

import java.awt.BorderLayout;
import java.awt.Component;

public class ChangeInfoForAdmin extends JFrame {
	private JTextField textField;
	private UserModel userModel;
	private JFrame frame;
	private JTextField nameField;
	private JTextField collegeField;
	private JTextField sexField;
	private JTextField mailField;
	private JComboBox comboBox;
	private JTextField identityField;

	public ChangeInfoForAdmin() {
		frame = this;
		setSize(new Dimension(700, 433));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);

		JButton searchButton = new JButton("查询");
		panel_1.add(searchButton);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton confirmButton = new JButton("确认修改");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		panel.add(confirmButton);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(433, 10));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(29, 68, 38, 18);
		lblNewLabel.setBackground(new PrimaryColor());
		panel_2.add(lblNewLabel);

		nameField = new JTextField();
		nameField.setBounds(77, 68, 186, 21);
		panel_2.add(nameField);
		nameField.setColumns(30);

		JLabel lblNewLabel_1 = new JLabel("学院");
		lblNewLabel_1.setBounds(323, 69, 35, 18);
		panel_2.add(lblNewLabel_1);

		collegeField = new JTextField();
		collegeField.setBounds(374, 66, 186, 21);
		collegeField.setColumns(30);
		panel_2.add(collegeField);

		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(24, 155, 29, 21);
		panel_2.add(lblNewLabel_2);

		sexField = new JTextField();
		sexField.setBounds(77, 155, 186, 21);
		sexField.setColumns(30);
		panel_2.add(sexField);

		JLabel lblNewLabel_2_1 = new JLabel("邮箱");
		lblNewLabel_2_1.setBounds(334, 156, 35, 18);
		panel_2.add(lblNewLabel_2_1);

		mailField = new JTextField();
		mailField.setBounds(374, 153, 186, 21);
		mailField.setColumns(30);
		panel_2.add(mailField);
		

		JLabel lblNewLabel_2_2 = new JLabel("身份");
		lblNewLabel_2_2.setBounds(34, 241, 41, 18);
		panel_2.add(lblNewLabel_2_2);
		
		identityField = new JTextField();
		identityField.setColumns(30);
		identityField.setBounds(77, 240, 186, 21);
		panel_2.add(identityField);

		// ----------------------
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				receiveMessge();
			
				nameField.setText(userModel.getUser_Name());
				collegeField.setText(userModel.getCollege());
				sexField.setText(userModel.getSex());
				identityField.setText(userModel.getIdentity());
				mailField.setText(userModel.getEmail());
				// birthField.setText(user);
				
				frame.repaint();
			}

		});
	}
	public ChangeInfoForAdmin(User user) {
		frame = this;
		setSize(new Dimension(700, 433));
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);

		JButton searchButton = new JButton("查询");
		panel_1.add(searchButton);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton confirmButton = new JButton("确认修改");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		panel.add(confirmButton);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(433, 10));
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(29, 68, 38, 18);
		lblNewLabel.setBackground(new PrimaryColor());
		panel_2.add(lblNewLabel);

		nameField = new JTextField();
		nameField.setBounds(77, 68, 186, 21);
		panel_2.add(nameField);
		nameField.setColumns(30);

		JLabel lblNewLabel_1 = new JLabel("学院");
		lblNewLabel_1.setBounds(323, 69, 35, 18);
		panel_2.add(lblNewLabel_1);

		collegeField = new JTextField();
		collegeField.setBounds(374, 66, 186, 21);
		collegeField.setColumns(30);
		panel_2.add(collegeField);

		JLabel lblNewLabel_2 = new JLabel("性别");
		lblNewLabel_2.setBounds(24, 155, 29, 21);
		panel_2.add(lblNewLabel_2);

		sexField = new JTextField();
		sexField.setBounds(77, 155, 186, 21);
		sexField.setColumns(30);
		panel_2.add(sexField);

		JLabel lblNewLabel_2_1 = new JLabel("邮箱");
		lblNewLabel_2_1.setBounds(334, 156, 35, 18);
		panel_2.add(lblNewLabel_2_1);

		mailField = new JTextField();
		mailField.setBounds(374, 153, 186, 21);
		mailField.setColumns(30);
		panel_2.add(mailField);
		

		JLabel lblNewLabel_2_2 = new JLabel("身份");
		lblNewLabel_2_2.setBounds(34, 241, 41, 18);
		panel_2.add(lblNewLabel_2_2);
		
		identityField = new JTextField();
		identityField.setColumns(30);
		identityField.setBounds(77, 240, 186, 21);
		panel_2.add(identityField);

		// ----------------------
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				receiveMessge();
			
				nameField.setText(userModel.getUser_Name());
				collegeField.setText(userModel.getCollege());
				sexField.setText(userModel.getSex());
				identityField.setText(userModel.getIdentity());
				mailField.setText(userModel.getEmail());
				// birthField.setText(user);
				
				frame.repaint();
			}

		});
	}

	private void receiveMessge() {
		final TheClient client = new client.TheClient();
		final UserModel userModelToSent = new UserModel();
		userModelToSent.setCard(textField.getText());
		final Message messageToSend = new Message("SEARCH_INFO", userModelToSent);
		messageToSend.setCheckCode(1);
		Message message;

		try {
			message = client.sendAndReceive(messageToSend);
			// message = client.test(messageToSend);
			userModel = (UserModel) message.getAllembracing();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		final UserModel userModelCopy = new UserModel();
		userModelCopy.setCard(userModel.getCard());
		userModelCopy.setUser_Name(nameField.getText());
		userModelCopy.setEmail(mailField.getText());
		userModelCopy.setCollege(collegeField.getText());
		userModelCopy.setPassword(userModel.getPassword());
		userModelCopy.setIdentity(identityField.getText());
		userModelCopy.setSex(sexField.getText());
		// userModelCopy.setStatus((String) );

		final Message tmpMessage = new Message("UPDATE_INFO", userModelCopy);
		tmpMessage.setCheckCode(1);
		final TheClient tmpClient = new TheClient();
		Message messageReceived = null;
		try {
			messageReceived = tmpClient.sendAndReceive(tmpMessage);
			if (messageReceived.isResponse()) {
				JOptionPane.showMessageDialog(this, "修改成功");
				userModel.setUser_Name(userModelCopy.getUser_Name());
				userModel.setEmail(userModelCopy.getEmail());
				userModel.setPassword(userModelCopy.getPassword());
			} else {
				JOptionPane.showMessageDialog(null, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
}
