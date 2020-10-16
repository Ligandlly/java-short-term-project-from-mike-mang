// package com.ycz.iframe;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.IOException;
// import java.net.UnknownHostException;
// // import java.util.Random;

// import javax.swing.border.LineBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

// import com.ycz.model.*;
// import com.ycz.net.*;

// import Message.*;
// import UserModel.UserModel;

// // import client.*;
// import javax.swing.border.EmptyBorder;

// public class Login extends JFrame {

// 	private JFrame frame = this;
// 	private String card;
// 	private String password;

// 	void setCard(String s) {
// 		if (s.matches("\\d{9}")) {
// 			card = s;
// 		} else {
// 			JOptionPane.showMessageDialog(null, "用户名应为9位数字", "用户名错误", JOptionPane.ERROR_MESSAGE);
// 		}
// 	}

// 	String getCard() {
// 		return card;
// 	}

// 	void setPassword(String s) {
// 		if (s.matches("\\w{4,10}")) {
// 			password = s;
// 		} else {
// 			JOptionPane.showMessageDialog(null, "密码格式不合法", "密码错误", JOptionPane.ERROR_MESSAGE);
// 		}
// 	}

// 	String getPassword() {
// 		return password;
// 	}

// 	public Login() {
// 		setTitle("\u767B\u5F55");
// 		getContentPane().setBackground(Color.WHITE);
// 		setSize(new Dimension(700, 433));
// 		setMinimumSize(new Dimension(700, 433));
// 		setMaximumSize(new Dimension(700, 433));
// 		getContentPane().setLayout(null);

// 		cardField = new JTextField();
// 		cardField.setBorder(new LineBorder(new Green()));
// 		cardField.setBounds(476, 86, 188, 21);
// 		getContentPane().add(cardField);
// 		cardField.setColumns(20);

// 		passwordField = new JPasswordField();
// 		passwordField.setBorder(new LineBorder(new Green()));
// 		passwordField.setBounds(476, 165, 188, 21);
// 		getContentPane().add(passwordField);
// 		passwordField.setColumns(10);

// 		JLabel remand_label = new JLabel("一卡通号应为9位数字");
// 		remand_label.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
// 		remand_label.setForeground(new Brown());
// 		remand_label.setBounds(554, 67, 110, 16);
// 		remand_label.setVisible(false);

// 		// TODO TextFields Actions
// 		txtPassword = new JLabel("\u5BC6\u7801", JLabel.CENTER);
// 		passwordField.addFocusListener(new FocusListener() {

// 			@Override
// 			public void focusGained(FocusEvent e) {

// 				txtPassword.setBackground(new Yellow());
// 				passwordField.setBorder(new LineBorder(new Yellow()));
// 				// remand_label.setVisible(true);
// 			}

// 			@Override
// 			public void focusLost(FocusEvent e) {
// 				txtPassword.setBackground(new Green());
// 				passwordField.setBorder(new LineBorder(new Green()));
// 			}

// 		});

// 		cardField.addFocusListener(new FocusListener() {

// 			@Override
// 			public void focusGained(FocusEvent e) {
// 				cardField.setBorder(new LineBorder(new Yellow()));
// 				label.setBackground(new Yellow());

// 			}

// 			@Override
// 			public void focusLost(FocusEvent e) {
// 				String str = cardField.getText();
// 				if (str.matches("\\d{9}")) {
// 					cardField.setBorder(new LineBorder(new Green()));
// 					label.setBackground(new Green());
// 					remand_label.setVisible(false);
// 				} else {
// 					label.setBackground(new Yellow());
// 					cardField.setBorder(new LineBorder(new Yellow()));
// 					remand_label.setVisible(true);
// 				}
// 			}

// 		});

// 		cardField.getDocument().addDocumentListener(new DocumentListener() {

// 			@Override
// 			public void insertUpdate(DocumentEvent e) {
// 				String str = cardField.getText();
// 				if (str.matches("\\d{9}")) {
// 					cardField.setBorder(new LineBorder(new Green()));
// 					label.setBackground(new Green());
// 					remand_label.setVisible(false);
// 				} else {
// 					label.setBackground(new Yellow());
// 					cardField.setBorder(new LineBorder(new Yellow()));
// 					remand_label.setVisible(true);
// 				}

// 			}

// 			@Override
// 			public void removeUpdate(DocumentEvent e) {
// 				String str = cardField.getText();
// 				if (str.matches("\\d{9}")) {
// 					cardField.setBorder(new LineBorder(new Green()));
// 					label.setBackground(new Green());
// 					remand_label.setVisible(false);
// 				} else {
// 					label.setBackground(new Yellow());
// 					cardField.setBorder(new LineBorder(new Yellow()));
// 					remand_label.setVisible(true);
// 				}

// 			}

// 			@Override
// 			public void changedUpdate(DocumentEvent e) {

// 			}

// 		});

// 		txtPassword.setOpaque(true);
// 		txtPassword.setBorder(null);
// 		txtPassword.setBackground(new Green());
// 		txtPassword.setForeground(Color.WHITE);
// 		txtPassword.setBounds(476, 144, 66, 21);
// 		getContentPane().add(txtPassword);

// 		JButton btnNewButton = new JButton("\u767B\u5F55");
// 		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		btnNewButton.setOpaque(true);
// 		btnNewButton.setBorderPainted(false);
// 		btnNewButton.setBackground(new Green());
// 		btnNewButton.setForeground(Color.WHITE);
// 		btnNewButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent arg0) {
// 				// TODO: Insert login operations here
// 				setCard(cardField.getText());
// 				setPassword(passwordField.getText());
// 				System.out.println(card);
// 				System.out.println(password);

