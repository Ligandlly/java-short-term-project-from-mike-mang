package BankFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Message.Message;
import UserModel.UserModel;
import client.TheClient;
import user.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class RechargeSystem extends JFrame {

	private JPanel contentPane;
	private JTextField CardField;
	private JTextField TradeField;
	private JPasswordField passwordField;
	private static String price = "\\d{1,}+\\.+\\d{1,2}";
	private String testCard = "\\d{9}";
	private String Type="RECHARGE";
	private int check=7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeSystem frame = new RechargeSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RechargeSystem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RechargeSystem.class.getResource("/images/Bank.png")));
		setTitle("\u4E00\u5361\u901A\u5145\u503C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A\u8D26\u53F7");
		CardLabel.setBounds(75, 110, 84, 18);
		contentPane.add(CardLabel);
		
		JLabel PasswordLabel = new JLabel("\u5BC6\u7801");
		PasswordLabel.setBounds(75, 162, 84, 18);
		contentPane.add(PasswordLabel);
		
		JLabel jl3=new JLabel(new ImageIcon("src/images/Bank.png"));
		contentPane.add(jl3);
        jl3.setBounds(511, 113, 300, 200);
		
		CardField = new JTextField();
		CardField.setBounds(196, 107, 348, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		JLabel TradeLabel = new JLabel("\u5145\u503C\u91D1\u989D");
		TradeLabel.setBounds(74, 214, 84, 18);
		contentPane.add(TradeLabel);
		
		TradeField = new JTextField();
		TradeField.setBounds(196, 213, 348, 24);
		contentPane.add(TradeField);
		TradeField.setColumns(10);
		
		JButton OkButton = new JButton("\u786E\u8BA4\u5145\u503C");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean a= true;
				if(CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				if(TradeField.getText().matches(price)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入金额", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					UserModel temp=new UserModel();
					temp.setCard(CardField.getText());
					temp.setPassword(passwordField.getText());
					Message message=new Message(Type,temp);
					message.setCheckCode(check);
					Double tt=Double.valueOf(TradeField.getText().toString());
					message.setUsedouble(tt);
					Date date=new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                //格式化为日期/时间字符串
	                String cc=sdf.format(date);
	                message.setS2(cc);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							JOptionPane.showMessageDialog(null, "充值成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "充值失败", "错误", JOptionPane.ERROR_MESSAGE);
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
				}
			}
		});
		OkButton.setBounds(75, 311, 113, 27);
		contentPane.add(OkButton);
		
		JButton ResetButton = new JButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Reset(click);
			}
		});
		ResetButton.setBounds(434, 311, 113, 27);
		contentPane.add(ResetButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 159, 348, 24);
		contentPane.add(passwordField);
	}
	public RechargeSystem(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RechargeSystem.class.getResource("/images/Bank.png")));
		setTitle("\u4E00\u5361\u901A\u5145\u503C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A\u8D26\u53F7");
		CardLabel.setBounds(75, 110, 84, 18);
		contentPane.add(CardLabel);
		
		JLabel PasswordLabel = new JLabel("\u5BC6\u7801");
		PasswordLabel.setBounds(75, 162, 84, 18);
		contentPane.add(PasswordLabel);
		
		JLabel jl3=new JLabel(new ImageIcon("src/images/Bank.png"));
		contentPane.add(jl3);
        jl3.setBounds(511, 113, 300, 200);
		
		CardField = new JTextField();
		CardField.setBounds(196, 107, 348, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		JLabel TradeLabel = new JLabel("\u5145\u503C\u91D1\u989D");
		TradeLabel.setBounds(74, 214, 84, 18);
		contentPane.add(TradeLabel);
		
		TradeField = new JTextField();
		TradeField.setBounds(196, 213, 348, 24);
		contentPane.add(TradeField);
		TradeField.setColumns(10);
		
		JButton OkButton = new JButton("\u786E\u8BA4\u5145\u503C");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean a= true;
				if(CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				if(TradeField.getText().matches(price)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入金额", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					UserModel temp=new UserModel();
					temp.setCard(CardField.getText());
					temp.setPassword(passwordField.getText());
					Message message=new Message(Type,temp);
					message.setCheckCode(check);
					Double tt=Double.valueOf(TradeField.getText().toString());
					message.setUsedouble(tt);
					Date date=new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                //格式化为日期/时间字符串
	                String cc=sdf.format(date);
	                message.setS2(cc);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							JOptionPane.showMessageDialog(null, "充值成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "充值失败", "错误", JOptionPane.ERROR_MESSAGE);
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
				}
			}
		});
		OkButton.setBounds(75, 311, 113, 27);
		contentPane.add(OkButton);
		
		JButton ResetButton = new JButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Reset(click);
			}
		});
		ResetButton.setBounds(434, 311, 113, 27);
		contentPane.add(ResetButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 159, 348, 24);
		contentPane.add(passwordField);
	}

	protected void Reset(ActionEvent click) {
		this.CardField.setText("");
		this.passwordField.setText("");
		this.TradeField.setText("");
		
	}
}
