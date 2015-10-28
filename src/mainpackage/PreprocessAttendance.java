package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class PreprocessAttendance {
	String fileName1="sheet1.csv";
	String fileName2="sheet2.csv";
	String fileName3="sheet3.csv";
	String fileName4="sheet4.csv";
	String fileName5="sheet5.csv";
	String fileName6="sheet6.csv";
	String fileName7="sheet7.csv";
	String fileName8="sheet8.csv";
	public void readCsv()
	{
		
		BufferedReader fileReader=null;
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName1));
			fileReader.readLine();
			//System.out.println("asd");
			while((line=fileReader.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader2=null;
		try{
			String line="";
			fileReader2 =new BufferedReader(new FileReader(fileName2));
			fileReader2.readLine();
			//System.out.println("asd");
			while((line=fileReader2.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader3=null;
		try{
			String line="";
			fileReader3 =new BufferedReader(new FileReader(fileName3));
			fileReader3.readLine();
			//System.out.println("asd");
			while((line=fileReader3.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader4=null;
		try{
			String line="";
			fileReader4 =new BufferedReader(new FileReader(fileName4));
			fileReader4.readLine();
			//System.out.println("asd");
			while((line=fileReader4.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader5=null;
		try{
			String line="";
			fileReader5 =new BufferedReader(new FileReader(fileName5));
			fileReader5.readLine();
			//System.out.println("asd");
			while((line=fileReader5.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader6=null;
		try{
			String line="";
			fileReader6 =new BufferedReader(new FileReader(fileName6));
			fileReader6.readLine();
			//System.out.println("asd");
			while((line=fileReader6.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader7=null;
		try{
			String line="";
			fileReader7 =new BufferedReader(new FileReader(fileName7));
			fileReader7.readLine();
			//System.out.println("asd");
			while((line=fileReader7.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
		BufferedReader fileReader8=null;
		try{
			String line="";
			fileReader8 =new BufferedReader(new FileReader(fileName8));
			fileReader8.readLine();
			//System.out.println("asd");
			while((line=fileReader8.readLine())!=null)
			{
				
				String[] token=line.split(",");
				if(token[11].equals(null)){
					
				}
			}
		}catch(Exception c){
			
		}
	}
}
