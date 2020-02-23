
// ******************************************************************
//   RatePanel.java
//
//   Panel for a program that converts different currencies to
//   U.S. Dollars
// ****************************************************************** 
 
import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
 
public class RatePanel extends JPanel{     
    private double[] rate;          // exchange rates
    private String[] currencyName;
    private JLabel result, Total;
    private JTextField input;
    private JButton button;
    private int index;
    private double data;
    private double total;
    // ------------------------------------------------------------
    //  Sets up a panel to convert cost from one of 6 currencies
    //  into U.S. Dollars. The panel contains a heading, a text
    //  field for the cost of the item, a combo box for selecting
    //  the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel (){
        JLabel title = new JLabel ("How much is that in dollars?"); 
        title.setAlignmentX(Component.CENTER_ALIGNMENT); 
        title.setFont (new Font ("Helvetica", Font.BOLD, 20)); 
        
        // Set up the arrays for the currency conversions 
        currencyName = new String[] {"Select the currency..", "European Euro", "Canadian Dollar", 
                        "Japanese Yen", "Australian Dollar", "Indian Rupee", "Mexican Peso"}; 
        
        JComboBox currencyList = new JComboBox(currencyName);
        currencyList.setSelectedIndex(0);
        currencyList.addActionListener(new ComboListener());
        button=new JButton("Convert");
        button.addActionListener(new ButtonListener());
        
        input=new JTextField(10);
        
        rate = new double [] {0.0, 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880}; 
        result = new JLabel (" "); 
        Total = new JLabel (" "); 
        add (title);
        add (input);
        add (currencyList);
        add (button);
        add (Total);
        add (result);
        setPreferredSize (new Dimension (300, 200)); 
        setBackground (Color.getHSBColor(250, 100, 43));
    }

    // ******************************************************
    //   Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener{
 
        // -------------------------------------------------- 
        //  Determines which currency has been selected and 
        //   the value in that currency then computes and 
        //   displays the value in U.S. Dollars. 
        //-------------------------------------------------- 
        public void actionPerformed (ActionEvent event){
            JComboBox cb = (JComboBox)event.getSource();
            data = Double.parseDouble(input.getText());
            index = cb.getSelectedIndex();
            total = data*rate[index];
        }
    }
    
    private class ButtonListener implements ActionListener{
        //--------------------------------------------------       
        //   Determines which currency has been selected and 
        //   the value in that currency then computes and 
        //   displays the value in U.S. Dollars. 
        //-------------------------------------------------- 
        public void actionPerformed (ActionEvent event){
            Total.setText (data + " " + currencyName[index] +  " = " + String.format("%.2f", total) + " U.S. Dollars"); 
            result.setText ("(1 " + currencyName[index] +  " = " + rate[index] + " U.S. Dollars)"); 
        }     
    }
} 