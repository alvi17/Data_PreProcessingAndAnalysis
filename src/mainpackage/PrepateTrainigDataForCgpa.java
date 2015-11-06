package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrepateTrainigDataForCgpa{
	String fileName="processed_sheet1.csv";
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
		fileWriter = new FileWriter("G:/training_data_for_male_female_cgpa.csv");
		fileReader.readLine();
		fileWriter.append("SID,Cgpa,Total_Credit_Completed,Result_status");
		fileWriter.append("\n");
		int i=1;
		int serial=100;
		int prev_serial=2;
		String[] tokens=null;
		while ((line = fileReader.readLine()) != null) {
			 String[] token = line.split(",");
			 String c_complete,result_status,t_status;
			 double a,t,c,s;
			 serial=Integer.parseInt(token[0]);
			 if(serial==prev_serial)
			 {
				 tokens=token;
			 }
			 
			
			 
			 if(serial!=prev_serial)
			 {
				 
				 prev_serial=serial;
				 if(tokens.length>0)
				 {
//					  int attendance_mark=Integer.parseInt(tokens[1]);
//					  float total_credit=Float.parseFloat(tokens[2]);
//					  float term_count=Float.parseFloat(tokens[3]);
//					  float credit_completed=Float.parseFloat(tokens[4]);
//					  float cgpa=Float.parseFloat(tokens[5]);
					  
					  fileWriter.append(tokens[0]+","+tokens[5]+","+tokens[22]+"\n");
					  
				 }
			 
			
			 i++;
			
			 }
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
