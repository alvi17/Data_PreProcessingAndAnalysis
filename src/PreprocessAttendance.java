import java.io.BufferedReader;
import java.io.FileReader;


public class PreprocessAttendance {
	String fileName="sheet1.csv";
	public void readCsv()
	{
		BufferedReader fileReader=null;
		try{
			String line="";
			fileReader =new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
			while((line=fileReader.readLine())!=null)
			{
				String[] token=line.split(",");
				System.out.println(token[0]);
			}
		}catch(Exception c){
			
		}
	}
}
