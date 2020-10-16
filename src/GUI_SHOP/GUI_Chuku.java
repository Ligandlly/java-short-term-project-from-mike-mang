package GUI_SHOP;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.Dao;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import model.TbGoodinfo;
import user.User;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI_Chuku extends JFrame {
	private JTextField goodtextdelet;
	private int check = 2;
	private String Type = "DELETEGOOD";
	private JTable deletegoodtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Chuku frame = new GUI_Chuku();
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
	public GUI_Chuku() {
		setTitle("\u5220\u9664\u5546\u54C1");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		JPanel Chuku = new JPanel();
		Chuku.setBackground(Color.white);
		Chuku.setSize(700, 433);
		getContentPane().add(Chuku);
		Chuku.setLayout(null);

		JLabel deletgood = new JLabel("\u5220\u9664\u5546\u54C1");
		deletgood.setBounds(24, 65, 95, 29);
		Chuku.add(deletgood);

		goodtextdelet = new JTextField();
		goodtextdelet.setBounds(129, 69, 239, 21);
		Chuku.add(goodtextdelet);
		goodtextdelet.setColumns(10);

		JButton delete = new JButton("\u786E\u8BA4\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodDeleteActionPerformed(evt);
			}
		});
		delete.setBounds(400, 68, 97, 23);
		Chuku.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 129, 516, 203);
		Chuku.add(scrollPane);
		
		deletegoodtable = new MyTable();
		deletegoodtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u6807\u7B7E", "\u751F\u4EA7\u5546", "\u4EF7\u683C", "\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(deletegoodtable);
		this.filltable(new TbGoodinfo());
	}

	public GUI_Chuku(User user) {
		setTitle("\u5220\u9664\u5546\u54C1");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		JPanel Chuku = new JPanel();
		Chuku.setBackground(Color.white);
		Chuku.setSize(700, 433);
		getContentPane().add(Chuku);
		Chuku.setLayout(null);

		JLabel deletgood = new JLabel("\u5220\u9664\u5546\u54C1");
		deletgood.setBounds(24, 65, 95, 29);
		Chuku.add(deletgood);

		goodtextdelet = new JTextField();
		goodtextdelet.setBounds(129, 69, 239, 21);
		Chuku.add(goodtextdelet);
		goodtextdelet.setColumns(10);

		JButton delete = new JButton("\u786E\u8BA4\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodDeleteActionPerformed(evt);
			}
		});
		delete.setBounds(400, 68, 97, 23);
		Chuku.add(delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 129, 516, 203);
		Chuku.add(scrollPane);
		
		deletegoodtable = new JTable();
		deletegoodtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u6807\u7B7E", "\u751F\u4EA7\u5546", "\u4EF7\u683C", "\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(deletegoodtable);
		this.filltable(new TbGoodinfo());
	}


	/**
	 * ɾ����Ʒ
	 * 
	 * @param evt
	 */
	private void goodDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		TbGoodinfo goodinfo = new TbGoodinfo();
		goodinfo.setGood_name(this.goodtextdelet.getText());
		if (goodinfo.getGood_name().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入要删除的商品名");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除商品吗");
		if (n == 0) {
			Message message = new Message(Type, goodinfo);
			message.setCheckCode(check);
			client.TheClient client = new TheClient();
			try {
				Message recevied = client.sendAndReceive(message);
				if (recevied.isResponse()) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.filltable(new TbGoodinfo());
					this.resetValue();
				} else {
					JOptionPane.showMessageDialog(null, "出错了，再看看吧");
					this.resetValue();
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
//		if(goodinfo.getGood_name().isEmpty()) {
//			JOptionPane.showMessageDialog(null, "������Ҫɾ������Ʒ��");
//			return;
//		}
//		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����Ʒ��");
//		if(n==0) {
//			Connection con=null;
//			try {
//				con=dbUtil.getCon();
//				int deleteNum=Dao.DeleteGood(con, goodinfo);
//				if(deleteNum==1) {
//					JOptionPane.showMessageDialog(null, "ɾ������");
//					this.resetValue();
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
//			}finally {
//				try {
//					dbUtil.CloseConnection(con);
//				}catch(Exception e) {
//					e.printStackTrace(); 
//				}
//			}
//		}
	}

	private void filltable(TbGoodinfo good) {
//		System.out.print("���е�������");
		DefaultTableModel dtm = (DefaultTableModel) deletegoodtable.getModel();
		dtm.setRowCount(0);
		String tp="RETURN_ALLGOOD";
		Message message=new Message(tp,good);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
		Message received;
		try {
			received = client.sendAndReceive(message);
			if(message.isResponse())System.out.print("���ǰɰ�Sir");
			Vector<TbGoodinfo> a=new Vector<TbGoodinfo>();
			a=received.getTbGoodvector();
//			System.out.print(a.get(1).getGood_ID());
			for(int i=0;i<a.size();i++) {
				Vector temp=new Vector();
				TbGoodinfo Good=a.get(i);
				temp.add(Good.getGood_ID());
				temp.add(Good.getGood_name());
				temp.add(Good.getGood_tag());
				temp.add(Good.getGood_manufacturer());
				temp.add(Good.getGood_price());
				temp.add(Good.getGood_store());
				dtm.addRow(temp);
		    }
			

			MyTable.colorizeTabel(deletegoodtable);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.print("���ǰɰ�Sir");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void resetValue() {
		this.goodtextdelet.setText("");

	}
}
