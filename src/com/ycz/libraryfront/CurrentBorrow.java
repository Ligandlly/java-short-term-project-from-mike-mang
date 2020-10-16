package com.ycz.libraryfront;

import com.ycz.iframe.*;
import com.ycz.model.*;
// import com.ycz.net.TheClient;

import Message.*;
import client.TheClient;
import gui.DarkButton;
import gui.LightButton;
import gui.MyTable;
import gui.colors.PrimaryColor;
import gui.colors.SecondaryColor;
import user.*;

import com.ycz.Ubtil.*;
import com.ycz.dao.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.ScrollPane;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CurrentBorrow extends JFrame {

	private JPanel contentPane;
	private JTable bookBorrowList;
	private String Type1 = "GET_READERINFO";// getReaderinfo
	private String Type2 = "UPDATE_READERINFO";// UpdateReaderinfo
	private String Type3 = "UPDATE_BOOKBORROWINFO";// UpdateBookborrowinfo
	private String Type4 = "SEARCH_BOOKINFO";// SearchBookinfo
	private String Type5 = "UPDATE_BOOKINFO";// UpdateBookinfo
	private String Type6 = "SHOW_CURRENTBORROW";// showCurrentBorrow
	private String Type7 = "SEARCH_BOOKBORROWINFO";//SearchBookborrowinfo
	private String Type8 = "RENEW_BOOKBORROWINFO";//RenewBookborrowinfo
	private User person;
	private int check = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User person = new User("213182078", "喻慈舟", "student");
					CurrentBorrow frame = new CurrentBorrow(person);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Judge_Update_reputation(Connection con, TbBookborrowinfo bookborrowinfo) throws ParseException {
		// 将string backDate 转化为calendar类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(bookborrowinfo.getBackDate());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		TbReaderinfo reader = new TbReaderinfo();
		reader.setCard(person.card);
		Message message = new Message(Type1, reader);
		message.setCheckCode(check);
		TheClient client = new TheClient();
		Message received = new Message();
		try {
			System.out.println("将要从后端获得读者详细信息");
			received = client.sendAndReceive(message);
			reader = (TbReaderinfo) received.getAllembracing();
			System.out.println("从后端获得的读者详细信息为:" + reader);
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

		// try {
		// reader = ReaderDao.getReaderinfo(con, reader);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println("读者信息："+reader);
		double now_repu = reader.getReputation();
		// 还书时间晚于规定日期
		if (calendar.before(Calendar.getInstance())) {
			now_repu = now_repu - 5.0;
			reader.setReputation(now_repu);
			Message message2 = new Message(Type2, reader);
			message2.setCheckCode(check);
			TheClient client2 = new TheClient();
			Message received2 = new Message();
			try {
				received2 = client2.sendAndReceive(message2);
				if (received2.isResponse()) {
					JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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
			// try {
			// System.out.println("减少信誉操作的结果为:"+ReaderDao.UpdateReaderinfo(con, reader));
			// } catch (Exception e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} else {// 还书时间在规定日期之内
			now_repu = now_repu + 1.0;
			reader.setReputation(now_repu);
			Message message2 = new Message(Type2, reader);
			message2.setCheckCode(check);
			TheClient client2 = new TheClient();
			Message received2 = new Message();
			try {
				received2 = client2.sendAndReceive(message2);
				if (received2.isResponse()) {
					JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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

	/**
	 * Create the frame.
	 */
	public CurrentBorrow(User person) {
		this.person = person;
		setIconImage(Toolkit.getDefaultToolkit().getImage(CurrentBorrow.class.getResource("/com/ycz/images/maowu.png")));
		setTitle("当前借阅");
		setPreferredSize(new Dimension(700, 433));
		setResizable(false);
		setSize(new Dimension(700, 433));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(240,240,240));
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setPreferredSize(new Dimension(700, 433));
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(new Dimension(700, 433));
		scrollPane_1.setBounds(10, 10, 645, 324);// 是不是要去掉？
		contentPane.add(scrollPane_1);

		bookBorrowList = new MyTable();
		
		
		
		bookBorrowList.setVerifyInputWhenFocusTarget(false);
		bookBorrowList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u9898\u540D", "ISBN",
				"\u4F5C\u8005", "\u501F\u4E66\u65E5\u671F", "\u5E94\u8FD8\u65E5\u671F" }));
		scrollPane_1.setViewportView(bookBorrowList);

		JButton returnBookbutton = new LightButton("还书");
		returnBookbutton.setIcon(new ImageIcon(CurrentBorrow.class.getResource("/com/ycz/images/tushuguan.png")));
//		returnBookbutton.setForeground(Color.BLACK);
//		returnBookbutton.setBorderPainted(false);
//		returnBookbutton.setBackground(Color.white);
		returnBookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = bookBorrowList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择书籍！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Library_dbUtil D = new Library_dbUtil();
					Connection con = null;
					try {
						con = D.getCon();// 得到与数据库的连接
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int result = JOptionPane.showConfirmDialog(null, "确认还书？");
					if (result == 0) {// 确定还书

						// 把借书记录中对应信息改为"true"
						TbBookborrowinfo update_bookborrow = new TbBookborrowinfo();
						update_bookborrow.setCard(person.card);
						update_bookborrow.setISBN(String.valueOf(bookBorrowList.getValueAt(count, 1)));
						update_bookborrow.setIsback("true");
						Message message3 = new Message(Type3, update_bookborrow);
						message3.setCheckCode(check);
						TheClient client3 = new TheClient();
						Message received3 = new Message();
						try {
							received3 = client3.sendAndReceive(message3);
							if (received3.isResponse()) {
								//JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} else {
								//JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (UnknownHostException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						// try{
						// System.out.println("更新借阅记录的结果为："+BookborrowDao.UpdateBookborrowinfo(con,
						// update_bookborrow));
						// }catch(Exception e) {
						// e.printStackTrace();
						// }

						// 把对应书籍信息的amount+1
						// 先用ISBN查出对应书籍现在的amount
						TbBookinfo update_book = new TbBookinfo();
						update_book.setISBN(String.valueOf(bookBorrowList.getValueAt(count, 1)));
						Message message4 = new Message(Type4, update_book);
						message4.setCheckCode(check);
						TheClient client4 = new TheClient();
						Message received4 = new Message();
						try {
							received4 = client4.sendAndReceive(message4);
						} catch (UnknownHostException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						update_book = (TbBookinfo) received4.getAllembracing();
						// try {
						// update_book = BookDao.SearchBookinfo(con, update_book);
						// } catch (Exception e1) {
						// // TODO Auto-generated catch block
						// e1.printStackTrace();
						// }
						int currentamount = update_book.getAmount();
						System.out.println("还书之前的库存" + currentamount);
						// 库存+1，更新书籍信息
						currentamount = currentamount + 1;
						update_book.setAmount(currentamount);
						System.out.println("还书之后的库存" + currentamount);
						Message message5 = new Message(Type5, update_book);
						message5.setCheckCode(check);
						TheClient client5 = new TheClient();
						try {
							Message received5 = client5.sendAndReceive(message5);
							if (received5.isResponse()) {
								//JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							} else {
								//JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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

						// try {
						// System.out.println("更新书籍amount的结果为：" + BookDao.UpdateBookinfo(con,
						// update_book));
						// } catch (Exception e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }

						// 判断并修改读者信誉
						TbBookborrowinfo bookborrowinfo = new TbBookborrowinfo();
						bookborrowinfo.setCard(person.card);
						bookborrowinfo.setBorrowDate(String.valueOf(bookBorrowList.getValueAt(count, 3)));
						bookborrowinfo.setBackDate(String.valueOf(bookBorrowList.getValueAt(count, 4)));
						try {
							Judge_Update_reputation(con, bookborrowinfo);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "还书成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
						filltable(new TbBookborrowinfo());
					} else if (result == 1) {
					} else {
					}
				}

			}
		});
		returnBookbutton.setBounds(562, 344, 93, 23);
		contentPane.add(returnBookbutton);
		
		JButton renewBookButton = new JButton("续借");
		renewBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = bookBorrowList.getSelectedRow();
				if (count == -1) {
					JOptionPane.showMessageDialog(null, "您未选择书籍！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
//					Library_dbUtil D = new Library_dbUtil();
//					Connection con = null;
//					try {
//						con = D.getCon();// 得到与数据库的连接
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					int result = JOptionPane.showConfirmDialog(null, "确认续借？");
					if (result == 0) {//确定续借
						//把对应借阅信息的backDate+30天
						//先用ISBN查出对应书籍现在的backDate
						TbBookborrowinfo renew_book = new TbBookborrowinfo();
						renew_book.setISBN(String.valueOf(bookBorrowList.getValueAt(count, 1)));
						renew_book.setCard(person.card);
						Message message7 = new Message(Type7,renew_book);
						message7.setCheckCode(check);
						TheClient client7 = new TheClient();
						Message received7= new Message();
						try {
							received7 = client7.sendAndReceive(message7);
						} catch (UnknownHostException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						renew_book = (TbBookborrowinfo)received7.getAllembracing();
//						try {
//							update_book = BookDao.SearchBookinfo(con, update_book);
//						} catch (Exception e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
						String oldbackDate = renew_book.getBackDate();
						

						//先把string转成calendar类型
						SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
						Date date = null;
						try {
							date = sdf.parse(oldbackDate);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						
						//加上30天获得新的日期
						calendar.add(Calendar.DAY_OF_MONTH, +30);//还书日期：取借书日期后30天 	
						System.out.println("续借后的还书时间"+String.valueOf(calendar.getTime()));
						renew_book.setBackDate(String.valueOf(calendar.getTime()));
						
						//更新数据库还书时间
						Message message8= new Message(Type8,renew_book);
						message8.setCheckCode(check);
						TheClient client8 = new TheClient();
						try {
							Message received8 = client8.sendAndReceive(message8);
							if(received8.isResponse()) {
								JOptionPane.showMessageDialog(null, "更新成功！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "更新失败！", "图书管理小精灵", JOptionPane.INFORMATION_MESSAGE);
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
						filltable(new TbBookborrowinfo());
						MyTable.colorizeTabel(bookBorrowList);
					} else if (result == 1) {
					} else {
					} 
				}

			}
		});
		renewBookButton.setBounds(20, 344, 93, 23);
		contentPane.add(renewBookButton);
		
		JButton renewButton = new JButton("刷新\r\n");
		renewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filltable(new TbBookborrowinfo());
			}
		});
		renewButton.setBounds(281, 344, 93, 23);
		contentPane.add(renewButton);
		this.filltable(new TbBookborrowinfo());// 初始化BookList//自定义filltable()
		

//		setBackground(new Color(0xEBCB8B));
	}

	private void filltable(TbBookborrowinfo book) {
		System.out.println("准备filltable");
		DefaultTableModel dtm = (DefaultTableModel) bookBorrowList.getModel();// Jtable类型的BookList
		dtm.setRowCount(0);
		Connection con = null;
		Library_dbUtil b = new Library_dbUtil();
		Message message6 = new Message(Type6, person);
		message6.setCheckCode(check);
		TheClient client6 = new TheClient();
		Message received6 = new Message();
		try {
			received6 = client6.sendAndReceive(message6);
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
		Vector<TbBookborrowinfo> TbB = received6.getTbBookborrowinfovector();
		try {
			// con = b.getCon();
			// Vector<TbBookborrowinfo>TbB = BookborrowDao.showCurrentBorrow(con, person);
			for (int i = 0; i < TbB.size(); i++) {
				TbBookborrowinfo temp = new TbBookborrowinfo();
				Vector v = new Vector();
				// 把借书信息从Vector中提取出来
				temp = TbB.get(i);
				// 把v展现在表中
				v.add(temp.getBookName());
				v.add(temp.getISBN());
				v.add(temp.getWriter());
				v.add(temp.getBorrowDate());
				v.add(temp.getBackDate());
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				b.CloseConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
