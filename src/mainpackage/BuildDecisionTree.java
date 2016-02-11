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
	
	public ArrayList<ArrayList<String>> cgpa_gt_80;
	public ArrayList<ArrayList<String>> cgpa_gt_50;
	public ArrayList<ArrayList<String>> cgpa_gt_00;
	
	public BuildDecisionTree()
	{
		list=new ArrayList<Double>();
		fg=new FindInfoGain();
		fg.updateClassLabels();
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
		
		
		cgpa_gt_80=new ArrayList<ArrayList<String>>();
		cgpa_gt_50=new ArrayList<ArrayList<String>>();
		cgpa_gt_00=new ArrayList<ArrayList<String>>();
		
		cgpa_gt_80=fg.cgpa_gt_80;
		cgpa_gt_50=fg.cgpa_gt_50;
		cgpa_gt_00=fg.cgpa_gt_00;
		
	}
	
	public void buildTree_80()
	{		
		ArrayList<String> temp=cgpa_gt_80.get(0);		
		System.out.println(cgpa_gt_00.size());
		System.out.println(temp.toString());
		
		
	}
	
	public String getLabel(String[] attributes)
	{
		
		
		return "";
	}
	
	public static void main(String[] args) {
		BuildDecisionTree bt=new BuildDecisionTree();
		bt.buildTree_80();
	}

}
