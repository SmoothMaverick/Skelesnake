package GameDictionary;

import java.util.LinkedList;

public class GameDictionary {
	
	public LinkedList<Noun> nounsList;
	public LinkedList<Verb> verbsList;
	private int verbIndex=-1;
	private int nounIndex=-1;
	
	
	public GameDictionary()
	{
		nounsList = new LinkedList();
		verbsList = new LinkedList();	
	}

	public void init()
	{
		nounIndex =0;
		//locations
		nounsList.add(new Noun("north"));
		nounsList.add(new Noun("south"));
		nounsList.add(new Noun("east"));
		nounsList.add(new Noun("west"));
		//items
		nounsList.add(new Noun("backpack"));
		nounsList.add(new Noun("knife"));
		nounsList.add(new Noun("water"));
		
		verbIndex=0;
		//commands
		verbsList.add(new Verb("move"));
		verbsList.add(new Verb("go"));
		verbsList.add(new Verb("inspect"));
		verbsList.add(new Verb("take"));
		verbsList.add(new Verb("open"));
		verbsList.add(new Verb("use"));
	}
	
	//returns index of searched verb/noun
	public int searchVerb(String _str)
	{
		for(int i=0; i< nounsList.size();i++)
		{
			if(verbsList.get(i).getName().equalsIgnoreCase(_str))
			{
				return i;
			}
		}
		return -1;
	}
	//returns true if verb is in dictionary
	public boolean hasVerb(String _str)
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

	
	public boolean hasNoun(String _str)
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
	
	public int searchNoun(String _str)
	{
		for(int i=0; i< nounsList.size();i++)
		{
			if(nounsList.get(i).getName().equalsIgnoreCase(_str))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
	public String getVerb(int i)       { return verbsList.get(i).getName();}
	public int    getVerbLength()      { return verbsList.size();}
	public int    getVerbIndex()       { return verbIndex;}
	public String getActiveVerb()      { return verbsList.get(verbIndex).getName();}
	public void   addVerb(String _str) { verbsList.add(new Verb(_str));}
	public void   setVerbIndex(int i)  {verbIndex =i;}
	
	
	public String getNoun(int i)       { return nounsList.get(i).getName();}
	public int    getNounLength()      { return nounsList.size();}
	public int    getNounIndex()       { return nounIndex;}
	public String getActiveNoun()      { return nounsList.get(nounIndex).getName();}
	public void   addNoun(String _str) { nounsList.add(new Noun(_str));}
	public  void  setNounIndex(int i)  { nounIndex = i;}
	
}


