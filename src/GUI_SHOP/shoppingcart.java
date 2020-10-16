package GUI_SHOP;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import BankDAO.WalletDAO;
import BankModel.WalletModel;
import Dao.Dao;
import Message.Message;
import client.TheClient;
import model.TbGoodinfo;
import model.TbtradeMain;
import user.User;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class shoppingcart extends JFrame {
	private JTable table;
	private User user=new User();
	private TbtradeMain trade=new TbtradeMain();
	private int check = 2;
	private String Type = "SHOMYLIST";
	private JTextField yuan;
	private double sum=0;
	private double t=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					user.card="123";
					user.name="CHY";
					shoppingcart frame = new shoppingcart(user);
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
	public shoppingcart(User user) {
		setTitle("\u8D2D\u7269\u8F66");
		setBounds(100, 100, 700, 433);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u7ED3\u7B97");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getfeeactionPerformed(user);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u5237\u65B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetactionPerformed(evt,user);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u8D2D\u4E70\u6570\u91CF");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				modifyactionPerformed(evt);
			}
		});
		
		yuan = new JTextField();
		yuan.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u91D1\u989D\uFF1A");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(99, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(yuan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(107)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(587, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(113, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(btnNewButton_1)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_2)
								.addComponent(yuan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(39))))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u62E9", "\u5546\u54C1\u540D", "\u6807\u7B7E", "\u5355\u4EF7/\u5143", "\u8D2D\u4E70\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
/**
 * �޸Ĺ�������
 * @param evt
 */
	private void modifyactionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String Type1="MODIFY";
		int row = this.table.getSelectedRow();
		String Good_Name=(String)table.getValueAt(row, 1);
		int Good_Num=Integer.parseInt(table.getValueAt(row, 4).toString());
		TbtradeMain trade = new TbtradeMain();
		trade.setName(Good_Name);
		trade.setNum(Good_Num);
		Message message=new Message(Type1,trade);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
			try {
				Message recevied=client.sendAndReceive(message);
//				System.out.print("���ǰɰ�Sir"+recevied.isResponse());
				if(recevied.isResponse()) {
					JOptionPane.showMessageDialog(null, "修改成功");
				}else {
					JOptionPane.showMessageDialog(null, "修改失败");
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
			int rowcount = table.getRowCount();
			for(int j=0;j<rowcount;++j) {
				int a=Integer.parseInt(table.getValueAt(j, 4).toString());
				double b=Double.parseDouble(table.getValueAt(j, 3).toString());
				sum=sum+a*b;
			}
//			System.out.print(rowcount);
			System.out.print(sum);
			t=sum;
			this.yuan.setText(String.valueOf(t));
			sum=0;
	}

	private void getfeeactionPerformed(User user) {
		// TODO Auto-generated method stub
		WalletModel n= new WalletModel();
		n.setCard(user.card);
		n.setName(user.name);
		n.setBalance(t);
		String yp="SHOPTRADE";
		Message message= new Message(yp,n);
		message.setCheckCode(7);
		message.setS("��Ʒ");
		Date now = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //��ʽ��Ϊ����/ʱ���ַ���
        String cc=sdf.format(now);
        message.setS2(cc);
        client.TheClient client=new TheClient();
        try {
			Message recevied=client.sendAndReceive(message);
			 if(recevied.isResponse())
					JOptionPane.showMessageDialog(null, "已扣款，欢迎下次再来购买");
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
        if(message.isResponse())
		JOptionPane.showMessageDialog(null, "已扣款，欢迎下次再来购买");
	}

	private void resetactionPerformed(ActionEvent evt,User user) {
//		Connection con=null;
		DefaultTableModel dtm1 = (DefaultTableModel) table.getModel();
		dtm1.setRowCount(0);
		Message message =new Message(Type,user);
		message.setCheckCode(check);
		client.TheClient client =new TheClient();
		try {
//			Message recevied=client.sendAndReceive(message);
//			Vector <TbtradeMain> s = new Vector<TbtradeMain>();
//			s=recevied.getTbtradeMainvector();
//			for(int i=0;i<1;i++) {
////				TbtradeMain temp=s.get(i);
//				Vector v=new Vector();
//				v.add(true);
//				v.add("��â�����Ӥ��");
//				v.add("��");
//				v.add("10");
//				v.add("20");
//				v.add("1");
//				dtm1.addRow(v);
//		}
//			}finally {
//				
//			} 
		Message recevied=client.sendAndReceive(message);	
		Vector <TbtradeMain> s = new Vector<TbtradeMain>();
		s=recevied.getTbtradeMain();
		for(int i=0;i<s.size();i++) {
			TbtradeMain temp=s.get(i);
			Vector v=new Vector();
			if(temp.getState()==1)
			v.add(true);
			v.add(temp.getName());
			v.add(temp.getTag());
			//v.add(temp.getStore());
			v.add(temp.getPrice());
			v.add(temp.getNum());
			dtm1.addRow(v);
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
		}finally {
			
		}//catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			con=dbUtil.getCon();
//			ResultSet re=Dao.ShowMylist(con, user);
//			while(re.next()) {
//				Vector v=new Vector();
//				v.add(re.getInt("state"));
//				v.add(re.getString("name"));
//				v.add(re.getString("tag"));
//				v.add(re.getString("store"));
//				v.add(re.getString("price"));
//				v.add(re.getString("num"));
//				dtm.addRow(v);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "ˢ��ʧ��");
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//			}
//		}
	}
}
