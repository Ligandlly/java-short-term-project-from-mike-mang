package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HospitalModel.MedHistoryModel;
import HospitalModel.Transfer;
import Message.Message;
import client.TheClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.DarkButton;
import gui.LightButton;
import gui.LightTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class AddTransfer extends JFrame {

	private JPanel contentPane;
	private LightTextField CardField;
	private LightTextField PNameField;
	private LightTextField DNameField;
	private LightTextField CommentTxt;
	private String Card = "\\d{9}";
	private String Type = "ADD_TRANSFER";
	private int check=5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public AddTransfer(MedHistoryModel med) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("\u8F6C\u8BCA\u5355");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u60A3\u8005\u4E00\u5361\u901A");
		lblNewLabel.setBounds(34, 29, 98, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u60A3\u8005\u59D3\u540D");
		lblNewLabel_1.setBounds(34, 129, 98, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BA1\u6279\u533B\u751F");
		lblNewLabel_2.setBounds(34, 229, 98, 18);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u8F6C\u8BCA\u610F\u89C1");
		lblNewLabel_3.setBounds(34, 329, 98, 18);
		contentPane.add(lblNewLabel_3);

		CardField = new LightTextField();
		CardField.setBounds(126, 26, 420, 24);
		CardField.setText(med.getCard());
		contentPane.add(CardField);
		CardField.setColumns(10);

		PNameField = new LightTextField();
		PNameField.setBounds(126, 126, 420, 24);
		PNameField.setText(med.getPerson_Name());
		contentPane.add(PNameField);
		PNameField.setColumns(10);

		DNameField = new LightTextField();
		DNameField.setBounds(126, 226, 420, 24);
		contentPane.add(DNameField);
		DNameField.setColumns(10);

		CommentTxt = new LightTextField();
		CommentTxt.setBounds(126, 326, 420, 71);
		contentPane.add(CommentTxt);
		CommentTxt.setColumns(10);

		JButton OKButton = new DarkButton("\u786E\u8BA4");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				Transfer tran = new Transfer();
				tran.setCard(CardField.getText());
				tran.setTransfer_Doctor(DNameField.getText());
				tran.setTransfer_Name(PNameField.getText());
				tran.setTransfer_Diagnose(CommentTxt.getText());
				tran.setTransfer_Status("���");
				Message message=new Message(Type,tran);
				message.setCheckCode(check);
				client.TheClient client=new TheClient();
				try {
					Message received=client.sendAndReceive(message);
					if(received.isResponse()) {
						JOptionPane.showMessageDialog(null, "添加成功", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "请重试", "错误", JOptionPane.ERROR_MESSAGE);
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
				
				dispose();

			}
		});
		OKButton.setBounds(55, 433, 113, 27);
		contentPane.add(OKButton);

		JButton ResetButton = new LightButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				resetValueActionPerformed(click);
			}
		});
		ResetButton.setBounds(510, 433, 113, 27);
		contentPane.add(ResetButton);
	}

	private void resetValueActionPerformed(ActionEvent click) {
		this.DNameField.setText("");
		this.CommentTxt.setText("");

	}
}
