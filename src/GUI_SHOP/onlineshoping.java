package GUI_SHOP;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import Dao.Dao;
import Message.Message;
import client.TheClient;
import model.TbGoodinfo;
import model.TbtradeDetail;
import model.TbtradeMain;
import user.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;

public class onlineshoping extends JFrame {
	private static final String Search_tagtxt = null;
	private JTextField Search_nametxt;
	private JTextField search_tagtxt;
	private JTable GoodinfoTable;
	private User user=new User();
	private int check = 2;
	private String Type="SEARCH_GOODNAME";
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				User user=new User();
	// 				user.card="123";
	// 				user.name="CHY";
	// 				onlineshoping frame = new onlineshoping(user);
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Create the frame.
	 */
	public onlineshoping(User user) {
//		setIconifiable(true);
//		setClosable(true);
		setTitle("\u5728\u7EBF\u8D2D\u4E70");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel onlineshop = new JPanel();
		onlineshop.setBackground(Color.white);
		onlineshop.setSize(700,433);
		getContentPane().add(onlineshop);
		onlineshop.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6309\u540D\u79F0\u641C\u7D22\uFF1A");
		lblNewLabel.setBounds(67, 38, 93, 15);
		onlineshop.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6309\u6807\u7B7E\u641C\u7D22\uFF1A");
		lblNewLabel_1.setBounds(380, 38, 93, 15);
		onlineshop.add(lblNewLabel_1);
		
		Search_nametxt = new JTextField();
		Search_nametxt.setBounds(151, 35, 66, 21);
		onlineshop.add(Search_nametxt);
		Search_nametxt.setColumns(10);
		
		search_tagtxt = new JTextField();
		search_tagtxt.setBounds(463, 35, 66, 21);
		onlineshop.add(search_tagtxt);
		search_tagtxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodSearchactionPerformed_name(e);
			}
		});
		btnNewButton.setBounds(227, 34, 29, 23);
		onlineshop.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u641C\u7D22");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodSearchactionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(539, 34, 29, 23);
		onlineshop.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 63, 505, 298);
		onlineshop.add(scrollPane);
		
		GoodinfoTable = new JTable();
		GoodinfoTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent met) {
//				GoodinfoTablePressed(met);
//			}
		});
		GoodinfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u6807\u7B7E", "\u5546\u54C1\u4EF7\u683C", "\u5546\u54C1\u5E93\u5B58", "\u751F\u4EA7\u5546"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(GoodinfoTable);
		
		JButton btnNewButton_2 = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addGoodactionPerformed(evt,user);
			}
		});
		btnNewButton_2.setBounds(563, 371, 97, 23);
		onlineshop.add(btnNewButton_2);
		
		//this.fillTable_name(new TbGoodinfo());
		//this.fillTable_tag(new TbGoodinfo());

	}
	/**
	 *���빺�ﳵ
	 * @param evt
	 */
	private void addGoodactionPerformed(ActionEvent evt,User user) {
		String Type1="ONLINESHOP";
		int row = this.GoodinfoTable.getSelectedRow();
		int state=1;
		int num=1;
//		Date date=new TbtradeMain().getData();
//		String Good_ID=(String)GoodinfoTable.getValueAt(row, 0);
		String Good_Name=(String)GoodinfoTable.getValueAt(row, 1);
		String Good_Tag=(String)GoodinfoTable.getValueAt(row, 2);
		Double Good_Price=Double.valueOf(GoodinfoTable.getValueAt(row, 3).toString());
		int Good_Store=Integer.parseInt(GoodinfoTable.getValueAt(row, 4).toString());
		String Good_Manufacturer=(String)GoodinfoTable.getValueAt(row, 5);
		TbtradeMain trade=new TbtradeMain(Good_Name,Good_Price, state, Good_Tag, Good_Manufacturer,Good_Store, num,
				user.card, user.name);
		Message message=new Message(Type1,trade);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
			try {
				Message recevied=client.sendAndReceive(message);
				System.out.print("���ǰɰ�Sir"+recevied.isResponse());
				if(recevied.isResponse()) {
					JOptionPane.showMessageDialog(null, "添加成功");
				}else {
					JOptionPane.showMessageDialog(null, "添加失败");
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
			
//		Connection con=null;
//		try {
//			con=dbUtil.getCon();
//			boolean n=Dao.onlineshop(con, trade);
//			if(n) {
//				JOptionPane.showMessageDialog(null, "��ӳɹ�");
//			}else {
//					JOptionPane.showMessageDialog(null, "���ʧ��");
//				}
//		}catch(Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "���ʧ��");
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//			}
//		}
		
	}

	/**
	 * ����е���¼�����
	 * @param met
	 */
//	private TbtradeMain GoodinfoTablePressed(MouseEvent met) {
//		int row = this.GoodinfoTable.getSelectedRow();
//		String User_Name=user.name;
//		String User_ID=user.card;
//		Date date=new TbtradeMain().getData();
//		String Good_ID=(String)GoodinfoTable.getValueAt(row, 1);
//		String Good_Name=(String)GoodinfoTable.getValueAt(row, 2);
//		String Good_Tag=(String)GoodinfoTable.getValueAt(row, 3);
//		Double Good_Price=(Double)GoodinfoTable.getValueAt(row, 4);
//		int Good_Store=(int)GoodinfoTable.getValueAt(row, 5);
//		String Good_Manufacturer=(String)GoodinfoTable.getValueAt(row, 6);
//		trade = new TbtradeMain(Good_ID,Good_Name, Good_Price, 1, Good_Tag, Good_Manufacturer,Good_Store, 1,
//				User_Name,User_ID, date);
//		return trade;
//	}

	private void GoodSearchactionPerformed_name(ActionEvent e) {
		String goodname= this.Search_nametxt.getText();
		TbGoodinfo GoodName=new TbGoodinfo(goodname,null);
		this.fillTable_name(GoodName);
	}

	private void GoodSearchactionPerformed(ActionEvent e) {
		String goodtag= this.search_tagtxt.getText();
		TbGoodinfo GoodTag=new TbGoodinfo(goodtag,null);
		this.fillTable_tag(GoodTag);
	}
	/**
	 * ����Ʒ������
	 * @param goodinfo
	 */
	private void fillTable_name(TbGoodinfo goodinfo) {
		DefaultTableModel dtm=(DefaultTableModel)GoodinfoTable.getModel();
		dtm.setRowCount(0);
		TbGoodinfo good =new TbGoodinfo();
		good.setGood_name(this.Search_nametxt.getText());
		Message message=new Message(Type,good);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
//		Connection con =null;
		try {
			Message recevied=client.sendAndReceive(message);
			System.out.print("�������");
			Vector <TbGoodinfo> s = new Vector<TbGoodinfo>();
			s=recevied.getTbGoodvector();
			System.out.print("s�Ĵ�С"+s.size());
			for(int i=0;i<s.size();i++) {
				TbGoodinfo temp=s.get(i);
				System.out.print("temp���յ�����");
				Vector v=new Vector();
				v.add(temp.getGood_ID());
				v.add(temp.getGood_name());
				v.add(temp.getGood_tag());
				v.add(temp.getGood_price());
				v.add(temp.getGood_store());
				v.add(temp.getGood_manufacturer());
				System.out.print("���е�����");
				dtm.addRow(v);
			}
			if(recevied.isResponse()) {

			}else {
				JOptionPane.showMessageDialog(null, "没有搜索到啊，在看看吧");
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
//		try {
//			con=dbUtil.getCon();
//			ResultSet rs=Dao.SearchGood_name(con, name);
//			Vector vt=new Vector();
//			vt.add(rs.getString("Good_ID"));
//			vt.add(rs.getString("Good_name"));
//			vt.add(rs.getString("Good_tag"));
//			vt.add(rs.getString("Good_price"));
//			vt.add(rs.getString("Good_store"));
//			vt.add(rs.getString("Good_manufacturer"));
//			dtm.addRow(vt);
//			while(rs.next()) {
//				Vector v=new Vector();
//				v.add(rs.getString("Good_ID"));
//				v.add(rs.getString("Good_name"));
//				v.add(rs.getString("Good_tag"));
//				v.add(rs.getString("Good_price"));
//				v.add(rs.getString("Good_store"));
//				v.add(rs.getString("Good_manufacturer"));
//				dtm.addRow(v);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//			}
//		}
	}
	/**
	 * ����Ʒ��ǩ����
	 * @param goodinfo
	 */
	private void fillTable_tag(TbGoodinfo goodinfo) {
		DefaultTableModel dtm=(DefaultTableModel)GoodinfoTable.getModel();
		dtm.setRowCount(0);
		String tp="SEARCH_GOODTAG";
		TbGoodinfo good1=new TbGoodinfo();
		good1.setGood_tag(this.search_tagtxt.getText());
		Message message=new Message(tp,good1);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
//		Connection con =null;
		try {
			Message recevied=client.sendAndReceive(message);	
			System.out.print(recevied.isResponse());
			Vector <TbGoodinfo> s = new Vector<TbGoodinfo>();
			s=recevied.getTbGoodvector();
			System.out.print(s.size());
			for(int i=0;i<s.size();i++) {
				TbGoodinfo temp=s.get(i);
				Vector v=new Vector();
				v.add(temp.getGood_ID());
				v.add(temp.getGood_name());
				v.add(temp.getGood_tag());
				v.add(temp.getGood_price());
				v.add(temp.getGood_store());
				v.add(temp.getGood_manufacturer());
				dtm.addRow(v);
			}
			if(recevied.isResponse()) {
			}else {
				JOptionPane.showMessageDialog(null, "没有搜索到啊，再看看吧");
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
//		DefaultTableModel dtm=(DefaultTableModel)GoodinfoTable.getModel();
//		dtm.setRowCount(0);
//		Connection con =null;
//		String tag=this.search_tagtxt.getText();
//		try {
//			con=dbUtil.getCon();
//			ResultSet rs=Dao.SearchGood_tag(con, tag);
//			Vector vt=new Vector();
//			vt.add(rs.getString("Good_ID"));
//			vt.add(rs.getString("Good_name"));
//			vt.add(rs.getString("Good_tag"));
//			vt.add(rs.getString("Good_price"));
//			vt.add(rs.getString("Good_store"));
//			vt.add(rs.getString("Good_manufacturer"));
//			dtm.addRow(vt);
//			while(rs.next()) {
//				Vector v=new Vector();
//				v.add(rs.getString("Good_ID"));
//				v.add(rs.getString("Good_name"));
//				v.add(rs.getString("Good_tag"));
//				v.add(rs.getString("Good_price"));
//				v.add(rs.getString("Good_store"));
//				v.add(rs.getString("Good_manufacturer"));
//				dtm.addRow(v);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//			}
//		}
	}
}
