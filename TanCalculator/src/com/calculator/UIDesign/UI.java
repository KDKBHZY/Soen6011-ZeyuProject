package com.calculator.UIDesign;
import com.calculator.TanFunction;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI  extends JFrame {

    private static final int DEFAULT_WIDTH = 370;
    private static final int DEFAULT_HEIGHT = 480;

    CalculatorButton display;//a button that displays result

    public UI()
    {
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        display = new CalculatorButton("0");
        display.setEnabled(false);
        display.setHorizontalAlignment(JButton.RIGHT);
        this.add(display, new GBC(0, 0, 3, 1).setFill(GBC.BOTH).setWeight(100, 100));

        String[][] buttonString = new String[][]{
                { "C","-","Tan"},
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
                {".", "0", "="}};

        CalculatorButton[][] button = new CalculatorButton[buttonString.length][];
        for (int i = 0; i < buttonString.length; i++)
            button[i] = new CalculatorButton[buttonString[i].length];

        for (int i = 0; i < button.length; i++)
            for (int j = 0; j < button[i].length; j++)
            {
                button[i][j] = new CalculatorButton(buttonString[i][j]);
                if (i == 4 && j == 2)
                {
                    button[i][j].addActionListener(new EqualButtonAction());
                }
                else
                {
                    button[i][j].addActionListener(new OrdinaryButtonAction());
                }
            }

        for (int i = 0; i < button.length; i++)
            for (int j = 0; j < button[i].length; j++)
            {
                if (i == 0 && j == 0)
                {
                    this.add(button[i][j], new GBC(0, 1, 1, 1).setFill(GBC.BOTH).setWeight(100, 100));
                }

                else
                {
                    this.add(button[i][j], new GBC(j, i + 1).setFill(GBC.BOTH).setWeight(100, 100));
                }
            }
    }

    class OrdinaryButtonAction implements ActionListener
    {
        private String currentContent;

        @Override
        public void actionPerformed(ActionEvent e)
        {
            currentContent = display.getText();

            int tempChar = 0;
            String tempString = null;
            switch (e.getActionCommand())
            {
                case "C":
                    display.setText("0");
                    break;
                case "0":
                    if (currentContent.equals("0"))
                    {
                        return;
                    }
                    else if (currentContent.equals("Invalid!") || currentContent.equals("∞"))
                    {
                        return;
                    }
                    else
                    {
                        display.setText(currentContent + e.getActionCommand());
                    }
                    break;
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    if (currentContent.equals("0"))
                    {
                        display.setText(e.getActionCommand());
                    }
                    else if (currentContent.equals("Invalid!") || currentContent.equals("∞"))
                    {
                        return;
                    }
                    else
                    {
                        display.setText(currentContent + e.getActionCommand());
                    }
                    break;
                case "Tan":
                case "Rad":
                    tempChar = currentContent.codePointAt(currentContent.length() - 1);
                    if (!Character.isDigit(tempChar))
                    {
                        return;
                    }
                    else
                    {
                        display.setText(e.getActionCommand()+ "(" + currentContent +")");
                    }
                    break;
                case ".":
                    tempChar = currentContent.codePointAt(currentContent.length() - 1);
                    if (!Character.isDigit(tempChar))
                    {
                        return;
                    }
                    else
                    {
                        if (-1 != currentContent.lastIndexOf('.'))
                        {
                            tempString = currentContent.substring(currentContent.lastIndexOf('.') + 1, currentContent.length());
                            if (!tempString.matches(".*[÷×－＋].*"))
                            {
                                return;
                            }
                        }
                        display.setText(currentContent + e.getActionCommand());
                    }
                    break;
                case "-":
                    if(currentContent.equals("0")){
                        display.setText("-");
                    }
                    else{
                        display.setText(currentContent + e.getActionCommand());
                    }

            }
        }
    }

    class EqualButtonAction implements ActionListener
    {

        TanFunction tanfun = new TanFunction();
        public String currentContent;

        @Override
        public void actionPerformed(ActionEvent e)
        {
           currentContent = display.getText();

            currentContent = currentContent.substring(4,currentContent.length()-1);
            System.out.println(currentContent+"!!!!!");
try {
    display.setText(tanfun.calculateTan(Double.parseDouble(currentContent)));
} catch (NumberFormatException ex) {
    display.setText("Press number first");
}
        }

   }
}
