package GUI_SHOP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.Dao;
import Message.Message;
import client.TheClient;
import gui.MyTable;
import model.TbGoodinfo;
import user.User;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_XIUGAI extends JFrame {
	private JTextField IDtext;
	private JTextField GoodNameTxt;
	private JTextField ManufacturerTxt;
	private JTextField GoodPriceTxt;
	private JTextField GoodStoreTxt;
	private int check=2;
	private String Type="ADDGOOD";
	private JTextField tagtextField;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_XIUGAI frame = new GUI_XIUGAI();
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
	public GUI_XIUGAI() {
		setTitle("\u67E5\u8BE2&\u4FEE\u6539\u5E93\u5B58");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1ID\uFF1A");
		lblNewLabel.setBounds(44, 49, 58, 15);
		getContentPane().add(lblNewLabel);
		
		IDtext = new JTextField();
		IDtext.setBounds(148, 46, 126, 21);
		getContentPane().add(IDtext);
		IDtext.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodactionSearchperformed(evt);
			}
		});
		btnNewButton.setBounds(453, 45, 97, 23);
		getContentPane().add(btnNewButton);
		
		GoodNameTxt = new JTextField();
		GoodNameTxt.setBounds(207, 278, 126, 21);
		getContentPane().add(GoodNameTxt);
		GoodNameTxt.setColumns(10);
		
		ManufacturerTxt = new JTextField();
		ManufacturerTxt.setBounds(479, 278, 126, 21);
		getContentPane().add(ManufacturerTxt);
		ManufacturerTxt.setColumns(10);
		
		GoodPriceTxt = new JTextField();
		GoodPriceTxt.setBounds(372, 318, 97, 21);
		getContentPane().add(GoodPriceTxt);
		GoodPriceTxt.setColumns(10);
		
		GoodStoreTxt = new JTextField();
		GoodStoreTxt.setBounds(553, 318, 89, 21);
		getContentPane().add(GoodStoreTxt);
		GoodStoreTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(139, 281, 71, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u751F\u4EA7\u5546\uFF1A");
		lblNewLabel_2.setBounds(397, 281, 58, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6807\u7B7E\uFF1A");
		lblNewLabel_3.setBounds(139, 321, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5546\u5E97\u5355\u4EF7\uFF1A");
		lblNewLabel_4.setBounds(307, 321, 65, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5546\u54C1\u5E93\u5B58\uFF1A");
		lblNewLabel_5.setBounds(479, 321, 71, 15);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodactionaddperformed(e);
			}
		});
		btnNewButton_1.setBounds(545, 363, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		tagtextField = new JTextField();
		tagtextField.setBounds(207, 318, 80, 21);
		getContentPane().add(tagtextField);
		tagtextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				chosegood(evt);
			}
		});
		scrollPane.setBounds(54, 116, 601, 155);
		getContentPane().add(scrollPane);
		
		table = new MyTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u751F\u4EA7\u5546", "\u6807\u7B7E", "\u5546\u5E97\u5355\u4EF7", "\u5546\u54C1\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		this.filltable(new TbGoodinfo());
	}
	
	public GUI_XIUGAI(User user) {
		setTitle("\u67E5\u8BE2&\u4FEE\u6539\u5E93\u5B58");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1ID\uFF1A");
		lblNewLabel.setBounds(44, 49, 58, 15);
		getContentPane().add(lblNewLabel);
		
		IDtext = new JTextField();
		IDtext.setBounds(148, 46, 126, 21);
		getContentPane().add(IDtext);
		IDtext.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodactionSearchperformed(evt);
			}
		});
		btnNewButton.setBounds(453, 45, 97, 23);
		getContentPane().add(btnNewButton);
		
		GoodNameTxt = new JTextField();
		GoodNameTxt.setBounds(207, 278, 126, 21);
		getContentPane().add(GoodNameTxt);
		GoodNameTxt.setColumns(10);
		
		ManufacturerTxt = new JTextField();
		ManufacturerTxt.setBounds(479, 278, 126, 21);
		getContentPane().add(ManufacturerTxt);
		ManufacturerTxt.setColumns(10);
		
		GoodPriceTxt = new JTextField();
		GoodPriceTxt.setBounds(372, 318, 97, 21);
		getContentPane().add(GoodPriceTxt);
		GoodPriceTxt.setColumns(10);
		
		GoodStoreTxt = new JTextField();
		GoodStoreTxt.setBounds(553, 318, 89, 21);
		getContentPane().add(GoodStoreTxt);
		GoodStoreTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_1.setBounds(139, 281, 71, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u751F\u4EA7\u5546\uFF1A");
		lblNewLabel_2.setBounds(397, 281, 58, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6807\u7B7E\uFF1A");
		lblNewLabel_3.setBounds(139, 321, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5546\u5E97\u5355\u4EF7\uFF1A");
		lblNewLabel_4.setBounds(307, 321, 65, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5546\u54C1\u5E93\u5B58\uFF1A");
		lblNewLabel_5.setBounds(479, 321, 71, 15);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodactionaddperformed(e);
			}
		});
		btnNewButton_1.setBounds(545, 363, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		tagtextField = new JTextField();
		tagtextField.setBounds(207, 318, 80, 21);
		getContentPane().add(tagtextField);
		tagtextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				chosegood(evt);
			}
		});
		scrollPane.setBounds(54, 116, 601, 155);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1ID", "\u5546\u54C1\u540D\u79F0", "\u751F\u4EA7\u5546", "\u6807\u7B7E", "\u5546\u5E97\u5355\u4EF7", "\u5546\u54C1\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		this.filltable(new TbGoodinfo());
	}
	
	
	/**
	 * ��ȡ�޸��¼�
	 * @param evt
	 */
	private void chosegood(MouseEvent evt) {
		// TODO Auto-generated method stub
		System.out.print("hey");
		int row = this.table.getSelectedRow();
		String Good_Name=(String)table.getValueAt(row, 1);
		String Good_Tag=(String)table.getValueAt(row, 3);
		Double Good_Price=Double.valueOf(table.getValueAt(row, 4).toString());
		int Good_Store=Integer.parseInt(table.getValueAt(row, 5).toString());
		String Good_Manufacturer=(String)table.getValueAt(row, 2);
		this.GoodPriceTxt.setText(String.valueOf(Good_Price));
		this.GoodNameTxt.setText(Good_Name);
		this.GoodStoreTxt.setText(String.valueOf(Good_Store));
		this.ManufacturerTxt.setText(Good_Manufacturer);
		this.tagtextField.setText(Good_Tag);
		System.out.print(Good_Price);
	}
