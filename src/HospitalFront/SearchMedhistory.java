package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.DarkButton;
import gui.LightButton;
import gui.MyTable;
import user.User;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import HospitalModel.MedHistoryModel;
import Message.Message;
import client.TheClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchMedhistory extends JFrame {

	private JPanel contentPane;
	private JTable MedHistoryList;
	private JTextField CardField;
	private String testCard = "\\d{9}";
	private String Type = "RETURN_HISTORY";
	private int check = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMedhistory frame = new SearchMedhistory(new User());
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
	public SearchMedhistory(User user) {
		setTitle("\u75C5\u5386\u67E5\u8BE2");
		setSize(new Dimension(700, 433));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton okButton = new DarkButton("New button");
		okButton.setText("\u67E5\u8BE2");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) MedHistoryList.getModel();
				dtm.setRowCount(0);
				boolean a=true;
				if (CardField.getText().matches(testCard)) {
					
				}else {
					a=false;
					JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
				if(a==true) {
					MedHistoryModel medHistoryModel=new MedHistoryModel();
					medHistoryModel.setCard(CardField.getText());
					Message message=new Message(Type, medHistoryModel);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						Vector<MedHistoryModel>v=new Vector<MedHistoryModel>();
						v=recevied.getMedHistoryVector();
						System.out.println(v.size());
						for(int i=0;i<v.size();i++) {
							MedHistoryModel temp=new MedHistoryModel();
							temp=v.get(i);
							Vector s=new Vector();
							s.add(temp.getMedHistory_History());
							s.add(temp.getMedHistory_MainSuit());
							s.add(temp.getMedHistory_Diagnose());
							s.add(temp.getMedHistory_Time());
							dtm.addRow(s);
						}
						MyTable.colorizeTabel(MedHistoryList);
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
		okButton.setBounds(283, 327, 113, 27);
		contentPane.add(okButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(104, 110, 476, 137);
		contentPane.add(scrollPane_1);

		MedHistoryList = new MyTable();
		MedHistoryList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u65E2\u5F80\u75C5\u53F2",
				"\u4E3B\u8BC9", "\u8BCA\u65AD", "\u4E66\u5199\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(MedHistoryList);

		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A");
		CardLabel.setBounds(103, 50, 72, 18);
		contentPane.add(CardLabel);

		CardField = new JTextField();
		CardField.setBounds(210, 47, 279, 24);
		contentPane.add(CardField);
		CardField.setColumns(10);
	}
}
