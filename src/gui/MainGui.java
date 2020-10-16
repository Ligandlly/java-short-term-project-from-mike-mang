package gui;

import javax.swing.*;
// import javax.swing.event.MouseInputListener;
import javax.swing.plaf.FontUIResource;

// import gui.colors.Brown;
import gui.colors.PrimaryColor;
import gui.colors.SecondaryColor;
// import gui.colors.PaleGreen;
import gui.colors.HighlightColor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
// import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MainGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainGuiInfo info;
	JScrollPane titleScrollPane;
	JPanel titlePane;
	JPanel panel;
	JScrollPane labelScrollPane;
	JPanel labelPane;
	CardLayout cardLayout;
	JPanel cardPane;

	int module_number;

	public MainGui(final MainGuiInfo info) {
		super("虚拟校园 VCampus");

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ImageIcon imageIcon = new ImageIcon(("src/gui/icons/Marianne.png"));
		setIconImage(imageIcon.getImage());

		final int WIDTH = 825; // The Width of the window
		final int HEIGHT = 500; // The height of the window

		final int INNER_WIDTH = 700; // The width of the inner panel
		final int INNER_HEIGHT = 433; // the height of the inner panel

		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(new PrimaryColor());
		this.info = info;
		// * Set Panels First
		setResizable(false);
		// getContentPane().setSize(new Dimension(800, 493));
		setSize(new Dimension(WIDTH, HEIGHT));

		titleScrollPane = new JScrollPane();
		titlePane = new JPanel();
		titlePane.setBackground(Color.WHITE);
		// titlePane.setPreferredSize(new Dimension(10, HEIGHT - INNER_HEIGHT));

		titleScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		titleScrollPane.setBackground(new SecondaryColor());
		titleScrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT - INNER_HEIGHT));
		final JLabel identity = new JLabel("");
		identity.setBackground(new SecondaryColor());
		titleScrollPane.setRowHeaderView(identity);

		panel = new JPanel();

		panel.setLayout(new BorderLayout(0, 0));

		labelScrollPane = new JScrollPane(); // The Side Buttons for each Functions
		labelScrollPane.setPreferredSize(new Dimension(WIDTH - INNER_WIDTH, INNER_HEIGHT));
		labelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		labelPane = new JPanel();
		labelPane.setPreferredSize(new Dimension(100, 10));
		labelPane.setMaximumSize(new Dimension(100, 32767));
		labelPane.setMinimumSize(new Dimension(100, 10));
		labelPane.setBackground(new PrimaryColor());

		cardLayout = new CardLayout();
		cardPane = new JPanel(cardLayout); // Where The Operations Placed
		cardPane.setSize(new Dimension(INNER_WIDTH, INNER_HEIGHT));

		// * Initiate the Buttons
		// * Add Top Buttons
		for (final Module module : info.modules) {
			final JPanel topPanel = new TopPanel(module);
			titlePane.add(topPanel);
		}
		titleScrollPane.repaint();
		getContentPane().add(titleScrollPane, BorderLayout.NORTH);

		labelScrollPane.setViewportView(labelPane);
		labelPane.setLayout(new GridLayout(20, 1, 0, 0));
		titleScrollPane.setViewportView(titlePane);
		titlePane.setLayout(new GridLayout(1, 0, 0, 0));
		titlePane.setBackground(new SecondaryColor());
		panel.add(labelScrollPane, BorderLayout.WEST);

		panel.add(cardPane, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.CENTER);
		titleScrollPane.setBorder(null);
		labelScrollPane.setBorder(null);
		cardPane.setBackground(Color.white);
		
	}

	class TopLabel extends JLabel {
		/*
		 * The labels below icons on the top panel
		 */
		private static final long serialVersionUID = 1L;

		public TopLabel(final String s) {
			super(s);
		}

		public TopLabel(final Module module) {
			super(module.name);

			setHorizontalAlignment(SwingConstants.CENTER);
			// setPreferredSize(new Dimension(80, 60));
			setOpaque(false);
		}
	}

	class TopPanel extends JPanel {
		/*
		 * A TopPanel is composed by an icon and a top label
		 */
		public TopPanel(final Module m) {
			super(new BorderLayout());
			final JPanel panel = this;
			final JLabel iconLabel = new JLabel(new ImageIcon(MainGuiInfo.getIcon(m.name)));
			iconLabel.setOpaque(false);
			add(iconLabel, BorderLayout.CENTER);
			final JLabel button = new TopLabel(m);
			button.setForeground(Color.WHITE);
			add(button, BorderLayout.SOUTH);
			setBackground(new SecondaryColor());
			setPreferredSize(new Dimension(30, 30));
			setForeground(Color.WHITE);
			setVisible(true);
			setOpaque(true);
			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(final MouseEvent e) {
					labelPane.removeAll();
					cardPane.removeAll();
					for (final PanelWrapper wrapper : m.labels) {
						final JButton sideButton = new SideButton(wrapper);
						labelPane.add(sideButton);
						cardPane.add(wrapper.label, wrapper.panel);
					}
					labelPane.revalidate();
					labelPane.repaint();
					cardPane.revalidate();
					cardPane.repaint();

				}

				@Override
				public void mousePressed(final MouseEvent e) {
					// As same as mouseClicked
					labelPane.removeAll();
					cardPane.removeAll();
					for (final PanelWrapper wrapper : m.labels) {
						final JButton sideButton = new SideButton(wrapper);
						labelPane.add(sideButton);
						cardPane.add(wrapper.label, wrapper.panel);
					}
					labelPane.revalidate();
					labelPane.repaint();
					cardPane.revalidate();
					cardPane.repaint();
				}

				@Override
				public void mouseReleased(final MouseEvent e) {
					// As same as mouseClicked
					labelPane.removeAll();
					cardPane.removeAll();
					for (final PanelWrapper wrapper : m.labels) {
						final JButton sideButton = new SideButton(wrapper);
						labelPane.add(sideButton);
						cardPane.add(wrapper.label, wrapper.panel);
					}
					labelPane.revalidate();
					labelPane.repaint();
					cardPane.revalidate();
					cardPane.repaint();
				}

				@Override
				public void mouseEntered(final MouseEvent e) {
					panel.setBackground(new HighlightColor());
				}

				@Override
				public void mouseExited(final MouseEvent e) {
					panel.setBackground(new SecondaryColor());
				}

			});

		}
	}

	class SideButton extends JButton {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		public SideButton(final PanelWrapper wrapper) {
			super(wrapper.label);
			final JButton button = this;
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent e) {
					cardLayout.show(cardPane, wrapper.label);
				}

			});

			// outlooking
			setHorizontalAlignment(SwingConstants.CENTER);
			// setPreferredSize(new Dimension(66, 21));
			setOpaque(true);
			setForeground(Color.WHITE);
			setBackground(new PrimaryColor());
			setBorderPainted(false);
			// setSize(110, 30);
			setPreferredSize(new Dimension(110, 30));

			addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(final MouseEvent e) {

				}

				@Override
				public void mousePressed(final MouseEvent e) {

				}

				@Override
				public void mouseReleased(final MouseEvent e) {

				}

				@Override
				public void mouseEntered(final MouseEvent e) {
					button.setBackground(new HighlightColor());

				}

				@Override
				public void mouseExited(final MouseEvent e) {
					button.setBackground(new PrimaryColor());

				}

			});
		}
	}
}
//