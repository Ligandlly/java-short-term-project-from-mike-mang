// package gui;

// import javax.swing.*;
// import java.awt.Dimension;
// import java.awt.Color;
// import javax.swing.border.LineBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

// import Message.Message;
// import UserModel.UserModel;
// import client.TheClient;
// import gui.colors.Brown;
// import gui.colors.Green;
// import gui.colors.PaleGreen;
// import gui.colors.Yellow;
// import users.User;

// import java.awt.event.ActionListener;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.io.IOException;
// // import java.net.UnknownHostException;
// import java.awt.event.ActionEvent;
// import java.awt.Cursor;
// import java.awt.Font;

// public class ChangeInfo extends JFrame {
// 	private final JTextField sexField;
// 	private final JTextField mailField;
// 	private final JTextField cardField;
// 	private final JTextField nameField;
// 	private final JPasswordField newPasswordField;
// 	private final JPasswordField confirmPasswordField;
// 	private final JPasswordField passwordField;

// 	private JLabel nameLabel;
// 	private JButton nameButton;
// 	private JLabel mailLabel;
// 	private JButton mailButton;
// 	private JLabel passwordLabel;
// 	private JButton passwordButton;
// 	private JLabel newPasswordLabel;
// 	private JLabel confirmLabel;
// 	private JLabel passwordRemand;
// 	private JLabel confirmRemand;
// 	private JButton cancelButton;

// 	private final JPanel confirmPanel;
// 	private final JPanel newPasswordPanel;
// 	JPanel passwordPanel;

// 	private final User user;
// 	private UserModel userModel;
// 	private String password;
// 	private String newPassword;

// 	private Color sexColor, mailColor, cardColor, nameColor, newPasswordColor, confirmColor, passwordColor; // colors
// 																											// for each
// 																											// panels

// 	private boolean isNameBeingEdited, isMailBeingEdited, isPasswordBeingEdited;
// 	private final JTextField collegeField;

// 	private void loadData() {
// 		final TheClient client = new client.TheClient();
// 		final UserModel userModelToSent = new UserModel();
// 		userModelToSent.setCard(user.card);
// 		final Message messageToSend = new Message("SEARCH_INFO", userModelToSent);
// 		Message message;

// 		// try {
// 		// message = client.sendAndReceive(messageToSend);
// 		message = client.test(messageToSend);
// 		userModel = (UserModel) message.getAllembracing();

// 		// card
// 		cardField.setText(userModel.getCard());
// 		cardField.setEditable(false);
// 		cardColor = new PaleGreen();

// 		//
// 		collegeField.setText(userModel.getCollege());

// 		// sex
// 		sexField.setText(userModel.getSex());
// 		cardField.setEditable(false);
// 		sexColor = cardColor;

// 		// name
// 		nameField.setText(userModel.getUser_Name());
// 		nameField.setEditable(false);
// 		nameColor = new Green();

// 		// mail
// 		mailField.setText(userModel.getEmail());
// 		mailField.setEditable(false);
// 		mailColor = new Green();

// 		// password
// 		passwordColor = new Green();
// 		newPasswordColor = new Green();
// 		confirmColor = new Green();

// 		// passwordField.setVisible(false);
// 		passwordPanel.setVisible(false);
// 		newPasswordPanel.setVisible(false);
// 		confirmPanel.setVisible(true);
// 		confirmLabel.setVisible(false);
// 		confirmPasswordField.setVisible(false);
// 		passwordButton.setVisible(true);

// 		password = userModel.getPassword();

// 		// } catch (UnknownHostException e) {
// 		// e.printStackTrace();
// 		// } catch (ClassNotFoundException e) {
// 		// e.printStackTrace();
// 		// } catch (IOException e) {
// 		// e.printStackTrace();
// 		// }

// 	}

// 	public ChangeInfo(final User user) {
// 		this.user = user;
// 		isNameBeingEdited = false;
// 		isMailBeingEdited = false;
// 		isPasswordBeingEdited = false;

