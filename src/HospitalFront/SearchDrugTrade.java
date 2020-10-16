package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import HospitalModel.DrugTrade;
import HospitalModel.MedHistoryModel;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import user.User;

import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class SearchDrugTrade extends JFrame {

	private JPanel contentPane;
	private JTable drugTradelist;
	private JTextField CardField;
	private String Type="SEARCHDRUGTRADE";
	private int check=5;
	private String testCard = "\\d{9}";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					SearchDrugTrade frame = new SearchDrugTrade(user);
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
	public SearchDrugTrade(User user) {
		setTitle("\u5904\u65B9\u8BB0\u5F55\u67E5\u8BE2");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(89, 123, 496, 180);
		contentPane.add(scrollPane_1);
		
		drugTradelist = new MyTable();
		drugTradelist.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5904\u65B9\u5185\u5BB9", "\u836F\u54C1\u8D39\u7528", "\u5F00\u65B9\u533B\u751F", "\u5F00\u65B9\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(drugTradelist);
		
		JLabel Cardlabel = new JLabel("\u4E00\u5361\u901A");
		Cardlabel.setBounds(130, 49, 77, 25);
		contentPane.add(Cardlabel);
		
		CardField = new JTextField();
		CardField.setBounds(233, 50, 235, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
		
		JButton okButton = new JButton("\u67E5\u8BE2");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) drugTradelist.getModel();
				dtm.setRowCount(0);
				boolean a=true;
				if (CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					DrugTrade drugtrade=new DrugTrade();
					drugtrade.setCard(CardField.getText());
					Message message=new Message(Type, drugtrade);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						Vector<DrugTrade>v=new Vector<DrugTrade>();
						v=recevied.getDrugtradeVector();
						System.out.println(v.size());
						for(int i=0;i<v.size();i++) {
							DrugTrade temp=new DrugTrade();
							temp=v.get(i);
							Vector s=new Vector();
							s.add(temp.getDrugTrade_ALL());
							s.add(temp.getDrugTrade_Price());
							s.add(temp.getDrugTrade_Doctor());
							s.add(temp.getDrugTrade_Time());
							dtm.addRow(s);
						}
						MyTable.colorizeTabel(drugTradelist);
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
		okButton.setBounds(279, 343, 113, 27);
		contentPane.add(okButton);
	}
}
