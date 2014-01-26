package Gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class TextDemo extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
 
    public TextDemo() {
        super(new GridBagLayout());
        Font font = new Font("Verdana", Font.BOLD, 12);
        
        textField = new JTextField(20);
        textField.setBackground(Color.black);
        textField.addActionListener(this);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
 
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
		textArea.setBackground(Color.black);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(font);
        textArea.setForeground(Color.WHITE);
        
		JPanel panel1 = new JPanel();
//		JPanel panel2 = new JPanel(); 
		panel1.setPreferredSize(new Dimension(450,300));
//		panel2.setPreferredSize(new Dimension(450,300));
		panel1.setBackground(Color.yellow);
//		panel2.setBackground(Color.white);
        
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints cy = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        cy.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.HORIZONTAL;
        cy.fill = GridBagConstraints.VERTICAL;

        add(panel1,cy);
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        add(textField, c);
    }
 
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new TextDemo());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}