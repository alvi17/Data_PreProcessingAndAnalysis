package mainpackage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CheckLines {
	String file="processed_sheet2.csv";
	public void read() throws FileNotFoundException{
		BufferedReader fileReader=null;
		
		try {
			String line="";
			fileReader =new BufferedReader(new FileReader(file));
			line=fileReader.readLine();
			String[] parts=line.split(",");
			int lineno=0;
			while((line=fileReader.readLine())!=null){
				parts=line.split(",");
				if(parts[6].equals(""))
				{
					lineno++;
					System.out.println(lineno);
					
				}
				//lineno++;
				//System.out.println(lineno);
				if(parts.length!=20){
					//System.out.println(lineno);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
