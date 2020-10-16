package GUI_ARCHIVE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Message.Message;
import client.TheClient;
import user.User;
import Arcmodel.log;
import java.awt.Color;

public class ChangeLog extends JFrame {
	private JTable logtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeLog frame = new ChangeLog();
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
	public ChangeLog() {
		setResizable(false);

		setTitle("\u66F4\u6539\u65E5\u5FD7");
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setSize(700,433);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 688, 404);
		getContentPane().add(scrollPane_1);
		
		logtable = new JTable();
		logtable.setBackground(Color.WHITE);
		logtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u4E00\u5361\u901A\u53F7", "\u5B66\u751F\u59D3\u540D", "\u4FEE\u6539\u4EBA", "\u4FEE\u6539\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		logtable.getColumnModel().getColumn(0).setPreferredWidth(95);
		scrollPane_1.setViewportView(logtable);
		this.fillTable(new log());
	}
	
	
	public ChangeLog(User user) {
		setResizable(false);

		setTitle("\u66F4\u6539\u65E5\u5FD7");
		setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setSize(700,433);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 688, 404);
		getContentPane().add(scrollPane_1);
		
		logtable = new JTable();
		logtable.setBackground(Color.WHITE);
		logtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u4E00\u5361\u901A\u53F7", "\u5B66\u751F\u59D3\u540D", "\u4FEE\u6539\u4EBA", "\u4FEE\u6539\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		logtable.getColumnModel().getColumn(0).setPreferredWidth(95);
		scrollPane_1.setViewportView(logtable);
		this.fillTable(new log());
	}
	
	private void fillTable(log lg) {
		DefaultTableModel dtm = (DefaultTableModel) logtable.getModel();
		dtm.setRowCount(0);
		String tp="Log_Show";
		Message message = new Message(tp, lg);
		message.setCheckCode(4);
		
		client.TheClient client=new TheClient();
		Message received;
		try {
			received = client.sendAndReceive(message);
			Vector<log> TbB = new Vector<log>();
			TbB = received.getChangeVector();
			for(int i=0;i<TbB.size();i++) {
				log temp = new log();
				Vector v = new Vector();
				temp = TbB.get(i);
				v.add(temp.getCarc().getCard());
				v.add(temp.getCarc().getName());
				v.add(temp.getChanger());
				
				v.add(temp.getChange_Time());
			
				dtm.addRow(v);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
