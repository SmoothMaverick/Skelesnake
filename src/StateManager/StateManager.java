package StateManager;

import java.util.LinkedList;

import GUI.GUI;
import InputOutput.TextHandler;

//
//To manage player location
//General map management
//
//
public class StateManager {

	private LinkedList<String> stateList;
	private String             currentState;
	private TextHandler        IO;
	
	
	public StateManager(GUI _gui)
	{
	  stateList    = new LinkedList();
	  IO           = new TextHandler(_gui);
	}
	
	public void init()
	{
		currentState = "CAFETERIA";
	}
	
	public void play()
	{
		beginCurrentState();
	}
	
	private void beginCurrentState()
	{
		 IO.fetchAndDisplayText(currentState);
	}

	public void setCurrentState(String _location){ currentState = _location;}
	public void addState(String _location)       { stateList.add(_location);}
}
