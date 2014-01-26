package StateManager;

import java.util.LinkedList;


public class StateManager {

	public int x;
	public static int y;
	
	private LinkedList<String> stateList;
	private String             currentState;
	
	public StateManager()
	{
	  stateList = new LinkedList();	
	  currentState = "CAFETERIA";
	}
	
	public void init()
	{
		stateList.add("CAFETERIA");
		stateList.add("LIBRARY");
		stateList.add("MUB");
	}
	
	public String beginCurrentState()
	{
		return currentState;
	}

	
	public void setCurrentState(String _location){ currentState = _location;}
	//TODO 
	
	
	
}