// 		getContentPane().setBackground(Color.WHITE);
// 		setResizable(false);
// 		setSize(new Dimension(700, 433));
// 		getContentPane().setLayout(null);

// 		final JPanel cardPanel = new JPanel();
// 		cardPanel.setLayout(null);
// 		cardPanel.setBackground(Color.WHITE);
// 		cardPanel.setBounds(170, 77, 370, 21);
// 		getContentPane().add(cardPanel);

// 		final JLabel cardLabel = new JLabel("一卡通", SwingConstants.CENTER);
// 		cardLabel.setOpaque(true);
// 		cardLabel.setForeground(Color.WHITE);
// 		cardLabel.setBackground(new PaleGreen());
// 		cardLabel.setBounds(0, 0, 66, 21);
// 		cardPanel.add(cardLabel);

// 		cardField = new JTextField();
// 		cardField.setForeground(Color.gray);
// 		cardField.setHorizontalAlignment(SwingConstants.CENTER);
// 		cardField.setColumns(20);
// 		cardField.setBorder(new LineBorder(new PaleGreen()));
// 		cardField.setBounds(65, 0, 290, 21);
// 		cardPanel.add(cardField);

// 		final JPanel collegePanel = new JPanel();
// 		collegePanel.setLayout(null);
// 		collegePanel.setBackground(Color.WHITE);
// 		collegePanel.setBounds(170, 133, 370, 21);
// 		getContentPane().add(collegePanel);

// 		final JLabel collegeLabel = new JLabel("学院", SwingConstants.CENTER);
// 		collegeLabel.setOpaque(true);
// 		collegeLabel.setForeground(Color.WHITE);
// 		collegeLabel.setBackground(new Color(160, 191, 124));
// 		collegeLabel.setBounds(0, 0, 66, 21);
// 		collegePanel.add(collegeLabel);

// 		collegeField = new JTextField();
// 		collegeField.setText("213182087");
// 		collegeField.setHorizontalAlignment(SwingConstants.CENTER);
// 		collegeField.setForeground(new Color(114, 83, 52));
// 		collegeField.setEditable(false);
// 		collegeField.setColumns(20);
// 		collegeField.setBorder(new LineBorder(new PaleGreen()));
// 		collegeField.setBounds(65, 0, 290, 21);
// 		collegePanel.add(collegeField);

// 		final JPanel namePanel = new JPanel();
// 		namePanel.setBackground(Color.WHITE);
// 		namePanel.setBounds(170, 189, 355, 21);
// 		getContentPane().add(namePanel);
// 		namePanel.setLayout(null);

// 		final JLabel sexLabel = new JLabel("性别", SwingConstants.CENTER);
// 		sexLabel.setOpaque(true);
// 		sexLabel.setForeground(Color.WHITE);
// 		sexLabel.setBackground(new PaleGreen());
// 		sexLabel.setBounds(0, 0, 66, 21);
// 		namePanel.add(sexLabel);

// 		sexField = new JTextField();
// 		sexField.setBounds(65, 0, 39, 21);
// 		sexField.setForeground(Color.gray);
// 		namePanel.add(sexField);
// 		sexField.setColumns(20);
// 		sexField.setBorder(new LineBorder(new PaleGreen()));

// 		nameLabel = new JLabel("姓名", SwingConstants.CENTER);
// 		nameLabel.setBounds(110, 0, 66, 21);
// 		namePanel.add(nameLabel);
// 		nameLabel.setOpaque(true);
// 		nameLabel.setForeground(Color.WHITE);
// 		nameLabel.setBackground(new Green());

// 		nameButton = new JButton("修改");
// 		nameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		nameButton.setActionCommand("");
// 		nameButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(final ActionEvent e) {
// 			}
// 		});

// 		nameField = new JTextField();
// 		nameField.setColumns(20);
// 		nameField.setBorder(new LineBorder(new Green()));
// 		nameField.setBounds(175, 0, 79, 21);
// 		namePanel.add(nameField);
// 		nameButton.setOpaque(true);
// 		nameButton.setForeground(new Green());
// 		nameButton.setBorder(new LineBorder(new Green()));
// 		nameButton.setBackground(Color.WHITE);
// 		nameButton.setBounds(285, 0, 70, 21);
// 		namePanel.add(nameButton);

