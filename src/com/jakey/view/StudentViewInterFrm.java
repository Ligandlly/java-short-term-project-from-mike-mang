/*
 * StudentViewInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jakey.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.jakey.dao.StudentDao;
import com.jakey.model.Course;
import com.jakey.model.Sinfo;
import com.jakey.util.DbUtil;
import com.jakey.util.StringUtil;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Dimension;
import java.awt.Color;

/**
 *
 * @author  __USER__
 */
public class StudentViewInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	StudentDao studentDao = new StudentDao();

	/** Creates new form StudentViewInterFrm */
	public StudentViewInterFrm() {
		//getContentPane().setBackground(new Color(64, 116, 52));
		getContentPane().setBackground(new Color(240,240,240));
		setPreferredSize(new Dimension(700, 433));
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Sinfo());
	}

	private void fillTable(Sinfo sinfo) {
		DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;

		try {
			con = dbUtil.getCon();
			ResultSet rs = studentDao.StudentList(con, sinfo);

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Sno"));
				v.add(rs.getString("Sname"));
				v.add(rs.getString("Ssex"));
				v.add(rs.getString("Smajor"));
				v.add(rs.getString("Stele"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		studentTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		SnoTxt = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		SnameTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u5b66\u751f\u8d44\u6599\u67e5\u770b");

		studentTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "学号", "姓名", "性别", "专业", "电话" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(studentTable);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u641c\u7d22\u6761\u4ef6"));

		jLabel1.setText("\u5b66\u751f\u5b66\u53f7");

		jLabel2.setText("\u5b66\u751f\u59d3\u540d");


		jb_search
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\search.png")); // NOI18N
		jb_search.setText("\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_searchActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(78)
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SnoTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SnameTxt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(25)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(SnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(SnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(25)
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addGap(23))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String sno = this.SnoTxt.getText();
		String sname = this.SnameTxt.getText();
		if (StringUtil.isEmpty(sno)) {
			sno = "-1";
		}
		Sinfo sinfo = new Sinfo(Integer.parseInt(sno), sname);
		this.fillTable(sinfo);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField SnameTxt;
	private javax.swing.JTextField SnoTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_search;
	private javax.swing.JTable studentTable;
	// End of variables declaration//GEN-END:variables

}