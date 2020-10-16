package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalDAO.DrugDAO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import HospitalModel.*;
import Message.Message;
import client.TheClient;

import javax.swing.JCheckBoxMenuItem;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import gui.Green;

/**
 * radioButton��û�ĺ�
 * 
 * @author 91261
 *
 */
public class AddDrug extends JFrame {
	private JTextField Appovaltxt;
	private JTextField DrugNametxt;
	private JTextField DrugAmounttxt;
	private JTextField DrugPricetxt;
	private String temp="国药准字";
	private String temp2="国药";
	private static String Type = "ADD_DRUG";
	private static String appovaltext = "\\p{Upper}{1}+\\d{8}";// ƥ����׼�ĺŵ�������ʽ
	private static String amount = "\\d{1,}";
	private static String price = "\\d{1,}+\\.+\\d{1,2}";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private int check = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDrug frame = new AddDrug();
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
	public AddDrug() {
		setTitle("\u836F\u54C1\u5165\u5E93");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 506);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		JPanel AddDrugpanel = new JPanel();
		AddDrugpanel.setSize(700, 433);
		getContentPane().add(AddDrugpanel);
		AddDrugpanel.setLayout(null);

		JLabel lblAppovalTextLabel = new JLabel("\u6279\u51C6\u6587\u53F7");
		lblAppovalTextLabel.setBounds(52, 35, 72, 18);
		AddDrugpanel.add(lblAppovalTextLabel);

		Appovaltxt = new JTextField();
		Appovaltxt.setBounds(139, 32, 376, 24);
		Appovaltxt.setBorder(new LineBorder(new Green()));
		Appovaltxt.setForeground(new Green());
		Appovaltxt.setPreferredSize(new Dimension(180, 21));
		AddDrugpanel.add(Appovaltxt);
		Appovaltxt.setColumns(10);

		JLabel lblNewDrugLabel = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewDrugLabel.setBounds(52, 108, 72, 18);
		AddDrugpanel.add(lblNewDrugLabel);

		JLabel lblNewDrugAmountLabel_1 = new JLabel("\u836F\u54C1\u6570\u91CF");
		lblNewDrugAmountLabel_1.setBounds(52, 160, 72, 18);
		AddDrugpanel.add(lblNewDrugAmountLabel_1);

		JLabel lblNewDrugPriceLabel_2 = new JLabel("\u836F\u54C1\u5355\u4EF7");
		lblNewDrugPriceLabel_2.setBounds(52, 216, 72, 18);
		AddDrugpanel.add(lblNewDrugPriceLabel_2);

		JLabel lblNewDrugSortLabel_3 = new JLabel("\u836F\u54C1\u79CD\u7C7B");
		lblNewDrugSortLabel_3.setBounds(52, 269, 72, 18);
		AddDrugpanel.add(lblNewDrugSortLabel_3);

		DrugNametxt = new JTextField();
		DrugNametxt.setBounds(139, 105, 376, 24);
		DrugNametxt.setBorder(new LineBorder(new Green()));
		DrugNametxt.setForeground(new Green());
		DrugNametxt.setPreferredSize(new Dimension(180, 21));
		AddDrugpanel.add(DrugNametxt);
		DrugNametxt.setColumns(10);

		DrugAmounttxt = new JTextField();
		DrugAmounttxt.setBounds(139, 157, 376, 24);
		DrugAmounttxt.setBorder(new LineBorder(new Green()));
		DrugAmounttxt.setForeground(new Green());
		DrugAmounttxt.setPreferredSize(new Dimension(180, 21));
		AddDrugpanel.add(DrugAmounttxt);
		DrugAmounttxt.setColumns(10);

