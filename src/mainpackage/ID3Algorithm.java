package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ID3Algorithm {
	
	//String fileName="training_data_for_male_female_cgpa.csv";	
	String male_female;
	double cgpa;
	int cr_completed;
	String result;
	int split_attribute;
	double gain_male_female,gain_credit_completed,gain_cgpa;

	ArrayList<ArrayList<Double>> trainingList;
	String fileName="processedSheet2_withCgpa.csv";
	FileWriter fileWriter = null;
	BuildDecisionTree bt;
	
	public ID3Algorithm()
	{
		bt=new BuildDecisionTree();
	}
	
	public void getFinalClass()
	{
		BufferedReader fileReader = null;
		
		try{
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));
		fileWriter = new FileWriter("FinalResultFromsheet2.csv");
		fileReader.readLine();
		fileWriter.append("SID,Department,Hall,Male_Female,Attendance,Classtest,Cgpa,Total_Credit_Completed,Status");
		fileWriter.append("\n");
		int i=1;
		int serial=100;
		int prev_serial=0;
		String status=null;
		String[] tokens=null;
		while ((line = fileReader.readLine()) != null) {					
			 String[] token = line.split(",");
			 status=bt.getLabel(token);
			 fileWriter.append(token[0]+","+token[1]+","+token[2]+","+token[3]+","+token[4]
					 +","+token[5]+","+token[6]+","+token[7]+","+status+"\n");
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileReader.close();
				fileWriter.flush();
				fileWriter.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
