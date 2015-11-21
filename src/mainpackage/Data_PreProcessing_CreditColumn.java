package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data_PreProcessing_CreditColumn {
	String fileName="processed_sheet2.csv";
	FileWriter fileWriter = null;
	
	public Data_PreProcessing_CreditColumn()
	{
		super();
	}
	
	
	public void create_Credit_Csv()
	{
		BufferedReader fileReader = null;
		
		List id=new ArrayList();
		List attendance=new ArrayList();
		List totalCredit=new ArrayList();
		List completedCredit=new ArrayList();
		List cgpaList=new ArrayList();
		int sessionalCourse=0;
		try{
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));
	//	fileWriter = new FileWriter("processed_sheet1_withCredit.csv");
		String s=fileReader.readLine();
		String[] parts=s.split(",");
	//	fileWriter.append("SERIAL,DEPARTMENTID,HALLSTATUS,Gender,STARTINGACADEMICYEAR2,ADMISSIONDATE,ADMISSIONDATE,LETTERGRADE,CLASSATTENDENCEMARKS,CLASSTESTMARKS,PARTAMARKS,PARTBMARKS,TOTALNUMBER,LEVELNAME,TERMNAME,GPA,CGPA,TERMCOUNT,CRHREARNED,TOTCRHRCOMPLETED");
	//	fileWriter.append("\n");
		
		//int i=1;
		int serial=100;
		int prev_serial=0;
		String[] tokens=null;
		 String grades="";		 
		 String courseName="";
		 double totalNumber=0;
		 int sessional=0;
		 double credit=0;
		while ((line = fileReader.readLine()) != null) {
			 String[] token = line.split(",");
			 String c_complete,result_status,t_status;
			 double a,t,c;
			 int level=0;
			 int term=0;
			 
			 for(int i=0;i<token.length;i++)
			 {
				 if(parts[i].equals("LETTERGRADE") && !token[i].equals("NR"))
				 {
					 grades = token[i];	 
				 }
				 else if(parts[i].equals("TOTALNUMBER") && (!token[i].equals("Abs") && !token[i].equals("NR")))
				 {
					 if(!token[i].equals("Cont") && !token[i].equals("Sat") && !token[i].equals("Unsat") &&!token[i].equals("Fail"))
						 totalNumber=Double.parseDouble(token[i]);					 
				 }
				 else if(parts[i].equals("COURSENUMBER"))
				 {
					 courseName=token[i];
					 sessional=Integer.parseInt(courseName.substring(courseName.length()-1))%2;
				 }				  		
			 }
			 int x=0;
			 //check for sessional course
			 if(sessional==0 && totalNumber<=150)
			 {
				 double percent=totalNumber*100/150;
				// System.out.println(percent)
				 if((percent>=80 && grades.equals("A+"))||(percent<80 && percent>=75 && grades.equals("A"))||(percent<75 && percent>=70 && grades.equals("-A"))|| (percent<70 && percent>=65 && grades.equals("B+"))||(percent<65 && percent>=60 && grades.equals("B"))||(percent<60 && percent>=55 && grades.equals("B-"))||
						 (percent<55 && percent>=50 && grades.equals("C+"))||(percent<50 && percent>=45 && grades.equals("C"))||(percent<45 && percent>=40 && grades.equals("D"))||(percent<40 && grades.equals("F")))
				 {
					 credit=1.5;
					 x=1;
					 //System.out.println(",1.5,");
				 }
				 else 
				 {
					 if(!grades.equals("S") || !grades.equals("U") || !grades.equals("X"))
					 {
					//	 credit=0.75;
					 }
				 }
				 
				 if(totalNumber<=75)
				 {
					 double percent1=totalNumber*100/75;
						// System.out.println(percent)
						 if((percent1>=80 && grades.equals("A+"))||(percent1<80 && percent1>=75 && grades.equals("A"))||(percent1<75 && percent1>=70 && grades.equals("-A"))|| (percent1<70 && percent1>=65 && grades.equals("B+"))||(percent1<65 && percent1>=60 && grades.equals("B"))||(percent1<60 && percent1>=55 && grades.equals("B-"))||
								 (percent1<55 && percent1>=50 && grades.equals("C+"))||(percent1<50 && percent1>=45 && grades.equals("C"))||(percent1<45 && percent1>=40 && grades.equals("D"))||(percent1<40 && grades.equals("F")))
						 {
							 credit=.75;
							 x=1;
							 //System.out.println(",1.5,");
						 }
						 else 
						 {
							 if(!grades.equals("S") || !grades.equals("U") || !grades.equals("X"))
							 {
								// credit=1.5;
							 }
						 }
					 
				 }
				 if(x==0)
				 {
					 credit=1.5;
				 }
				 
				 sessionalCourse++;
				 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
			 }
			 
			 
			 //fileWriter.append(token[0]+","+token[5]+","+token[19]+","+token[22]+","++"\n");	
			 		 
		}
			 
			
			 			 
//			 if(serial!=prev_serial)
//			 {
//				 prev_serial=serial;
//				 if(tokens.length>0)
//				 {
//					  int attendance_mark=Integer.parseInt(tokens[1]);
//					  float total_credit=Float.parseFloat(tokens[2]);
//					  float term_count=Float.parseFloat(tokens[3]);
//					  float credit_completed=Float.parseFloat(tokens[4]);
//					  float cgpa=Float.parseFloat(tokens[5]);
//				 }
			 
			
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
			//	fileWriter.flush();
			//	fileWriter.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Total Sessional Course :"+sessionalCourse);
	}
}
