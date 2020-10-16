package com.ycz.libraryfront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Vector;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.dao.BookDao;
import com.ycz.dao.BookborrowDao;
import com.ycz.dao.ReaderDao;
import com.ycz.model.TbBookborrowinfo;
import com.ycz.model.TbBookinfo;
import com.ycz.model.TbReaderinfo;
// import com.ycz.net.TheClient;

import Message.Message;
import client.TheClient;
import gui.DarkButton;
import gui.MyTable;
import user.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ReaderInfo extends JFrame {

	private String Type = "READER_INFO";
	private JPanel contentPane;
	private JTable ReaderList;
	private final JButton btnNewButton = new DarkButton("修改信息");
	private User person;
	private int check=3;
	
	private String Type1 = "CHANGE_READERINFO";//changeReaderinfo
	private String Type2 = "SHOW_READERS";//showReaders

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User person = new User("213183000", "周", "librarian");
					ReaderInfo frame = new ReaderInfo();
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
	public ReaderInfo() {
		setTitle("读者信息");
		setSize(new Dimension(700, 433));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 10, 696, 334);
		contentPane.add(scrollPane_1);

		ReaderList = new MyTable();
		ReaderList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u4E00\u5361\u901A\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5B66\u9662",
						"\u6700\u5927\u53EF\u501F\u4E66\u6570\u91CF", "\u6700\u5927\u53EF\u9884\u7EA6\u6570\u91CF",
						"\u4FE1\u8A89" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ReaderList.setSize(new Dimension(700, 433));
		scrollPane_1.setViewportView(ReaderList);
		//修改读者信息，可以修改：最大可借书数量，最大可预约书数量，信誉值
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = ReaderList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择读者！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					String currentBmaxnum = String.valueOf(ReaderList.getValueAt(count, 4));
					String currentSmaxnum = String.valueOf(ReaderList.getValueAt(count, 5));
					double currentrepu = Double.parseDouble(String.valueOf(ReaderList.getValueAt(count, 6)));
					System.out.println("修改后的最大可借书数量为："+currentBmaxnum);
					System.out.println("修改后的最大预约书数量为："+currentSmaxnum);
					System.out.println("修改后的信誉值为："+currentrepu);

					int result = JOptionPane.showConfirmDialog(null, "确认修改？");
					if (result == 0) {
						TbReaderinfo update_reader = new TbReaderinfo();
						update_reader.setBmaxnum(currentBmaxnum);
						update_reader.setSmaxnum(currentSmaxnum);
						update_reader.setReputation(currentrepu);
						update_reader.setCard(String.valueOf(ReaderList.getValueAt(count, 0)));
						System.out.println("要修改成："+update_reader);
						//得到前端要传给后端的内容
						//将内容放入Message，指定调用方法的类型
						Message message = new Message(Type1,update_reader);
						message.setCheckCode(check);
						TheClient client = new TheClient();
						Message received = new Message();
						
						try {
							received = client.sendAndReceive(message);
							if(received.isResponse()) {
								JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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
						
						
						
						//先建立与数据库的连接
//						Library_dbUtil D = new Library_dbUtil();
//						Connection con = null;
//						try {
//							con = D.getCon();// 得到与数据库的连接
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						try {
//							System.out.println("更新读者信息的结果为：" + ReaderDao.changeReaderinfo(con, update_reader));
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						JOptionPane.showMessageDialog(null, "修改读者信息成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					} else if (result == 1) {
					} else {
					}
				}

			}
		});
		btnNewButton.setBounds(558, 354, 136, 40);
		contentPane.add(btnNewButton);
		this.filltable(new TbReaderinfo());
		MyTable.colorizeTabel(ReaderList);
	}
	public ReaderInfo(User user) {
		setTitle("读者信息");
		setSize(new Dimension(700, 433));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 10, 696, 334);
		contentPane.add(scrollPane_1);

		ReaderList = new MyTable();
		ReaderList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u4E00\u5361\u901A\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5B66\u9662",
						"\u6700\u5927\u53EF\u501F\u4E66\u6570\u91CF", "\u6700\u5927\u53EF\u9884\u7EA6\u6570\u91CF",
						"\u4FE1\u8A89" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ReaderList.setSize(new Dimension(700, 433));
		scrollPane_1.setViewportView(ReaderList);
		//修改读者信息，可以修改：最大可借书数量，最大可预约书数量，信誉值
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = ReaderList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择读者！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					String currentBmaxnum = String.valueOf(ReaderList.getValueAt(count, 4));
					String currentSmaxnum = String.valueOf(ReaderList.getValueAt(count, 5));
					double currentrepu = Double.parseDouble(String.valueOf(ReaderList.getValueAt(count, 6)));
					System.out.println("修改后的最大可借书数量为："+currentBmaxnum);
					System.out.println("修改后的最大预约书数量为："+currentSmaxnum);
					System.out.println("修改后的信誉值为："+currentrepu);

					int result = JOptionPane.showConfirmDialog(null, "确认修改？");
					if (result == 0) {
						TbReaderinfo update_reader = new TbReaderinfo();
						update_reader.setBmaxnum(currentBmaxnum);
						update_reader.setSmaxnum(currentSmaxnum);
						update_reader.setReputation(currentrepu);
						update_reader.setCard(String.valueOf(ReaderList.getValueAt(count, 0)));
						System.out.println("要修改成："+update_reader);
						//得到前端要传给后端的内容
						//将内容放入Message，指定调用方法的类型
						Message message = new Message(Type1,update_reader);
						message.setCheckCode(check);
						TheClient client = new TheClient();
						Message received = new Message();
						
						try {
							received = client.sendAndReceive(message);
							if(received.isResponse()) {
								JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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
						
						
						
						//先建立与数据库的连接
//						Library_dbUtil D = new Library_dbUtil();
//						Connection con = null;
//						try {
//							con = D.getCon();// 得到与数据库的连接
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						try {
//							System.out.println("更新读者信息的结果为：" + ReaderDao.changeReaderinfo(con, update_reader));
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						JOptionPane.showMessageDialog(null, "修改读者信息成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					} else if (result == 1) {
					} else {
					}
				}

			}
		});
		btnNewButton.setBounds(558, 354, 136, 40);
		contentPane.add(btnNewButton);
		this.filltable(new TbReaderinfo());
		MyTable.colorizeTabel(ReaderList);
	}

	private void filltable(TbReaderinfo reader) {
		System.out.println("进入filltable函数");
		DefaultTableModel dtm = (DefaultTableModel) ReaderList.getModel();// Jtable类型的BookList
		dtm.setRowCount(0);
//		// 连接上数据库
//		Connection con = null;
//		Library_dbUtil b = new Library_dbUtil();
		try {
//			con = b.getCon();
//			Vector<TbReaderinfo> TbB = ReaderDao.showReaders(con);
			Message message = new Message(Type2,new TbReaderinfo());
			message.setCheckCode(check);
			TheClient client = new TheClient();
			Message received = new Message();
			System.out.println("将要传送打印读者信息的message");
			received = client.sendAndReceive(message);
			Vector<TbReaderinfo> TbB = new Vector<TbReaderinfo>();
			TbB = received.getTbReaderinfovector();
			for (int i = 0; i < TbB.size(); i++) {
				TbReaderinfo temp = new TbReaderinfo();
				Vector v = new Vector();
				temp = TbB.get(i);
				v.add(temp.getCard());
				v.add(temp.getReaderName());
				v.add(temp.getSex());
				v.add(temp.getInstitude());
				v.add(temp.getBmaxnum());
				v.add(temp.getSmaxnum());
				v.add(temp.getReputation());
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
}