// 		final JPanel mailPanel = new JPanel();
// 		mailPanel.setBackground(Color.WHITE);
// 		mailPanel.setLayout(null);
// 		mailPanel.setBounds(172, 245, 355, 21);
// 		getContentPane().add(mailPanel);

// 		mailLabel = new JLabel("邮箱", SwingConstants.CENTER);
// 		mailLabel.setOpaque(true);
// 		mailLabel.setForeground(Color.WHITE);
// 		mailLabel.setBackground(new Green());
// 		mailLabel.setBounds(0, 0, 66, 21);
// 		mailPanel.add(mailLabel);

// 		mailField = new JTextField();
// 		mailField.setColumns(20);
// 		mailField.setBorder(new LineBorder(new Green()));
// 		mailField.setBounds(65, 0, 188, 21);
// 		mailPanel.add(mailField);

// 		mailButton = new JButton("修改");
// 		mailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		mailButton.setOpaque(true);
// 		mailButton.setForeground(new Green());
// 		mailButton.setBorder(new LineBorder(new Green()));
// 		mailButton.setBackground(Color.WHITE);
// 		mailButton.setActionCommand("");
// 		mailButton.setBounds(285, 0, 70, 21);
// 		mailPanel.add(mailButton);

// 		passwordPanel = new JPanel();
// 		passwordPanel.setBackground(Color.WHITE);
// 		passwordPanel.setLayout(null);
// 		passwordPanel.setBounds(172, 278, 355, 21);
// 		getContentPane().add(passwordPanel);

// 		passwordLabel = new JLabel("原密码", SwingConstants.CENTER);
// 		passwordLabel.setOpaque(true);
// 		passwordLabel.setForeground(Color.WHITE);
// 		passwordLabel.setBackground(new Green());
// 		passwordLabel.setBounds(0, 0, 66, 21);
// 		// passwordLabel.setVisible(false);
// 		passwordPanel.add(passwordLabel);

// 		passwordField = new JPasswordField();
// 		passwordField.setColumns(10);
// 		passwordField.setBorder(new LineBorder(new Green()));
// 		passwordField.setBounds(65, 0, 188, 21);
// 		passwordPanel.add(passwordField);

// 		confirmPanel = new JPanel();
// 		confirmPanel.setBackground(Color.WHITE);
// 		confirmPanel.setLayout(null);
// 		confirmPanel.setBounds(172, 345, 355, 21);
// 		confirmPanel.setVisible(false);

// 		newPasswordPanel = new JPanel();
// 		newPasswordPanel.setLayout(null);
// 		newPasswordPanel.setBackground(Color.WHITE);
// 		newPasswordPanel.setBounds(172, 311, 355, 21);
// 		getContentPane().add(newPasswordPanel);

// 		newPasswordLabel = new JLabel("新密码", SwingConstants.CENTER);
// 		newPasswordLabel.setOpaque(true);
// 		newPasswordLabel.setForeground(Color.WHITE);
// 		newPasswordLabel.setBackground(new Green());
// 		newPasswordLabel.setBounds(0, 0, 66, 21);
// 		newPasswordPanel.add(newPasswordLabel);

// 		newPasswordField = new JPasswordField();
// 		newPasswordField.setColumns(10);
// 		newPasswordField.setBorder(new LineBorder(new Green()));
// 		newPasswordField.setBounds(65, 0, 188, 21);
// 		newPasswordPanel.add(newPasswordField);
// 		getContentPane().add(confirmPanel);

// 		confirmLabel = new JLabel("确认密码", SwingConstants.CENTER);
// 		confirmLabel.setOpaque(true);
// 		confirmLabel.setForeground(Color.WHITE);
// 		confirmLabel.setBackground(new Green());
// 		confirmLabel.setBounds(0, 0, 66, 21);
// 		confirmPanel.add(confirmLabel);

