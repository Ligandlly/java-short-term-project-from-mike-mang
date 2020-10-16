package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalDAO.StaffDAO;
import HospitalModel.StaffModel;
import Message.Message;
import client.TheClient;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import gui.DarkButton;
import gui.LightButton;
import gui.LightTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class AddStaff extends JFrame {

	private JPanel contentPane;
	private LightTextField CardTxt;
	private LightTextField NameTxt;
	private LightTextField WorkTimeTxt;
	private LightTextField DepartmentTxt;
	private LightTextField FeeTxt;
	private String testCard = "\\d{9}";
	private String Fee = "\\d{1,}+\\.+\\d{1,2}";
	private String Tag = "ADD_STAFF";
	private String temp="男";
	private int check = 5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff frame = new AddStaff();
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
	public AddStaff() {
		setTitle("\u6DFB\u52A0\u804C\u5DE5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JPanel AddStaffpanel = new JPanel();
		AddStaffpanel.setSize(700, 433);
		contentPane.add(AddStaffpanel);
		AddStaffpanel.setLayout(null);

		JLabel CardLabel = new JLabel("\u4E00\u5361\u901A\u53F7");
		CardLabel.setBounds(48, 50, 72, 18);
		AddStaffpanel.add(CardLabel);

		JLabel NameLabel = new JLabel("\u59D3\u540D");
		NameLabel.setBounds(48, 98, 72, 18);
		AddStaffpanel.add(NameLabel);

		JLabel SexLabel = new JLabel("\u6027\u522B");
		SexLabel.setBounds(48, 150, 72, 18);
		AddStaffpanel.add(SexLabel);

		JLabel WorkTimeLabel = new JLabel("\u5DE5\u4F5C\u65F6\u6BB5");
		WorkTimeLabel.setBounds(48, 200, 72, 18);
		AddStaffpanel.add(WorkTimeLabel);

		JLabel DepartmentLabel = new JLabel("\u79D1\u5BA4");
		DepartmentLabel.setBounds(48, 250, 72, 18);
		AddStaffpanel.add(DepartmentLabel);

		JLabel FeeLabel = new JLabel("\u6302\u53F7\u8D39");
		FeeLabel.setBounds(48, 300, 72, 18);
		AddStaffpanel.add(FeeLabel);

		JRadioButton ManRadioButton = new JRadioButton("\u7537");
		ManRadioButton.setSelected(true);
		buttonGroup.add(ManRadioButton);
		ManRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = ManRadioButton.getText();
			}
		});
		ManRadioButton.setBounds(147, 150, 72, 18);
		AddStaffpanel.add(ManRadioButton);

		JRadioButton WomanRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(WomanRadioButton);
		WomanRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = WomanRadioButton.getText();
			}
		});
		WomanRadioButton.setBounds(259, 150, 72, 18);
		AddStaffpanel.add(WomanRadioButton);

		CardTxt = new LightTextField();
		CardTxt.setBounds(147, 47, 277, 24);
		AddStaffpanel.add(CardTxt);
		CardTxt.setColumns(10);

		NameTxt = new LightTextField();
		NameTxt.setBounds(147, 95, 277, 24);
		AddStaffpanel.add(NameTxt);
		NameTxt.setColumns(10);

		WorkTimeTxt = new LightTextField();
		WorkTimeTxt.setBounds(147, 197, 277, 24);
		AddStaffpanel.add(WorkTimeTxt);
		WorkTimeTxt.setColumns(10);

		DepartmentTxt = new LightTextField();
		DepartmentTxt.setBounds(147, 247, 277, 24);
		AddStaffpanel.add(DepartmentTxt);
		DepartmentTxt.setColumns(10);

		FeeTxt = new LightTextField();
		FeeTxt.setBounds(147, 297, 277, 24);
		AddStaffpanel.add(FeeTxt);
		FeeTxt.setColumns(10);

		JButton OKButton = new DarkButton("\u786E\u8BA4");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickOK) {
				AddStaffOk(clickOK);
			}
		});
		OKButton.setBounds(83, 371, 113, 27);
		AddStaffpanel.add(OKButton);

		JButton ResetButton = new LightButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				resetValueActionPerformed(click);
			}
		});
		ResetButton.setBounds(349, 371, 113, 27);
		AddStaffpanel.add(ResetButton);
	}

	/**
	 * ���ȷ�ϰ�ť
	 * 
	 * @param clickOK
	 */
	protected void AddStaffOk(ActionEvent clickOK) {
		StaffModel staff = new StaffModel();
		boolean a = true;
		if (CardTxt.getText().matches(testCard)) {
		} else {
			JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
			a = false;
		}
		if (FeeTxt.getText().matches(Fee)) {
		} else {
			JOptionPane.showMessageDialog(null, "未正确设置挂号费", "错误", JOptionPane.ERROR_MESSAGE);
			a = false;
		}

		if (a == true) {
			staff.setCard(CardTxt.getText());
			staff.setStaff_Name(NameTxt.getText());
			staff.setStaff_Department(DepartmentTxt.getText());
			staff.setStaff_Sex(temp);
			System.out.println(temp);
			staff.setStaff_WorkTime(WorkTimeTxt.getText());
			staff.setStaff_Fee(Double.valueOf(FeeTxt.getText()));
			Message message = new Message(Tag, staff);
			message.setCheckCode(check);
			client.TheClient client=new TheClient();
			Message recevied=new Message();
			try {
				recevied=client.sendAndReceive(message);
				if (recevied.isResponse()==true) {
					JOptionPane.showMessageDialog(null, "添加职工成功", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "搜索不到职工信息或已经入院", "提示",JOptionPane.ERROR_MESSAGE);
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
	 * ���ý�������
	 * 
	 * @param click
	 */
	private void resetValueActionPerformed(ActionEvent click) {
		this.CardTxt.setText("");
		this.NameTxt.setText("");
		this.DepartmentTxt.setText("");
		this.FeeTxt.setText("");
		this.WorkTimeTxt.setText("");
	}
}
