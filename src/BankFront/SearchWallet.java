package BankFront;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BankModel.WalletModel;
import Message.Message;
import UserModel.UserModel;
import client.TheClient;

import gui.colors.*;
import user.User;

public class SearchWallet extends JFrame {

	private JPanel contentPane;
	private JTextField CardField;
	private JPasswordField passwordField;
	private JTextField BalanceField;
	private String Type="SEARCH_BALANCE";
	private int check =7;
	private String testCard = "\\d{9}";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWallet frame = new SearchWallet();
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
	public SearchWallet() {
		setTitle("\u4F59\u989D\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A\u53F7");
		CardLabel.setBounds(63, 82, 72, 18);
		contentPane.add(CardLabel);
		
		JLabel jl4=new JLabel(new ImageIcon("src/images/money2.png"));
		contentPane.add(jl4);
        jl4.setBounds(28, 183, 221, 194);
        jl4.setVisible(false);
		
		JLabel jl3=new JLabel(new ImageIcon("src/images/money.png"));
		jl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WalletModel wallet=new WalletModel();
				String card=CardField.getText();
				boolean a=true;
				if(card.matches(testCard)) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Œ¥’˝»∑ ‰»Î“ªø®Õ®∫≈", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
					a=false;
				}
				if(a==true) {
					UserModel user=new UserModel();
					user.setCard(card);
					user.setPassword(passwordField.getText());
					Message message =new Message(Type,user);
					client.TheClient client=new TheClient();
					message.setCheckCode(check);
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							wallet=(WalletModel)recevied.getAllembracing();
							double i=wallet.getBalance();
							BalanceField.setText(String.valueOf(i));
						}else {
							JOptionPane.showMessageDialog(null, "≤È—Ø ß∞‹", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
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
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl3.setBackground(new HighlightColor());
				jl3.setVisible(false);
				jl4.setVisible(true);
			}
			
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				jl3.setBackground(new PrimaryColor());
				jl3.setVisible(true);
				jl4.setVisible(false);
			}
		});
		
		contentPane.add(jl3);
        jl3.setBounds(28, 183, 221, 194);
		
		CardField = new JTextField();
		CardField.setBounds(174, 79, 255, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\u5BC6\u7801");
		passwordLabel.setBounds(63, 149, 72, 18);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 146, 255, 24);
		contentPane.add(passwordField);
		
		BalanceField = new JTextField();
		BalanceField.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 42));
		BalanceField.setOpaque(false);
		BalanceField.setBounds(288, 243, 307, 82);
		contentPane.add(BalanceField);
		BalanceField.setColumns(10);
	}

	public SearchWallet(User user) {
		setTitle("\u4F59\u989D\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A\u53F7");
		CardLabel.setBounds(63, 82, 72, 18);
		contentPane.add(CardLabel);
		
		JLabel jl4=new JLabel(new ImageIcon("src/images/money2.png"));
		contentPane.add(jl4);
        jl4.setBounds(28, 183, 221, 194);
        jl4.setVisible(false);
		
		JLabel jl3=new JLabel(new ImageIcon("src/images/money.png"));
		jl3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WalletModel wallet=new WalletModel();
				String card=CardField.getText();
				boolean a=true;
				if(card.matches(testCard)) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Œ¥’˝»∑ ‰»Î“ªø®Õ®∫≈", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
					a=false;
				}
				if(a==true) {
					UserModel user=new UserModel();
					user.setCard(card);
					user.setPassword(passwordField.getText());
					Message message =new Message(Type,user);
					client.TheClient client=new TheClient();
					message.setCheckCode(check);
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							wallet=(WalletModel)recevied.getAllembracing();
							double i=wallet.getBalance();
							BalanceField.setText(String.valueOf(i));
						}else {
							JOptionPane.showMessageDialog(null, "≤È—Ø ß∞‹", "¥ÌŒÛ", JOptionPane.ERROR_MESSAGE);
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
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jl3.setBackground(new HighlightColor());
				jl3.setVisible(false);
				jl4.setVisible(true);
			}
			
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				jl3.setBackground(new PrimaryColor());
				jl3.setVisible(true);
				jl4.setVisible(false);
			}
		});
		
		contentPane.add(jl3);
        jl3.setBounds(28, 183, 221, 194);
		
		CardField = new JTextField();
		CardField.setBounds(174, 79, 255, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("\u5BC6\u7801");
		passwordLabel.setBounds(63, 149, 72, 18);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 146, 255, 24);
		contentPane.add(passwordField);
		
		BalanceField = new JTextField();
		BalanceField.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 42));
		BalanceField.setOpaque(false);
		BalanceField.setBounds(288, 243, 307, 82);
		contentPane.add(BalanceField);
		BalanceField.setColumns(10);
	}


}
