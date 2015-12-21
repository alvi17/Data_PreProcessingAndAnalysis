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
		int num=0;
		
		List id=new ArrayList();
		List attendance=new ArrayList();
		List totalCredit=new ArrayList();
		List completedCredit=new ArrayList();
		List cgpaList=new ArrayList();
		
		int sessionalCourse=0;
		int serial_num=0;
		int non_credit=0;
		
		try{
			
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));
		fileWriter = new FileWriter("processed_sheet2_withCredit.csv");
		String s=fileReader.readLine();
		String[] parts=s.split(",");
		fileWriter.append("SERIAL,DEPARTMENTID,HALLSTATUS,Gender,STARTINGACADEMICYEAR2,ADMISSIONDATE,ADMISSIONDATE,LETTERGRADE,CLASSATTENDENCEMARKS,CLASSTESTMARKS,PARTAMARKS,PARTBMARKS,TOTALNUMBER,LEVELNAME,TERMNAME,GPA,CGPA,TERMCOUNT,CRHREARNED,TOTCRHRCOMPLETED,COURSECREDIT");
		fileWriter.append("\n");
		
		//	int i=1;
		int serial=100;
		int prev_serial=0;
		String[] tokens=null;
		String grades="";		 
		String courseName="";
		double totalNumber=0;
		int sessional=0;
		double credit=0;
		 
		while ((line = fileReader.readLine()) != null){
			 String[] token = line.split(",");
			 String c_complete,result_status,t_status;
			 double a,t,c;
			 int level=0;
			 int term=0;
			 serial_num++;
			 fileWriter.append(line);
			 for(int i=0;i<token.length;i++)
			 {
				 if(parts[i].equals("LETTERGRADE") )
				 {
					 grades = token[i];	 
				 }
				 else if(parts[i].equals("TOTALNUMBER"))
				 {
					 if(!token[i].equals("Abs") && !token[i].equals("NR") && !token[i].equals("Cont") && !token[i].equals("Sat") && !token[i].equals("Unsat") &&!token[i].equals("Fail"))
					 {
						 totalNumber=Double.parseDouble(token[i]);	
						 if(token[i].endsWith("9") || token[i].endsWith("24")||token[i].endsWith("54")||token[i].endsWith("84")||token[i].endsWith("94"))
						 {
							 totalNumber=totalNumber+1;
						 }
					 }	
					 else
					 {
						 totalNumber=0;
					 }
				 }
				 else if(parts[i].equals("COURSENUMBER"))
				 {
					 courseName=token[i];
					 if(courseName.length()>0)
					 {
					 sessional=Integer.parseInt(courseName.substring(courseName.length()-1))%2;
					 }
				 }				  		
			 }
			 int x=0;
			 double percent=0;
			 //check for sessional course
			 if(sessional==0 && totalNumber==0)
			 {
				 non_credit++;
				 if(grades.equals("S") || grades.equals("U") || grades.equals("X")||grades.equals("NR"))
				 {
					 credit=0;
					
					 x=1;
				 }
				 fileWriter.append(","+credit);
				 
			 }
			 else if(sessional==0 && totalNumber<=150)
			 {
				 percent=totalNumber*100/150;
				// System.out.println(percent)
				 if((percent>=80 && grades.equals("A+"))||(percent<80 && percent>=75 && grades.equals("A"))||(percent<75 && percent>=70 && grades.equals("A-"))|| (percent<70 && percent>=65 && grades.equals("B+"))||(percent<65 && percent>=60 && grades.equals("B"))||(percent<60 && percent>=55 && grades.equals("B-"))||
						 (percent<55 && percent>=50 && grades.equals("C+"))||(percent<50 && percent>=45 && grades.equals("C"))||(percent<45 && percent>=40 && grades.equals("D"))||(percent<40 && grades.equals("F")))
				 {
					 credit=1.5;
					 x=1;
					 //	System.out.println(",1.5,");
				 }
				 
				 if(totalNumber<=75)
				 {
					 double percent1=totalNumber*100/75;
						// System.out.println(percent)
						 if((percent1>=80 && grades.equals("A+"))||(percent1<80 && percent1>=75 && grades.equals("A"))||(percent1<75 && percent1>=70 && grades.equals("A-"))|| (percent1<70 && percent1>=65 && grades.equals("B+"))||(percent1<65 && percent1>=60 && grades.equals("B"))||(percent1<60 && percent1>=55 && grades.equals("B-"))||
								 (percent1<55 && percent1>=50 && grades.equals("C+"))||(percent1<50 && percent1>=45 && grades.equals("C"))||(percent1<45 && percent1>=40 && grades.equals("D"))||(percent1<40 && grades.equals("F")))
						 {
							 credit=.75;
							 x=1;
							 //	System.out.println(",1.5,");
						 }
						 
				 }
				 if(x==0)
				 {
					 credit=1.5;
				 }				 
				 sessionalCourse++;
				 fileWriter.append(","+credit);
				 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
			 }
			 else if(courseName.contains("400") &&  !grades.equals("X"))
			 {
				 //thesis
				credit=6;
				fileWriter.append(","+credit);
				System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
 
			 }
			 
			 else
			 {
				 num++;
				 //theory courses
				 double p1=totalNumber/200*100; //2 credit
				 double p2=totalNumber/300*100; //3 credit
				 double p3=totalNumber/400*100; //4 credit
				 
				 //check for 2 credit course
				 
				 if(totalNumber<=200)
				 {
					 if((p1>=79 && grades.equals("A+")) || (p1<=79.5 && p1>=74 && grades.equals("A"))||(p1<=74.5 && p1>=69 && grades.equals("A-")) 
							 ||(p1<=69.5 && p1>=64 && grades.equals("B+"))||(p1<=64.5 && p1>=59 && grades.equals("B")) || (p1<=59.5 && p1>=54 && grades.equals("B-"))||(p1<=54.5 && p1>=49 && grades.equals("C+"))
							 ||(p1<=49.5 && p1>=44 && grades.equals("C")) ||(p1<=44.5 && p1>=39 && grades.equals("D")))
					 {
						 credit = 2;
					 }
					 
					 if((p2>=64 && grades.equals("B+")) || (p2<=64.5 && p2>=59 && grades.equals("B")) || (p2<=59.5 && p2>=54 && grades.equals("B-"))
							 ||(p2<=54.5 && p2>=49 && grades.equals("C+")) || (p2<=49.5 && p2>=44 && grades.equals("C")) || (p2<=44.5 && p2>=39 && grades.equals("D")))
					 {
						 credit=3;
					 }
					 
					 if((p3<=49.5 && p3>=44 && grades.equals("C")) || (p3<=44.5 && p3>=39 && grades.equals("D")))
					 {
						 credit=4;
					 }
					 if(p3<39 && grades.equals("F"))
					 {
						 credit=4;
					 }
					 if(p2<39 && grades.equals("F"))
					 {
						 credit=3;
					 }
					 if(p1<39 && grades.equals("F"))
					 {
						 credit=2;
					 }
					 
					 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
				 }
				 else if(totalNumber<300 && totalNumber>200)
				 {
					 //check for 3 credit
					 if((p2>=79 && grades.equals("A+")) || (p2<=79.5 && p2>=74 && grades.equals("A"))
							 ||(p2<=74.5 && p2>=69 && grades.equals("A-")) 
							 ||(p2<=69.5 && p1>=64 && grades.equals("B+"))){
						 credit = 3;
					 }
					 //check for 4 credit
					 if((p3<=74.5 && p3>=69 && grades.equals("A-"))||(p3<=69.5 && p3>=64 && grades.equals("B+"))||(p3<=64.5 && p3>=59 && grades.equals("B"))
							 ||(p3<=59.5 && p3>=54 && grades.equals("B-"))||(p3<=54.5 && p3>=49 && grades.equals("C+")))
					 {
						 credit = 4;
					 }
					 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
				 }
				 
				 else if(totalNumber>=300)
				 {
					 //check for 3 credit
					 
					// if((p3>=80 && grades.equals("A+"))||(p3<80 && p3>=75 && grades.equals("A")))
				//	 {
						 credit = 4;
					//}
					 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
					 //check for 4 credit
				 }
				 else
				 {
					 credit=3;
					 System.out.println(courseName+","+"Percent :"+percent+","+credit+",");
				 }
				 fileWriter.append(","+credit);
			 }
			fileWriter.append("\n");
			credit=0;
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
		System.out.println("Total Sessional Course :"+sessionalCourse +"Total theory course: "+num +" Total course: "+serial_num +" Sum: "+(sessionalCourse+num+non_credit));
	}

}
