package StateManager;

import java.util.LinkedList;

import GUI.GUI;
import GameDictionary.GameDictionary;
import InputOutput.TextHandler;

//
//To manage player location
//General map management
//

public class StateManager {

	private LinkedList<String> stateList;
	private String             currentState, playerInput;
	private TextHandler        IO;
	private GameDictionary     GD;
	
	public StateManager(GUI _gui)
	{
	  stateList    = new LinkedList();
	  IO           = new TextHandler(_gui);
	  GD           = new GameDictionary();
	  playerInput  = "";
	}
	
	public void init()
	{
		currentState = "CAFETERIA";
		GD.init();
	}
	
	public void play()
	{
		beginCurrentState();
	}
	
	private void beginCurrentState()
	{
		 IO.fetchAndDisplayText(currentState);
	}

	private void parseInput()
	{
		String[] activeInput = playerInput.split("\\s+");
		
		if(activeInput.length <= 2)
		{
			if(!GD.searchVerbs(activeInput[0]))
			{
				IO.errorMessageVerb(activeInput[0]);
				return;
			}
			else if(!GD.searchNouns(activeInput[1]))
			{
				IO.errorMessageNoun(activeInput[0], activeInput[1]);
			}
		}
		else {IO.errorMessage();}
	}
	
	//the manager can parse input from gui
	public void getPlayerInput(String _str)      { playerInput = _str; parseInput();}
	public void setCurrentState(String _location){ currentState = _location;}
	public void addState(String _location)       { stateList.add(_location);}
}
