package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
// import java.util.Random;
import java.util.Map;

import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;

import gui.colors.*;
import Message.*;
import UserModel.*;
import client.TheClient;

// import client.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	static private Map<String, Integer> identityMap;
	static {
		identityMap = new HashMap<>();
		identityMap.put("学生", 1);
		identityMap.put("学籍管理", 2);
		identityMap.put("读者", 3);
		identityMap.put("图书管理员", 4);
		identityMap.put("教师", 5);
		identityMap.put("教务管理员", 6);
		identityMap.put("医生", 7);
		identityMap.put("医院管理员", 8);
		identityMap.put("管理员", 9);
		identityMap.put("商店管理员", 10);
	}

	private JFrame frame = this;
	private String card;
	private String password;

	void setCard(String s) {
		if (s.matches("\\d{9}")) {
			card = s;
		} else {
			JOptionPane.showMessageDialog(null, "用户名应为9位数字", "用户名错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	String getCard() {
		return card;
	}

	void setPassword(String s) {
		if (s.matches("\\w{4,10}")) {
			password = s;
		} else {
			JOptionPane.showMessageDialog(null, "密码格式不合法", "密码错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	String getPassword() {
		return password;
	}

	public Login() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ImageIcon imageIcon = new ImageIcon(("src/gui/icons/Marianne.png"));
		setIconImage(imageIcon.getImage());

		setTitle("\u767B\u5F55");
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(700, 433));
		setMinimumSize(new Dimension(700, 433));
		setMaximumSize(new Dimension(700, 433));
		getContentPane().setLayout(null);

		cardField = new JTextField();
		cardField.setBorder(new LineBorder(new Green()));
		cardField.setBounds(476, 86, 188, 21);
		getContentPane().add(cardField);
		cardField.setColumns(20);

		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Green()));
		passwordField.setBounds(476, 207, 188, 21);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);

		JLabel remand_label = new JLabel("一卡通号应为9位数字");
		remand_label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		remand_label.setForeground(Color.black);
		remand_label.setBounds(554, 67, 110, 16);
		remand_label.setVisible(false);

		// TODO TextFields Actions
		txtPassword = new JLabel("\u5BC6\u7801", JLabel.CENTER);
		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

				txtPassword.setBackground(new HighlightColor());
				passwordField.setBorder(new LineBorder(new HighlightColor()));
				// remand_label.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtPassword.setBackground(new Green());
				passwordField.setBorder(new LineBorder(new Green()));
			}

		});

		cardField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				cardField.setBorder(new LineBorder(new HighlightColor()));
				label.setBackground(new HighlightColor());

			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = cardField.getText();
				if (str.matches("\\d{9}")) {
					cardField.setBorder(new LineBorder(new Green()));
					label.setBackground(new Green());
					remand_label.setVisible(false);
				} else {
					label.setBackground(new HighlightColor());
					cardField.setBorder(new LineBorder(new HighlightColor()));
					remand_label.setVisible(true);
				}
			}

		});

		cardField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = cardField.getText();
				if (str.matches("\\d{9}")) {
					cardField.setBorder(new LineBorder(new Green()));
					label.setBackground(new Green());
					remand_label.setVisible(false);
				} else {
					label.setBackground(new HighlightColor());
					cardField.setBorder(new LineBorder(new HighlightColor()));
					remand_label.setVisible(true);
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String str = cardField.getText();
				if (str.matches("\\d{9}")) {
					cardField.setBorder(new LineBorder(new Green()));
					label.setBackground(new Green());
					remand_label.setVisible(false);
				} else {
					label.setBackground(new HighlightColor());
					cardField.setBorder(new LineBorder(new HighlightColor()));
					remand_label.setVisible(true);
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

		txtPassword.setOpaque(true);
		txtPassword.setBorder(null);
		txtPassword.setBackground(new Green());
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBounds(476, 186, 66, 21);
		getContentPane().add(txtPassword);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Green());
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setCard(cardField.getText());
				setPassword(passwordField.getText());
				System.out.println(card);
				System.out.println(password);

				Message message = new Message();
				message.setCheckCode(1);
				message.setType("LOGIN");
				UserModel userModelToSend = new UserModel();
				userModelToSend.setCard(card);
				userModelToSend.setPassword(password);
				message.setAllembracing(userModelToSend);

				client.TheClient client = new client.TheClient();

				Message received;
				try {
					received = client.sendAndReceive(message);
					System.out.println(received.isResponse());
					if (received.isResponse()) {
						// JOptionPane.showMessageDialog(null, "登陆成功", "成功",
						// JOptionPane.INFORMATION_MESSAGE);
						UserModel userModel = (UserModel) received.getAllembracing();
						System.out.println(userModel.getIdentity());
						MainGui mainGui = new MainGui(
								new MainGuiInfo(identityMap.get(userModel.getIdentity()).intValue(), userModel));
						mainGui.setVisible(true);
						frame.setVisible(false); // Hide Login window after login successfully
					} else {
						JOptionPane.showMessageDialog(null, "密码或用户名错误", "登陆失败", JOptionPane.ERROR_MESSAGE);
					}
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// System.out.println("von dem Server: "+client.response);

			}
		});

		btnNewButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new HighlightColor());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Green());

			}

		});

		btnNewButton.setBounds(594, 309, 70, 23);
		getContentPane().add(btnNewButton);

		label = new JLabel("\u4E00\u5361\u901A", JLabel.CENTER);
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setBackground(new Green());
		label.setBounds(476, 65, 66, 21);
		getContentPane().add(label);

		btnNewButton_1 = new JButton("忘记密码");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorder(new LineBorder(new Green()));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Green());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final TheClient client = new client.TheClient();
				UserModel userModel;
				final UserModel userModelToSent = new UserModel();
				userModelToSent.setCard(cardField.getText());
				final Message messageToSend = new Message("SEARCH_INFO", userModelToSent);
				messageToSend.setCheckCode(1);
				Message message;
				try {
					message = client.sendAndReceive(messageToSend);
					// message = client.test(messageToSend);
					userModel = (UserModel) message.getAllembracing();
					SendMail.sendMail(userModel.getEmail(), "您的密码是："+userModel.getPassword());
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(476, 308, 70, 23);
		// btnNewButton_1.setVisible(false);
		getContentPane().add(btnNewButton_1);

		lblNewLabel = new JLabel(new ImageIcon(Login.class.getResource("/gui/login.jpeg")));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(0, 0, 433, 433);
		getContentPane().add(lblNewLabel);
		// ImageIcon image = new
		// ImageIcon(Login.class.getResource("/gui/VarifyCode.jpg"));
		try {
			// System.out.println(VerifyCode.getCodeImg());
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		getContentPane().add(remand_label);
		setLocationRelativeTo(null);

	}

	static final long serialVersionUID = 1L;
	private JTextField cardField;
	private JTextField passwordField;
	private JLabel txtPassword;
	private JLabel label;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	// public void loginWindow() {
	// setSize(700, 433);
	// Box hBox = Box.createHorizontalBox();

	// JLabel imgLabel = new JLabel(new ImageIcon("GUI/login.jpeg"));
	// imgLabel.setSize(433, 433);
	// hBox.add(imgLabel);

	// getContentPane().add(hBox);
	// setVisible(true);
	// }

}