// 		confirmPasswordField = new JPasswordField();
// 		confirmPasswordField.setColumns(10);
// 		confirmPasswordField.setBorder(new LineBorder(new Green()));
// 		confirmPasswordField.setBounds(65, 0, 188, 21);
// 		confirmPanel.add(confirmPasswordField);

// 		cardField.setForeground(Color.gray);
// 		sexField.setForeground(Color.gray);
// 		collegeField.setForeground(Color.gray);
// 		nameField.setForeground(new Brown());
// 		mailField.setForeground(new Brown());
// 		passwordField.setForeground(new Brown());
// 		newPasswordField.setForeground(new Brown());
// 		confirmPasswordField.setForeground(new Brown());

// 		passwordButton = new JButton("修改密码");
// 		passwordButton.setBounds(284, 0, 70, 21);
// 		confirmPanel.add(passwordButton);
// 		passwordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		passwordButton.setOpaque(true);
// 		passwordButton.setForeground(Color.WHITE);
// 		passwordButton.setBorder(null);
// 		passwordButton.setBackground(new Green());
// 		passwordButton.setActionCommand("");

// 		cancelButton = new JButton("取消");
// 		cancelButton.setOpaque(true);
// 		cancelButton.setForeground(Color.WHITE);
// 		cancelButton.setBorder(new LineBorder(new Green()));
// 		cancelButton.setBackground(new Color(64, 116, 52));
// 		cancelButton.setActionCommand("");
// 		cancelButton.setBounds(580, 21, 70, 21);
// 		getContentPane().add(cancelButton);

// 		final JLabel mailRemand = new JLabel("邮箱格式不合法");
// 		mailRemand.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
// 		mailRemand.setBounds(60, 250, 100, 16);
// 		getContentPane().add(mailRemand);

// 		passwordRemand = new JLabel("密码格式不合法");
// 		passwordRemand.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
// 		passwordRemand.setBounds(60, 316, 100, 16);
// 		getContentPane().add(passwordRemand);

// 		confirmRemand = new JLabel("两次密码不一致");
// 		confirmRemand.setVisible(false);
// 		confirmRemand.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
// 		confirmRemand.setBounds(60, 350, 82, 16);
// 		getContentPane().add(confirmRemand);
// 		passwordRemand.setVisible(false);
// 		mailRemand.setVisible(false);
// 		cancelButton.setVisible(false);

// 		// ----------------------------------------------
// 		loadData();

// 		// cancel
// 		cancelButton.addActionListener(new ActionListener() {

// 			@Override
// 			public void actionPerformed(final ActionEvent e) {
// 				resetName();
// 				resetMail();
// 				resetPassword();

// 			}

// 		});

// 		// name button
// 		nameButton.addMouseListener(new MouseListener() {

// 			@Override
// 			public void mouseClicked(final MouseEvent e) {
// 				System.out.println("name: " + isNameBeingEdited);
// 				if (isNameBeingEdited == false) {
// 					if (isMailBeingEdited) {
// 						resetMail();
// 					}
// 					if (isPasswordBeingEdited) {
// 						resetPassword();
// 					}
// 					nameColor = new Yellow();
// 					changeNameColor();
// 					nameButton.setBorder(new LineBorder(new Green()));
// 					nameButton.setForeground(new Green());
// 					nameField.setEditable(true);
// 					nameButton.setText("确认修改");
// 					isNameBeingEdited = true;
// 					cancelButton.setBounds(525, 189, 70, 21);
// 					cancelButton.setVisible(true);
// 				} else {
// 					// TODO: Message
// 					// updateInfo();
// 					resetName();
// 					isNameBeingEdited = false;
// 				}
// 			}

// 			@Override
// 			public void mousePressed(final MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseReleased(final MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseEntered(final MouseEvent e) {
// 				if (!isNameBeingEdited) {
// 					nameColor = new Yellow();
// 					changeNameColor();
// 				}
// 			}

// 			@Override
// 			public void mouseExited(final MouseEvent e) {
// 				if (!isNameBeingEdited) {
// 					nameColor = new Green();
// 					changeNameColor();
// 				}
// 			}

