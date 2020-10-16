package gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import gui.colors.PrimaryColor;

public class LightLabel extends JLabel {
  public LightLabel(String title) {
    super(title);
    setHorizontalAlignment(SwingConstants.CENTER);
    setForeground(new PrimaryColor());
  }
}
