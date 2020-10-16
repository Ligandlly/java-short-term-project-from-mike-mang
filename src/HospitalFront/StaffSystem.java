package HospitalFront;

import java.awt.BorderLayout;

import gui.DarkButton;
import gui.LightButton;
import gui.MyTable;
import user.User;

import java.awt.EventQueue;
import HospitalModel.*;
import Message.Message;
import client.TheClient;
import gui.MyTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class StaffSystem extends JFrame {

	private JPanel contentPane;
	private JTable StaffList;
	private JButton SearchStaffButton;
	private JButton AddStaffButton;
	private JButton DeleteStaffButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField Nametxt;
	private String Type = "SEARCH_STAFF";
	private int check = 5;
	public JComboBox DepartmentBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffSystem frame = new StaffSystem();
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
	public StaffSystem() {
		setTitle("\u804C\u5DE5\u7BA1\u7406");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 105, 630, 187);
		contentPane.add(scrollPane_1);

		StaffList = new MyTable();
		StaffList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E00\u5361\u901A", "\u540D\u5B57",
				"\u6027\u522B", "\u804C\u4F4D", "\u5DE5\u4F5C\u65F6\u95F4", "\u79D1\u5BA4", "\u6302\u53F7\u8D39" }));
		scrollPane_1.setViewportView(StaffList);

		SearchStaffButton = new DarkButton("\u67E5\u8BE2");
		SearchStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchStaff();
			}
		});
		SearchStaffButton.setBounds(560, 47, 87, 27);
		contentPane.add(SearchStaffButton);

		AddStaffButton = new DarkButton("\u589E\u52A0\u804C\u5DE5");
		AddStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff A = new AddStaff();
				A.setVisible(true);
				MyTable.colorizeTabel(StaffList);
			}
		});
		AddStaffButton.setBounds(142, 338, 113, 27);
		contentPane.add(AddStaffButton);

		DeleteStaffButton = new LightButton("\u804C\u5DE5\u79BB\u9662");
		DeleteStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tp="DELETE_STAFF";
				int count=StaffList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择职工", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = (String) StaffList.getValueAt(count, 0);
					System.out.println(N);
					StaffModel staff=new StaffModel();
					staff.setCard(N);
					Message message=new Message(tp,staff);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							JOptionPane.showMessageDialog(null, "职工离院成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "职工离院失败", "错误", JOptionPane.ERROR_MESSAGE);
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
		DeleteStaffButton.setBounds(407, 338, 113, 27);
		contentPane.add(DeleteStaffButton);

		lblNewLabel = new JLabel("\u804C\u5DE5\u59D3\u540D");
		lblNewLabel.setBounds(38, 52, 72, 18);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_1.setBounds(293, 52, 72, 18);
		contentPane.add(lblNewLabel_1);

		Nametxt = new JTextField();
		Nametxt.setBounds(119, 50, 86, 24);
		contentPane.add(Nametxt);
		Nametxt.setColumns(10);

		DepartmentBox.setBounds(352, 50, 102, 24);
		contentPane.add(DepartmentBox);

		//this.filltable(new StaffModel());
		this.fillComBox();

	}
	public StaffSystem(User user) {
		setTitle("\u804C\u5DE5\u7BA1\u7406");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 105, 630, 187);
		contentPane.add(scrollPane_1);

		StaffList = new MyTable();
		StaffList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E00\u5361\u901A", "\u540D\u5B57",
				"\u6027\u522B", "\u804C\u4F4D", "\u5DE5\u4F5C\u65F6\u95F4", "\u79D1\u5BA4", "\u6302\u53F7\u8D39" }));
		scrollPane_1.setViewportView(StaffList);

		SearchStaffButton = new DarkButton("\u67E5\u8BE2");
		SearchStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchStaff();
			}
		});
		SearchStaffButton.setBounds(560, 47, 87, 27);
		contentPane.add(SearchStaffButton);

		AddStaffButton = new DarkButton("\u589E\u52A0\u804C\u5DE5");
		AddStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff A = new AddStaff();
				A.setVisible(true);
				MyTable.colorizeTabel(StaffList);
			}
		});
		AddStaffButton.setBounds(142, 338, 113, 27);
		contentPane.add(AddStaffButton);

		DeleteStaffButton = new LightButton("\u804C\u5DE5\u79BB\u9662");
		DeleteStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tp="DELETE_STAFF";
				int count=StaffList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "请选择职工", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = (String) StaffList.getValueAt(count, 0);
					System.out.println(N);
					StaffModel staff=new StaffModel();
					staff.setCard(N);
					Message message=new Message(tp,staff);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message recevied=client.sendAndReceive(message);
						if(recevied.isResponse()) {
							JOptionPane.showMessageDialog(null, "职工离院成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "职工离院失败", "错误", JOptionPane.ERROR_MESSAGE);
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
		DeleteStaffButton.setBounds(407, 338, 113, 27);
		contentPane.add(DeleteStaffButton);

		lblNewLabel = new JLabel("\u804C\u5DE5\u59D3\u540D");
		lblNewLabel.setBounds(38, 52, 72, 18);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_1.setBounds(293, 52, 72, 18);
		contentPane.add(lblNewLabel_1);

		Nametxt = new JTextField();
		Nametxt.setBounds(119, 50, 86, 24);
		contentPane.add(Nametxt);
		Nametxt.setColumns(10);

		DepartmentBox.setBounds(352, 50, 102, 24);
		contentPane.add(DepartmentBox);

		//this.filltable(new StaffModel());
		this.fillComBox();

	}

	public void SearchStaff() {
		DefaultTableModel dtm = (DefaultTableModel) StaffList.getModel();
		dtm.setRowCount(0);
		String name = Nametxt.getText();
		Department department = (Department) DepartmentBox.getSelectedItem();
		StaffModel staff = new StaffModel();
		staff.setStaff_Name(name);
		staff.setStaff_Department(department.getDepartment_Name());
		Message message = new Message(Type, staff);
		message.setCheckCode(check);
		client.TheClient client = new TheClient();
		try {
			Message received = client.sendAndReceive(message);
			Vector<StaffModel> temp = new Vector<StaffModel>();
			temp = received.getSvector();
			for (int i = 0; i < temp.size(); i++) {
				Vector s = new Vector();
				StaffModel staff1 = temp.get(i);
				s.add(staff1.getCard());
				System.out.println(s);
				s.add(staff1.getStaff_Name());
				s.add(staff1.getStaff_Sex());
				s.add(staff1.getStaff_Identity());
				s.add(staff1.getStaff_WorkTime());
				s.add(staff1.getStaff_Department());
				s.add(staff1.getStaff_Fee());
				dtm.addRow(s);
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

	public void fillComBox() {
		String tp = "RETURN_DPLIST";
		Message message = new Message();
		message.setCheckCode(check);
		message.setType(tp);
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
			Vector<Department> v = received.getDvector();
			for (int i = 0; i < v.size(); i++) {
				Department Dpa = new Department();
				Dpa.setDepartment_Name(v.get(i).getDepartment_Name());
				DepartmentBox.addItem(Dpa);
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

	public void filltable(StaffModel stf) {
		DefaultTableModel dtm = (DefaultTableModel) StaffList.getModel();
		dtm.setRowCount(0);
		String tp = "RETURN_STAFFLIST";
		Message message = new Message();
		message.setCheckCode(check);
		message.setType(tp);
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
			Vector<StaffModel> v = new Vector<StaffModel>();
			v = received.getSvector();
			System.out.println(v.size());
			for (int i = 0; i < v.size(); i++) {
				Vector s = new Vector();
				StaffModel staff = v.get(i);
				System.out.println(staff.getCard());
				s.add(staff.getCard());
				s.add(staff.getStaff_Name());
				s.add(staff.getStaff_Sex());
				s.add(staff.getStaff_Identity());
				s.add(staff.getStaff_WorkTime());
				s.add(staff.getStaff_Department());
				s.add(staff.getStaff_Fee());
				dtm.addRow(v);
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
