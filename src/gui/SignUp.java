package gui;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class SignUp extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	public SignUp() {
		getContentPane();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(268, 433));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel listPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) listPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEADING);
		listPanel.setPreferredSize(new Dimension(268, 433));
		scrollPane.setViewportView(listPanel);
		
		JPanel panel_1 = new MyPanel("asd");
		listPanel.add(panel_1);
		
		JLabel lblNewLabel_1 = new GreenLabel("New label");
		listPanel.add(lblNewLabel_1);
		
		textField = new GreenTextField();
		listPanel.add(textField);
		textField.setColumns(10);

		listPanel.add(new EscapeLabel());
		
		JLabel lblNewLabel_2 = new GreenLabel("New label");
		listPanel.add(lblNewLabel_2);
		
		textField_1 = new GreenTextField();
		listPanel.add(textField_1);
		textField_1.setColumns(10);
		
		setSize(new Dimension(268, 433));
		setBackground(Color.WHITE);
		setResizable(false);
		
		
		
		
	}
}

class MyPanel extends JPanel {
	MyPanel(String s) {
		super();
		setPreferredSize(new Dimension(268, 42));
		JLabel label = new GreenLabel(s);
		add(label);
		JTextField text = new GreenTextField();
		add(text);
	}
	
}

class EscapeLabel extends JLabel {
	EscapeLabel() {
		super();
		setPreferredSize(new Dimension(68, 21));
	}
}

class GreenLabel extends JLabel{
	GreenLabel(String title) {
		super(title);
		setHorizontalAlignment(SwingConstants.CENTER);
		setPreferredSize(new Dimension(66, 21));
		setOpaque(true);
		setForeground(Color.WHITE);
		setBackground(new Color(51, 102, 0));
		
	}
}

class GreenTextField extends JTextField {
	GreenTextField() {
		super(20);
		setBorder(new LineBorder(new Color(51, 102, 0)));
		setPreferredSize(new Dimension(180, 21));
	}
}