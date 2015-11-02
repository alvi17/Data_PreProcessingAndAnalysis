package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessCsv {
	
	String fileName="G:/training_data.csv";
	FileWriter fileWriter = null;
	public ProcessCsv()
	{
		super();
	}
	
	public void readCsv()
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
		fileWriter = new FileWriter("G:/training_data_processed.csv");
		fileReader.readLine();
		fileWriter.append("SID,Attendance,Total CR. Completed,Credit Earned,Term Completed,Cgpa,Attendance_status,CreditComplete_staus,Cgpa_status,Sincerity_status");
		fileWriter.append("\n");
		int i=1;
		 while ((line = fileReader.readLine()) != null) {
			 String[] tokens = line.split(",");
			 String a_status,t_status,c_status,s_status;
			 double a,t,c,s;
			 if(tokens.length>0)
			 {
				  int attendance_mark=Integer.parseInt(tokens[1]);
				  float total_credit=Float.parseFloat(tokens[2]);
				  float term_count=Float.parseFloat(tokens[3]);
				  float credit_completed=Float.parseFloat(tokens[4]);
				  float cgpa=Float.parseFloat(tokens[5]);
				  if(attendance_mark>=36)
				  {
					  attendance_mark=40;
					  a_status="OK";
					  a=0.3;
					  tokens[1]=attendance_mark+"";
					  
					  
				  }
				  else if(attendance_mark<=30 && attendance_mark>=24)
				  {
					  a_status="OK";
					  a=.3;
					  
				  }
				  else
				  {
					  a_status="Not OK";
					  a=.1;
				  }
				  
				  if(credit_completed>0)
				  {
					  float diff=Math.abs(total_credit-term_count*18);
					  if(diff*.95>=(Math.abs(credit_completed*term_count-total_credit)))
					  {
						  t_status="InComplete";
						  t=.01;
					  }
					  else
					  {
						  t_status="Complete";
						  t=.8;
					  }
				  }
				  else
				  {
					  t_status="InComplete";
					  t=.01;
				  }
				  if(cgpa>=3.5)
				  {
					  c_status="High";
					  c=.7;
					  
				  }
				  else if(cgpa>=3.25 && cgpa<3.5)
				  {
					  c_status="Medium";
					  c=.5;
				  }
				  else
				  {
					  c_status="Low";
					  c=.1;
				  }
				  
				  s=a+t+c;
				  if(s>=1.2)
				  {
					  s_status="Sincere";
				  }
				  else
				  {
					  s_status="Not Sincere";
				  }
				  fileWriter.append(tokens[0]+","+tokens[1]+","+tokens[2]+","+tokens[3]+","+tokens[4]+","+
				  tokens[5]+","+a_status+","+t_status+","+c_status+","+s_status+"\n");
				// System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]);
			 }
			 i++;
			
		 }
		 System.out.println("i= "+i);
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
	
	public void process_training_data()
	{
		try{
		fileWriter = new FileWriter("G:/training_data_processed.csv");
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
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
