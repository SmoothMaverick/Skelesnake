package GameDictionary;

import java.util.LinkedList;

public class GameDictionary {
	
	public LinkedList<Noun> nounsList;
	public LinkedList<Verb> verbsList;
	
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
	
	public boolean searchVerbs(String _str)
	{
		for(int i=0; i< verbsList.size();i++)
		{
			if(verbsList.get(i).getName().equalsIgnoreCase(_str))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean searchNouns(String _str)
	{
		for(int i=0; i< nounsList.size();i++)
		{
			if(nounsList.get(i).getName().equalsIgnoreCase(_str))
			{
				return true;
			}
		}
		return false;
	}
	
	public String getVerb(int i)  { return verbsList.get(i).getName();}
	public int    getVerbLength() { return verbsList.size();}
	public String getNoun(int i)  { return nounsList.get(i).getName();}
	public int    getNounLength() { return nounsList.size();}
}


