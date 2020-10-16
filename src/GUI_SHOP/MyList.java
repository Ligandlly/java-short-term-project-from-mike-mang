package GUI_SHOP;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Dao.Dao;
import Message.Message;
import client.TheClient;
import model.TbtradeDetail;
import user.User;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MyList extends JFrame {
	private JTable listtable;
	private TbtradeDetail tradedetail = new TbtradeDetail();
	private Dao dao = new Dao();
	private int check = 2;
	private String Type = "SHOWLIST";

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
					MyList frame = new MyList(user);
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
	public MyList(User user) {
		setTitle("\u6211\u7684\u8BA2\u5355");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SearchactionPerformed(evt,user);
			}
		});
		btnNewButton.setBounds(26, 50, 97, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 96, 535, 226);
		getContentPane().add(scrollPane);

		listtable = new JTable();
		listtable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5E8F\u53F7",
				"\u5546\u54C1\u540D\u79F0", "\u8D2D\u4E70\u4EBA", "\u6570\u91CF/\u4EF6", "\u8D2D\u4E70\u65F6\u95F4" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(listtable);

	}

	private void SearchactionPerformed(ActionEvent evt,User user) {
		DefaultTableModel dtm = (DefaultTableModel) listtable.getModel();
		dtm.setRowCount(0);
//		Connection con=null;
		Message message = new Message(Type, user);
		message.setCheckCode(check);
		client.TheClient client = new TheClient();
		try {
			System.out.print("准备调用后端处理");		
			Message recevied=client.sendAndReceive(message);
			Vector <TbtradeDetail> s = new Vector<TbtradeDetail>();
			s=recevied.getTbtradeDetail();
//			System.out.print("数组大小为："+s.size());
			for(int i=0;i<s.size();i++) {
				TbtradeDetail temp=s.get(i);
				Vector v=new Vector();
				v.add(i);
				v.add(temp.getName());
				v.add(temp.getUer_ID());
				v.add(temp.getNum());
				v.add(temp.getData());
				dtm.addRow(v);
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
//			ResultSet re=Dao.showlist(con, user);
//			while(re.next()) {
//				Vector v=new Vector();
//				v.add(re.getInt("xuhao"));
//				v.add(re.getString("Name"));
//				v.add(re.getString("Uer_ID"));
//				v.add(re.getString("num"));
//				v.add(re.getString("date"));
//				dtm.addRow(v);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//				}
//			}
	}
}
