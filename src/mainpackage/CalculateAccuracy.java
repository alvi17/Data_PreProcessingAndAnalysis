package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CalculateAccuracy {
	
	String fileName="processedSheet2_Updated_Status.csv";
	String fileName1="FinalResultFromsheet2.csv";
	
	public CalculateAccuracy()
	{
		
	}
	
	public double getAccuracy()
	{
		BufferedReader fileReader = null;
		BufferedReader fileReader1 = null;
		
		int i=0;
		int match=0;
		try{
			String line = "";
			String line1="";
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
			fileReader1 = new BufferedReader(new FileReader(fileName1));
			fileReader1.readLine();
			String[] tokens=null;
			String[] tokens1=null;
			while ((line = fileReader.readLine()) != null && (line1 = fileReader1.readLine()) != null) {					
				tokens=line.split(",");
				tokens1=line1.split(",");
				
				i++;
				if(i==100)
				{
//					break;
				}
				if(tokens[8].equals(tokens1[8]))
				{
					match++;
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
				fileReader1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		double accuracy=((double)match/(double)i)*100;
		return accuracy;
	}

}