		DrugPricetxt = new JTextField();
		DrugPricetxt.setBounds(139, 213, 376, 24);
		DrugPricetxt.setBorder(new LineBorder(new Green()));
		DrugPricetxt.setForeground(new Green());
		DrugPricetxt.setPreferredSize(new Dimension(180, 21));
		AddDrugpanel.add(DrugPricetxt);
		DrugPricetxt.setColumns(10);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JButton btnOKAddDrugButton = new JButton("\u786E\u8BA4");
		btnOKAddDrugButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AddDrugOk(event);
			}
		});
		btnOKAddDrugButton.setBounds(95, 362, 113, 27);
		btnOKAddDrugButton.setBorder(new LineBorder(new Green()));
		btnOKAddDrugButton.setForeground(new Green());
		btnOKAddDrugButton.setPreferredSize(new Dimension(180, 21));
		btnOKAddDrugButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddDrugpanel.add(btnOKAddDrugButton);

		JButton btnResetButton_1 = new JButton("\u91CD\u7F6E");
		btnResetButton_1.setBorderPainted(false);
		btnResetButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				resetValueActionPerformed(click);
			}
		});
		btnResetButton_1.setBounds(413, 362, 113, 27);
		btnResetButton_1.setBorder(new LineBorder(new Green()));
		btnResetButton_1.setForeground(Color.WHITE);
		btnResetButton_1.setPreferredSize(new Dimension(180, 21));
		btnResetButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetButton_1.setBackground(new Green());
		AddDrugpanel.add(btnResetButton_1);

		JRadioButton rdbtnNationlDrugRadioButton = new JRadioButton("\u56FD\u836F");
		rdbtnNationlDrugRadioButton.setSelected(true);
		buttonGroup_1.add(rdbtnNationlDrugRadioButton);
		rdbtnNationlDrugRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp = rdbtnNationlDrugRadioButton.getText();
			}
		});
		rdbtnNationlDrugRadioButton.setBounds(139, 265, 157, 27);
		AddDrugpanel.add(rdbtnNationlDrugRadioButton);

		JRadioButton rdbtnInternationalDrugRadioButton_1 = new JRadioButton("\u8FDB\u53E3");
		buttonGroup_1.add(rdbtnInternationalDrugRadioButton_1);
		rdbtnInternationalDrugRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp = rdbtnInternationalDrugRadioButton_1.getText();
			}
		});
		rdbtnInternationalDrugRadioButton_1.setBounds(358, 265, 157, 27);
		AddDrugpanel.add(rdbtnInternationalDrugRadioButton_1);

		JRadioButton nationokRadioButton = new JRadioButton("\u56FD\u836F\u51C6\u5B57");
		nationokRadioButton.setSelected(true);
		buttonGroup.add(nationokRadioButton);
		nationokRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp2 = nationokRadioButton.getText();
			}
		});
		nationokRadioButton.setBounds(139, 65, 157, 27);
		AddDrugpanel.add(nationokRadioButton);

		JRadioButton nationtestRadioButton = new JRadioButton("\u56FD\u836F\u8BD5\u5B57");
		buttonGroup.add(nationtestRadioButton);
		nationtestRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				temp2 = nationtestRadioButton.getText();
			}
		});
		nationtestRadioButton.setBounds(358, 65, 157, 27);
		AddDrugpanel.add(nationtestRadioButton);

	}

	/**
	 * 
	 * @param event
	 */
	protected void AddDrugOk(ActionEvent event) {
		DrugModel drug = new DrugModel();
		boolean a = true;
		if (Appovaltxt.getText().matches(appovaltext)) {
		} else {
			JOptionPane.showMessageDialog(null, "未正确输入批准文号", "错误", JOptionPane.ERROR_MESSAGE);
			a = false;
		}

		if (DrugAmounttxt.getText().matches(amount)) {
		} else {
			JOptionPane.showMessageDialog(null, "未正确输入药品数量", "错误", JOptionPane.ERROR_MESSAGE);
			a = false;
		}

		if (DrugPricetxt.getText().matches(price)) {
		} else {
			JOptionPane.showMessageDialog(null, "未正确输入药品单价", "错误", JOptionPane.ERROR_MESSAGE);
			a = false;
		}
		if (a == true) {
			drug.setDrug_ApporovalNumber(temp2 + Appovaltxt.getText());
			drug.setDrug_Name(DrugNametxt.getText());
			drug.setDrug_Amount(Integer.parseInt(DrugAmounttxt.getText()));
			drug.setDrug_Price(Double.valueOf(DrugPricetxt.getText().toString()));
			drug.setDrug_Sort(temp);
			Message message = new Message(Type, drug);
			client.TheClient client = new TheClient();
			message.setCheckCode(check);
			Message recevied = new Message();
			try {
				recevied = client.sendAndReceive(message);
				if (recevied.isResponse()) {
					JOptionPane.showMessageDialog(null, "药品入库成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "药品入库失败，请重新添加", "错误", JOptionPane.ERROR_MESSAGE);
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

	/**
	 * �����¼�����
	 * 
	 * @param click
	 */
	private void resetValueActionPerformed(ActionEvent click) {
		this.Appovaltxt.setText("");
		this.DrugAmounttxt.setText("");
		this.DrugNametxt.setText("");
		this.DrugPricetxt.setText("");
	}
}
