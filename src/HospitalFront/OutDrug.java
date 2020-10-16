package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalModel.DrugModel;
import Message.Message;
import client.TheClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import gui.DarkButton;
import gui.LightButton;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class OutDrug extends JFrame {

	private JPanel contentPane;
	private JTextField DrugNameField;
	private JTextField AmountField;
	private String amount="\\d{1,}";
	private String Type="OUT_DRUG";
	private int check=5;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public OutDrug(String N) {
		setResizable(false);
		setTitle("\u836F\u54C1\u51FA\u5E93");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel.setBounds(34, 43, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u5E93\u6570\u91CF");
		lblNewLabel_1.setBounds(34, 114, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		DrugNameField = new JTextField();
		DrugNameField.setEditable(false);
		DrugNameField.setBounds(136, 40, 194, 24);
		DrugNameField.setText(N);
		contentPane.add(DrugNameField);
		DrugNameField.setColumns(10);
		
		AmountField = new JTextField();
		AmountField.setBounds(136, 111, 194, 24);
		contentPane.add(AmountField);
		AmountField.setColumns(10);
		
		DarkButton OKButton = new DarkButton("\u786E\u8BA4\u51FA\u5E93");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean a=true;
				if(AmountField.getText().matches(amount)) {
					
				}else {
					JOptionPane.showMessageDialog(null, "未正确输入数量","错误",JOptionPane.ERROR_MESSAGE);
					a=false;
				}
				if(a==true) {
				DrugModel drug=new DrugModel();
				drug.setDrug_Name(DrugNameField.getText());
				drug.setDrug_Amount(Integer.parseInt(AmountField.getText()));
				Message message=new Message(Type, drug);
				message.setCheckCode(check);
				client.TheClient client=new TheClient();
				Message recevied;
				try {
					recevied = client.sendAndReceive(message);
					if(recevied.isResponse()) {
						JOptionPane.showMessageDialog(null, "药品出库成功","提示",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "药品库存数不足","失败",JOptionPane.ERROR_MESSAGE);
					}
					dispose();
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

				}
				
			}
		});
		OKButton.setBounds(34, 191, 113, 27);
		contentPane.add(OKButton);
		
		LightButton ResetButton = new LightButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				resetValueActionPerformed(click);
			}
		});
		ResetButton.setBounds(283, 191, 113, 27);
		contentPane.add(ResetButton);
	}
	
	private void resetValueActionPerformed(ActionEvent click) {
		this.AmountField.setText("");
	}

}
