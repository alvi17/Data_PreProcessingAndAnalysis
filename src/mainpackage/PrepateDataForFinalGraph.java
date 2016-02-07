package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrepateDataForFinalGraph {
	
	String fileName="processedSheet2_withCgpa.csv";
	FileWriter fileWriter = null;
	
	
	public PrepateDataForFinalGraph()
	{
		super();
	}
	
	
	public void processData()
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
		fileWriter = new FileWriter("processedSheetForGraph.csv");
		fileReader.readLine();
		
		while ((line = fileReader.readLine()) != null) {	
			String[] token = line.split(",");
			if(token[3].equals("1"))
			{
				String s="";
				if(Double.parseDouble(token[6])<=2)
				{
					s="2.124";
				}
				else if(Double.parseDouble(token[6])>4)
				{
					s="3.554343";
				}
				else
				{
					s=token[6];
				}
				fileWriter.append(s+"\n");
				
			}
		}
		
		
		
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
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
