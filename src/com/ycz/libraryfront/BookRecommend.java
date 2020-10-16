package com.ycz.libraryfront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ycz.model.TbBookorderinfo;
import Message.Message;
import client.TheClient;
import gui.DarkButton;
import gui.DarkLabel;
import gui.LightButton;
import gui.LightLabel;
import gui.LightTextField;
import user.User;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class BookRecommend extends JFrame {

	private JPanel contentPane;
	private JTextField textISBN;
	private User person;
	private int check = 3;

	private String Type1 = "SEARCH_BOOKORDERINFO";// SearchBookorderinfo
	private String Type2 = "INSERT_BOOKORDERINFO";
	private String Type3 = "INCREASE_BOOKORDERNUMBER";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User person = new User("213183069", "喻慈舟", "student");
					BookRecommend frame = new BookRecommend(person);
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
	public BookRecommend(User person) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(BookRecommend.class.getResource("/com/ycz/images/tushu.png")));
		setTitle("荐购小卡片");
		setPreferredSize(new Dimension(700, 433));
		setSize(new Dimension(700, 433));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700, 433));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblIsbn = new DarkLabel("ISBN");
		lblIsbn.setBounds(146, 84, 84, 21);
		panel.add(lblIsbn);

		textISBN = new LightTextField();
		textISBN.setBounds(230, 84, 228, 21);
		panel.add(textISBN);
		textISBN.setColumns(10);

		JButton btnRecommend = new DarkButton("确认荐购");
		btnRecommend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 如果输入信息有误，提示重新输入！
				if (textISBN.getText().isBlank() )
					JOptionPane.showMessageDialog(null, "请输入ISBN号！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				else {
					// SearchBookorderinfo(Connection con, TbBookorderinfo book)
					TbBookorderinfo book = new TbBookorderinfo();
					book.setISBN(textISBN.getText());
					Message message1 = new Message(Type1, book);
					message1.setCheckCode(check);
					TheClient client1 = new TheClient();
					Message received1 = new Message();
					try {
						received1 = client1.sendAndReceive(message1);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					book = (TbBookorderinfo) received1.getAllembracing();
					Calendar cal = Calendar.getInstance();// 荐购日期：本地时间
					String order_time = String.valueOf(cal.getTime());
					if (book.getOrderDate() == null) {// 如果这本书没有被荐购过
						book.setOrderDate(order_time);
						book.setISBN(textISBN.getText());
						book.setNumber(1);
						book.setCheckAndAccept("false");
						Message message2 = new Message(Type2, book);
						message2.setCheckCode(check);
						TheClient client2 = new TheClient();
						Message received2 = new Message();
						try {
							received2 = client2.sendAndReceive(message2);
							if (received2.isResponse()) {
								JOptionPane.showMessageDialog(null, "荐购成功！", "图书管理小精灵",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "荐购失败！", "图书管理小精灵",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {// 如果这本书被荐购过
						book.setOrderDate(order_time);
						book.setISBN(textISBN.getText());
						int oldnumber = book.getNumber();
						book.setNumber(oldnumber + 1);
						Message message3 = new Message(Type3, book);
						message3.setCheckCode(check);
						TheClient client3 = new TheClient();
						Message received3 = new Message();
						try {
							received3 = client3.sendAndReceive(message3);
							if (received3.isResponse()) {
								JOptionPane.showMessageDialog(null, "荐购成功！", "图书管理小精灵",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "荐购失败！", "图书管理小精灵",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}

			}
		});
		btnRecommend.setBounds(415, 189, 93, 23);
		panel.add(btnRecommend);

		JLabel lblTipsisbn = new LightLabel("Tips：请准确填写预荐购图书的ISBN号。我们将尽快购买！");
		lblTipsisbn.setBounds(146, 296, 336, 15);
		panel.add(lblTipsisbn);
	}
}