// 		});

// 		// mail
// 		mailButton.addMouseListener(new MouseListener() {

// 			@Override
// 			public void mouseClicked(final MouseEvent e) {
// 				System.out.println("mail: " + isMailBeingEdited);
// 				if (!isMailBeingEdited) {
// 					if (isNameBeingEdited) {
// 						resetName();
// 					}
// 					if (isPasswordBeingEdited) {
// 						resetPassword();
// 					}
// 					mailField.setEditable(true);
// 					mailButton.setText("确认修改");
// 					isMailBeingEdited = true;
// 					cancelButton.setBounds(527, 245, 70, 21);
// 					cancelButton.setVisible(true);
// 				} else {

// 					// TODO: Message
// 					// updateInfo();
// 					resetMail();
// 					isMailBeingEdited = false;
// 				}

// 			}

// 			@Override
// 			public void mousePressed(final MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseReleased(final MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseEntered(final MouseEvent e) {
// 				mailColor = new Yellow();
// 				changeMailColor();
// 			}

// 			@Override
// 			public void mouseExited(final MouseEvent e) {
// 				mailColor = new Green();
// 				changeMailColor();
// 			}

// 		});

// 		mailField.getDocument().addDocumentListener(new DocumentListener() {

// 			@Override
// 			public void insertUpdate(final DocumentEvent e) {
// 				final String str = mailField.getText();
// 				if (str.matches(".*\\@.+\\..*")) {
// 					mailRemand.setVisible(false);
// 					mailButton.setVisible(true);
// 					mailButton.setBorder(new LineBorder(new Green()));
// 					mailButton.setForeground(new Green());
// 					mailLabel.setBackground(new Green());
// 					mailField.setBorder(new LineBorder(new Green()));
// 				} else {
// 					mailRemand.setVisible(true);
// 					mailButton.setVisible(false);
// 					mailButton.setBorder(new LineBorder(new Yellow()));
// 					mailButton.setForeground(new Yellow());
// 					mailLabel.setBackground(new Yellow());
// 					mailField.setBorder(new LineBorder(new Yellow()));
// 				}
// 			}

// 			@Override
// 			public void removeUpdate(final DocumentEvent e) {
// 				final String str = mailField.getText();
// 				if (str.matches(".*\\@.+\\..*")) {
// 					mailRemand.setVisible(false);
// 					mailButton.setVisible(true);
// 					mailButton.setBorder(new LineBorder(new Green()));
// 					mailButton.setForeground(new Green());
// 					mailLabel.setBackground(new Green());
// 					mailField.setBorder(new LineBorder(new Green()));

// 				} else {
// 					mailRemand.setVisible(true);
// 					mailButton.setVisible(false);
// 					mailButton.setBorder(new LineBorder(new Yellow()));
// 					mailButton.setForeground(new Yellow());
// 					mailLabel.setBackground(new Yellow());
// 					mailField.setBorder(new LineBorder(new Yellow()));

// 				}

// 			}

// 			@Override
// 			public void changedUpdate(final DocumentEvent e) {

// 			}

// 		});

// 		// password
// 		passwordButton.addMouseListener(new MouseListener() {

// 			@Override
// 			public void mouseClicked(MouseEvent e) {
// 				if (!isPasswordBeingEdited) {
// 					if (isNameBeingEdited) {
// 						resetName();
// 					}
// 					if (isMailBeingEdited) {
// 						resetMail();
// 					}
// 					passwordPanel.setVisible(true);
// 					newPasswordPanel.setVisible(true);
// 					confirmPanel.setVisible(true);
// 					confirmLabel.setVisible(true);
// 					confirmPasswordField.setVisible(true);
// 					passwordButton.setText("确认修改");
// 					passwordButton.setBorder(null);
// 					passwordButton.setVisible(false);
// 					cancelButton.setBounds(527, 345, 70, 21);
// 					cancelButton.setVisible(true);
// 					isPasswordBeingEdited = true;
// 				} else {

