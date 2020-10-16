package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import HospitalModel.Department;
import HospitalModel.Regist;
import HospitalModel.StaffModel;
import Message.Message;
import client.TheClient;
import gui.DarkButton;
import gui.LightButton;
import gui.MyTable;
import user.User;

import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AddRegist extends JFrame {

	private JPanel contentPane;
	private JTextField Nametxt;
	private JTable Doctortable;
	private String Type = "ADD_REGIST";
	private JComboBox DepBox;
	private int check = 5;
	private String test1="213180316";
	private String test2="Ӣ��";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRegist frame = new AddRegist(new User());
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
	public AddRegist(User user) {
		setTitle("\u6302\u53F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 83, 564, 183);
		contentPane.add(scrollPane);

		Doctortable = new MyTable();
		Doctortable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u533B\u751F\u59D3\u540D",
				"\u79D1\u5BA4", "\u4E0A\u73ED\u65F6\u95F4", "\u6302\u53F7\u8D39" }));
		scrollPane.setViewportView(Doctortable);

		JLabel lblNewLabel = new JLabel("\u533B\u751F\u59D3\u540D");
		lblNewLabel.setBounds(56, 40, 72, 18);
		contentPane.add(lblNewLabel);

		Nametxt = new JTextField();
		Nametxt.setBounds(161, 37, 86, 24);
		contentPane.add(Nametxt);
		Nametxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u79D1\u5BA4");
		lblNewLabel_1.setBounds(319, 40, 72, 18);
		contentPane.add(lblNewLabel_1);

		DepBox = new JComboBox();
		DepBox.setBounds(420, 37, 86, 24);
		contentPane.add(DepBox);

		JButton SearchButton = new DarkButton("\u67E5\u8BE2");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchStaff();
			}
		});
		SearchButton.setBounds(546, 36, 86, 27);
		contentPane.add(SearchButton);

		JButton RegistButton = new LightButton("\u6302\u53F7");
		RegistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = Doctortable.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "未选择医生", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String N = Doctortable.getValueAt(count, 0).toString();
					double fee=Double.valueOf(Doctortable.getValueAt(count, 3).toString());
					System.out.println(fee);
					Department d=(Department)DepBox.getSelectedItem();
					Regist regist=new Regist();
					regist.setCard(user.card);
					regist.setRegist_Name(user.name);
					regist.setRegist_Doctor(N);
					regist.setRegist_Fee(fee);
					regist.setRegist_Status("新开");
					regist.setRegist_Department(d.getDepartment_Name());
					Date date=new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        //格式化为日期/时间字符串
			        String cc=sdf.format(date);
					regist.setRegist_Time(cc);
					Message message=new Message(Type,regist);
					message.setCheckCode(check);
					client.TheClient client=new TheClient();
					try {
						Message received=client.sendAndReceive(message);
						if(received.isResponse()) {
							JOptionPane.showMessageDialog(null, "挂号成功", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "挂号失败，请重试", "错误", JOptionPane.DEFAULT_OPTION);
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
		RegistButton.setBounds(56, 327, 113, 27);
		contentPane.add(RegistButton);

		JButton DeleteButton = new DarkButton("\u9000\u53F7");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		DeleteButton.setBounds(507, 327, 113, 27);
		contentPane.add(DeleteButton);
		
		this.fillcombox();
		// TODO  For testing only fillcombox method removed here
	}

	public void fillcombox() {
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
				DepBox.addItem(Dpa);
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
	
	public void SearchStaff() {
		DefaultTableModel dtm = (DefaultTableModel) Doctortable.getModel();
		dtm.setRowCount(0);
		String name = Nametxt.getText();
		String tp="SEARCH_STAFF";
		Department department = (Department) DepBox.getSelectedItem();
		StaffModel staff = new StaffModel();
		staff.setStaff_Name(name);
		staff.setStaff_Department(department.getDepartment_Name());
		Message message = new Message(tp, staff);
		message.setCheckCode(check);
		client.TheClient client = new TheClient();
		try {
			Message received = client.sendAndReceive(message);
			Vector<StaffModel> temp = new Vector<StaffModel>();
			temp = received.getSvector();
			for (int i = 0; i < temp.size(); i++) {
				Vector s = new Vector();
				StaffModel staff1 = temp.get(i);
				s.add(staff1.getStaff_Name());
				s.add(staff1.getStaff_Department());
				s.add(staff1.getStaff_WorkTime());
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
		MyTable.colorizeTabel(Doctortable);
	}
}
