package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class Calulate_Info_Cgpa {
	
	String fileName="training_data_for_male_female_cgpa.csv";
	public Calulate_Info_Cgpa()
	{
		super();
	}
	
	public void calculate()
	{
		BufferedReader fileReader = null;
		
		int num_Female=0;
		int num_Male=0;
		double male_cgpa=0;
		double female_cgpa=0;
		int female_80=0;
		int female_70=0;
		int female_50=0;
		int female_20=0;
		int female_2=0;
		int male_80=0;
		int male_70=0;
		int male_50=0;
		int male_20=0;
		int male_2=0;
		double cg=0;
		String gender="";
		try
		{
			String line = "";
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null){
				String[] token=line.split(",");
				gender=token[1];
				cg=Double.parseDouble(token[2]);
				if(gender.equals("M"))
				{
					if(cg>=3.8)
					{
						male_80++;
					}
					else if(cg>=3.7 && cg<3.8)
					{
						male_70++;
					}
					else if(cg>=3.5 && cg<3.7)
					{
						male_50++;
					}
					else if(cg<3.5 && cg>3.2)
					{
						male_20++;
					}
					else
					{
						male_2++;
					}
					male_cgpa+=cg;
					num_Male++;
				}
				else
				{
					if(cg>=3.8)
					{
						female_80++;
					}
					else if(cg>=3.7 && cg<3.8)
					{
						female_70++;
					}
					else if(cg>=3.5 && cg<3.7)
					{
						female_50++;
					}
					else if(cg<3.5 && cg>3.2)
					{
						female_20++;
					}
					else
					{
						female_2++;
					}
					female_cgpa+=cg;
					num_Female++;
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
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		double average_male=male_cgpa/num_Male;
		double average_female=female_cgpa/num_Female;
		
		System.out.println("Male : "+num_Male +" Male_cgpa:"+average_male);
		System.out.println("FeMale : "+num_Female +" Female_cgpa:"+average_female);
		
		System.out.println("Male 3.8 :"+(double)male_80/num_Male*100 +"\nMale 3.7: "+(double)male_70/num_Male*100+"\nMale 3.5: "+(double)male_50/num_Male*100 +"\nMale 3.2 : "+(double)male_20/num_Male*100+"\n Male <3.2: "+(double)male_2/num_Male*100);
		System.out.println("FeMale 3.8 :"+(double)female_80/num_Female*100 +"\nFeMale 3.7: "+(double)female_70/num_Female*100+"\nFeMale 3.5: "+(double)female_50/num_Female*100 +"\nFeMale 3.2 : "+(double)female_20/num_Female*100+"\nFeMale <3.2: "+(double)female_2/num_Female*100);
		
	}
	
}