// 					if (String.valueOf(passwordField.getPassword()).equals(password)) {

// 						// TODO : Message
// 						// updateInfo();
// 					} else {
// 						JOptionPane.showMessageDialog(null, "原密码错误", "错误", JOptionPane.ERROR_MESSAGE);
// 					}

// 					resetPassword();
// 					isPasswordBeingEdited = false;
// 				}

// 			}

// 			@Override
// 			public void mousePressed(MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseReleased(MouseEvent e) {

// 			}

// 			@Override
// 			public void mouseEntered(MouseEvent e) {
// 				passwordButton.setBackground(new Yellow());

// 			}

// 			@Override
// 			public void mouseExited(MouseEvent e) {
// 				passwordButton.setBackground(new Green());

// 			}

// 		});

// 		newPasswordField.getDocument().addDocumentListener(new DocumentListener() {

// 			@Override
// 			public void insertUpdate(DocumentEvent e) {
// 				String str = String.valueOf(newPasswordField.getPassword());
// 				if (!str.matches("\\d{4,10}")) {
// 					passwordRemand.setVisible(true);
// 					newPasswordColor = new Yellow();
// 					changeNewPasswordColor();
// 				} else {
// 					passwordRemand.setVisible(false);
// 					newPasswordColor = new Green();
// 					changeNewPasswordColor();
// 					newPassword = String.valueOf(newPasswordField.getPassword());
// 				}
// 			}

// 			@Override
// 			public void removeUpdate(DocumentEvent e) {
// 				String str = String.valueOf(newPasswordField.getPassword());
// 				if (!str.matches("\\d{4,10}")) {
// 					passwordRemand.setVisible(true);
// 					newPasswordColor = new Yellow();
// 					changeNewPasswordColor();
// 				} else {
// 					passwordRemand.setVisible(false);
// 					newPasswordColor = new Green();
// 					changeNewPasswordColor();
// 					newPassword = String.valueOf(newPasswordField.getPassword());
// 				}
// 			}

// 			@Override
// 			public void changedUpdate(DocumentEvent e) {

// 			}

// 		});

// 		confirmPasswordField.getDocument().addDocumentListener(new DocumentListener() {

// 			@Override
// 			public void insertUpdate(DocumentEvent e) {
// 				String str = String.valueOf(confirmPasswordField.getPassword());
// 				if (!str.equals(newPassword)) {
// 					confirmRemand.setVisible(true);
// 					confirmColor = new Yellow();
// 					changeConfirmColor();
// 				} else {
// 					confirmRemand.setVisible(false);
// 					confirmColor = new Green();
// 					changeConfirmColor();
// 					passwordButton.setVisible(true);
// 				}
// 			}

// 			@Override
// 			public void removeUpdate(DocumentEvent e) {
// 				String str = String.valueOf(confirmPasswordField.getPassword());
// 				if (!str.equals(newPassword)) {
// 					confirmRemand.setVisible(true);
// 					confirmColor = new Yellow();
// 					changeConfirmColor();
// 				} else {
// 					confirmRemand.setVisible(false);
// 					confirmColor = new Green();
// 					changeConfirmColor();
// 				}

// 			}

// 			@Override
// 			public void changedUpdate(DocumentEvent e) {

// 			}

// 		});

// 	}

// 	// * Carm. 34

// 	// * Diānae sumus in fide
// 	// * puellae et puerī integrī;
// 	// * Diānam puerī integrī
// 	// * puellaeque canāmus.

// 	// * Ō Lātōnia, māximī
// 	// * magna prōgeniēs Iovis,
// 	// * quam māter prope Dēliam
// 	// * dēpōsīvit olīvam,

// 	// * montium domina ut forēs
// 	// * silvārumque virentium
// 	// * saltuumque reconditōrum
// 	// * amniumque sonantum,

// 	// * tū Lūcīna dolentibus
// 	// * Iūnō dicta puerperīs,
// 	// * tū potēns Trivia et nothō es
// 	// * dicta lūmine Lūna.

