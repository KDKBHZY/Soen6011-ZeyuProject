package com.calculator;

import com.calculator.UIDesign.UiDesign;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * The main function to run the program
 * @author <Zeyu_Huang>
 * @version 1.0
 * @since <pre>7月 31, 2022</pre>
 */
public class Main {

  /**.
   * set up ui.
   * @param args null.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        UiDesign frame = new UiDesign();
        frame.setTitle("Calculator");
        // frame.setIconImage(new ImageIcon(getClass().getResource("/com/shawn/image/cal.png")).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
      }
    });

  }
}
