package mainpackage;

import java.util.ArrayList;

public class BuildDecisionTree {
	
	ArrayList<Double>list;
	FindInfoGain fg;

	public ArrayList<Integer> deptList;
	public ArrayList<Integer> hallList;
	public ArrayList<Integer> male_femaleList;
	public ArrayList<Double> cgpaList;
	public ArrayList<Double> classtestList;
	public ArrayList<Double> attendanceList;
	public ArrayList<Integer> creditList;
	public ArrayList<String> statusList;
	
	
	public BuildDecisionTree()
	{
		list=new ArrayList<Double>();
		fg=new FindInfoGain();
		fg.getArrtibute();
		list=fg.sortedList;
		
		deptList=new ArrayList<Integer>();
		hallList=new ArrayList<Integer>();
		male_femaleList=new ArrayList<Integer>();
		cgpaList=new ArrayList<Double>();
		classtestList=new ArrayList<Double>();
		creditList=new ArrayList<Integer>();
		attendanceList=new ArrayList<Double>();
		statusList=new ArrayList<String>();	
		
	}
	
	public void buildTree()
	{
		
		
	}
	
	public String getLabel(String[] attributes)
	{
		
		
		return "";
	}
	
	

}