// 	// * Tū cursū, dea, mēnstruō
// 	// * mētiēns iter annuum,
// 	// * rūstica agricolae bonīs
// 	// * tēcta frūgibus explēs.

// 	// * Sīs quōcumque tibī placet
// 	// * sāncta nōmine, Rōmulīque,
// 	// * antīquē ut solita es,
// 	// * bonā sōspitēs ope gentem.

// 	private void changeNameColor() {
// 		nameLabel.setBackground(nameColor);
// 		nameField.setBorder(new LineBorder(nameColor));
// 		nameButton.setBorder(new LineBorder(nameColor));
// 		nameButton.setForeground(nameColor);
// 	}

// 	private void changeMailColor() {
// 		mailLabel.setBackground(mailColor);
// 		mailField.setBorder(new LineBorder(mailColor));
// 		mailButton.setBorder(new LineBorder(mailColor));
// 		mailButton.setForeground(mailColor);
// 	}

// 	private void changeNewPasswordColor() {
// 		newPasswordLabel.setBackground(newPasswordColor);
// 		newPasswordField.setBorder(new LineBorder(newPasswordColor));
// 	}

// 	private void changeConfirmColor() {
// 		confirmPasswordField.setBorder(new LineBorder(confirmColor));
// 		confirmLabel.setBackground(confirmColor);
// 	}

// 	private void resetName() {
// 		nameColor = new Green();
// 		changeNameColor();
// 		nameButton.setText("修改");
// 		nameField.setText(userModel.getUser_Name());
// 		isNameBeingEdited = false;
// 		cancelButton.setVisible(false);
// 	}

// 	private void resetMail() {
// 		mailField.setEditable(false);
// 		mailColor = new Green();
// 		changeMailColor();
// 		mailButton.setText("修改");
// 		mailField.setText(userModel.getEmail());
// 		isMailBeingEdited = false;
// 		cancelButton.setVisible(false);
// 	}

// 	private void resetPassword() {
// 		passwordButton.setText("修改密码");
// 		passwordButton.setBorder(null);
// 		newPasswordColor = new Green();
// 		confirmColor = new Green();
// 		changeNewPasswordColor();
// 		changeConfirmColor();
// 		passwordPanel.setVisible(false);
// 		passwordField.setText("");

// 		newPasswordPanel.setVisible(false);
// 		newPasswordField.setText("");
// 		passwordRemand.setVisible(false);

// 		confirmRemand.setVisible(false);
// 		confirmPasswordField.setVisible(false);
// 		confirmPasswordField.setText("");
// 		confirmLabel.setVisible(false);
// 		isPasswordBeingEdited = false;
// 		cancelButton.setVisible(false);

// 		confirmRemand.setVisible(false);
// 		passwordRemand.setVisible(false);

// 		passwordButton.setVisible(true);
// 	}

// 	private void updateInfo() {
// 		final UserModel userModelCopy = new UserModel();
// 		userModelCopy.setUser_Name(nameField.getText());
// 		userModelCopy.setEmail(mailField.getText());
// 		userModelCopy.setPassword(String.valueOf(newPasswordField.getPassword()));
// 		final Message tmpMessage = new Message("UPDATE_INFO", userModelCopy);
// 		final TheClient tmpClient = new TheClient();
// 		Message messageReceived = null;
// 		try {
// 			messageReceived = tmpClient.sendAndReceive(tmpMessage);
// 			if (messageReceived.isResponse()) {
// 				JOptionPane.showMessageDialog(null, "修改成功", "成功", JOptionPane.YES_OPTION);
// 				userModel.setUser_Name(userModelCopy.getUser_Name());
// 				userModel.setEmail(userModelCopy.getEmail());
// 				userModel.setPassword(userModelCopy.getPassword());
// 			} else {
// 				JOptionPane.showMessageDialog(null, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
// 			}
// 		} catch (ClassNotFoundException | IOException e) {
// 			e.printStackTrace();
// 			JOptionPane.showMessageDialog(null, "修改失败", "错误", JOptionPane.ERROR_MESSAGE);
// 		}
// 	}
// }

