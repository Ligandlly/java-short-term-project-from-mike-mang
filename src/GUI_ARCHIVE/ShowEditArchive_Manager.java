package GUI_ARCHIVE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Arcmodel.Archive;
import Arcmodel.log;
import Message.Message;
import client.TheClient;
import user.User;
import arcdao.Arcdao;
import GUI_ARCHIVE.ChooseStudent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ShowEditArchive_Manager extends JFrame {

	private JPanel contentPane;
	private JTextField Birthtext;
	private JTextField Nativetext;
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
	private JTextField Telephonetext;
	private static String Type1 = "Archive_View";
	private static String Type2 = "Archive_Edit";
	private static String Type3 = "Log_Insert";
	private static int check = 4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//			ShowEditArchive_Manager frame = new ShowEditArchive_Manager();
//				frame.setVisible(true);
//						
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}	
//				}
//		});
//	}

	/**
	 * Create the frame.
	 */
	static Archive arc = new Archive();
	public ShowEditArchive_Manager(Archive s,User user) {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("\u67E5\u770B\u4FEE\u6539\u6863\u6848\uFF08\u7BA1\u7406\u7AEF\uFF09");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3  \u540D\uFF1A\r\n");
		lblNewLabel.setBounds(10, 52, 58, 15);
		contentPane.add(lblNewLabel);
		
		JRadioButton WomanRadioButton = new JRadioButton("\u5973");
		WomanRadioButton.setEnabled(false);
		WomanRadioButton.setBackground(Color.WHITE);
		WomanRadioButton.setBounds(269, 48, 37, 23);
		contentPane.add(WomanRadioButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lblNewLabel_2.setBounds(358, 50, 66, 15);
		contentPane.add(lblNewLabel_2);
		
		Birthtext = new JTextField();
		Birthtext.setColumns(10);
		Birthtext.setBounds(416, 47, 66, 21);
		contentPane.add(Birthtext);
		
		JLabel lblNewLabel_3 = new JLabel("\u6C11  \u65CF\uFF1A");
		lblNewLabel_3.setBounds(10, 101, 58, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7C4D\u8D2F\uFF1A");
		lblNewLabel_4.setBounds(148, 101, 169, 15);
		contentPane.add(lblNewLabel_4);
		
		Nativetext = new JTextField();
		Nativetext.setColumns(10);
		Nativetext.setBounds(183, 98, 134, 21);
		contentPane.add(Nativetext);
		
		JLabel lblNewLabel_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_5.setBounds(358, 210, 66, 15);
		contentPane.add(lblNewLabel_5);
		
		IDnumbertext = new JTextField();
		IDnumbertext.setColumns(10);
		IDnumbertext.setBounds(422, 207, 242, 21);
		contentPane.add(IDnumbertext);
		
		JLabel lblNewLabel_6 = new JLabel("\u5B66  \u5386\uFF1A");
		lblNewLabel_6.setBounds(10, 157, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_7.setBounds(148, 157, 169, 15);
		contentPane.add(lblNewLabel_7);
		
		Collegetext = new JTextField();
		Collegetext.setColumns(10);
		Collegetext.setBounds(183, 154, 132, 21);
		contentPane.add(Collegetext);
		
		JLabel lblNewLabel_8 = new JLabel("\u4E13   \u4E1A\uFF1A");
		lblNewLabel_8.setBounds(360, 156, 58, 15);
		contentPane.add(lblNewLabel_8);
		
		Majortext = new JTextField();
		Majortext.setColumns(10);
		Majortext.setBounds(417, 151, 66, 21);
		contentPane.add(Majortext);
		
		JLabel lblNewLabel_9 = new JLabel("\u5E74   \u9F84\uFF1A");
		lblNewLabel_9.setBounds(358, 101, 58, 15);
		contentPane.add(lblNewLabel_9);
		
		Agetext = new JTextField();
		Agetext.setEnabled(false);
		Agetext.setColumns(10);
		Agetext.setBounds(416, 98, 66, 21);
		contentPane.add(Agetext);
		
		JLabel lblNewLabel_10 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		lblNewLabel_10.setBounds(10, 210, 66, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_1.setBounds(148, 52, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton ManRadioButton = new JRadioButton("\u7537");
		ManRadioButton.setSelected(true);
		ManRadioButton.setEnabled(false);
		ManRadioButton.setBackground(Color.WHITE);
		ManRadioButton.setBounds(212, 48, 37, 23);
		contentPane.add(ManRadioButton);
		
		Nametext = new JTextField();
		Nametext.setEnabled(false);
		Nametext.setColumns(10);
		Nametext.setBounds(66, 49, 66, 21);
		contentPane.add(Nametext);
		
		Nationtext = new JTextField();
		Nationtext.setColumns(10);
		Nationtext.setBounds(65, 98, 66, 21);
		contentPane.add(Nationtext);
		
		Eductiontext = new JTextField();
		Eductiontext.setColumns(10);
		Eductiontext.setBounds(66, 154, 66, 21);
		contentPane.add(Eductiontext);
		
		Politicstext = new JTextField();
		Politicstext.setColumns(10);
		Politicstext.setBounds(66, 207, 66, 21);
		contentPane.add(Politicstext);
		
		JLabel lblNewLabel_11 = new JLabel("\u5A5A\u59FB\u72B6\u51B5\uFF1A");
		lblNewLabel_11.setBounds(148, 210, 66, 15);
		contentPane.add(lblNewLabel_11);
		
		JRadioButton YesRadioButton = new JRadioButton("\u5DF2\u5A5A");
		YesRadioButton.setEnabled(false);
		YesRadioButton.setBackground(Color.WHITE);
		YesRadioButton.setBounds(212, 206, 49, 23);
		contentPane.add(YesRadioButton);
		
		JRadioButton NotRadioButton = new JRadioButton("\u672A\u5A5A");
		NotRadioButton.setSelected(true);
		NotRadioButton.setEnabled(false);
		NotRadioButton.setBackground(Color.WHITE);
		NotRadioButton.setBounds(269, 206, 58, 23);
		contentPane.add(NotRadioButton);
		
		JLabel lblNewLabel_12 = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel_12.setBounds(10, 265, 66, 15);
		contentPane.add(lblNewLabel_12);
		
		Cardtext = new JTextField();
		Cardtext.setColumns(10);
		Cardtext.setBounds(66, 262, 66, 21);
		contentPane.add(Cardtext);
		
		JLabel lblNewLabel_13 = new JLabel("\u5165\u5B66\u65E5\u671F\uFF1A");
		lblNewLabel_13.setBounds(156, 265, 66, 15);
		contentPane.add(lblNewLabel_13);
		
		Enrolltext = new JTextField();
		Enrolltext.setColumns(10);
		Enrolltext.setBounds(232, 262, 85, 21);
		contentPane.add(Enrolltext);
		
		JLabel photoLabel = new JLabel("\u53CC\u51FB\u6DFB\u52A0\u7167\u7247");
		photoLabel.setEnabled(false);
		photoLabel.setPreferredSize(new Dimension(120, 140));
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		photoLabel.setBounds(526, 48, 120, 139);
		contentPane.add(photoLabel);
		
		Telephonetext = new JTextField();
		Telephonetext.setEnabled(false);
		Telephonetext.setColumns(10);
		Telephonetext.setBounds(414, 259, 143, 21);
		contentPane.add(Telephonetext);
		
		JLabel lblNewLabel_14 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_14.setBounds(358, 262, 58, 15);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Edit(event,user);
				//Changelog(event);
			}

			
		});
		btnNewButton.setBounds(372, 345, 97, 23);
		contentPane.add(btnNewButton);
		
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
		
		Cardtext.setText(s.getCard());
		Nametext.setText(s.getName());
		Agetext.setText(s.getAge());
		//arc.setText(s.getSex());
		Birthtext.setText(s.getBirthDate());
		IDnumbertext.setText(s.getIDnumber());
		Nationtext.setText(s.getNationality());
		Nativetext.setText(s.getNativeplace());
		//arc.setText(s.getMarriaged());
		Politicstext.setText(s.getPolitical_status());
		Eductiontext.setText(s.getEducation());
		Collegetext.setText(s.getCollege());
		Majortext.setText(s.getMajor());
		Enrolltext.setText(s.getEnrollment_date());
		Telephonetext.setText(s.getTelephone());
		
	}
	
	

	protected void Edit(ActionEvent event,User user) {
		arc.setCard(Cardtext.getText());
	
		arc.setBirthDate (Birthtext.getText());
		arc.setIDnumber (IDnumbertext.getText());
		arc.setNationality (Nationtext.getText());
		arc.setNativeplace (Nativetext.getText());
		//arc.setMarriaged(temp2);
		arc.setPolitical_status (Politicstext.getText());
		arc.setEducation (Eductiontext.getText());
		arc.setCollege (Collegetext.getText());
		arc.setMajor (Majortext.getText());
		arc.setEnrollment_date (Enrolltext.getText());
		//arc.setTelephone(Telephonetext.getText());
	

		 Message message = new Message(Type2, arc);
		 message.setS(user.name);

		 message.setCheckCode(check);
		client.TheClient client = new TheClient();
		Message received = new Message();
		try {
			received = client.sendAndReceive(message);
			if(received.isResponse()) {
				LogInsert(user);//修改成功则记录
				JOptionPane.showMessageDialog(null, "修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败，请重新修改", "错误", JOptionPane.ERROR_MESSAGE);
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
	
	/**
	 * 传送流
	 */

	
}
	
	/**
	 * 还需添加流，以及message的传送
	 * @param event
	 */
	protected void registeredOk(ActionEvent event) {//注册
		Archive arc = new Archive();
			
			
		}
	private void resetValue() {

		this.Birthtext.setText("");
		this.Nativetext.setText("");
		this.IDnumbertext.setText("");
		this.Collegetext.setText("");
		this.Majortext.setText("");
		//this.Agetext.setText("");
		//this.Nametext.setText("");
		this.Nationtext.setText("");
		this.Eductiontext.setText("");
		this.Politicstext.setText("");
		this.Cardtext.setText("");
		this.Enrolltext.setText("");
		//this.Telephonetext.setText("");
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
