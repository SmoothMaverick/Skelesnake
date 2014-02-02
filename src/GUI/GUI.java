package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import StateManager.StateManager;
 
public class GUI extends JPanel implements ActionListener {
    protected JTextField   textField;
    protected JTextArea    textArea;
    private   StateManager SM;
    private   String       input;
    private final static String newline = "\n";
 
    public GUI() {
        super(new GridBagLayout());
        
        SM        = new StateManager(this);
        Font font = new Font("Verdana", Font.BOLD, 12);
        input     = "";
        
         textArea  = new JTextArea(35, 20);
        // textArea  = new JTextArea(10, 20);
         textArea.setEditable(false);
 		 textArea.setBackground(Color.black);
         JScrollPane scrollPane = new JScrollPane(textArea);
         textArea.setFont(font);
         textArea.setForeground(Color.WHITE);
        
        textField = new JTextField(50);
        textField.setBackground(Color.black);
        textField.addActionListener(this);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
      //  textField.setPreferredSize(new Dimension(10,30));
 
        
       
        
        /*  JPANEL
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(450,300));
		panel1.setPreferredSize(new Dimension(450,50));
		panel1.setBackground(Color.yellow);
        
        */
        
        //Add Components to this panel.
        GridBagConstraints c  = new GridBagConstraints();
        GridBagConstraints cy = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        cy.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill  = GridBagConstraints.HORIZONTAL;
        cy.fill = GridBagConstraints.VERTICAL;

       // add(panel1,cy);
 
        c.fill    = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(textField, c);
        
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(this);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        
        
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
     
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new GUI());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent evt) {
        input = textField.getText().toString();
        textArea.append(input + newline);
        textField.selectAll();
        textField.setText("");
        //callback method
        parseInput();
        
        
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

  private void parseInput()             {SM.getPlayerInput(input);}
  public StateManager getStateManager() {return SM;}
  public void showText(String _str)     {textArea.append(_str + newline);}
}