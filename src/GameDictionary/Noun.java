package GameDictionary;

public class Noun {

	String name;
	private boolean bInspectable = true;
	private boolean bTakable     = false;
	private boolean bDoorObject  = false;
	private boolean bPerishable  = false;
	
	public Noun(String _name)
	{
		name = _name;
		
		switch(name)
		{
		case "backpack": bInspectable = true;
		case "knife"   : bTakable     = true;
		case "water"   : bPerishable  = true;
		}
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isInspectable() {return bInspectable;}
	public boolean isTakable()     {return bTakable;    }
	public boolean isDoorObject()  {return bDoorObject; }
	public boolean isPerishable()  {return bPerishable; }
	
}
