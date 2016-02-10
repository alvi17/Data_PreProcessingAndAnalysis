package mainpackage;

import java.util.ArrayList;

public class BuildDecisionTree {
	
	ArrayList<Double>list;
	FindInfoGain fg;
	public BuildDecisionTree()
	{
		list=new ArrayList<Double>();
		fg=new FindInfoGain();
		fg.getArrtibute();
		list=fg.sortedList;
	}
	
	
	
	

}
