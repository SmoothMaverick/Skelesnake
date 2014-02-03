package GUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Main.EscapeCCSF;
import StateManager.StateManager;
 
public class GUI extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    protected JScrollPane scrollPane;
    protected JPanel panel;
    protected JPanel panelL;
    protected JPanel panelR;
    protected GridBagConstraints c;
    private   StateManager SM;
    private   String       input;
    private final static String newline = "\n";
 
    public GUI() {
        super(new GridBagLayout());
        
        SM        = new StateManager(this);
        Font font = new Font("Verdana", Font.BOLD, 12);
        input     = "";
        
        textArea  = new JTextArea(35, 45);
        textArea.setEditable(false);
 		textArea.setBackground(Color.black);
        textArea.setFont(font);
        textArea.setForeground(Color.WHITE);
        scrollPane = new JScrollPane(textArea);
        
        textField = new JTextField(50);
        textField.setBackground(Color.black);
        textField.addActionListener(this);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
        
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,164));
        panel.setBackground(Color.GRAY);
        panel.setVisible(false);
        
        panelL = new JPanel();
        panelL.setPreferredSize(new Dimension(50,560));
        panelL.setBackground(Color.BLACK);
        panelL.setVisible(false);
        
        panelR = new JPanel();
        panelR.setPreferredSize(new Dimension(50,560));
        panelR.setBackground(Color.BLACK);
        panelR.setVisible(false);
        
        c  = new GridBagConstraints();
       
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridwidth = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        add(panelL);

        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = GridBagConstraints.CENTER;
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        
        add(scrollPane, c);
        
        c.gridx = 1;
        c.gridy = 1;
        add(panel,c);
        
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = GridBagConstraints.EAST;
        c.gridx = 2;
        c.gridy = 0;
        add(panelR);
        
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill  = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        
//        add(panel,c);
//        add(scrollPane, c);
//        add(textField, c);
        
        //Create and set up the window.
        JFrame frame = new JFrame("Epic Text RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(this);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
     
//    public static void createAndShowGUI() {
//        JFrame frame = new JFrame("Epic Text RPG");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new GUI());
//        frame.pack();
//        frame.setVisible(true);
//        frame.setResizable(false);
//	}
    
    private void panelAdd() {
        //replace text field with video/image panel
//        c.anchor = GridBagConstraints.CENTER;
//        c.gridwidth = GridBagConstraints.CENTER;
//        c.fill  = GridBagConstraints.HORIZONTAL;
        panel.setVisible(true);
    	panelL.setVisible(false);
    	panelR.setVisible(false);
    	scrollPane.setPreferredSize(new Dimension(400,419));
        revalidate();
        repaint();
    }
    
    private void panelRemove() {
        //replace video/image panel with text field
    	panel.setVisible(false);
    	panelL.setVisible(false);
    	panelR.setVisible(false);
    	scrollPane.setPreferredSize(new Dimension(10,563));
        revalidate();
        repaint();
    }
    
    private void panelLeft() {
        //split between text field and video/image panel
    	panel.setVisible(false);
    	panelL.setVisible(true);
    	panelR.setVisible(false);
    	//scrollPane.setPreferredSize(new Dimension(10,563));
        revalidate();
        repaint();
    }
    
    private void panelRight() {
        //split between text field and video/image panel
    	panel.setVisible(false);
    	panelL.setVisible(false);
    	panelR.setVisible(true);
    	//scrollPane.setPreferredSize(new Dimension(10,563));
        revalidate();
        repaint();
    }
    
    //Move to game dictionary? NO- STATEMANAGER: dictionary only holds words
	public String execute(String userInput) {
		String output = "";
		if(userInput.equals("p on")) {
			panelAdd();
			
		} else if (userInput.equals("p off")) { 
			panelRemove();
		} else if (userInput.equals("p l")) {
			panelLeft();
		} else if (userInput.equals("p r")) {
			panelRight();
		} else {
			output = "";
		}
		return output + newline;
	}
    
    public void actionPerformed(ActionEvent evt) {
        input = textField.getText().toString();
        textArea.append(input + execute(input) + newline); //handle the 'execute' call in the manager
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
