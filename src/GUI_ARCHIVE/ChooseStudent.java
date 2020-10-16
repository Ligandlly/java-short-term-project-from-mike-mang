package GUI_ARCHIVE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import GUI_ARCHIVE.ShowEditArchive_Manager;

import Arcmodel.Archive;
import Message.Message;
import client.TheClient;
import user.User;
import arcdao.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Vector;
import java.awt.event.ActionEvent;


public class ChooseStudent extends JFrame {

	private JPanel contentPane;
	private JTextField SCardtext;
	private static String Type1 = "Archive_View";
	private static int check = 4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					user.name="хн╧Заж";
					ChooseStudent frame = new ChooseStudent(user);
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

	public ChooseStudent(User user) {
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel.setBounds(71, 137, 144, 33);
		contentPane.add(lblNewLabel);
		
		SCardtext = new JTextField();
		SCardtext.setBounds(201, 140, 252, 27);
		contentPane.add(SCardtext);
		SCardtext.setColumns(10);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SearchArchive(event,user);
				//ShowEditArchive_Manager a=new ShowEditArchive_Manager();
				//a.setVisible(true);
			}
		});
		btnNewButton.setBounds(356, 292, 97, 23);
		contentPane.add(btnNewButton);
	}
	protected void SearchArchive(ActionEvent event,User user) {
		 Archive arc_Choose=new Archive();
		arc_Choose.setCard(SCardtext.getText());
		if (arc_Choose.getCard().equals("")!=true) {
			
			Message message = new Message(Type1, arc_Choose);
			message.setCheckCode(check);
			client.TheClient client = new TheClient();

			Message received = new Message();
			try {
				received = client.sendAndReceive(message);
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
		
			try {
				Archive s = (Archive)received.getAllembracing();
				ShowEditArchive_Manager a=new ShowEditArchive_Manager(s,user);
				a.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
