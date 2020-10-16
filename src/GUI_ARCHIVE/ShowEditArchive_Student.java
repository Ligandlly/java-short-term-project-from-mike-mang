package GUI_ARCHIVE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arcmodel.Archive;
import Arcmodel.log;
import Message.Message;
import client.TheClient;
import com.Hospital.Ubtil.*;
import arcdao.Arcdao;
import user.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ShowEditArchive_Student extends JFrame {

	private JPanel contentPane;
	private JTextField Birthtext;
	private JTextField IDnumbertext;
	private JTextField Collegetext;
	private JTextField Majortext;
	private JTextField Agetext;
	private JTextField Nametext;
	private JTextField Nationtext;
	private JTextField Eductiontext;
	private JTextField Politicstext;
	private JTextField Cardtext;
	private JTextField Enrolltext;
	private JTextField Nativetext;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	private String temp;
	private JTextField Telephonetext;
	private static String Type1 = "Archive_View";
	private static String Type2 = "Archive_Edit";
	private static String Type3 = "Log_Insert";
	private static int check = 4;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					User u1 = new User();
					u1.card="213180003";
					
					ShowEditArchive_Student frame = new ShowEditArchive_Student(u1);
					frame.setVisible(true);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the frame.
	 */
	static Archive arc = new Archive();


	public ShowEditArchive_Student(User user) {
		setBackground(Color.WHITE);
		setTitle("\u67E5\u770B\u4FEE\u6539\u6863\u6848");
		setSize(new Dimension(700, 433));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Edit(event, user);
				//LogInsert(event);
			}
		});
		btnNewButton.setBounds(388, 324, 97, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\u59D3  \u540D\uFF1A\r\n");
		lblNewLabel.setBounds(26, 38, 58, 15);
		contentPane.add(lblNewLabel);

		JRadioButton WomanRadioButton = new JRadioButton("\u5973");
		WomanRadioButton.setEnabled(false);
		buttonGroup.add(WomanRadioButton);
		WomanRadioButton.setBackground(Color.WHITE);
		WomanRadioButton.setBounds(285, 34, 37, 23);
		contentPane.add(WomanRadioButton);

		JLabel lblNewLabel_2 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lblNewLabel_2.setBounds(374, 36, 66, 15);
		contentPane.add(lblNewLabel_2);

		Birthtext = new JTextField();
		Birthtext.setEditable(false);
		Birthtext.setColumns(10);
		Birthtext.setBounds(432, 33, 66, 21);
		contentPane.add(Birthtext);

		JLabel lblNewLabel_3 = new JLabel("\u6C11  \u65CF\uFF1A");
		lblNewLabel_3.setBounds(26, 87, 58, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u7C4D\u8D2F\uFF1A");
		lblNewLabel_4.setBounds(165, 96, 169, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_5.setBounds(374, 196, 66, 15);
		contentPane.add(lblNewLabel_5);

		IDnumbertext = new JTextField();
		IDnumbertext.setEditable(false);
		IDnumbertext.setColumns(10);
		IDnumbertext.setBounds(432, 193, 242, 21);
		contentPane.add(IDnumbertext);

		JLabel lblNewLabel_6 = new JLabel("\u5B66  \u5386\uFF1A");
		lblNewLabel_6.setBounds(26, 143, 58, 15);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_7.setBounds(165, 143, 169, 15);
		contentPane.add(lblNewLabel_7);

		Collegetext = new JTextField();
		Collegetext.setColumns(10);
		Collegetext.setBounds(199, 140, 132, 21);
		contentPane.add(Collegetext);

		JLabel lblNewLabel_8 = new JLabel("\u4E13   \u4E1A\uFF1A");
		lblNewLabel_8.setBounds(376, 142, 58, 15);
		contentPane.add(lblNewLabel_8);

		Majortext = new JTextField();
		Majortext.setColumns(10);
		Majortext.setBounds(433, 137, 66, 21);
		contentPane.add(Majortext);

		JLabel lblNewLabel_9 = new JLabel("\u5E74   \u9F84\uFF1A");
		lblNewLabel_9.setBounds(374, 87, 58, 15);
		contentPane.add(lblNewLabel_9);

		Agetext = new JTextField();
		Agetext.setColumns(10);
		Agetext.setBounds(432, 84, 66, 21);
		contentPane.add(Agetext);

		JLabel lblNewLabel_10 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		lblNewLabel_10.setBounds(26, 196, 66, 15);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_1 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_1.setBounds(164, 38, 58, 15);
		contentPane.add(lblNewLabel_1);

		JRadioButton ManRadioButton = new JRadioButton("\u7537");
		ManRadioButton.setSelected(true);
		ManRadioButton.setEnabled(false);
		buttonGroup.add(ManRadioButton);
		ManRadioButton.setBackground(Color.WHITE);
		ManRadioButton.setBounds(228, 34, 37, 23);
		contentPane.add(ManRadioButton);

		Nametext = new JTextField();
		Nametext.setColumns(10);
		Nametext.setBounds(82, 35, 66, 21);
		contentPane.add(Nametext);

		Nationtext = new JTextField();
		Nationtext.setEditable(false);
		Nationtext.setColumns(10);
		Nationtext.setBounds(81, 84, 66, 21);
		contentPane.add(Nationtext);

		Eductiontext = new JTextField();
		Eductiontext.setColumns(10);
		Eductiontext.setBounds(82, 140, 66, 21);
		contentPane.add(Eductiontext);

		Politicstext = new JTextField();
		Politicstext.setColumns(10);
		Politicstext.setBounds(82, 193, 66, 21);
		contentPane.add(Politicstext);

		JLabel lblNewLabel_11 = new JLabel("\u5A5A\u59FB\u72B6\u51B5\uFF1A");
		lblNewLabel_11.setBounds(164, 196, 66, 15);
		contentPane.add(lblNewLabel_11);

		JRadioButton YesRadioButton = new JRadioButton("\u5DF2\u5A5A");
		YesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = YesRadioButton.getText();
			}
		});
		buttonGroup_1.add(YesRadioButton);
		YesRadioButton.setBackground(Color.WHITE);
		YesRadioButton.setBounds(228, 192, 49, 23);
		contentPane.add(YesRadioButton);

		JRadioButton NotRadioButton = new JRadioButton("\u672A\u5A5A");
		NotRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = NotRadioButton.getText();
			}
		});
		buttonGroup_1.add(NotRadioButton);
		NotRadioButton.setSelected(true);
		NotRadioButton.setBackground(Color.WHITE);
		NotRadioButton.setBounds(285, 192, 58, 23);
		contentPane.add(NotRadioButton);

		JLabel lblNewLabel_12 = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel_12.setBounds(26, 251, 66, 15);
		contentPane.add(lblNewLabel_12);

		Cardtext = new JTextField();
		Cardtext.setEditable(false);
		Cardtext.setColumns(10);
		Cardtext.setBounds(82, 248, 66, 21);
		contentPane.add(Cardtext);

		JLabel lblNewLabel_13 = new JLabel("\u5165\u5B66\u65E5\u671F\uFF1A");
		lblNewLabel_13.setBounds(172, 251, 66, 15);
		contentPane.add(lblNewLabel_13);

		Enrolltext = new JTextField();
		Enrolltext.setEditable(false);
		Enrolltext.setColumns(10);
		Enrolltext.setBounds(248, 248, 85, 21);
		contentPane.add(Enrolltext);

		JLabel photoLabel = new JLabel("\u53CC\u51FB\u6DFB\u52A0\u7167\u7247");
		photoLabel.setPreferredSize(new Dimension(120, 140));
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		photoLabel.setBounds(542, 34, 120, 139);
		contentPane.add(photoLabel);

		JLabel lblNewLabel_14 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_14.setBounds(376, 251, 58, 15);
		contentPane.add(lblNewLabel_14);

		Telephonetext = new JTextField();
		Telephonetext.setBounds(432, 248, 143, 21);
		contentPane.add(Telephonetext);
		Telephonetext.setColumns(10);


		Nativetext = new JTextField();
		Nativetext.setEditable(false);
		Nativetext.setBounds(199, 84, 134, 21);
		contentPane.add(Nativetext);
		Nativetext.setColumns(10);
		
		fillall(user);
		Cardtext.setText(arc.getCard());
		Nametext.setText(arc.getName());
		Agetext.setText(arc.getAge());
		//arc.setText(arc.getSex());
		Birthtext.setText(arc.getBirthDate());
		IDnumbertext.setText(arc.getIDnumber());
		Nationtext.setText(arc.getNationality());
		Nativetext.setText(arc.getNativeplace());
		//arc.setText(arc.getMarriaged());
		Politicstext.setText(arc.getPolitical_status());
		Eductiontext.setText(arc.getEducation());
		Collegetext.setText(arc.getCollege());
		Majortext.setText(arc.getMajor());
		Enrolltext.setText(arc.getEnrollment_date());
		Telephonetext.setText(arc.getTelephone());

	}

	protected void Edit(ActionEvent event, User user) {

		arc.setName(Nametext.getText());
		arc.setAge(Agetext.getText());
		arc.setTelephone(Telephonetext.getText());
		arc.setMarriaged(temp);
		arc.setPolitical_status(Politicstext.getText());
		arc.setEducation(Eductiontext.getText());
		arc.setCollege(Collegetext.getText());
		arc.setMajor(Majortext.getText());
		
		

		 Message message = new Message(Type2, arc);

		 message.setCheckCode(check);
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
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
	
		/**
		 * 传送流
		 */
		
		try {
			if (received.isResponse()) {
				LogInsert(user);//修改成功则记录
				JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "修改失败，请重新修改", "错误", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 还需添加流，以及message的传送
	 * 
	 * @param event
	 */

	private void resetValue() {

		this.Collegetext.setText("");
		this.Majortext.setText("");
		this.Agetext.setText("");
		this.Nametext.setText("");
		this.Eductiontext.setText("");
		this.Politicstext.setText("");
		this.Telephonetext.setText("");

	}
	
	private static void fillall(User user) {
		String uString=user.card;
		Archive s = new Archive();
		
		s.setCard(uString);
		
		Message message = new Message(Type1, s);
		message.setCheckCode(check);
		client.TheClient client = new TheClient();

		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
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
	 s = (Archive) received.getAllembracing();
	  arc = s;
	  
				
		arc.setCard(s.getCard());
		arc.setName(s.getName());
		arc.setAge(s.getAge());
		arc.setSex(s.getSex());
		arc.setBirthDate(s.getBirthDate());
		arc.setIDnumber(s.getIDnumber());
		arc.setNationality(s.getNationality());
		arc.setNativeplace(s.getNativeplace());
		arc.setMarriaged(s.getMarriaged());
		arc.setPolitical_status(s.getPolitical_status());
		arc.setEducation(s.getEducation());
		arc.setCollege(s.getCollege());
		arc.setMajor(s.getMajor());
		arc.setEnrollment_date(s.getEnrollment_date());
		arc.setTelephone(s.getTelephone());
	}

	private static void LogInsert(User user) {
		log change=new log();
		
		Date date=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化为日期/时间字符串
        String cc=sdf.format(date);
       
		// change.Carc.setCard(arc.getCard());
		// change.Carc.setName(arc.getName());
		change.setChanger(user.name);
		change.setChange_Time(cc);

		Message message = new Message(Type3, change);
		message.setCheckCode(check);
		message.setS(arc.getCard());
		message.setS2(arc.getName());
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
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
