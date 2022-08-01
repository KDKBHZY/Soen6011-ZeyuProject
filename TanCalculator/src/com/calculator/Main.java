package com.calculator;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.calculator.UIDesign.UI;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
               UI frame = new UI();
                frame.setTitle("Calculator");
               // frame.setIconImage(new ImageIcon(getClass().getResource("/com/shawn/image/cal.png")).getImage());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });

    }
}
