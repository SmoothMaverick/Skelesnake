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
		IO.errorMessage("                                                             ------ESCAPE CCSF!------");
		IO.errorMessage("");
		beginCurrentState();
	}
	
	private void beginCurrentState()
	{
		if(!IO.getCurrentState().equalsIgnoreCase(currentState))
		    IO.fetchAndDisplayText(currentState);
	}

	private void parseInput()
	{
		String[] activeInput = playerInput.split("\\s+");
		
		//set the index in the Dictionary(bookmark)
		 GD.setVerbIndex(GD.searchVerb(activeInput[0]));
		 GD.setNounIndex(GD.searchNoun(activeInput[1]));
		 
		if(activeInput.length == 2)
		{
			//catch unrecognized args
			if(!GD.hasVerb(activeInput[0]))
			{
				IO.errorMessageVerb(activeInput[0]);
				return;
			}
			else if(!GD.hasNoun(activeInput[1]))
			{
				IO.errorMessageNoun(activeInput[0], activeInput[1]);
				return;
			}

			 //movement
			 if(GD.getActiveVerb().equalsIgnoreCase("go") || GD.getActiveVerb().equalsIgnoreCase("move"))
			 {
				 if(GD.hasNoun(activeInput[1]))
					{  
					    IO.setParentToChild(activeInput[1]);
					    if(!currentState.equalsIgnoreCase(IO.getCurrentState()))
					    {
					    	IO.fetchAndDisplayCurrentStateText();
					    	currentState = IO.getCurrentState();
					    }
					    else
					    	IO.errorMessage("Cannot go " + activeInput[1]);
					}
			 }
			 
			//TODO logic for other verbs here-check which are 'Noun-able';
			//INSPECT needs a ITEMOBJECT
			if( GD.getActiveVerb().equalsIgnoreCase("inspect") )
			{	
				if(GD.getActiveNoun().equalsIgnoreCase("backpack"))
				{
					System.out.println("xxx");
					for(int i =0; i< GD.getNounLength();i++)
					{
						IO.displayText(GD.getNoun(i));
						System.out.println(GD.getNoun(i));
					}
				}
			}
			
			//TAKE needs an ITEM
			if(GD.getActiveVerb().equalsIgnoreCase("take")){System.out.println(activeInput[0]); }
			//OPEN needs a DOOROBJECT
			if(GD.getActiveVerb().equalsIgnoreCase("open") ){System.out.println(activeInput[0]);}
			//USE  needs a PERISHABLEOBJECT
			if(GD.getActiveVerb().equalsIgnoreCase("use") ){System.out.println(activeInput[0]); }

		}
		//HELP COMMAND
		else if(activeInput[0].equalsIgnoreCase("help"))
		{
			IO.errorMessage("ACTIVE COMMANDS: ");
			for(int i=0; i< GD.getVerbLength();i++)
				IO.errorMessage(GD.getVerb(i));
		}
		//OTHER NON-GAME SPECIFIC COMMANDS-resizing, closing, panel addition, rotation, etc.
		//
		// else if (activeInput[0].equalsIgnoreCase("rotate"){gui.rotate(int angle);}
		//
		////  
		 
		else {IO.errorMessage("Please use exactly two arguments.");} 
	}
	
	
	
	//the manager can parse input from gui
	public void getPlayerInput(String _str)      { playerInput  = _str; parseInput();}
	public void setCurrentState(String _location){ currentState = _location;}
	public void addState(String _location)       { stateList.add(_location);}
}