// 				Message message = new Message();
// 				UserModel userModel = new UserModel();
// 				userModel.setCard(card);
// 				userModel.setPassword(password);
// 				message.setAllembracing(userModel);

// 				client.TheClient client = new client.TheClient();

// 				Message received;
// 				try {
// 					received = client.sendAndReceive(message);
// 					System.out.println(received.isResponse());
// 					if (received.isResponse()) {
// 						JOptionPane.showMessageDialog(null, "登录成功", "登录成功", JOptionPane.INFORMATION_MESSAGE);
// 					} else {
// 						JOptionPane.showMessageDialog(null, "一卡通号或密码错误", "登录失败", JOptionPane.ERROR_MESSAGE);
// 					}
// 				} catch (UnknownHostException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				} catch (ClassNotFoundException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				} catch (IOException e) {
// 					// TODO Auto-generated catch block
// 					e.printStackTrace();
// 				}

// 				// System.out.println("von dem Server: "+client.response);

// 			}
// 		});

// 		btnNewButton.addMouseListener(new MouseListener() {

// 			@Override
// 			public void mouseClicked(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 			@Override
// 			public void mouseReleased(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 			@Override
// 			public void mouseEntered(MouseEvent e) {
// 				btnNewButton.setBackground(new Yellow());

// 			}

// 			@Override
// 			public void mouseExited(MouseEvent e) {
// 				btnNewButton.setBackground(new Green());

// 			}

// 		});

// 		btnNewButton.setBounds(594, 309, 70, 23);
// 		getContentPane().add(btnNewButton);

// 		label = new JLabel("\u4E00\u5361\u901A", JLabel.CENTER);
// 		label.setOpaque(true);
// 		label.setForeground(Color.WHITE);
// 		label.setBackground(new Green());
// 		label.setBounds(476, 65, 66, 21);
// 		getContentPane().add(label);

// 		btnNewButton_1 = new JButton("\u6CE8\u518C");
// 		btnNewButton_1.setOpaque(true);
// 		btnNewButton_1.setBorder(new LineBorder(new Green()));
// 		btnNewButton_1.setBackground(Color.WHITE);
// 		btnNewButton_1.setForeground(new Green());
// 		btnNewButton_1.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 			}
// 		});
// 		btnNewButton_1.setBounds(476, 308, 70, 23);
// 		getContentPane().add(btnNewButton_1);

// 		lblNewLabel = new JLabel(new ImageIcon(Login.class.getResource("/gui/login.jpeg")));
// 		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
// 		lblNewLabel.setBounds(0, 0, 433, 433);
// 		getContentPane().add(lblNewLabel);

// 		JLabel label_1 = new JLabel("验证码", SwingConstants.CENTER);
// 		label_1.setOpaque(true);
// 		label_1.setForeground(Color.WHITE);
// 		label_1.setBackground(new Green());
// 		label_1.setBounds(476, 227, 66, 21);
// 		getContentPane().add(label_1);

// 		varifyField = new JTextField();
// 		varifyField.setColumns(20);
// 		varifyField.setBorder(new LineBorder(new Green()));
// 		varifyField.setBounds(476, 248, 92, 21);
// 		getContentPane().add(varifyField);
// 		ImageIcon image = new ImageIcon(Login.class.getResource("/gui/VarifyCode.jpg"));

// 		panel = new JPanel();
// 		panel.setBackground(Color.WHITE);
// 		panel.setBounds(572, 243, 92, 30);
// 		getContentPane().add(panel);

// 		JButton btnNewButton_2 = new JButton("");
// 		panel.add(btnNewButton_2);
// 		btnNewButton_2.setBackground(Color.WHITE);
// 		btnNewButton_2.setBorder(new EmptyBorder(0, 0, 0, 0));
// 		try {
// 			System.out.println(VerifyCode.getCodeImg());
// 		} catch (Exception e2) {
// 			// TODO Auto-generated catch block
// 			e2.printStackTrace();
// 		}
// 		btnNewButton_2.setIcon(image);
// 		btnNewButton_2.addMouseListener(new MouseListener() {

// 			@Override
// 			public void mouseClicked(MouseEvent e) {
// 				try {
// 					System.out.println(VerifyCode.getCodeImg());
// 					// panel.remove(btnNewButton_2);
// 					btnNewButton_2.setIcon(new ImageIcon(Login.class.getResource("/gui/VarifyCode.jpg")));
// 					// panel.add(btnNewButton_2);
// 					btnNewButton_2.validate();
// 					frame.validate();					
// 				} catch (Exception e1) {
// 					// TODO Auto-generated catch block
// 					e1.printStackTrace();
// 				}

// 			}

// 			@Override
// 			public void mousePressed(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 			@Override
// 			public void mouseReleased(MouseEvent e) {
				

// 			}

// 			@Override
// 			public void mouseEntered(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 			@Override
// 			public void mouseExited(MouseEvent e) {
// 				// TODO Auto-generated method stub

// 			}

// 		});
		
		
// 		getContentPane().add(remand_label);
// 		setLocationRelativeTo(null);
// 	}
	
	
	
	
	
// 	static final long serialVersionUID = 1L;
// 	private JTextField cardField;
// 	private JTextField passwordField;
// 	private JLabel txtPassword;
// 	private JLabel label;
// 	private JButton btnNewButton_1;
// 	private JLabel lblNewLabel;
// 	private JTextField varifyField;
// 	private JPanel panel;
//     public  void loginWindow() {
//         setSize(700, 433);
//         Box hBox = Box.createHorizontalBox();

//         JLabel imgLabel = new JLabel(new ImageIcon("GUI/login.jpeg"));
//         imgLabel.setSize(433, 433);
//         hBox.add(imgLabel);

//         getContentPane().add(hBox);
//         setVisible(true);
// 	}
// }
