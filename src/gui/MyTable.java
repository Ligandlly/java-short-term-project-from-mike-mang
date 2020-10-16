package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.Component;

import gui.colors.PrimaryColor;
import gui.colors.SecondaryColor;
import gui.colors.PrimaryColor;

public class MyTable extends JTable {

  public static void colorizeTabel(JTable table) {
    try {
      DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
          if (row % 2 == 0) {
            setBackground(Color.white); // 设置奇数行底色
          } else if (row % 2 == 1) {
            setBackground(new Color(0xA3BE8C)); // 设置偶数行底色
          }
          // if (Double.parseDouble(table.getValueAt(row, 11).toString()) > 0) {
          //   setBackground(Color.red);
          // }
          // 如果需要设置某一个Cell颜色，需要加上column过滤条件即可
          return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
      };
      for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public MyTable() {
    super();
    System.out.println("MyTable()");

    JTableHeader header = getTableHeader();
    header.setOpaque(false);
    header.setBackground(new PrimaryColor());
    header.setForeground(Color.white);
    // setForeground(new PrimaryColor());
    // makeFace(this);

  }

  public MyTable(int numRows, int numColumns) {
    super(numRows, numColumns);

    JTableHeader header = getTableHeader();
    header.setOpaque(false);
    header.setBackground(new PrimaryColor());
    header.setForeground(Color.white);
    setForeground(new PrimaryColor());
  }

  public MyTable(Object[][] rowData, Object[] columnNames) {
    super(rowData, columnNames);

    JTableHeader header = getTableHeader();
    header.setOpaque(false);
    header.setBackground(new PrimaryColor());
    header.setForeground(Color.white);
    setForeground(new PrimaryColor());
  }

  public MyTable(TableModel dm) {
    super(dm);

    JTableHeader header = getTableHeader();
    header.setOpaque(false);
    header.setBackground(new PrimaryColor());
    header.setForeground(Color.white);
    setForeground(new PrimaryColor());
  }
}
