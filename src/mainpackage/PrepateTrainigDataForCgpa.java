package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrepateTrainigDataForCgpa{
	String fileName="sheet1.csv";
	FileWriter fileWriter = null;
	
	public PrepateTrainigDataForCgpa()
	{
		super();
	}
	public void create_training_Csv()
	{
		BufferedReader fileReader = null;
		
		List id=new ArrayList();
		List attendance=new ArrayList();
		List totalCredit=new ArrayList();
		List completedCredit=new ArrayList();
		List cgpaList=new ArrayList();
		try {
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));
		fileWriter = new FileWriter("training_data_for_male_female_cgpa.csv");
		fileReader.readLine();
		fileWriter.append("SID,Male_Female,Cgpa,Total_Credit_Completed,Result_status");
		fileWriter.append("\n");
		int i=1;
		int serial=100;
		int prev_serial=0;
		String[] tokens=null;
		while ((line = fileReader.readLine()) != null) {
			 String[] token = line.split(",");
			 String c_complete,result_status,t_status;
			 double a,t,c,s;
			 int level=0,term=0;
			 if(token.length>21)
			 {
			 serial=Integer.parseInt(token[0]);
			if(!token[16].equals(""))
			{
			 level=Integer.parseInt(token[16]);
			}
			if(!token[17].equals(""))
			{
			 term=Integer.parseInt(token[17]);
			}
			 if(((level==4 && term ==2 )|| (level==5 && term ==2)) && serial!=prev_serial)
			 {
				 double cgpa=Double.parseDouble(token[19]);
				 int term_complete=Integer.parseInt(token[22]);
				 if(cgpa>=3.8 && term_complete>=158)
				 {
					 result_status="Excellent";
				 }
				 else if(cgpa>=3.65 && cgpa<3.8 && term_complete>=158)
				 {
					 result_status="VeryGood";
				 }
				 else if(cgpa>=3.5 && cgpa<3.65 && term_complete>=158)
				 {
					 result_status="Good";
				 }
				 else if(cgpa>=3 && cgpa<=3.5 && term_complete>=158)
				 {
					 result_status="Moderate";
				 }
				 else if(cgpa>=3.5 && term_complete<158)
				 {
					 result_status="Moderate";
				 }
				 else if(cgpa<3 && term_complete>=158)
				 {
					 result_status="Poor";
				 }
				 else if(cgpa<3.5 && term_complete<158)
				 {
					 result_status="VeryPoor";
				 }
				 else
				 {
					 result_status="Moderate";
				 }
			 
			  fileWriter.append(token[0]+","+token[5]+","+token[19]+","+token[22]+","+result_status+"\n");	
			  prev_serial=serial;
			 }
			 }
			 if(serial==prev_serial)
			 {
				 tokens=token;
			 }
			 			 
//			 if(serial!=prev_serial)
//			 {
//				 
//				 prev_serial=serial;
//				 if(tokens.length>0)
//				 {
//					  int attendance_mark=Integer.parseInt(tokens[1]);
//					  float total_credit=Float.parseFloat(tokens[2]);
//					  float term_count=Float.parseFloat(tokens[3]);
//					  float credit_completed=Float.parseFloat(tokens[4]);
//					  float cgpa=Float.parseFloat(tokens[5]);
					  //				 }
			 
			
			 i++;
			 System.out.println("i= "+i);
			
			 }
		
		
		}
		catch(Exception e)
		{
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
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	

}
