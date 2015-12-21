package mainpackage;

import java.util.ArrayList;

public class Node {
	
	double value;
	double attribute_id;
	double attribute_value;
	double info_gain;
	int level;
	ArrayList<String> attributeValue;
	
	ArrayList<Node> childNodes=new ArrayList<Node>();
	public Node()
	{		
		attributeValue=new ArrayList<String>();			
	}
		
	public void setChildList(ArrayList<Node> child)
	{
		this.childNodes=child;
	}
	
	public ArrayList<Node> getChildList(){
		return childNodes;
	}
	
	public void setAttribute(double value)
	{
		this.attribute_value=value;
		
	}
	
	public double getValue()
	{
		return this.attribute_value;
	}
	
	public void setLevel(int level)
	{
		this.level=level;
	}
	
		
}
