package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculate_CgpaForSheets {
	String fileName="processed_sheet4_withCredit.csv";
	FileWriter fileWriter = null;
	
	public Calculate_CgpaForSheets()
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
		try{
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));
		fileWriter = new FileWriter("processedSheet4_withCgpa.csv");
		fileReader.readLine();
		fileWriter.append("SID,Department,Hall_Status,Male_Female,Attendance,ClassText,Cgpa,Total_Credit_Completed,Status");
		fileWriter.append("\n");
		int i=1;
		int serial=4478;
		int prev_serial=4478;
		String[] tokens=null;
		double cgpa_temp=0;
		int term_complete=0;
		double attendance_marks=0;
		int hall_status=0;
		int male_female=0;
		int department_id=0;
		double totalgpa=0;
		int theory_credit=0;
		double classtest_marks=0;
		while ((line = fileReader.readLine()) != null) {	
			
			
			 String[] token = line.split(",");
			// System.out.println(token[0]);
			 String c_complete,result_status,t_status;
			 double a,t,c,s;
			 int level=0,term=0;
		
			 serial=Integer.parseInt(token[0]);
			if(!token[16].equals("") && !token[16].equals("NA"))
			{
				level=Integer.parseInt(token[16]);
			}
			if(!token[17].equals(""))
			{
				term=Integer.parseInt(token[17]);
			}
			
			
			if(((level==4 && term ==2 )|| (level==5 && term ==2) && token[1].equals("Arch")))
			{
				 //double cgpa=Double.parseDouble(token[19]);
				if(!token[22].equals("NR"))
				  term_complete=Integer.parseInt(token[22]);

			//  fileWriter.append(token[0]+","+token[5]+","+token[19]+","+token[22]+"\n");	
			//  prev_serial=serial;
			 }
			
			 
			 if(serial==prev_serial)
			 {
				 tokens=token;
				 if(!token[11].equals("INF"))
				{
					
					attendance_marks+=((double)Integer.parseInt(token[11])/(10));
					
					if(Integer.parseInt(token[9].substring(token[9].length()-1))%2!=0)
					{
						theory_credit+=Double.parseDouble(token[23]);
					}
				//	System.out.println("Attendance = "+attendance_marks);
				}
				 
				 if(!token[12].equals("INF") && !token[12].equals("Abs"))
				 {
					 classtest_marks+=Double.parseDouble(token[12])/20;
				 }
				 
				 if(token[5].equals("F"))
				 {
					 male_female=0;
				 }
				 else 
				 {
					 male_female=1;
				 }
				 
				 if(token[2].equals("Resident"))
				 {
					 hall_status=1;
				 }
				 else
				 {
					 hall_status=0;
				 }
				 
				 if(token[1].equals("EEE"))
				 {
					 department_id=1;
				 }
				 else if(token[1].equals("CSE"))
				 {
					 department_id=2;
				 }
				 else if(token[1].equals("IPE"))
				 {
					 department_id=3;
				 }
				 else if(token[1].equals("ME"))
				 {
					 department_id=4;
				 }
				 else if(token[1].equals("CE"))
				 {
					 department_id=5;
				 }
				 else if(token[1].equals("MME"))
				 {
					 department_id=6;
				 }
				 else if(token[1].equals("ChE"))
				 {
					 department_id=7;
				 }
				 else if(token[1].equals("NAME"))
				 {
					 department_id=8;
				 }
				 else if(token[1].equals("URP"))
				 {
					 department_id=9;
				 }
				 else if(token[1].equals("Arch"))
				 {
					 department_id=10;
				 }
				 else if(token[1].equals("WRE"))
				 {
					 department_id=11;
				 }
				 
				 
				 if(token[10].equals("A+"))
				 {
					 totalgpa+=(4* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("A"))
				 {
					 totalgpa+=(3.75* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("A-"))
				 {
					 totalgpa+=(3.5* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("B+"))
				 {
					 totalgpa+=(3.25* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("B"))
				 {
					 totalgpa+=(3* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("B-"))
				 {
					 totalgpa+=(2.75* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("C+"))
				 {
					 totalgpa+=(2.5* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("C"))
				 {
					 totalgpa+=(2.25* Double.parseDouble(token[23]));
					 
				 }
				 else if(token[10].equals("D"))
				 {
					 totalgpa+=(2* Double.parseDouble(token[23]));
					 
				 }
				 
				// System.out.println("Total gpa = "+totalgpa);
				 
				 if(token[2].equals("Attached"))
				 {
					 hall_status=0;
				 }
				 else
				 {
					 hall_status=1;
				 }
					  
				 
				 
			 }
			 			 
			 if(serial!=prev_serial)
			 {
				 prev_serial=serial;
				 if(term_complete!=0)
				 {
				 double a_status=attendance_marks/theory_credit;
				 double cgpa=totalgpa/term_complete;
				 double c_status=classtest_marks/theory_credit;
				
				 fileWriter.append(token[0]+","+department_id+","+hall_status+","+male_female+","+a_status+","+c_status +","+cgpa+","+term_complete+"\n");
				 i++;
				 System.out.println("i = "+i);
				 }
				 department_id=0;
				 hall_status=0;
				 male_female=0;
				 term_complete=0;
				 totalgpa=0;
				 attendance_marks=0;
				 theory_credit=0;
				 classtest_marks=0;
			 }

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
