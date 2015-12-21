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

}
