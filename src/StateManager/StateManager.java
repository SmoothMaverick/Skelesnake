package StateManager;

import java.util.LinkedList;


public class StateManager {

	private LinkedList<String> stateList;
	private String             currentState;
	
	public StateManager()
	{
	  stateList    = new LinkedList();	
	  currentState = "CAFETERIA";
	}
	
	public void init()
	{
	
	}
	
	public String beginCurrentState()
	{
		return currentState;
	}

	
	public void setCurrentState(String _location){ currentState = _location;}
	public void addState(String _location)       { stateList.add(_location);}
}
