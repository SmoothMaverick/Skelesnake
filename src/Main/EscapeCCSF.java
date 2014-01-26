package Main;

import InputOutput.TextHandler;
import StateManager.StateManager;
import GUI.GUI;



public class EscapeCCSF {
	
	public static TextHandler  IO;
	public static StateManager SM;
	public static StateManager test;
	public static GUI          gui;
	
	public static void main(String[] args)
	{
		  javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                gui.createAndShowGUI();
	            }
	        });
		  
		IO = new TextHandler();
		SM   = new StateManager();
		test = new StateManager();
		init();
		play();
	}
	
	public static void init()
	{
		SM.init();
	}
	
	public static void play()
	{
		
		SM.setCurrentState("MUB");
		
		
		IO.beginState(SM.beginCurrentState());
	}
	
}
