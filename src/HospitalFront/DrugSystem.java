package HospitalFront;

import java.awt.BorderLayout;
import HospitalModel.*;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import user.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalDAO.DrugDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import gui.DarkButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class DrugSystem extends JFrame {

	private JPanel contentPane;
	private JTable DrugList;
	private JTextField Drugtxt;
	private String Type = "SEARCH_DRUG";
	private int check = 5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugSystem frame = new DrugSystem();
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
	public DrugSystem() {
		setTitle("\u836F\u623F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(104, 104, 525, 176);
		contentPane.add(scrollPane_1);

		DrugList = new MyTable();
		DrugList.setVerifyInputWhenFocusTarget(false);
		DrugList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6279\u51C6\u6587\u53F7", "\u836F\u54C1\u540D\u79F0", "\u836F\u54C1\u6570\u91CF",
						"\u836F\u54C1\u4EF7\u683C", "\u836F\u54C1\u79CD\u7C7B" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DrugList.getColumnModel().getColumn(0).setResizable(false);
		scrollPane_1.setViewportView(DrugList);

		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(109, 57, 72, 18);
		contentPane.add(lblNewLabel);

		Drugtxt = new JTextField();
		Drugtxt.setBounds(209, 54, 295, 24);
		contentPane.add(Drugtxt);
		Drugtxt.setColumns(10);

		DarkButton SearchOK = new DarkButton("\u67E5\u8BE2");
		SearchOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SearchDrug(event);
			}
		});
		SearchOK.setBounds(76, 333, 113, 27);
		contentPane.add(SearchOK);

		DarkButton AddDrugin = new DarkButton("\u836F\u54C1\u5165\u5E93");
		AddDrugin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDrug a = new AddDrug();
				a.setVisible(true);
			}
		});
		AddDrugin.setBounds(289, 333, 113, 27);
		contentPane.add(AddDrugin);

		DarkButton DrugOut = new DarkButton("\u836F\u54C1\u51FA\u5E93");
		DrugOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = DrugList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择药品", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = DrugList.getValueAt(count, 1).toString();
					OutDrug out = new OutDrug(N);
					out.setVisible(true);
				}

			}
		});
		DrugOut.setBounds(502, 333, 113, 27);
		contentPane.add(DrugOut);
		
		this.filltable(new DrugModel());
		MyTable.colorizeTabel(DrugList);
	}
	public DrugSystem(User user) {
		setTitle("\u836F\u623F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(104, 104, 525, 176);
		contentPane.add(scrollPane_1);

		DrugList = new MyTable();
		DrugList.setVerifyInputWhenFocusTarget(false);
		DrugList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6279\u51C6\u6587\u53F7", "\u836F\u54C1\u540D\u79F0", "\u836F\u54C1\u6570\u91CF",
						"\u836F\u54C1\u4EF7\u683C", "\u836F\u54C1\u79CD\u7C7B" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DrugList.getColumnModel().getColumn(0).setResizable(false);
		scrollPane_1.setViewportView(DrugList);

		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(109, 57, 72, 18);
		contentPane.add(lblNewLabel);

		Drugtxt = new JTextField();
		Drugtxt.setBounds(209, 54, 295, 24);
		contentPane.add(Drugtxt);
		Drugtxt.setColumns(10);

		DarkButton SearchOK = new DarkButton("\u67E5\u8BE2");
		SearchOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SearchDrug(event);
			}
		});
		SearchOK.setBounds(76, 333, 113, 27);
		contentPane.add(SearchOK);

		DarkButton AddDrugin = new DarkButton("\u836F\u54C1\u5165\u5E93");
		AddDrugin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDrug a = new AddDrug();
				a.setVisible(true);
			}
		});
		AddDrugin.setBounds(289, 333, 113, 27);
		contentPane.add(AddDrugin);

		DarkButton DrugOut = new DarkButton("\u836F\u54C1\u51FA\u5E93");
		DrugOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = DrugList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择药品", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = DrugList.getValueAt(count, 1).toString();
					OutDrug out = new OutDrug(N);
					out.setVisible(true);
				}

			}
		});
		DrugOut.setBounds(502, 333, 113, 27);
		contentPane.add(DrugOut);
		
		this.filltable(new DrugModel());
		MyTable.colorizeTabel(DrugList);
	}

	protected void SearchDrug(ActionEvent event) {
		DrugModel drug = new DrugModel();
		drug.setDrug_Name(Drugtxt.getText());
		if (drug.getDrug_Name().equals("") != true) {
			Message message = new Message(Type, drug);
			message.setCheckCode(check);
			client.TheClient client = new TheClient();
			try {
				Message received = client.sendAndReceive(message);
				DefaultTableModel dtm = (DefaultTableModel) DrugList.getModel();
				DrugModel drug1=(DrugModel)received.getAllembracing();
				Vector v = new Vector();
				v.add(drug1.getDrug_ApporovalNumber());
				v.add(drug1.getDrug_Name());
				v.add(drug1.getDrug_Amount());
				v.add(drug1.getDrug_Price());
				v.add(drug1.getDrug_Sort());
				dtm.setRowCount(0);
				dtm.addRow(v);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			filltable(new DrugModel());
		}

	}

	/**
	 * 初始化表格
	 * 
	 * @param drugmodel
	 */
	private void filltable(DrugModel drugmodel) {
		DefaultTableModel dtm = (DefaultTableModel) DrugList.getModel();
		dtm.setRowCount(0);
		String tp="RETURN_ALLDRUG";
		Message message=new Message();
		message.setCheckCode(check);
		message.setType(tp);
		client.TheClient client=new TheClient();
		Message received;
		try {
			received = client.sendAndReceive(message);
			Vector<DrugModel> a=new Vector<DrugModel>();
			a=received.getVector();
			for(int i=0;i<a.size();i++) {
				Vector temp=new Vector();
				DrugModel drug=a.get(i);
				temp.add(drug.getDrug_ApporovalNumber());
				temp.add(drug.getDrug_Name());
				temp.add(drug.getDrug_Amount());
				temp.add(drug.getDrug_Price());
				temp.add(drug.getDrug_Sort());
				dtm.addRow(temp);
		    }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


