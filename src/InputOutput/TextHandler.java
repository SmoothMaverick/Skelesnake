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
			NodeList nodes = doc.getElementsByTagName(_currentState); //find current Location element
			
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
	 
	public void   getClientInput(String _str)  {currentInput = _str;}
	public String getCurrentOutput()           {return currentOutput;}
	public void   setChildElement(String _str) {childElement=_str;}
	
	private void displayText()
	{
	   gui.showText(currentOutput);
	}
	
}
	
	

