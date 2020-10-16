/*
 * GradeViewInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jakey.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.jakey.dao.GradeDao;
import com.jakey.model.Grade;
import com.jakey.util.DbUtil;
import java.awt.Dimension;
import java.awt.Color;

/**
 *
 * @author  __USER__
 */
public class GradeViewFrm2 extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	GradeDao gradeDao = new GradeDao();

	/** Creates new form GradeViewInterFrm */
	public GradeViewFrm2() {
		getContentPane().setBackground(new Color(64, 116, 52));
		setPreferredSize(new Dimension(700, 433));
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Grade());
	}

	private void fillTable(Grade grade) {
		DefaultTableModel dtm = (DefaultTableModel) gradeTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = gradeDao.gradeList(con, grade);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("gradeId"));
				v.add(rs.getString("gradeName"));
				v.add(rs.getString("gradeTime"));
				v.add(rs.getString("gradeTeacher"));
				v.add(rs.getString("capacity"));
				v.add(rs.getString("numSelected"));
				dtm.addRow(v);

			}
		}catch (Exception e) {
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

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
//GEN-BEGIN:initComponents
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {

jScrollPane1 = new javax.swing.JScrollPane();
gradeTable = new javax.swing.JTable();

setClosable(true);
setIconifiable(true);
setTitle("\u8BFE\u7A0B\u6210\u7EE9\u67E5\u770B");

gradeTable.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"�γ̱��", "�γ�����", "����ʱ��", "�ο���ʦ", "�γ̳ɼ�", "��ע"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
jScrollPane1.setViewportView(gradeTable);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
.addContainerGap())
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
.addContainerGap())
);

pack();
}// </editor-fold>
//GEN-END:initComponents

//GEN-BEGIN:variables
// Variables declaration - do not modify
private javax.swing.JTable gradeTable;
private javax.swing.JScrollPane jScrollPane1;
// End of variables declaration//GEN-END:variables

}