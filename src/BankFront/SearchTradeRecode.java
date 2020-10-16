package BankFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BankModel.TradeRecode;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import user.User;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SearchTradeRecode extends JFrame {

	private JPanel contentPane;
	private JTable TradeRecodeList;
	private JTextField CardField;
	private JLabel CardLabel;
	private JLabel lblNewLabel;
	private String Type="SEARCH_TRADE";
	private int check=7;
	private String testCard = "\\d{9}";
	private JComboBox TypecomboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchTradeRecode frame = new SearchTradeRecode();
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
	public SearchTradeRecode() {
		setSize(new Dimension(700, 433));
		setTitle("\u4EA4\u6613\u8BB0\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchTradeRecode.class.getResource("/images/money2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(51, 119, 578, 139);
		contentPane.add(scrollPane_1);
		
		TradeRecodeList = new MyTable();
		TradeRecodeList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E00\u5361\u901A", "\u59D3\u540D", "\u4EA4\u6613\u7C7B\u522B", "\u4EA4\u6613\u91D1\u989D", "\u4EA4\u6613\u65F6\u95F4", "\u4F59\u989D"
			}
		));
		scrollPane_1.setViewportView(TradeRecodeList);
		
		CardField = new JTextField();
		CardField.setBounds(145, 58, 146, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		CardLabel = new JLabel("\u4E00\u5361\u901A");
		CardLabel.setBounds(51, 61, 72, 18);
		contentPane.add(CardLabel);
		
		lblNewLabel = new JLabel("\u4EA4\u6613\u7C7B\u522B");
		lblNewLabel.setBounds(341, 61, 72, 18);
		contentPane.add(lblNewLabel);
		
		TypecomboBox = new JComboBox();
		TypecomboBox.setBounds(443, 58, 91, 24);
		contentPane.add(TypecomboBox);
		
		JButton okButton = new JButton("\u67E5\u627E");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) TradeRecodeList.getModel();
				dtm.setRowCount(0);
				boolean a=true;
				if(CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					String atemp=CardField.getText();
					String btemp=TypecomboBox.getSelectedItem().toString();
					TradeRecode recode=new TradeRecode();
					recode.setCard(atemp);
					if(btemp.equals("null")) {
						
					}else {
						recode.setTrade_Type(btemp);
					}
					
					Message message=new Message(Type,recode);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						Vector<TradeRecode>v=recevied.getTradeRecodevector();
						for(int i=0;i<v.size();i++) {
							Vector tt=new Vector();
							TradeRecode ttemp=new TradeRecode();
							ttemp=v.get(i);
							tt.add(ttemp.getCard());
							tt.add(ttemp.getPerson_Name());
							tt.add(ttemp.getTrade_Type());
							tt.add(ttemp.getTransaction_Amount());
							tt.add(ttemp.getDate());
							tt.add(ttemp.getBalance());
							
							dtm.addRow(tt);
						}
						
						MyTable.colorizeTabel(TradeRecodeList);
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
		okButton.setName("okButton");
		okButton.setBounds(280, 329, 113, 27);
		contentPane.add(okButton);
		
		
		fillcombox();
	}
	
	public SearchTradeRecode(User user) {
		setSize(new Dimension(700, 433));
		setTitle("\u4EA4\u6613\u8BB0\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchTradeRecode.class.getResource("/images/money2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(51, 119, 578, 139);
		contentPane.add(scrollPane_1);
		
		TradeRecodeList = new JTable();
		TradeRecodeList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E00\u5361\u901A", "\u59D3\u540D", "\u4EA4\u6613\u7C7B\u522B", "\u4EA4\u6613\u91D1\u989D", "\u4EA4\u6613\u65F6\u95F4", "\u4F59\u989D"
			}
		));
		scrollPane_1.setViewportView(TradeRecodeList);
		
		CardField = new JTextField();
		CardField.setBounds(145, 58, 146, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		CardLabel = new JLabel("\u4E00\u5361\u901A");
		CardLabel.setBounds(51, 61, 72, 18);
		contentPane.add(CardLabel);
		
		lblNewLabel = new JLabel("\u4EA4\u6613\u7C7B\u522B");
		lblNewLabel.setBounds(341, 61, 72, 18);
		contentPane.add(lblNewLabel);
		
		TypecomboBox = new JComboBox();
		TypecomboBox.setBounds(443, 58, 91, 24);
		contentPane.add(TypecomboBox);
		
		JButton okButton = new JButton("\u67E5\u627E");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) TradeRecodeList.getModel();
				dtm.setRowCount(0);
				boolean a=true;
				if(CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					String atemp=CardField.getText();
					String btemp=TypecomboBox.getSelectedItem().toString();
					TradeRecode recode=new TradeRecode();
					recode.setCard(atemp);
					if(btemp.equals("null")) {
						
					}else {
						recode.setTrade_Type(btemp);
					}
					
					Message message=new Message(Type,recode);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						Vector<TradeRecode>v=recevied.getTradeRecodevector();
						for(int i=0;i<v.size();i++) {
							Vector tt=new Vector();
							TradeRecode ttemp=new TradeRecode();
							ttemp=v.get(i);
							tt.add(ttemp.getCard());
							tt.add(ttemp.getPerson_Name());
							tt.add(ttemp.getTrade_Type());
							tt.add(ttemp.getTransaction_Amount());
							tt.add(ttemp.getDate());
							tt.add(ttemp.getBalance());
							
							dtm.addRow(tt);
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
		okButton.setName("okButton");
		okButton.setBounds(280, 329, 113, 27);
		contentPane.add(okButton);
		
		
		fillcombox();
	}
	

	public void fillcombox() {
		String a="null";
		String a1="充值";
		String a2="商品";
		String a3="药品";
		
		TypecomboBox.addItem(a);
		TypecomboBox.addItem(a1);
		TypecomboBox.addItem(a2);
		TypecomboBox.addItem(a3);
	}
}
