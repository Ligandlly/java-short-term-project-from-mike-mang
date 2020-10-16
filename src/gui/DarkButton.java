package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import gui.colors.HighlightColor;
import gui.colors.PrimaryColor;
import java.awt.Cursor;

public class DarkButton extends JButton {
  DarkButton button;

  public DarkButton(String title) {
    super(title);
    setBorder(new LineBorder(new PrimaryColor(), 1, true));
    button = this;
    setBackground(new PrimaryColor());
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    setForeground(Color.white);
    setOpaque(true);
    setBorderPainted(false);
    addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        button.setBackground(new HighlightColor());

      }

      @Override
      public void mouseExited(MouseEvent e) {
        button.setBackground(new PrimaryColor());

      }

    });
  }
  
  public DarkButton() {
	    super();
	    setBorder(new LineBorder(new PrimaryColor(), 1, true));
	    button = this;
	    setBackground(new PrimaryColor());
	    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    setForeground(Color.white);
	    setOpaque(true);
	    setBorderPainted(false);
	    addMouseListener(new MouseListener() {

	      @Override
	      public void mouseClicked(MouseEvent e) {

	      }

	      @Override
	      public void mousePressed(MouseEvent e) {

	      }

	      @Override
	      public void mouseReleased(MouseEvent e) {

	      }

	      @Override
	      public void mouseEntered(MouseEvent e) {
	        button.setBackground(new HighlightColor());

	      }

	      @Override
	      public void mouseExited(MouseEvent e) {
	        button.setBackground(new PrimaryColor());

	      }

	    });
	  }
}
