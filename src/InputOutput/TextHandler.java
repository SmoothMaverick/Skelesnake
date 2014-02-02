package InputOutput;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import GUI.GUI;

public class TextHandler {

	private DocumentBuilderFactory dbFactory;
	
	private File    practice;
	private Element stateElement;
	private GUI     gui;
	private String  currentOutput,currentInput;
	private String  currentState,childElement;
	
	
	public TextHandler(GUI _gui)
	{
		gui           = _gui;
		practice      = new File ("metadata//practice.xml");
		dbFactory     = DocumentBuilderFactory.newInstance();
		currentOutput = "";
		currentInput  = "";
		currentState  = "Cafeteria";
		childElement  = "introduction";
	}
	
	
	public void fetchAndDisplayText(String _currentState)
	{
		currentState = _currentState;
		
		try {
			DocumentBuilder dBuilder     = dbFactory.newDocumentBuilder();
			Document        doc          = dBuilder.parse(practice);  
			
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getElementsByTagName(currentState); //find current Location element
			
			for(int i = 0; i < nodes.getLength(); i++)
			{
				Node node = nodes.item(i); //saves all children from location element
				if(node.getNodeType() == Node.ELEMENT_NODE)
				{
				    stateElement = (Element)node;
					if (stateElement != null)
					{	
						currentOutput = getValue(childElement, stateElement);
						displayText();
					}
					
				}
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	//returns specific node value from an elementObject
	public static String getValue(String tagName, Element element)
	{
		NodeList nodes = element.getElementsByTagName(tagName).item(0).getChildNodes();
		Node node      = (Node)nodes.item(0);
		
		return node.getNodeValue();
	}
	
	public void fetchCurrentState(String _current)
	{
		currentState = _current;
	}
	
	public void   errorMessage() { gui.showText("I don't understand, please use only listed "  +
												 "commands\nfor a list of recognized commands "+
												 "type: get help");}
	
	private void displayText()
	{
	   gui.showText(currentOutput);
	}
	
	//To move
	public void setParentToChild(String _child)
	{
		currentState = getValue(_child, stateElement);
	}
	
	public void fetchAndDisplayCurrentStateText()
	{
		if(currentState != null && currentState != "")
		fetchAndDisplayText(currentState);
	}
	
	public void   errorMessage(String _str)     {gui.showText(_str); }
	public void   errorMessageVerb(String _str) {gui.showText("I don't know how to "+ _str + " something.");}
	public void   errorMessageNoun(String _str0, String _str1){gui.showText("I can't "+ _str0 + " the " + _str1 + ".");}
	
    
	public void   getClientInput(String _str)  {currentInput = _str; }
	public String getCurrentOutput()           {return currentOutput;}
	public String getCurrentState()            {return currentState; }
	
	
}
	
	

