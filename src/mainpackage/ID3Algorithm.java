package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class ID3Algorithm {
	String fileName="training_data_for_male_female_cgpa.csv";
	
	String male_female;
	double cgpa;
	int cr_completed;
	String result;
	int split_attribute;
	double gain_male_female,gain_credit_completed,gain_cgpa;
	public ID3Algorithm(String male_female,double cgpa,int creditcompelted,String result)
	{
		this.male_female=male_female;
		this.cgpa=cgpa;
		this.cr_completed=creditcompelted;
		this.result=result;
		split_attribute=0;
		gain_male_female=0;
		gain_credit_completed=0;
		gain_cgpa=0;
	}
	
	public String CreateDicisionTree()
	{
		BufferedReader fileReader = null;
		//cr_completed is chosen as split criteria
		if(split_attribute==2)
		{
			int root=this.cr_completed;
			try{
				String line = "";
				fileReader = new BufferedReader(new FileReader(fileName));
				fileReader.readLine();
				String[] tokens=null;
				while((line=fileReader.readLine())!=null)
				{
					tokens=line.split(",");
					int credit=Integer.parseInt(tokens[3]);
					double cg=Double.parseDouble(tokens[2]);
					String gender=tokens[1];
					String result=tokens[4];
					if(cr_completed>=158)
					{
						if(credit>=158)
						{
							if(gender.equals(male_female) && Math.abs(cg-cgpa)<=0.05)
							{
								return result;
							}
							
						}
						
					}
					else
					{
						if(credit<158)
						{
							if(gender.equals(male_female) && Math.abs(cg-cgpa)<=0.05)
							{
								return result;
							}
							
						}
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	public void calculateGain()
	{
		FindInfoGain fg=new FindInfoGain();
		gain_male_female=fg.calculateInfoD()-fg.calculateInfoMale_Female();
		gain_credit_completed=fg.calculateInfoD()-fg.calculateCreditCompleteInfo();
		
		if(gain_male_female>gain_credit_completed){
			split_attribute=1;
		}
		else
		{
			split_attribute=2;
		}
		
	}

}
