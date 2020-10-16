package com.ycz.libraryfront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.dao.BookDao;
import com.ycz.dao.ReaderDao;
import com.ycz.model.TbBookinfo;
import com.ycz.model.TbReaderinfo;
import gui.DarkLabel;
// import com.ycz.net.TheClient;

import Message.Message;
import client.TheClient;
import user.User;

import java.awt.Dimension;
import java.awt.FlowLayout;
//import javax.swing.DarkLabel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import gui.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyCard extends JFrame {

	private JPanel contentPane;
	private JTextField textCard;
	private JTextField textReaderName;
	private JTextField textReputation;
	private JTextField textInstitude;
	private JTextField textBmaxnum;
	private JTextField textSmaxnum;
	private String Type1 = "GET_READERINFO";//getReaderinfo
	private User person;
	private int check=3;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User person = new User("213183069", "喻慈舟", "student");
					MyCard frame = new MyCard(person);
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
	public MyCard(User person) {
		setSize(new Dimension(700, 433));
		setResizable(false);
		setTitle("证件信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(700, 433));
		panel.setPreferredSize(new Dimension(700, 433));
		//panel.setBounds(10, 10, 426, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(48, 30, 128, 86);
		lblNewLabel_2.setIcon(new ImageIcon(MyCard.class.getResource("/com/ycz/images/读者证 (1).png")));
		panel.add(lblNewLabel_2);
		
		textCard = new LightTextField();
		textCard.setEditable(false);
		textCard.setBounds(478, 32, 144, 31);
		panel.add(textCard);
		textCard.setColumns(10);
		
		DarkLabel lblNewLabel_1 = new DarkLabel("一卡通号");
		lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(375, 32, 103, 31);
		panel.add(lblNewLabel_1);
		
		DarkLabel lblNewLabel_4 = new DarkLabel("姓名");
		lblNewLabel_4.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(375, 85, 103, 31);
		panel.add(lblNewLabel_4);
		
		textReaderName = new LightTextField();
		textReaderName.setEditable(false);
		textReaderName.setColumns(10);
		textReaderName.setBounds(478, 85, 144, 31);
		panel.add(textReaderName);
		
		DarkLabel lblNewLabel_1_1 = new DarkLabel("信誉\r\n");
		lblNewLabel_1_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(63, 172, 97, 31);
		panel.add(lblNewLabel_1_1);
		
		textReputation = new LightTextField();
		textReputation.setEditable(false);
		textReputation.setColumns(10);
		textReputation.setBounds(160, 172, 177, 31);
		panel.add(textReputation);
		
		DarkLabel lblNewLabel_1_1_1 = new DarkLabel("学院");
		lblNewLabel_1_1_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(375, 172, 103, 31);
		panel.add(lblNewLabel_1_1_1);
		
		textInstitude = new LightTextField();
		textInstitude.setEditable(false);
		textInstitude.setColumns(10);
		textInstitude.setBounds(478, 172, 144, 31);
		panel.add(textInstitude);
		
		DarkLabel lblNewLabel_1_1_2 = new DarkLabel("最大借书数量");
		lblNewLabel_1_1_2.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(63, 248, 97, 31);
		panel.add(lblNewLabel_1_1_2);
		
		DarkLabel lblNewLabel_1_1_2_1 = new DarkLabel("最大预约数量");
		lblNewLabel_1_1_2_1.setFont(new Font("幼圆", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(375, 248, 103, 31);
		panel.add(lblNewLabel_1_1_2_1);
		
		textBmaxnum = new LightTextField();
		textBmaxnum.setEditable(false);
		textBmaxnum.setColumns(10);
		textBmaxnum.setBounds(160, 248, 177, 31);
		panel.add(textBmaxnum);
		
		textSmaxnum = new LightTextField();
		textSmaxnum.setEditable(false);
		textSmaxnum.setColumns(10);
		textSmaxnum.setBounds(478, 248, 144, 31);
		panel.add(textSmaxnum);
		
		JButton btnReturn = new LightButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // 设置按下右上角X号后关闭
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnReturn.setIcon(new ImageIcon(MyCard.class.getResource("/com/ycz/images/返回 (1).png")));
		btnReturn.setBounds(478, 330, 144, 36);
		panel.add(btnReturn);
		System.out.println("进入文本框初始化函数之前");
		this.filltext(new TbReaderinfo(),person);// 初始化文本框
	}
	
	private void filltext(TbReaderinfo reader,User person) {
		//先获取与数据库的连接
//		Connection con = null;
//		Library_dbUtil b = new Library_dbUtil();
		try {
			System.out.println("开始填写文本框");
//			con = b.getCon();
			//通过user ID获取读者详细信息
			TbReaderinfo reader1 = new TbReaderinfo();
			reader1.setCard(person.card);
			//去数据库查找reader
			System.out.println("查找数据库前的读者信息为："+reader1);
			//得到前端要传给后端的内容
			//将内容放入Message，指定调用方法的类型
			Message message = new Message(Type1,reader1);
			//指定调用的模块，check = 3
			message.setCheckCode(check);
			//生成客户端，新建一个线程
			TheClient client = new TheClient();
			//从服务端获得的内容会存在Message received中
			Message received = new Message();
			received = client.sendAndReceive(message);
			reader1= (TbReaderinfo)received.getAllembracing();
			//reader1 = ReaderDao.getReaderinfo(con, reader1);
			System.out.println("查找数据库之后的读者信息为："+reader1);
			textCard.setText(reader1.getCard());
			textReaderName.setText(reader1.getReaderName());
			textReputation.setText(String.valueOf(reader1.getReputation()));
			textInstitude.setText(reader1.getInstitude());
			textBmaxnum.setText(reader1.getBmaxnum());
			textSmaxnum.setText(reader1.getSmaxnum());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
}
