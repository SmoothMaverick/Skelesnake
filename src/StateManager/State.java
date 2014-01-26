package StateManager;

public class State {

	String type, intro, north, south, east, west;
	
	public State(String _type )
	{
		type = _type;
		intro = "DEFAULT INTRO";
	}
	
	public String getIntro()
	{
		return intro;
	}
}
