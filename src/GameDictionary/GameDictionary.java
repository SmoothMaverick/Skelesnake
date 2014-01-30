package GameDictionary;

import java.util.LinkedList;

public class GameDictionary {
	
	LinkedList<Noun> nounsList;
	LinkedList<Verb> verbsList;
	
	public GameDictionary()
	{
		nounsList = new LinkedList();
		verbsList = new LinkedList();	
	}

	public void init()
	{
		nounsList.add(new Noun("north"));
		nounsList.add(new Noun("south"));
		nounsList.add(new Noun("east"));
		nounsList.add(new Noun("west"));
		
		verbsList.add(new Verb("move"));
		verbsList.add(new Verb("go"));
		verbsList.add(new Verb("inspect"));
		verbsList.add(new Verb("take"));
		verbsList.add(new Verb("open"));
	}
	
	
}
