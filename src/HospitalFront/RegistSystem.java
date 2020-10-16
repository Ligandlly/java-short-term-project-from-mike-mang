package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalDAO.DrugDAO;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import user.User;

import java.awt.Label;
import java.awt.Button;
import java.awt.CardLayout;

import gui.DarkButton;
import gui.LightLabel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class RegistSystem extends JFrame {

	private JPanel contentPane;
	private static JTable RegisterList;
	private static int check = 5;
	private String Type = "COM_REGIST";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					RegistSystem frame = new RegistSystem(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * 
	 * Create the frame.
	 */
//	public RegistSystem() {
//		setTitle("\u67E5\u770B\u6302\u53F7\u4FE1\u606F");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 700, 438);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(72, 69, 557, 222);
//		contentPane.add(scrollPane_1);
//
//		RegisterList = new MyTable();
//		RegisterList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E00\u5361\u901A\u53F7",
//				"\u59D3\u540D", "\u6302\u53F7\u65F6\u95F4", "\u5355\u636E\u72B6\u6001" }));
//		scrollPane_1.setViewportView(RegisterList);
//
//		JLabel label = new LightLabel("\u5F53\u524D\u6392\u961F\u5217\u8868");
//		label.setBounds(291, 28, 104, 25);
//		contentPane.add(label);
//		// TODO: Encoding errors repaired here
//
//		DarkButton OkButton = new DarkButton("\u63A5\u8BCA");
//		OkButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				int count = RegisterList.getSelectedRow();
//				if (count == -1) {
//					JOptionPane.showMessageDialog(null, "请选择病人", "提示", JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					String N = RegisterList.getValueAt(count, 0).toString();
//					String M = RegisterList.getValueAt(count, 1).toString();
//					Regist re = new Regist();
//					re.setCard(N);
//					re.setRegist_Status("完成");
//					Message message = new Message(Type, re);
//					message.setCheckCode(check);
//					client.TheClient client = new TheClient();
//					try {
//						Message received = client.sendAndReceive(message);
//						if (received.isResponse()) {
//							JOptionPane.showMessageDialog(null, "接诊成功", "提示", JOptionPane.INFORMATION_MESSAGE);
//							AddMedHistory d = new AddMedHistory(N, M);
//							d.setVisible(true);
//						} else {
//							JOptionPane.showMessageDialog(null, "接诊失败，请重试", "错误", JOptionPane.ERROR_MESSAGE);
//						}
//					} catch (UnknownHostException e1) {
//						e1.printStackTrace();
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}
//
//				}
//			}
//		});
//		OkButton.setBounds(117, 339, 113, 27);
//		contentPane.add(OkButton);
//
//		DarkButton DelectButton = new DarkButton("\u9000\u53F7");
//		DelectButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				int count = RegisterList.getSelectedRow();
//				if (count == -1) {
//					JOptionPane.showMessageDialog(null, "请选择病人", "提示", JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					String N = RegisterList.getValueAt(count, 0).toString();
//					Regist re = new Regist();
//					re.setCard(N);
//					re.setRegist_Status("作废");
//					Message message = new Message(Type, re);
//					message.setCheckCode(check);
//					client.TheClient client = new TheClient();
//					try {
//						Message received = client.sendAndReceive(message);
//						if (received.isResponse()) {
//							JOptionPane.showMessageDialog(null, "退号成功", "提示", JOptionPane.INFORMATION_MESSAGE);
//						} else {
//							JOptionPane.showMessageDialog(null, "退号失败，请重试", "错误", JOptionPane.ERROR_MESSAGE);
//						}
//					} catch (UnknownHostException e1) {
//						e1.printStackTrace();
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						e1.printStackTrace();
//					}
//
//				}
//			}
//		});
//		DelectButton.setBounds(444, 339, 113, 27);
//		contentPane.add(DelectButton);
//
//		DarkButton ReSawButton = new DarkButton("\u5237\u65B0");
//		ReSawButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				filltable(new StaffModel());
//				MyTable.colorizeTabel(RegisterList);
//			}
//		});
//		ReSawButton.setBounds(282, 339, 113, 27);
//		contentPane.add(ReSawButton);
//
//		filltable(new StaffModel());
//		MyTable.colorizeTabel(RegisterList);
//		// TODO: For Testing Only!
//	}
	public RegistSystem(User user) {
		setTitle("\u67E5\u770B\u6302\u53F7\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(72, 69, 557, 222);
		contentPane.add(scrollPane_1);

		RegisterList = new MyTable();
		RegisterList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E00\u5361\u901A\u53F7",
				"\u59D3\u540D", "\u6302\u53F7\u65F6\u95F4", "\u5355\u636E\u72B6\u6001" }));
		scrollPane_1.setViewportView(RegisterList);

		JLabel label = new LightLabel("\u5F53\u524D\u6392\u961F\u5217\u8868");
		label.setBounds(291, 28, 104, 25);
		contentPane.add(label);
		// TODO: Encoding errors repaired here

		DarkButton OkButton = new DarkButton("\u63A5\u8BCA");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = RegisterList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择病人", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = RegisterList.getValueAt(count, 0).toString();
					String M = RegisterList.getValueAt(count, 1).toString();
					Regist re = new Regist();
					re.setCard(N);
					re.setRegist_Status("完成");
					Message message = new Message(Type, re);
					message.setCheckCode(check);
					client.TheClient client = new TheClient();
					try {
						Message received = client.sendAndReceive(message);
						if (received.isResponse()) {
							JOptionPane.showMessageDialog(null, "接诊成功", "提示", JOptionPane.INFORMATION_MESSAGE);
							AddMedHistory d = new AddMedHistory(N, M);
							d.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "接诊失败，请重试", "错误", JOptionPane.ERROR_MESSAGE);
						}
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		OkButton.setBounds(117, 339, 113, 27);
		contentPane.add(OkButton);

		DarkButton DelectButton = new DarkButton("\u9000\u53F7");
		DelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = RegisterList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择病人", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = RegisterList.getValueAt(count, 0).toString();
					Regist re = new Regist();
					re.setCard(N);
					re.setRegist_Status("作废");
					Message message = new Message(Type, re);
					message.setCheckCode(check);
					client.TheClient client = new TheClient();
					try {
						Message received = client.sendAndReceive(message);
						if (received.isResponse()) {
							JOptionPane.showMessageDialog(null, "退号成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "退号失败，请重试", "错误", JOptionPane.ERROR_MESSAGE);
						}
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		DelectButton.setBounds(444, 339, 113, 27);
		contentPane.add(DelectButton);

		DarkButton ReSawButton = new DarkButton("\u5237\u65B0");
		ReSawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filltable(user);
				MyTable.colorizeTabel(RegisterList);
			}
		});
		ReSawButton.setBounds(282, 339, 113, 27);
		contentPane.add(ReSawButton);

		filltable(user);
		MyTable.colorizeTabel(RegisterList);
		// TODO: For Testing Only!
	}

	private static void filltable(User user) {
		DefaultTableModel dtm = (DefaultTableModel) RegisterList.getModel();
		String tp = "REGIST_MYLIST";
		StaffModel staff=new StaffModel();
		staff.setStaff_Name(user.name);
		dtm.setRowCount(0);
		Message message = new Message(tp, staff);
		message.setCheckCode(check);
		client.TheClient client = new TheClient();
		Message received;
		try {
			received = client.sendAndReceive(message);
			Vector<Regist> rs = new Vector<Regist>();
			rs = received.getRegistvectot();
			System.out.println(rs.size());
			for (int i = 0; i < rs.size(); i++) {
				Regist s = rs.get(i);
				Vector v = new Vector();
				v.add(s.getCard());
				v.add(s.getRegist_Name());
				v.add(s.getRegist_Time());
				v.add(s.getRegist_Status());
				dtm.addRow(v);
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
