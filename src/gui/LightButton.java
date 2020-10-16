package gui;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import gui.colors.HighlightColor;
import gui.colors.PrimaryColor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LightButton extends JButton {
  LightButton button;

  public LightButton(String title) {
    super(title);
    button = this;
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setBorder(null);
    setForeground(new PrimaryColor());
    setOpaque(true);
    setBorder(new LineBorder(new PrimaryColor(), 1, true));
    setBackground(Color.white);
    addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        setForeground(new HighlightColor());
        setBorder(new LineBorder(new HighlightColor()));
      }

      @Override
      public void mouseExited(MouseEvent e) {
        setForeground(new PrimaryColor());
        setBorder(new LineBorder(new PrimaryColor()));

      }
      
    });
  }
}
