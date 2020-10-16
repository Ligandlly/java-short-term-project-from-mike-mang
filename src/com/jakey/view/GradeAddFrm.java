/*
 * GradeAddInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.jakey.view;


import java.sql.Connection;

import javax.swing.JOptionPane;

import com.jakey.dao.GradeDao;
import com.jakey.model.Grade;

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
public class GradeAddFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil=new DbUtil();
	GradeDao gradedao=new GradeDao();

	/** Creates new form GradeAddInterFrm */
	public GradeAddFrm() {
		setBackground(new Color(204, 255, 102));
		getContentPane().setBackground(new Color(64, 116, 52));
		setPreferredSize(new Dimension(700, 433));
		getContentPane().setSize(new Dimension(700, 433));
		setSize(new Dimension(700, 433));
		initComponents();
		this.setLocation(200, 50);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		gradeTimeTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		gradeNameTxt = new javax.swing.JTextField();
		gradeTeacherTxt = new javax.swing.JTextField();
		capacityTxt = new javax.swing.JTextField();
		jb_add = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFE\u7A0B\u6210\u7EE9\u8F93\u5165");

		jLabel1.setText("\u8bfe\u7a0b\u540d\u79f0");

		jLabel2.setText("\u8003\u8BD5\u65F6\u95F4");

		jLabel3.setText("\u4efb\u8bfe\u8001\u5e08");

		jLabel4.setText("\u8BFE\u7A0B\u6210\u7EE9");

		jb_add
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\GradeSys\\src\\com\\jakey\\view\\image\\add.png")); // NOI18N
		jb_add.setText("\u6dfb\u52a0");
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\GradeSys\\src\\com\\jakey\\view\\image\\reset.png")); // NOI18N
		jb_reset.setText("\u91cd\u7f6e");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(41)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel4)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel3)
									.addGap(18)
									.addComponent(gradeTeacherTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel1)
									.addGap(18)
									.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
							.addGap(108))
						.addComponent(jLabel2))
					.addContainerGap(175, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(390, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(gradeTimeTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(capacityTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
					.addGap(154))
				.addGroup(layout.createSequentialGroup()
					.addGap(215)
					.addComponent(jb_add, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(123)
					.addComponent(jb_reset, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(211, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(119)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(gradeTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(jLabel2)
							.addComponent(gradeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabel1)))
					.addGap(43)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(capacityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4)
						.addComponent(gradeTeacherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_reset)
						.addComponent(jb_add))
					.addGap(80))
		);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		String gradeName=this.gradeNameTxt.getText();
		String gradeTime=this.gradeTimeTxt.getText();
		String gradeTeacher=this.gradeTeacherTxt.getText();
		String  capacity=this.capacityTxt.getText();
		if(StringUtil.isEmpty(gradeName)){
			JOptionPane.showMessageDialog(this, "�γ̳ɼ����Ʋ���Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(gradeTime)){
			JOptionPane.showMessageDialog(this, "�Ͽ�ʱ�䲻��Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(gradeTeacher)){
			JOptionPane.showMessageDialog(this, "�ο���ʦ����Ϊ��!");
			return;
		}
		if(StringUtil.isEmpty(capacity)){
			JOptionPane.showMessageDialog(this, "�γ̳ɼ�����Ϊ��!");
			return;
		}
		Grade grade=new Grade(gradeName,gradeTime,gradeTeacher,Integer.parseInt(capacity));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=gradedao.gradeAdd(con, grade);
			if(n==1){
				JOptionPane.showMessageDialog(this, "�γ̳ɼ����ӳɹ�!");
				this.resetValue();
			}else{
				JOptionPane.showMessageDialog(this, "�γ̳ɼ�����ʧ��!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "�γ̳ɼ�����ʧ��!");
		}
		
	}

	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.resetValue();
	}
private void resetValue(){
	this.gradeNameTxt.setText("");
	this.gradeTeacherTxt.setText("");
	this.gradeTimeTxt.setText("");
	this.capacityTxt.setText("");
}
	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField capacityTxt;
	private javax.swing.JTextField gradeNameTxt;
	private javax.swing.JTextField gradeTeacherTxt;
	private javax.swing.JTextField gradeTimeTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JButton jb_add;
	private javax.swing.JButton jb_reset;
	// End of variables declaration//GEN-END:variables

}