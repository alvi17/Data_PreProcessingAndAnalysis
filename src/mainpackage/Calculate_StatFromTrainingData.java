package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculate_StatFromTrainingData {

	String fileName="processedSheet2_withCgpa.csv";
	
	double eeemax=0;
	double eeemin=0;
	double eeeavg=0;
	
	double csemax=0;
	double csemin=0;
	double cseavg=0;
	
	double ipemax=0;
	double ipemin=0;
	double ipeavg=0;
	
	double memax=0;
	double memin=0;
	double meavg=0;
	
	double cemax=0;
	double cemin=0;
	double ceavg=0;
	
	double mmemax=0;
	double mmemin=0;
	double mmeavg=0;
	
	double chemax=0;
	double chemin=0;
	double cheavg=0;
	
	double namemax=0;
	double namemin=0;
	double nameavg=0;
	
	double wremax=0;
	double wremin=0;
	double wreavg=0;
	
	public Calculate_StatFromTrainingData()
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
	
		String s=fileReader.readLine();
		String[] parts=s.split(",");
	
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
			// fileWriter.append(line);
			
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

			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	//	System.out.println("Total Sessional Course :"+sessionalCourse +"Total theory course: "+num +" Total course: "+serial_num +" Sum: "+(sessionalCourse+num+non_credit));
	}

}
