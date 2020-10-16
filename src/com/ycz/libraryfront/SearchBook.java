package com.ycz.libraryfront;

import java.awt.BorderLayout;
import com.ycz.model.*;

import Message.*;
import client.TheClient;
import gui.DarkButton;
import gui.LightButton;
import gui.MyTable;
import user.*;

import java.awt.EventQueue;
import com.ycz.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ycz.Ubtil.*;

import com.ycz.dao.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gui.LightTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTable BookList;
	private LightTextField Booktxt;
	private String Type1 = "UPDATE_BOOKINFO";//UpdateBookinfo
	private String Type2 = "INSERT_BOOKBORROWINFO";//InsertBookborrowinfo
	private String Type3 = "SEARCH_BOOKINFO2";//SearchBookinfo2
	private String Type4 = "SHOW_BOOKS";//showBooks
	
	private LightTextField Writertxt;
	private LightTextField Publishertxt;
	private LightTextField ISBNtxt;
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
					SearchBook frame = new SearchBook(person);
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
	public SearchBook(User person) {
		setSize(new Dimension(700, 433));
		setPreferredSize(new Dimension(700, 433));
		setResizable(false);
		setTitle("馆藏查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(104, 104, 525, 176);
		contentPane.add(scrollPane_1);

		BookList = new MyTable();
		BookList.setVerifyInputWhenFocusTarget(false);
		BookList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ISBN", "\u5206\u7C7B\u53F7",
				"\u9898\u540D", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u9986\u85CF\u6570\u91CF" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(BookList);

		JButton SearchOK = new LightButton("\u67E5\u8BE2");
		SearchOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SearchBook(event);// SearchBook(ActionEvent event)?
			}
		});
		SearchOK.setBounds(104, 314, 113, 27);
		contentPane.add(SearchOK);

		/*
		 * JButton AddDrugin = new JButton("\u836F\u54C1\u5165\u5E93");
		 * AddDrugin.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { AddDrug a = new AddDrug();
		 * a.setVisible(true); } }); AddDrugin.setBounds(289, 333, 113, 27);
		 * contentPane.add(AddDrugin);
		 */

		// 初始化；添加事件响应函数；setbounds（）；contentPane.add()

		JButton BorrowBook = new DarkButton("借阅");
		BorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = BookList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择书籍！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else if (Integer.parseInt(BookList.getValueAt(count, 5).toString()) <= 0)// 库存不为零时才出书！
				{
					JOptionPane.showMessageDialog(null, "库存不足！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int currentamount = Integer.parseInt(BookList.getValueAt(count, 5).toString());
					int result = JOptionPane.showConfirmDialog(null, "确认借阅？");
					if (result == 0) {
						//得到前端将要传给后端的内容
						currentamount = currentamount - 1;
						TbBookinfo update_book = new TbBookinfo();
						update_book.setAmount(currentamount);
						update_book.setISBN(String.valueOf(BookList.getValueAt(count, 0)));
						//将内容放入Message，指定调用方法的类型
						Message message=new Message(Type1,update_book);//借阅图书，amount-1
						//指定调用的模块，check = 3;
						message.setCheckCode(check);
						//生成客户端，新建一个线程
				        TheClient client=new TheClient();
				        //从服务端获得的内容会存在Message received中
				        Message received;
						try {
							received = client.sendAndReceive(message);
							if(received.isResponse()) {//如果服务端响应，则操作成功；否则失败
					        	JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					        }else {
					        	JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					        }//分别catch三种错误
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
				        
//						Library_dbUtil D = new Library_dbUtil();
//						Connection con = null;
//						try {
//							con = D.getCon();// 得到与数据库的连接
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						try {
//							System.out.println("更新书籍amount的结果为：" + BookDao.UpdateBookinfo(con, update_book));
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						TbBookborrowinfo new_bookborrow = new TbBookborrowinfo();
						new_bookborrow.setCard(person.card);
						new_bookborrow.setISBN(String.valueOf(BookList.getValueAt(count, 0)));
						new_bookborrow.setTypeld(String.valueOf(BookList.getValueAt(count, 1)));
						new_bookborrow.setBookName(String.valueOf(BookList.getValueAt(count, 2)));
						new_bookborrow.setLibrarianId("213183000");
						new_bookborrow.setWriter(String.valueOf(BookList.getValueAt(count, 3)));
						new_bookborrow.setIsback("false");
						
						Calendar cal = Calendar.getInstance();//借书日期：本地时间
						System.out.println("借书时间："+String.valueOf(cal.getTime()));
						new_bookborrow.setBorrowDate(String.valueOf(cal.getTime()));	
						cal.add(Calendar.DAY_OF_MONTH, +30);//还书日期：取借书日期后30天 	
						System.out.println("还书时间"+String.valueOf(cal.getTime()));
						new_bookborrow.setBackDate(String.valueOf(cal.getTime()));
						System.out.println("将要创建用于借书的message");
						Message message1=new Message(Type2,new_bookborrow);//借书，新增借书信息，InsertBookborrowinfo
						message1.setCheckCode(check);
						System.out.println("将要创建用于借书的线程");
				        TheClient client1=new TheClient();
				        Message received1;
						try {
							System.out.println("将要获得从后端返回的信息");
							received1 = client1.sendAndReceive(message1);
							if(received1.isResponse()) {
					        	JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					        }else {
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
				        
//						try {
//							System.out.println("新增借书信息的结果为："+BookborrowDao.InsertBookborrowinfo(con, new_bookborrow));
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
	//					JOptionPane.showMessageDialog(null, "借阅成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
					} else if (result == 1) {
					} else {
					}
					//String N = BookList.getValueAt(count, 1).toString();

					
				}

			}
		});
		BorrowBook.setBounds(516, 314, 113, 27);
		contentPane.add(BorrowBook);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(104, 10, 525, 84);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("题名");

		Booktxt = new LightTextField();
		Booktxt.setColumns(10);

		JLabel label = new JLabel("作者");

		Writertxt = new LightTextField();
		Writertxt.setColumns(10);

		JLabel lblIsbn = new JLabel("ISBN");

		ISBNtxt = new LightTextField();
		ISBNtxt.setColumns(10);

		JLabel label_1 = new JLabel("出版社");

		Publishertxt = new LightTextField();
		Publishertxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Booktxt, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Writertxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ISBNtxt, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Publishertxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(Booktxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(Writertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(ISBNtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(Publishertxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Tips:找不到图书？试试用更短的关键字，或移步读者荐购！");
		lblNewLabel_1.setBounds(103, 347, 525, 53);
		contentPane.add(lblNewLabel_1);
		this.filltable(new TbBookinfo());// 初始化BookList//自定义filltable()
		MyTable.colorizeTabel(BookList);
	}

	protected void SearchBook(ActionEvent event) {
		TbBookinfo book = new TbBookinfo();
		book.setBookName(Booktxt.getText());
		book.setWriter(Writertxt.getText());
		book.setPublisher(Publishertxt.getText());
		book.setISBN(ISBNtxt.getText());
		System.out.println("要查找的题名是：" + book.getBookName());
		System.out.println("要查找的作者是：" + book.getWriter());
		System.out.println("要查找的出版社是：" + book.getPublisher());
		System.out.println("要查找的ISBN是：" + book.getISBN());
		DefaultTableModel dtm = (DefaultTableModel) BookList.getModel();// Jtable类型的BookList
		dtm.setRowCount(0);
		Message message=new Message(Type3,book);
		message.setCheckCode(check);
        TheClient client=new TheClient();
        try {
			Message recevied=client.sendAndReceive(message);
			Vector<TbBookinfo>TbB=recevied.getTbBookinfovector();
			for(int i=0 ; i<TbB.size();i++) {
				TbBookinfo temp = new TbBookinfo();
				Vector v = new Vector();
				temp = TbB.get(i);
				v.add(temp.getISBN());
				v.add(temp.getTypeld());
				v.add(temp.getBookName());
				v.add(temp.getWriter());
				v.add(temp.getPublisher());
				v.add(temp.getAmount());
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
        
//		Connection con = null;
//		Library_dbUtil b = new Library_dbUtil();
//		try {
//			con = b.getCon();
//
//			Vector<TbBookinfo> TbB = BookDao.SearchBookinfo2(con, book);//多关键字模糊查找书籍
//			for(int i=0 ; i<TbB.size();i++) {
//				TbBookinfo temp = new TbBookinfo();
//				Vector v = new Vector();
//				temp = TbB.get(i);
//				v.add(temp.getISBN());
//				v.add(temp.getTypeld());
//				v.add(temp.getBookName());
//				v.add(temp.getWriter());
//				v.add(temp.getPublisher());
//				v.add(temp.getAmount());
//				dtm.addRow(v);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				b.CloseConnection(con);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * 初始化表格
	 * 
	 * @param bookinfo
	 */
	private void filltable(TbBookinfo bookinfo) {
		DefaultTableModel dtm = (DefaultTableModel) BookList.getModel();// Jtable类型的BookList
		dtm.setRowCount(0);
//		Connection con = null;
//		Library_dbUtil b = new Library_dbUtil();
//		try {
//			con = b.getCon();
			Message message = new Message(Type4,new TbBookinfo());
			message.setCheckCode(check);
			TheClient client = new TheClient();
			Message received;
			Vector<TbBookinfo> TbB = new Vector<TbBookinfo>();
			try {
				received = client.sendAndReceive(message);
				TbB = received.getTbBookinfovector();
			}catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Vector<TbBookinfo> TbB = BookDao.showBooks(con);//初始化图书馆藏书列表
			for(int i=0;i<TbB.size();i++) {
				TbBookinfo temp = new TbBookinfo();
				Vector v = new Vector();
				temp = TbB.get(i);
				v.add(temp.getISBN());
				v.add(temp.getTypeld());
				v.add(temp.getBookName());
				v.add(temp.getWriter());
				v.add(temp.getPublisher());
				v.add(temp.getAmount());
				dtm.addRow(v);
			}
	}
}
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				b.CloseConnection(con);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

