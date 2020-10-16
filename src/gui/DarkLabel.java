package gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gui.colors.PrimaryColor;

import java.awt.Color;

public class DarkLabel extends JLabel {
  public DarkLabel(String title) {
    super(title);
    setHorizontalAlignment(SwingConstants.CENTER);
		setOpaque(true);
    setForeground(Color.WHITE);
    setBackground(new PrimaryColor());
//    setBorder(new LineBorder(new PrimaryColor(), 1, true));
  }
  public DarkLabel() {
	  super();
	    setHorizontalAlignment(SwingConstants.CENTER);
			setOpaque(true);
	    setForeground(Color.WHITE);
	    setBackground(new PrimaryColor());
	    setBorder(new LineBorder(new PrimaryColor(), 1, true));
	  }
}
