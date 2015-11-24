package mainpackage;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PreprocessAttendance {
	
	String fileName1="sheet1.csv";
	String fileName2="sheet2.csv";
	String fileName3="sheet3.csv";
	String fileName4="sheet4.csv";
	String fileName5="sheet5.csv";
	String fileName6="sheet6.csv";
	String fileName7="sheet7.csv";
	String fileName8="sheet8.csv";
	
	String proFileName1="processed_sheet1.csv";
	String proFileName2="processed_sheet2.csv";
	String proFileName3="processed_sheet3.csv";
	String proFileName4="processed_sheet4.csv";
	String proFileName5="processed_sheet5.csv";
	String proFileName6="processed_sheet6.csv";
	String proFileName7="processed_sheet7.csv";
	String proFileName8="processed_sheet8.csv";
	
	//FileWriter fileWriter = null;
	public void readCsv()
	{
		BufferedReader fileReader=null;
		FileWriter fileWriter = null;
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName1));
			
			fileWriter = new FileWriter(proFileName1);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName1));
					line=fileReader.readLine();
					///String[] party=line.split(",");
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();				
				if(count!=0){
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName1));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		//sheet2 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName2));
			
			fileWriter = new FileWriter(proFileName2);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName2));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName2));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		//sheet 3 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName3));
			
			fileWriter = new FileWriter(proFileName3);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName3));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName3));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}
		catch(Exception c){
		}
		/*
		//sheet 4 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName4));
			
			fileWriter = new FileWriter(proFileName4);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName4));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName4));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		
		//sheet 5 process
		
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName5));
			
			fileWriter = new FileWriter(proFileName5);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName5));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName5));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		
		//sheet 6 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName6));
			
			fileWriter = new FileWriter(proFileName6);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName6));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName6));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		
		///sheet 7 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName7));
			
			fileWriter = new FileWriter(proFileName7);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName7));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName7));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}
		//sheet 8 process
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName8));
			
			fileWriter = new FileWriter(proFileName8);
			
			
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int[] rejected = new int[100];
			int indexReject=0;
			int indRejStart=0;
			//System.out.println(parts.length);
			int flag=0;
			for(int i=0;i<parts.length;i++){
				//System.out.println(parts[i]);
				
				int count=0;
				if(flag==0){
					flag++;
				}else{
					//BufferedReader fileReader=null;
					fileReader =new BufferedReader(new FileReader(fileName8));
					line=fileReader.readLine();
					///String[] party=line.split(",");
					
				}
				
				while((line=fileReader.readLine())!=null){
					
					String[] token1=line.split(",");
					if(!token1[i].equals("")){
						count++;
						break;
					}
				}
				fileReader.close();
				
				if(count!=0){
					
					
					fileWriter.append(parts[i]);
					if((parts.length-1)!=i){
						
						fileWriter.append(",");
					}
				}
				else{
					
					rejected[indexReject]=i;
					indexReject++;
				}
			}
			
			fileReader =new BufferedReader(new FileReader(fileName8));
			line=fileReader.readLine();
			int no=0;
			int lineno=0;
			while((line=fileReader.readLine())!=null)
			{
				no++;
				int lastElemCheck=0;
				indRejStart=0;
				fileWriter.append("\n");
				String[] token=line.split(",");
				if(token.length!=parts.length){
					lastElemCheck++;
				}
				lineno++;
				
				for(int i=0;i<token.length;i++){
					
					int flagReject=0;
					for(int j=indRejStart;j<indexReject;j++){
						if(rejected[j]==i){
							flagReject++;
							indRejStart++;
							continue;
						}
					}
					if(flagReject>0){
						continue;
					}
					if(parts[i].equals("CLASSATTENDENCEMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CLASSATTENDENCEMARKS") && token[i].equals("")){
						fileWriter.append("INF");
					}else if(parts[i].equals("LETTERGRADE") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("LETTERGRADE") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CLASSTESTMARKS") && !token[i].equals("")){
						
						fileWriter.append(token[i]);
						
					}else if(parts[i].equals("CLASSTESTMARKS") && token[i].equals("")){
						
						fileWriter.append("INF");
					}else if(parts[i].equals("PARTAMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTAMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("PARTBMARKS") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("PARTBMARKS") && token[i].equals("")){
						fileWriter.append("NA");
					}else if(parts[i].equals("TOTALNUMBER") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("TOTALNUMBER") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CRHREARNED") && lastElemCheck==0){
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(parts[i].equals("GPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("GPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("CGPA") && !token[i].equals("")){
						fileWriter.append(token[i]);
					}else if(parts[i].equals("CGPA") && token[i].equals("")){
						fileWriter.append("NR");
					}else if(parts[i].equals("TOTCRHRCOMPLETED") && lastElemCheck==0){
						//System.out.println(token[i]);
						fileWriter.append(token[i]);
						//System.out.println(parts[i]);
					}else if(lastElemCheck!=0 && i==token.length-1){
						fileWriter.append(token[i]);
						//System.out.println(token[i]);
						fileWriter.append(",NR,NR");
						//System.out.println(no);
					}else{
						fileWriter.append(token[i]);
					}
					if((token.length-1)!=i){
						fileWriter.append(",");
					}
				}
			}
			fileWriter.close();
			fileReader.close();
		}catch(Exception c){
		}*/
		
		
	}
}
