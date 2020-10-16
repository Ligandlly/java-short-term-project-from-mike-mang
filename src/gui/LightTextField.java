package gui;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import gui.colors.PrimaryColor;

import java.awt.Color;

public class LightTextField extends JTextField {
  public LightTextField() {
    super();
    setBorder(new LineBorder(new PrimaryColor()));
    setBackground(Color.white);
  }

  public LightTextField(int col) {
    super(col);
    setBorder(new LineBorder(new PrimaryColor()));
    setBackground(Color.white);
  }
}
