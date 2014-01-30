package Main;

import InputOutput.TextHandler;
import StateManager.StateManager;
import GUI.GUI;



public class EscapeCCSF {
	
	public static StateManager SM;
	public static GUI          gui;
	
	public static void main(String[] args)
	{
		
		  javax.swing.SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
            gui = new GUI();
            //gui.showText("showTest()");
    		SM   = new StateManager(gui);
    		init();
    		play();
	       }
	      });

	}
	
	public static void init()
	{
		SM.init();
	}
	
	public static void play()
	{
		SM.setCurrentState("LIBRARY");
		SM.play();
	}

}
