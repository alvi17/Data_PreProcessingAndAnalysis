package mainpackage;

import java.util.ArrayList;
import java.util.Random;

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
	
	public String  buildTree_80(String[] attr)
	{		
		String status="";
		
		for(int i=0;i<cgpa_gt_80.size();i++)
		{
			int match=0;
			ArrayList<String> temp=cgpa_gt_80.get(i);		
			//System.out.println(cgpa_gt_00.size());
			//System.out.println(temp.toString());
			
			if(Double.parseDouble(temp.get(4))>=.8 && Double.parseDouble(attr[4])>=.8)
			{
				//check for others
				match++;
				
				
			}
			else if(Double.parseDouble(temp.get(4))>=.65 && Double.parseDouble(temp.get(4))<.8
					&& Double.parseDouble(attr[4])<=.8 && Double.parseDouble(attr[4])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(4))<.65 && Double.parseDouble(attr[4])<=.65)
			{
				match++;
				
			}
			
			
			if(Double.parseDouble(temp.get(5))>=.8 && Double.parseDouble(attr[5])>=.8)
			{
				//check for others
				match++;
				
				
			}
			else if(Double.parseDouble(temp.get(5))>=.65 && Double.parseDouble(temp.get(5))<.8
					&& Double.parseDouble(attr[5])<=.8 && Double.parseDouble(attr[5])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(5))<.65 && Double.parseDouble(attr[5])<=.65)
			{
				match++;
				
			}
						
			if(Integer.parseInt(temp.get(2))==Integer.parseInt(attr[2]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(1))==Integer.parseInt(attr[1]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(3))==Integer.parseInt(attr[3]))
			{
				match++;
			}
					
			if(match>3)
			{
				status=temp.get(7);
			}
		}
		if(status.equals(""))
		{
			double random=Math.random();
			if(random>=.3)
			{
				status="Excellent";
			}
			else
			{
				status="Very Good";
			}						
		}		
		return status;
	}
	
	public String  buildTree_50(String[] attr)
	{		
		String status="";
		//int match=0;
		for(int i=0;i<cgpa_gt_50.size();i++)
		{
			int match=0;
			ArrayList<String> temp=cgpa_gt_50.get(i);		
			//System.out.println(cgpa_gt_00.size());
			//System.out.println(temp.toString());
			
			if(Double.parseDouble(temp.get(4))>=.8 && Double.parseDouble(attr[4])>=.8)
			{
				//check for others
				match++;			
			}
			else if(Double.parseDouble(temp.get(4))>=.65 && Double.parseDouble(temp.get(4))<.8
					&& Double.parseDouble(attr[4])<=.8 && Double.parseDouble(attr[4])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(4))<.65 && Double.parseDouble(attr[4])<.65)
			{
				match++;
				
			}
						
			if(Double.parseDouble(temp.get(5))>=.8 && Double.parseDouble(attr[5])>=.8)
			{
				//check for others
				match++;
							
			}
			else if(Double.parseDouble(temp.get(5))>=.65 && Double.parseDouble(temp.get(5))<.8
					&& Double.parseDouble(attr[5])<.8 && Double.parseDouble(attr[5])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(5))<.65 && Double.parseDouble(attr[5])<.65)
			{
				match++;
				
			}
						
			if(Integer.parseInt(temp.get(2))==Integer.parseInt(attr[2]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(1))==Integer.parseInt(attr[1]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(3))==Integer.parseInt(attr[3]))
			{
				match++;
			}
					
			if(match>3)
			{
				status=temp.get(7);
			}
		}
		if(status.equals(""))
		{
			double random=Math.random();
			if(random>=.9)
			{
				status="Excellent";
			}
			else if(random>.8 && random<.9)
			{
				status="Very Good";
			}
			else if(random>.5 && random<.8)
			{
				status="Good";
			}
			else
			{
				status="Moderate";
			}
		}		
		return status;
	}
	
	
	public String  buildTree_00(String[] attr)
	{		
		String status="";
		//int match=0;
		for(int i=0;i<cgpa_gt_00.size();i++)
		{
			int match=0;
			ArrayList<String> temp=cgpa_gt_00.get(i);		
			//System.out.println(cgpa_gt_00.size());
			//System.out.println(temp.toString());
			
			if(Double.parseDouble(temp.get(4))>=.8 && Double.parseDouble(attr[4])>=.8)
			{
				//check for others
				match++;
				
				
			}
			else if(Double.parseDouble(temp.get(4))>=.65 && Double.parseDouble(temp.get(4))<.8
					&& Double.parseDouble(attr[4])<.8 && Double.parseDouble(attr[4])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(4))<.65 && Double.parseDouble(attr[4])<=.65)
			{
				match++;
				
			}
			
			
			if(Double.parseDouble(temp.get(5))>=.8 && Double.parseDouble(attr[5])>=.8)
			{
				//check for others
				match++;
				
				
			}
			else if(Double.parseDouble(temp.get(5))>=.65 && Double.parseDouble(temp.get(5))<.8
					&& Double.parseDouble(attr[5])<=.8 && Double.parseDouble(attr[5])>=.65)
			{
				match++;
			}
			else if(Double.parseDouble(temp.get(5))<.65 && Double.parseDouble(attr[5])<=.65)
			{
				match++;
				
			}
						
			if(Integer.parseInt(temp.get(2))==Integer.parseInt(attr[2]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(1))==Integer.parseInt(attr[1]))
			{
				match++;
			}
			if(Integer.parseInt(temp.get(3))==Integer.parseInt(attr[3]))
			{
				match++;
			}
					
			if(match>4)
			{
				status=temp.get(7);
			}
		}
		if(status.equals(""))
		{
			double random=Math.random();
			if(random>=.5 && random <.8)
			{
				status="Moderate";
			}
			else if(random>=.8)
			{
				status="Good";
			}
			else if(random<.5 && random >=.25)
			{
				status="Poor";
			}
			else
			{
				status="Very Poor";
			}
		}		
		return status;
	}
	
	public String getLabel(String[] attributes)
	{
		String[] attr=new String[7];
		attr[0]=attributes[0];
		attr[1]=attributes[1];
		attr[2]=attributes[2];
		attr[3]=attributes[3];
		attr[4]=attributes[4];
		attr[5]=attributes[5];
		attr[6]=attributes[7];
		
		if(Double.parseDouble(attributes[6])>=3.8)
		{
			return buildTree_80(attr);
		}
		else if(Double.parseDouble(attributes[6])<3.8 && Double.parseDouble(attributes[6])>=3.5)
		{
			return buildTree_50(attr);
		}
		else
		{
			return buildTree_00(attr);
		}
		
	}
	
	public static void main(String[] args) {
		BuildDecisionTree bt=new BuildDecisionTree();
		///bt.buildTree_80({""});
	}

}
