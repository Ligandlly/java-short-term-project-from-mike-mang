package GUI_ARCHIVE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import Arcmodel.Archive;
import Arcmodel.TbRecord;
import com.Hospital.Ubtil.*;
import arcdao.*;
import Message.Message;
import client.TheClient;
import user.User;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class RegArchive extends JFrame {
	private JTextField Birthtext;
	private JTextField Nativetext;
	private JTextField IDnumtext;
	private JTextField Collegetext;
	private JTextField Majortext;
	private JTextField Agetext;
	private JTextField Nametext;
	private JTextField Natinnalitytext;
	private JTextField Eductiontext;
	private JTextField Politicstext;
	private JTextField Cardtext;
	private JTextField EnrollDatetext;
	private JLabel photoLabel;

	public static TbRecord UPDATE_RECORD = null;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private String temp = "男";
	private String temp2 = "未婚";
	private JTextField Telephonetext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user=new User();
					user.name="任国林";
					RegArchive frame = new RegArchive(user);
					// System.out.println();
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
	public RegArchive(User user) {
		setResizable(false);
		setTitle("\u5B66\u751F\u6CE8\u518C");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);

		setSize(700, 433);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 688, 404);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A\r\n");
		lblNewLabel.setBounds(10, 42, 58, 19);
		panel_1.add(lblNewLabel);

		JRadioButton WomanRadioButton = new JRadioButton("\u5973");
		WomanRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = WomanRadioButton.getText();
			}
		});
		WomanRadioButton.setBackground(Color.WHITE);
		buttonGroup_1.add(WomanRadioButton);
		WomanRadioButton.setBounds(269, 40, 58, 23);
		panel_1.add(WomanRadioButton);

		JLabel lblNewLabel_2 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		lblNewLabel_2.setBounds(148, 90, 85, 19);
		panel_1.add(lblNewLabel_2);

		Birthtext = new JTextField();
		Birthtext.setBounds(218, 90, 88, 21);
		panel_1.add(Birthtext);
		Birthtext.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u6C11\u65CF\uFF1A");
		lblNewLabel_3.setBounds(10, 90, 58, 18);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u7C4D\u8D2F\uFF1A");
		lblNewLabel_4.setBounds(356, 41, 49, 21);
		panel_1.add(lblNewLabel_4);

		Nativetext = new JTextField();
		Nativetext.setBounds(419, 40, 93, 21);
		panel_1.add(Nativetext);
		Nativetext.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_5.setBounds(380, 198, 78, 19);
		panel_1.add(lblNewLabel_5);

		IDnumtext = new JTextField();
		IDnumtext.setBounds(450, 197, 222, 21);
		panel_1.add(IDnumtext);
		IDnumtext.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("\u5B66\u5386\uFF1A");
		lblNewLabel_6.setBounds(10, 147, 58, 19);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u5B66\u9662\uFF1A");
		lblNewLabel_7.setBounds(148, 147, 49, 17);
		panel_1.add(lblNewLabel_7);

		Collegetext = new JTextField();
		Collegetext.setBounds(195, 145, 132, 21);
		panel_1.add(Collegetext);
		Collegetext.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("\u4E13\u4E1A\uFF1A");
		lblNewLabel_8.setBounds(358, 145, 58, 23);
		panel_1.add(lblNewLabel_8);

		Majortext = new JTextField();
		Majortext.setBounds(419, 144, 93, 21);
		panel_1.add(Majortext);
		Majortext.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_9.setBounds(358, 90, 58, 18);
		panel_1.add(lblNewLabel_9);

		Agetext = new JTextField();
		Agetext.setBounds(419, 92, 93, 21);
		panel_1.add(Agetext);
		Agetext.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		lblNewLabel_10.setBounds(10, 199, 85, 17);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1.setBounds(148, 44, 58, 15);
		panel_1.add(lblNewLabel_1);

		JRadioButton ManRadioButton = new JRadioButton("\u7537");
		ManRadioButton.setSelected(true);
		ManRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp = ManRadioButton.getText();
			}
		});
		ManRadioButton.setBackground(Color.WHITE);
		buttonGroup_1.add(ManRadioButton);
		ManRadioButton.setBounds(212, 40, 51, 23);
		panel_1.add(ManRadioButton);

		Nametext = new JTextField();
		Nametext.setBounds(66, 41, 66, 21);
		panel_1.add(Nametext);
		Nametext.setColumns(10);

		Natinnalitytext = new JTextField();
		Natinnalitytext.setBounds(65, 90, 66, 21);
		panel_1.add(Natinnalitytext);
		Natinnalitytext.setColumns(10);

		Eductiontext = new JTextField();
		Eductiontext.setBounds(66, 146, 66, 21);
		panel_1.add(Eductiontext);
		Eductiontext.setColumns(10);

		Politicstext = new JTextField();
		Politicstext.setBounds(78, 196, 66, 21);
		panel_1.add(Politicstext);
		Politicstext.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("\u5A5A\u59FB\u72B6\u51B5\uFF1A");
		lblNewLabel_11.setBounds(160, 198, 78, 19);
		panel_1.add(lblNewLabel_11);

		JRadioButton YesRadioButton = new JRadioButton("\u5DF2\u5A5A");
		YesRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp2 = YesRadioButton.getText();
			}
		});
		YesRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(YesRadioButton);
		YesRadioButton.setBounds(248, 196, 58, 23);
		panel_1.add(YesRadioButton);

		JRadioButton NotRadioButton = new JRadioButton("\u672A\u5A5A");
		NotRadioButton.setSelected(true);
		NotRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp2 = NotRadioButton.getText();
			}
		});
		NotRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(NotRadioButton);
		NotRadioButton.setBounds(312, 196, 58, 23);
		panel_1.add(NotRadioButton);

		JLabel lblNewLabel_12 = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblNewLabel_12.setBounds(10, 254, 85, 18);
		panel_1.add(lblNewLabel_12);

		Cardtext = new JTextField();
		Cardtext.setBounds(78, 252, 66, 21);
		panel_1.add(Cardtext);
		Cardtext.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("\u5165\u5B66\u65E5\u671F\uFF1A");
		lblNewLabel_13.setBounds(156, 254, 77, 18);
		panel_1.add(lblNewLabel_13);

		EnrollDatetext = new JTextField();
		EnrollDatetext.setBounds(232, 254, 85, 21);
		panel_1.add(EnrollDatetext);
		EnrollDatetext.setColumns(10);

		/**
		 * 注册按钮
		 */
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RegOk(event,user);
			}
		});
		btnNewButton_1.setBounds(95, 318, 113, 34);
		panel_1.add(btnNewButton_1);

		photoLabel = new JLabel("\u53CC\u51FB\u6DFB\u52A0\u7167\u7247");
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER); // 设置照片或文字居中显示
		photoLabel.setBounds(526, 40, 120, 139);
		panel_1.add(photoLabel);

		photoLabel.setBorder(new LineBorder(new Color(0, 0, 0))); // 设置边框
		photoLabel.setPreferredSize(new Dimension(120, 140)); // 设置显示照片的大小

		Telephonetext = new JTextField();
		Telephonetext.setColumns(10);
		Telephonetext.setBounds(419, 252, 143, 21);
		panel_1.add(Telephonetext);

		JLabel lblNewLabel_14 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_14.setBounds(358, 254, 66, 18);
		panel_1.add(lblNewLabel_14);

		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValue();
			}
		});
		btnNewButton.setBounds(399, 317, 113, 36);
		panel_1.add(btnNewButton);
		if (UPDATE_RECORD == null || UPDATE_RECORD.getPhoto() == null) { // 新建档案或未上传照片
			photoLabel.setText("双击添加照片"); // 显示文字提示
		} else { // 修改档案并且已上传照片
			java.net.URL url = this.getClass().getResource("/personnel_photo/"); // 获得指定路径的绝对路径
			String photo = url.toString().substring(5) + UPDATE_RECORD.getPhoto(); // 组织员工照片的存放路径
			photoLabel.setIcon(new ImageIcon(photo)); // 创建照片对象并显示
			panel_1.add(photoLabel);

			photoLabel.addMouseListener(new MouseAdapter() { // 添加鼠标监听器
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) { // 判断是否为双击
						JFileChooser fileChooser = new JFileChooser(); // 创建文件选取对话框

						int i = fileChooser.showOpenDialog(getParent()); // 弹出文件选取对话框并接收用户的处理信息
						if (i == fileChooser.APPROVE_OPTION) { // 用户选取了照片
							File file = fileChooser.getSelectedFile(); // 获得用户选取的文件对象
							if (file != null) {
								ImageIcon icon = new ImageIcon(file.getAbsolutePath()); // 创建照片对象
								photoLabel.setText(null); // 取消提示文字
								photoLabel.setIcon(icon); // 显示照片
							}
						}
					}
				}
			});

			if (photoLabel.getIcon() != null) { // 查看是否上传照片
				File selectPhoto = new File(photoLabel.getIcon().toString()); // 通过选中图片的路径创建文件对象
				java.net.URL url1 = this.getClass().getResource("/personnel_photo/"); // 获得指定路径的绝对路径
				StringBuffer uriBuffer = new StringBuffer(url1.toString()); // 组织文件路径
				String selectPhotoName = selectPhoto.getName();
				int i = selectPhotoName.lastIndexOf(".");
				JTextComponent recordNoTextField = null;
				uriBuffer.append(recordNoTextField.getText());
				uriBuffer.append(selectPhotoName.substring(i));
				try {
					File photo1 = new File(new URI(this.toString())); // 创建上传文件对象
					// record.setPhoto(photo1.getName()); //将图片名称保存到数据库
					if (!photo1.exists()) { // 如果文件不存在则创建文件
						photo1.createNewFile();
					}
					InputStream inStream = new FileInputStream(selectPhoto); // 创建输入流对象
					OutputStream outStream = new FileOutputStream(photo1); // 创建输出流对象
					int readBytes = 0; // 读取字节数
					byte[] buffer = new byte[10240]; // 定义缓存数组
					while ((readBytes = inStream.read(buffer, 0, 10240)) != -1) { // 从输入流读取数据到缓存数组中
						outStream.write(buffer, 0, readBytes); // 将缓存数组中的数据输出到输出流
					}
					outStream.close(); // 关闭输出流对象
					inStream.close(); // 关闭输入流对象
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * 注册事件处理程序
	 */

	protected void RegOk(ActionEvent event,User user) {
		Archive arc = new Archive();
		arc.setCard(Cardtext.getText());
		arc.setName(Nametext.getText());
		arc.setAge(Agetext.getText());
		arc.setSex(temp);
		arc.setBirthDate(Birthtext.getText());
		arc.setIDnumber(IDnumtext.getText());
		arc.setNationality(Natinnalitytext.getText());
		arc.setNativeplace(Nativetext.getText());
		arc.setMarriaged(temp2);
		arc.setPolitical_status(Politicstext.getText());
		arc.setEducation(Eductiontext.getText());
		arc.setCollege(Collegetext.getText());
		arc.setMajor(Majortext.getText());
		arc.setEnrollment_date(EnrollDatetext.getText());
		arc.setTelephone(Telephonetext.getText());

		if (StringUtil.isEmpty(Cardtext.getText())) {
			JOptionPane.showMessageDialog(this, "一卡通号不能为空!");
			return;
		}

		Message message = new Message("Archive_Reg", arc);
		message.setCheckCode(4);
		client.TheClient client = new TheClient();
		message.setS(user.name);
		Message received = new Message();
		try {

			received = client.sendAndReceive(message);
			if (received.isResponse()) {
				JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "注册失败，请重新注册", "错误", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void registeredOk(ActionEvent event) {// 注册
		Archive arc = new Archive();

	}

	private void resetValue() {
		this.Birthtext.setText("");
		this.Nativetext.setText("");
		this.IDnumtext.setText("");
		this.Collegetext.setText("");
		this.Majortext.setText("");
		this.Agetext.setText("");
		this.Nametext.setText("");
		this.Natinnalitytext.setText("");
		this.Eductiontext.setText("");
		this.Politicstext.setText("");
		this.Cardtext.setText("");
		this.EnrollDatetext.setText("");
		this.Telephonetext.setText("");
	}
}
