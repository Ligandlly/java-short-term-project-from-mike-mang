package HospitalFront;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Hospital.Ubtil.Hospital_dbUtil;

import HospitalDAO.DrugDAO;
import HospitalDAO.MedHistoryDAO;
import HospitalModel.MedHistoryModel;
import Message.Message;

import gui.DarkLabel;
import gui.LightButton;

import javax.swing.JOptionPane;
import gui.LightTextField;
import gui.DarkButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class AddMedHistory extends JFrame {

	private JPanel contentPane;
	private LightTextField CardField;
	private LightTextField NameField;
	private LightTextField MedHistoryField;
	private LightTextField MainSuitField;
	private LightTextField DiagnoseField;
	private LightTextField TimeField;
	private String Type = "ADD_MEDHISTORY";
	private String CARD = "\\d{9}";
	private String TIME = "\\d{4}+\\/+\\d{1,2}+\\/+\\d{1,2}";
	private static int check=5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddMedHistory frame = new AddMedHistory();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddMedHistory(String a,String b) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(700, 433));
		setResizable(false);
		setTitle("\u75C5\u5386");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 473);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(700, 433));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DarkLabel lblNewLabel = new DarkLabel("\u4E00\u5361\u901A");
		lblNewLabel.setBounds(54, 13, 72, 24);
		contentPane.add(lblNewLabel);

		DarkLabel lblNewLabel_1 = new DarkLabel("\u75C5\u4EBA\u59D3\u540D");
		lblNewLabel_1.setBounds(54, 76, 72, 24);
		contentPane.add(lblNewLabel_1);

		DarkLabel lblNewLabel_2 = new DarkLabel("\u75C5\u53F2");
		lblNewLabel_2.setBounds(54, 139, 72, 24);
		contentPane.add(lblNewLabel_2);

		DarkLabel lblNewLabel_3 = new DarkLabel("\u4E3B\u8BC9");
		lblNewLabel_3.setBounds(54, 200, 72, 24);
		contentPane.add(lblNewLabel_3);

		DarkLabel lblNewLabel_4 = new DarkLabel("\u8BCA\u65AD");
		lblNewLabel_4.setBounds(54, 263, 72, 24);
		contentPane.add(lblNewLabel_4);

		DarkLabel lblNewLabel_5 = new DarkLabel("\u4E66\u5199\u65F6\u95F4");
		lblNewLabel_5.setBounds(54, 328, 72, 24);
		contentPane.add(lblNewLabel_5);

		CardField = new LightTextField();
		CardField.setBounds(126, 13, 467, 24);
		CardField.setText(a);
		contentPane.add(CardField);
		CardField.setColumns(10);

		NameField = new LightTextField();
		NameField.setBounds(126, 76, 467, 24);
		NameField.setText(b);
		contentPane.add(NameField);
		NameField.setColumns(10);

		MedHistoryField = new LightTextField();
		MedHistoryField.setBounds(126, 139, 467, 24);
		contentPane.add(MedHistoryField);
		MedHistoryField.setColumns(10);

		MainSuitField = new LightTextField();
		MainSuitField.setBounds(126, 200, 467, 24);
		contentPane.add(MainSuitField);
		MainSuitField.setColumns(10);

		DiagnoseField = new LightTextField();
		DiagnoseField.setBounds(126, 263, 465, 24);
		contentPane.add(DiagnoseField);
		DiagnoseField.setColumns(10);

		TimeField = new LightTextField();
		TimeField.setBounds(126, 328, 467, 24);
		Date date=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化为日期/时间字符串
        String cc=sdf.format(date);
        TimeField.setText(cc);
        TimeField.setEditable(false);
		contentPane.add(TimeField);
		TimeField.setColumns(10);
		

		DarkButton OKButton = new DarkButton("\u4FDD\u5B58");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				AddMedHistory(click);
			}
		});
		OKButton.setBounds(66, 394, 113, 27);
		contentPane.add(OKButton);

		DarkButton ResetButton = new DarkButton("\u91CD\u7F6E");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				resetValueActionPerformed(click);
			}
		});
		ResetButton.setBounds(603, 394, 113, 27);
		contentPane.add(ResetButton);
		
		LightButton TransferButton = new LightButton("\u8F6C\u8BCA");
		TransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedHistoryModel med=new MedHistoryModel();
				med.setCard(CardField.getText());
				med.setPerson_Name(NameField.getText());
				AddTransfer A=new AddTransfer(med);
				A.setVisible(true);
			}
		});
		TransferButton.setBounds(245, 394, 113, 27);
		contentPane.add(TransferButton);
		
		LightButton AddDrugTradeButton = new LightButton("\u5F00\u5904\u65B9");
		AddDrugTradeButton.setBounds(424, 394, 113, 27);
		contentPane.add(AddDrugTradeButton);
	}

	protected void AddMedHistory(ActionEvent click) {
		MedHistoryModel med = new MedHistoryModel();
		boolean flag = true;
		if (CardField.getText().matches(CARD)) {

		} else {
			flag = false;
			JOptionPane.showMessageDialog(null, "未正确输入一卡通号", "错误", JOptionPane.ERROR_MESSAGE);
		}

		if (flag == true) {
			med.setCard(CardField.getText());
			med.setPerson_Name(NameField.getText());
			med.setMedHistory_History(MedHistoryField.getText());
			med.setMedHistory_MainSuit(MainSuitField.getText());
			med.setMedHistory_Diagnose(DiagnoseField.getText());
			med.setMedHistory_Time(TimeField.getText());
			Message message = new Message(Type, med);
			client.TheClient client=new client.TheClient();
			message.setCheckCode(check);
			Message received=new Message();
			try{
				received=client.sendAndReceive(message);
				if(received.isResponse()) {
					JOptionPane.showMessageDialog(null, "病历保存成功", "提示ʾ", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "病历保存失败，请重试", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}catch(UnknownHostException e){
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Connection con = null;
			// Hospital_dbUtil D = new Hospital_dbUtil();
			// try {
			// 	con = D.getCon();
			// 	if (MedHistoryDAO.InsertMedHistory(con, med) != 0) {
			// 		JOptionPane.showMessageDialog(null, "������ӳɹ�", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			// 	}
			// } catch (Exception e) {
			// 	e.printStackTrace();
			// }
		}
	}

	private void resetValueActionPerformed(ActionEvent click) {
		this.MedHistoryField.setText("");
		this.MainSuitField.setText("");
		this.DiagnoseField.setText("");
	}

}
