package GUI_SHOP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Hospital.Ubtil.StringUtil;
import Dao.Dao;
import Message.Message;
import client.TheClient;
import model.TbGoodinfo;
import user.User;

public class GUI_Ruku extends JFrame {
	private JTextField goodtextID;
	private JTextField goodtextname;
	private JTextField goodtexttag;
	private JTextField goodtextmanufacturer;
	private JTextField goodtextprice;
	private JTextField goodtextstore;
	private int check=2;
	private String Type="ADDGOOD";
	
	private Dao dao=new Dao();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Ruku frame = new GUI_Ruku();
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
	public GUI_Ruku() {
		setBackground(Color.LIGHT_GRAY);
//		setClosable(true);
		setTitle("\u6DFB\u52A0\u5546\u54C1");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel Ruku = new JPanel();
		Ruku.setBackground(Color.white);
		getContentPane().add(Ruku);
		Ruku.setLayout(null);
		
		JButton addgoodinfo = new JButton("\u6DFB\u52A0");
		addgoodinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodactionaddperformed(evt);
			}
		});
		addgoodinfo.setBounds(427, 282, 97, 23);
		Ruku.add(addgoodinfo);
		
		JButton resetgoodinfo = new JButton("\u91CD\u7F6E");
		resetgoodinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 resetValueactionPerformed(e);
			}
		});
		resetgoodinfo.setBounds(547, 282, 97, 23);
		Ruku.add(resetgoodinfo);
		
		JLabel Good_ID = new JLabel("\u5546\u54C1ID");
		Good_ID.setBounds(30, 50, 92, 22);
		Ruku.add(Good_ID);
		
		JLabel Good_name = new JLabel("\u5546\u54C1\u540D\u79F0");
		Good_name.setBounds(30, 90, 92, 23);
		Ruku.add(Good_name);
		
		JLabel Good_tag = new JLabel("\u6807\u7B7E");
		Good_tag.setBounds(30, 130, 92, 23);
		Ruku.add(Good_tag);
		
		JLabel Good_manufacturer = new JLabel("\u751F\u4EA7\u5546");
		Good_manufacturer.setBounds(30, 170, 92, 23);
		Ruku.add(Good_manufacturer);
		
		JLabel Good_price = new JLabel("\u5355\u4EF7");
		Good_price.setBounds(30, 210, 92, 23);
		Ruku.add(Good_price);
		
		JLabel Good_store = new JLabel("\u5E93\u5B58");
		Good_store.setBounds(30, 250, 92, 23);
		Ruku.add(Good_store);
		
		goodtextID = new JTextField();
		goodtextID.setBounds(113, 51, 162, 23);
		Ruku.add(goodtextID);
		goodtextID.setColumns(10);
		
		goodtextname = new JTextField();
		goodtextname.setBounds(113, 93, 162, 22);
		Ruku.add(goodtextname);
		goodtextname.setColumns(10);
		
		goodtexttag = new JTextField();
		goodtexttag.setBounds(113, 135, 162, 23);
		Ruku.add(goodtexttag);
		goodtexttag.setColumns(10);
		
		goodtextmanufacturer = new JTextField();
		goodtextmanufacturer.setBounds(113, 173, 162, 23);
		Ruku.add(goodtextmanufacturer);
		goodtextmanufacturer.setColumns(10);
		
		goodtextprice = new JTextField();
		goodtextprice.setBounds(113, 218, 162, 22);
		Ruku.add(goodtextprice);
		goodtextprice.setColumns(10);
		 
		goodtextstore = new JTextField();
		goodtextstore.setBounds(113, 263, 162, 22);
		Ruku.add(goodtextstore);
		goodtextstore.setColumns(10);

	}
	
	public GUI_Ruku(User user) {
		setBackground(Color.LIGHT_GRAY);
//		setClosable(true);
		setTitle("\u6DFB\u52A0\u5546\u54C1");
		setBounds(100, 100, 700, 433);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel Ruku = new JPanel();
		Ruku.setBackground(Color.white);
		getContentPane().add(Ruku);
		Ruku.setLayout(null);
		
		JButton addgoodinfo = new JButton("\u6DFB\u52A0");
		addgoodinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				goodactionaddperformed(evt);
			}
		});
		addgoodinfo.setBounds(427, 282, 97, 23);
		Ruku.add(addgoodinfo);
		
		JButton resetgoodinfo = new JButton("\u91CD\u7F6E");
		resetgoodinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 resetValueactionPerformed(e);
			}
		});
		resetgoodinfo.setBounds(547, 282, 97, 23);
		Ruku.add(resetgoodinfo);
		
		JLabel Good_ID = new JLabel("\u5546\u54C1ID");
		Good_ID.setBounds(30, 50, 92, 22);
		Ruku.add(Good_ID);
		
		JLabel Good_name = new JLabel("\u5546\u54C1\u540D\u79F0");
		Good_name.setBounds(30, 90, 92, 23);
		Ruku.add(Good_name);
		
		JLabel Good_tag = new JLabel("\u6807\u7B7E");
		Good_tag.setBounds(30, 130, 92, 23);
		Ruku.add(Good_tag);
		
		JLabel Good_manufacturer = new JLabel("\u751F\u4EA7\u5546");
		Good_manufacturer.setBounds(30, 170, 92, 23);
		Ruku.add(Good_manufacturer);
		
		JLabel Good_price = new JLabel("\u5355\u4EF7");
		Good_price.setBounds(30, 210, 92, 23);
		Ruku.add(Good_price);
		
		JLabel Good_store = new JLabel("\u5E93\u5B58");
		Good_store.setBounds(30, 250, 92, 23);
		Ruku.add(Good_store);
		
		goodtextID = new JTextField();
		goodtextID.setBounds(113, 51, 162, 23);
		Ruku.add(goodtextID);
		goodtextID.setColumns(10);
		
		goodtextname = new JTextField();
		goodtextname.setBounds(113, 93, 162, 22);
		Ruku.add(goodtextname);
		goodtextname.setColumns(10);
		
		goodtexttag = new JTextField();
		goodtexttag.setBounds(113, 135, 162, 23);
		Ruku.add(goodtexttag);
		goodtexttag.setColumns(10);
		
		goodtextmanufacturer = new JTextField();
		goodtextmanufacturer.setBounds(113, 173, 162, 23);
		Ruku.add(goodtextmanufacturer);
		goodtextmanufacturer.setColumns(10);
		
		goodtextprice = new JTextField();
		goodtextprice.setBounds(113, 218, 162, 22);
		Ruku.add(goodtextprice);
		goodtextprice.setColumns(10);
		 
		goodtextstore = new JTextField();
		goodtextstore.setBounds(113, 263, 162, 22);
		Ruku.add(goodtextstore);
		goodtextstore.setColumns(10);

	}
	
	
	/**
	 * ��Ʒ����¼�
	 * @param e
	 */
	private void goodactionaddperformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String GoodID=this.goodtextID.getText();
		String Goodname=this.goodtextname.getText();
		String Goodtag=this.goodtexttag.getText();
		String Goodmanufacturer=this.goodtextmanufacturer.getText();
		String Goodprice=this.goodtextprice.getText();
		String Goodstore=this.goodtextstore.getText();
		if(StringUtil.isEmpty(GoodID)) {
			JOptionPane.showMessageDialog(null, "商品ID不能为空");
			return;
		}
		TbGoodinfo goodinfo=new TbGoodinfo(GoodID,Goodname,Goodtag,Double.valueOf(Goodprice),Integer.parseInt(Goodstore),Goodmanufacturer);
		Message message=new Message(Type,goodinfo);
		message.setCheckCode(check);
		client.TheClient client=new TheClient();
		try {
			Message recevied=client.sendAndReceive(message);
			//V <>s=received.getxxx();
			//for(int i=0;i<s.size();i++){
			//Tb b=s.get(i)
			//}
			if(recevied.isResponse()) {
				JOptionPane.showMessageDialog(null, "添加成功");
				this.resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "这里出错了");
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
		
//		Connection con=null;
//		try {
//			con=dbUtil.getCon();
//			boolean n=Dao.addGood(con, goodinfo);
//			if(n) {
//				JOptionPane.showMessageDialog(null, "��ӳɹ�");
//				resetValue();
//			}else {
//					JOptionPane.showMessageDialog(null, "���ʧ��");
//					resetValue();
//				}
//		}catch(Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "���ʧ��");
//			resetValue();
//		}finally {
//			try {
//				dbUtil.CloseConnection(con);
//			}catch(Exception e) {
//				e.printStackTrace(); 
//			}
//		}
	}

	//�����¼�����
	private void resetValueactionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	private void resetValue() {
		this.goodtextID.setText("");
		this.goodtextname.setText("");	
		this.goodtexttag.setText(""); 
		this.goodtextmanufacturer.setText("");
		this.goodtextprice.setText("");
		this.goodtextstore.setText("");
	
	} 
}