/**
 * �޸���Ϣ
 * @param evt
 */
	private void goodactionSearchperformed(ActionEvent evt) {
		this.Search();
	}

	protected void goodactionaddperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String GoodID=this.IDtext.getText();
		String GoodName=this.GoodNameTxt.getText();
		String Manufacturer=this.ManufacturerTxt.getText();
		String Goodtag=this.tagtextField.getText();
		String Goodprice=this.GoodPriceTxt.getText();
		String Goodstore=this.GoodStoreTxt.getText();
		if(GoodID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "商品ID不能为空");
			return;
		}
		TbGoodinfo goodinfo=new TbGoodinfo(GoodID,GoodName,Goodtag,Double.valueOf(Goodprice),Integer.parseInt(Goodstore),Manufacturer,null,null);
//		Connection con=null;
		Message message=new Message(Type,goodinfo);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
		try {
			Message recevied=client.sendAndReceive(message);
			if(recevied.isResponse()) {
				JOptionPane.showMessageDialog(null, "修改成功");
				String tp="RETURN_ALLDRUG";
				Message message1=new Message();
				message1.setCheckCode(check);
				message1.setType(tp);
				client.TheClient client1=new TheClient();
				Message received1;
				received1 = client1.sendAndReceive(message1);
				if(received1.isResponse()){
					//JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}
			}else {
				JOptionPane.showMessageDialog(null, "出错了，再看看吧");
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
//		try {
//			
//			con=dbUtil.getCon();
//			boolean n=Dao.addGood(con, goodinfo);
//			if(n) {
//					con=dbUtil.getCon();
//					int deleteNum=Dao.DeleteGood(con, goodinfo);
//			}
//			if(n) {
//				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
//
//			}else {
//					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
//
//				}
//		}catch(Exception evt) {
//			evt.printStackTrace();
//			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
//
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception evt) {
//				evt.printStackTrace(); 
//			}
//		}
//		
//	}
	private void filltable(TbGoodinfo good) {
		System.out.print("���е�������");
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
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
			
			MyTable.colorizeTabel(table);
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

	/**
	 * ��ѯ
	 */
	private void Search() {
		String tp="SEARCHGOOD";
		 TbGoodinfo goodinfo=new TbGoodinfo();
			String GoodID=this.IDtext.getText();
			goodinfo.setGood_ID(GoodID);
			if(GoodID.isEmpty()) {
				JOptionPane.showMessageDialog(null, "商品ID不能为空");
				return;
			}
		Message message=new Message(tp,goodinfo);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
		try {
			Message recevied=client.sendAndReceive(message);
			TbGoodinfo tbg=(TbGoodinfo)recevied.getAllembracing();
			System.out.print(tbg);
			this.GoodPriceTxt.setText(String.valueOf(tbg.getGood_price()));
			this.tagtextField.setText(tbg.getGood_tag());
			this.ManufacturerTxt.setText(tbg.getGood_manufacturer());
			this.GoodNameTxt.setText(tbg.getGood_name());
			this.GoodStoreTxt.setText(String.valueOf(tbg.getGood_store()));
			if(recevied.isResponse()) {
//				JOptionPane.showMessageDialog(null, "sou�ɹ�");
			}else {
				JOptionPane.showMessageDialog(null, "出错了，再看看吧");
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
		
//		Connection con=null;
//		 TbGoodinfo goodinfo=new TbGoodinfo();
//		String GoodID=this.IDtext.getText();
//		goodinfo.setGood_ID(GoodID);
//		if(GoodID.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "��ƷID����Ϊ��");
//			return;
//		}
//		try {
//			con=dbUtil.getCon();
//			TbGoodinfo rs=Dao.SearchGood(con, goodinfo);
//			this.GoodPriceTxt.setText(String.valueOf(rs.getGood_price()));
//			this.tagtextField.setText(rs.getGood_tag());
//			this.ManufacturerTxt.setText(rs.getGood_manufacturer());
//			this.GoodNameTxt.setText(rs.getGood_name());
//			this.GoodStoreTxt.setText(String.valueOf(rs.getGood_store()));
//		}catch(Exception e){
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
