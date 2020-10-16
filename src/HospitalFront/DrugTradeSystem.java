package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BankModel.WalletModel;
import HospitalModel.Department;
import HospitalModel.DrugModel;
import HospitalModel.DrugTrade;
import Message.Message;
import client.TheClient;
import user.User;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrugTradeSystem extends JFrame {

	private JPanel contentPane;
	private JTextField Price1Field;
	private JTextField Price2Field;
	private JTextField Price3Field;
	private JTextField Amount1Field;
	private JTextField Amount2Field;
	private JTextField Amount3Field;
	private static int check = 5;
	private String Type = "DETECT_DRUGFEE";
	private JComboBox<String> Drug3Box;
	private JComboBox<String> Drug1Box;
	private JComboBox<String> Drug2Box;
	private double money = 0;
	private Vector<DrugModel> Drugtrade;
	private Vector<DrugModel> Drugtotal;
	private DrugModel tt1;
	private DrugModel tt2;
	private DrugModel tt3;
	private DrugModel t;
	private JTextField ALLMoney;
	private JTextField CardField;
	private String CARD = "\\d{9}";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					user.card="213180315";
					user.name="����";
					DrugTradeSystem frame = new DrugTradeSystem(user);
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
	public DrugTradeSystem(User user) {
		setResizable(false);
		setTitle("\u5904\u65B9\u5F00\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Drug1Box = new JComboBox();
		Drug1Box.setBounds(99, 110, 108, 30);
		contentPane.add(Drug1Box);

		JLabel Drug1Label = new JLabel("\u836F\u54C11");
		Drug1Label.setBounds(36, 112, 72, 27);
		contentPane.add(Drug1Label);

		JLabel Drug2Label = new JLabel("\u836F\u54C12");
		Drug2Label.setBounds(36, 175, 72, 27);
		contentPane.add(Drug2Label);

		Drug2Box = new JComboBox();
		Drug2Box.setBounds(99, 174, 108, 30);
		contentPane.add(Drug2Box);

		JLabel Drug3Label = new JLabel("\u836F\u54C13");
		Drug3Label.setBounds(36, 238, 72, 27);
		contentPane.add(Drug3Label);

		Drug3Box = new JComboBox();
		Drug3Box.setBounds(99, 238, 108, 30);
		contentPane.add(Drug3Box);

		JLabel Price1Label = new JLabel("\u5355\u4EF7");
		Price1Label.setBounds(243, 112, 72, 27);
		contentPane.add(Price1Label);

		JLabel Price2Label = new JLabel("\u5355\u4EF7");
		Price2Label.setBounds(243, 175, 72, 27);
		contentPane.add(Price2Label);

		JLabel Price3Label = new JLabel("\u5355\u4EF7");
		Price3Label.setBounds(243, 238, 72, 27);
		contentPane.add(Price3Label);

		Price1Field = new JTextField();
		Price1Field.setEditable(false);
		Price1Field.setBounds(284, 110, 86, 30);
		contentPane.add(Price1Field);
		Price1Field.setColumns(10);

		Price2Field = new JTextField();
		Price2Field.setEditable(false);
		Price2Field.setBounds(284, 175, 86, 27);
		contentPane.add(Price2Field);
		Price2Field.setColumns(10);

		Price3Field = new JTextField();
		Price3Field.setEditable(false);
		Price3Field.setBounds(284, 238, 86, 27);
		contentPane.add(Price3Field);
		Price3Field.setColumns(10);

		JLabel Amount1Label = new JLabel("\u5F00\u65B9\u6570\u91CF");
		Amount1Label.setBounds(403, 110, 72, 30);
		contentPane.add(Amount1Label);

		JLabel Amount2Label = new JLabel("\u5F00\u65B9\u6570\u91CF");
		Amount2Label.setBounds(403, 175, 72, 27);
		contentPane.add(Amount2Label);

		JLabel Amount3Label = new JLabel("\u5F00\u65B9\u6570\u91CF");
		Amount3Label.setBounds(403, 238, 72, 27);
		contentPane.add(Amount3Label);

		Amount1Field = new JTextField();
		Amount1Field.setBounds(473, 110, 86, 30);
		Amount1Field.setText("1");
		contentPane.add(Amount1Field);
		Amount1Field.setColumns(10);

		Amount2Field = new JTextField();
		Amount2Field.setBounds(473, 175, 86, 27);
		Amount2Field.setText("1");
		contentPane.add(Amount2Field);
		Amount2Field.setColumns(10);

		Amount3Field = new JTextField();
		Amount3Field.setBounds(473, 238, 86, 27);
		Amount3Field.setText("1");
		contentPane.add(Amount3Field);
		Amount3Field.setColumns(10);

		JButton Lock1 = new JButton("\u9501\u5B9A");
		Lock1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = Drug1Box.getSelectedItem().toString();
				for (int i = 0; i < Drugtrade.size(); i++) {
					t = Drugtrade.get(i);
					if (temp.equals(t.getDrug_Name())) {
						String a = String.valueOf(t.getDrug_Price());
						double t1 = t.getDrug_Price();
						money += t1 * Double.valueOf(Amount1Field.getText());
						DrugModel drug = new DrugModel();
						drug.setDrug_Name(t.getDrug_Name());
						drug.setDrug_Amount(Integer.valueOf(Amount1Field.getText()));
						Price1Field.setText(a);
						Amount1Field.setEditable(false);
						Lock1.setVisible(false);
						ALLMoney.setText(String.valueOf(money));
						tt1 = drug;
					}
				}
			}
		});
		Lock1.setBounds(589, 112, 72, 27);
		contentPane.add(Lock1);

		JButton Lock2 = new JButton("\u9501\u5B9A");
		Lock2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = Drug2Box.getSelectedItem().toString();
				for (int i = 0; i < Drugtrade.size(); i++) {
					DrugModel t = new DrugModel();
					t = Drugtrade.get(i);
					if (temp.equals(t.getDrug_Name())) {
						String a = String.valueOf(t.getDrug_Price());
						double t1 = t.getDrug_Price();
						money += t1 * Double.valueOf(Amount2Field.getText());
						DrugModel drug = new DrugModel();
						drug.setDrug_Name(t.getDrug_Name());
						drug.setDrug_Amount(Integer.valueOf(Amount2Field.getText()));
						Price2Field.setText(a);
						Amount2Field.setEditable(false);
						Lock2.setVisible(false);
						ALLMoney.setText(String.valueOf(money));
						tt2 = drug;
					}
				}
			}
		});
		Lock2.setBounds(589, 175, 72, 27);
		contentPane.add(Lock2);

		JButton Lock3 = new JButton("\u9501\u5B9A");
		Lock3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = Drug3Box.getSelectedItem().toString();
				for (int i = 0; i < Drugtrade.size(); i++) {
					DrugModel t = new DrugModel();
					t = Drugtrade.get(i);
					if (temp.equals(t.getDrug_Name())) {
						String a = String.valueOf(t.getDrug_Price());
						DrugModel drug = new DrugModel();
						double t1 = t.getDrug_Price();
						money += t1 * Double.valueOf(Amount2Field.getText());
						drug.setDrug_Name(t.getDrug_Name());
						drug.setDrug_Amount(Integer.valueOf(Amount3Field.getText()));
						Price3Field.setText(a);
						Amount3Field.setEditable(false);
						Lock3.setVisible(false);
						ALLMoney.setText(String.valueOf(money));
						tt3 = drug;
					}
				}
			}
		});
		Lock3.setBounds(589, 238, 72, 27);
		contentPane.add(Lock3);

		JButton OKButton = new JButton("\u7ED3\u7B97");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (CardField.getText().matches(CARD)) {
					
				}else {
					JOptionPane.showMessageDialog(null, "一卡通输入错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
				Vector<DrugModel> s = new Vector<DrugModel>();
				if (tt1.getDrug_Name().equals("")) {
					
				}else {
					s.add(tt1);
				}
					
				if (tt2.getDrug_Name().equals("")) {
					
				}else {
					s.add(tt2);
				}
					
				if (tt3.getDrug_Name().equals("")) {
					
				}else {
					s.add(tt3);
				}
					
				Message message = new Message();
				message.setVector(s);
				String tp1 = "OUTDRUG2";
				message.setCheckCode(check);
				message.setType(tp1);
				message.setAllembracing(tt1);
				client.TheClient client = new TheClient();
				boolean a = true;
				try {
					Message recevied = client.sendAndReceive(message);
					if (recevied.isResponse()) {

					} else {
						a = false;
						JOptionPane.showMessageDialog(null, "药品库存不足", "错误", JOptionPane.ERROR_MESSAGE);
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

				String cc=null;
				if (a == true) {
					String cardd=CardField.getText();
					Date date=new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                //��ʽ��Ϊ����/ʱ���ַ���
	                cc=sdf.format(date);
					String Tradecontext=tt1.getDrug_Name()+"*"+tt1.getDrug_Amount()+";"+tt2.getDrug_Name()+"*"+tt2.getDrug_Amount()+";"+tt3.getDrug_Name()+"*"+tt3.getDrug_Amount()+";";
				    DrugTrade Dtr=new DrugTrade();
				    Dtr.setCard(cardd);
				    Dtr.setDrugTrade_ALL(Tradecontext);
				    Dtr.setDrugTrade_Doctor(user.name);
				    Dtr.setDrugTrade_Price(money);
				    Dtr.setDrugTrade_Time(cc);
				    String tp2="NEW_DRUGTRADE";
				    Message message2=new Message(tp2,Dtr);
				    message2.setCheckCode(check);
				    client.TheClient Recode=new TheClient();
				    
				    try {
						Message recevied2=Recode.sendAndReceive(message2);
						if(recevied2.isResponse()) {
							a=true;
						}else {
							JOptionPane.showMessageDialog(null, "处方记录生成失败", "错误", JOptionPane.ERROR_MESSAGE);
							a=false;
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
				
				if(a==true) {
					a=false;
					WalletModel www=new WalletModel();
					String tp2="DrugFeeTRADE";
					int check2=7;
					www.setCard(CardField.getText());
					www.setBalance(money);
					Message message3=new Message(tp2,www);
					message3.setCheckCode(check2);
					message3.setS(cc);
					message3.setUsedouble(money);
					client.TheClient WAlletSend=new TheClient();
					try {
						Message recevied3=WAlletSend.sendAndReceive(message3);
						if(recevied3.isResponse()) {
							JOptionPane.showMessageDialog(null, "处方开具成功", "提示", JOptionPane.INFORMATION_MESSAGE);
							a=true;
						}else {
							JOptionPane.showMessageDialog(null, "交易失败", "错误", JOptionPane.ERROR_MESSAGE);
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
		OKButton.setBounds(69, 325, 113, 27);
		contentPane.add(OKButton);

		ALLMoney = new JTextField();
		ALLMoney.setFont(new Font("宋体", Font.PLAIN, 34));
		ALLMoney.setBounds(430, 301, 188, 60);
		contentPane.add(ALLMoney);
		ALLMoney.setColumns(10);

		JLabel prLabel = new JLabel("\u603B\u989D");
		prLabel.setFont(new Font("宋体", Font.PLAIN, 36));
		prLabel.setBounds(341, 300, 75, 60);
		contentPane.add(prLabel);

		JLabel lblNewLabel = new JLabel("\u4E00\u5361\u901A");
		lblNewLabel.setBounds(182, 51, 72, 18);
		contentPane.add(lblNewLabel);

		CardField = new JTextField();
		CardField.setBounds(243, 48, 173, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);

		fillcombox();
	}

	public void fillcombox() {
		String tp = "RETURN_ALLDRUG2";
		Message message = new Message();
		message.setCheckCode(check);
		message.setType(tp);
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
			Drugtrade = received.getVector();
			Vector<String> ss = new Vector<String>();
			for (int i = 0; i < Drugtrade.size(); i++) {
				DrugModel d = new DrugModel();
				d = Drugtrade.get(i);
				String t = d.getDrug_Name();
				Drug1Box.addItem(t);
				Drug2Box.addItem(t);
				Drug3Box.addItem(t);
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
