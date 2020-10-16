package com.ycz.libraryfront;

import java.awt.BorderLayout;
import gui.*;
import user.User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Vector;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ycz.Ubtil.Library_dbUtil;
import com.ycz.model.TbBookborrowinfo;
import com.ycz.model.TbBookinfo;
import com.ycz.model.TbBookorderinfo;
// import com.ycz.net.TheClient;

import Message.Message;
import client.TheClient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookorderManagement extends JFrame {

	private JPanel contentPane;
	private JTable BookorderList;
	private int check = 3;
	private String Type1 = "SHOW_CURRENTORDER";// showCurrentOrder
	private String Type2 = "FINISH_BOOKORDERINFO";// FinishBookorderinfo(Connection con, TbBookorderinfo book)
	// private DefaultTableModel dtm ;//= (DefaultTableModel)
	// BookorderList.getModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookorderManagement frame = new BookorderManagement();
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
	public BookorderManagement() {
		setPreferredSize(new Dimension(700, 433));
		setSize(new Dimension(700, 433));
		setResizable(false);
		setTitle("新书订购管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setPreferredSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(new Dimension(700, 433));
		scrollPane_1.setPreferredSize(new Dimension(700, 433));
		scrollPane_1.setBounds(0, 0, 700, 329);
		contentPane.add(scrollPane_1);

		BookorderList = new MyTable();
		BookorderList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ISBN", "\u6570\u91CF", "\u6700\u665A\u8350\u8D2D\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(BookorderList);

		gui.DarkButton btnBuybook = new gui.DarkButton("购买");
		btnBuybook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = BookorderList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择书籍！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(null, "确认购买？");
					if (result == 0) {
						// 得到前端将要传给后端的内容
						int amount = (int) BookorderList.getValueAt(count, 1);
						TbBookorderinfo update_book = new TbBookorderinfo();
						// update_book.setNumber(amount);
						update_book.setISBN(String.valueOf(BookorderList.getValueAt(count, 0)));
						// 买书时间为本地时间
						Calendar cal = Calendar.getInstance();
						System.out.println("买书时间：" + String.valueOf(cal.getTime()));
						update_book.setBuyDate(String.valueOf(cal.getTime()));
						update_book.setCheckAndAccept("true");
						update_book.setLibrarianId("213183000");
						// 将内容放入Message，指定调用方法的类型
						Message message2 = new Message(Type2, update_book);// 购买图书
						// 指定调用的模块，check = 3;
						message2.setCheckCode(check);
						// 生成客户端，新建一个线程
						TheClient client2 = new TheClient();
						// 从服务端获得的内容会存在Message received中
						Message received2;
						try {
							received2 = client2.sendAndReceive(message2);
							if (received2.isResponse()) {// 如果服务端响应，则操作成功；否则失败
								JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} // 分别catch三种错误
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (result == 1) {
					} else {
					}
					// String N = BookList.getValueAt(count, 1).toString();
				}
			}
		});
		btnBuybook.setBounds(512, 356, 93, 23);
		contentPane.add(btnBuybook);

		gui.DarkButton btnRenew = new gui.DarkButton("刷新");
		btnRenew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filltable(new TbBookorderinfo());// 刷新表格
			}
		});
		btnRenew.setBounds(101, 356, 93, 23);
		contentPane.add(btnRenew);
		this.filltable(new TbBookorderinfo());// 初始化BookList//自定义filltable()
		MyTable.colorizeTabel(BookorderList);
	}
	
	public BookorderManagement(User user) {
		setPreferredSize(new Dimension(700, 433));
		setSize(new Dimension(700, 433));
		setResizable(false);
		setTitle("新书订购管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setPreferredSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(new Dimension(700, 433));
		scrollPane_1.setPreferredSize(new Dimension(700, 433));
		scrollPane_1.setBounds(0, 0, 700, 329);
		contentPane.add(scrollPane_1);

		BookorderList = new MyTable();
		BookorderList.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ISBN", "\u6570\u91CF", "\u6700\u665A\u8350\u8D2D\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(BookorderList);

		gui.DarkButton btnBuybook = new gui.DarkButton("购买");
		btnBuybook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = BookorderList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择书籍！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(null, "确认购买？");
					if (result == 0) {
						// 得到前端将要传给后端的内容
						int amount = (int) BookorderList.getValueAt(count, 1);
						TbBookorderinfo update_book = new TbBookorderinfo();
						// update_book.setNumber(amount);
						update_book.setISBN(String.valueOf(BookorderList.getValueAt(count, 0)));
						// 买书时间为本地时间
						Calendar cal = Calendar.getInstance();
						System.out.println("买书时间：" + String.valueOf(cal.getTime()));
						update_book.setBuyDate(String.valueOf(cal.getTime()));
						update_book.setCheckAndAccept("true");
						update_book.setLibrarianId("213183000");
						// 将内容放入Message，指定调用方法的类型
						Message message2 = new Message(Type2, update_book);// 购买图书
						// 指定调用的模块，check = 3;
						message2.setCheckCode(check);
						// 生成客户端，新建一个线程
						TheClient client2 = new TheClient();
						// 从服务端获得的内容会存在Message received中
						Message received2;
						try {
							received2 = client2.sendAndReceive(message2);
							if (received2.isResponse()) {// 如果服务端响应，则操作成功；否则失败
								JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} // 分别catch三种错误
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (result == 1) {
					} else {
					}
					// String N = BookList.getValueAt(count, 1).toString();
				}
			}
		});
		btnBuybook.setBounds(512, 356, 93, 23);
		contentPane.add(btnBuybook);

		gui.DarkButton btnRenew = new gui.DarkButton("刷新");
		btnRenew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filltable(new TbBookorderinfo());// 刷新表格
			}
		});
		btnRenew.setBounds(101, 356, 93, 23);
		contentPane.add(btnRenew);
		this.filltable(new TbBookorderinfo());// 初始化BookList//自定义filltable()
		MyTable.colorizeTabel(BookorderList);
	}

	private void filltable(TbBookorderinfo book) {
		DefaultTableModel dtm = (DefaultTableModel) BookorderList.getModel();// Jtable类型的BookList
		dtm.setRowCount(0);
		// Connection con = null;
		// Library_dbUtil b = new Library_dbUtil();
		Message message1 = new Message(Type1, new TbBookorderinfo());
		message1.setCheckCode(check);
		TheClient client1 = new TheClient();
		Message received1 = new Message();
		try {
			received1 = client1.sendAndReceive(message1);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Vector<TbBookorderinfo> TbB = received1.getTbBookorderinfovector();
		try {
			// con = b.getCon();
			// Vector<TbBookborrowinfo>TbB = BookborrowDao.showCurrentBorrow(con, person);
			for (int i = 0; i < TbB.size(); i++) {
				TbBookorderinfo temp = new TbBookorderinfo();
				Vector v = new Vector();
				// 把借书信息从Vector中提取出来
				temp = TbB.get(i);
				// 把v展现在表中
				v.add(temp.getISBN());
				v.add(temp.getNumber());
				v.add(temp.getOrderDate());
				// dtm.setRowCount(0);
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// finally {
		// try {
		// b.CloseConnection(con);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
	}
}
