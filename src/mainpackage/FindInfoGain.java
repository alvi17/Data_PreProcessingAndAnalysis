package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;

public class FindInfoGain {
	double infoD;
	double infoMaleFemale;
	double infoCgpa;
	double infoTermComplete;
	
	int excellent,very_good,good,moderate,poor,very_poor,count,female,male;
	
	int excellent_female,very_good_female,good_female,moderate_female,poor_female,very_poor_female;
	int excellent_male,very_good_male,good_male,moderate_male,poor_male,very_poor_male;
	String fileName="training_data_for_male_female_cgpa.csv";
	
	int excellent_cg,very_good_cg,good_cg,moderate_cg,poor_cg,very_poor_cg;
	int excellent_tc,very_good_tc,good_tc,moderate_tc,poor_tc,very_poor_tc;
	int excellent_tnc,very_good_tnc,good_tnc,moderate_tnc,poor_tnc,very_poor_tnc;
	int term_complete,term_not_complete;
	
	public FindInfoGain()
	{
		excellent=0;
		very_good=0;
		good=0;
		poor=0;
		moderate=0;
		very_poor=0;
		count=0;
		female=0;
		male=0;
		excellent_female=0;
		very_good_female=0;
		good_female=0;
		moderate_female=0;
		poor_female=0;
		very_poor_female=0;
		excellent_male=0;
		very_good_male=0;
		good_male=0;
		moderate_male=0;
		poor_male=0;
		very_poor_male=0;
		term_complete=0;
		term_not_complete=0;
		excellent_tc=0;
		very_good_tc=0;
		good_tc=0;
		moderate_tc=0;
		poor_tc=0;
		very_poor_tc=0;
		excellent_tnc=0;
		very_good_tnc=0;
		good_tnc=0;
		moderate_tnc=0;
		poor_tnc=0;
		very_poor_tnc=0;
		
	}
	
	public void updateClassLabels()
	{
		BufferedReader fileReader = null;
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
			String[] tokens=null;
			while((line=fileReader.readLine())!=null)
			{
				tokens=line.split(",");
				String result_status=tokens[4];
				String male_female=tokens[1];
				int credit_complete=Integer.parseInt(tokens[3]);
				
				if(credit_complete>=158)
				{
					term_complete++;
				}
				else
				{
					term_not_complete++;
				}
				
				if(male_female.equals("M"))
				{
					male++;
				}
				else
				{
					female++;
				}
				
				if(result_status.equals("Excellent"))
				{
					if(male_female.equals("M"))
					{
						excellent_male++;
					}
					else if(male_female.equals("F"))
					{
						excellent_female++;
					}
					
					if(credit_complete>=158)
					{
						excellent_tc++;
					}
					excellent++;
				}
				else if(result_status.equals("VeryGood"))
				{
					if(male_female.equals("M"))
					{
						very_good_male++;
					}
					else if(male_female.equals("F"))
					{
						very_good_female++;
					}
					
					if(credit_complete>=158)
					{
						very_good_tc++;
					}
					very_good++;
				}
				else if(result_status.equals("Good"))
				{
					if(male_female.equals("M"))
					{
						good_male++;
					}
					else if(male_female.equals("F"))
					{
						good_female++;
					}
					if(credit_complete>=158)
					{
						good_tc++;
					}
					good++;
				}
				else if(result_status.equals("Moderate"))
				{
					if(male_female.equals("M"))
					{
						moderate_male++;
					}
					else if(male_female.equals("F"))
					{
						moderate_female++;
					}
					if(credit_complete>=158)
					{
						moderate_tc++;
					}
					else
					{
						moderate_tnc++;
					}
					
					moderate++;
				}
				else if(result_status.equals("Poor"))
				{
					if(male_female.equals("M"))
					{
						poor_male++;
					}
					else if(male_female.equals("F"))
					{
						poor_female++;
					}
					if(credit_complete>=158)
					{
						poor_tc++;
					}
					else
					{
						poor_tnc++;
					}
					poor++;
				}
				else if(result_status.equals("VeryPoor"))
				{
					if(male_female.equals("M"))
					{
						very_poor_male++;
					}
					else if(male_female.equals("F"))
					{
						very_poor_female++;
					}
					if(credit_complete>=158)
					{
						very_poor_tc++;
					}
					else
					{
						very_poor_tnc++;
					}
					very_poor++;
				}
				count++;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}
	
	public double calculateInfoD()
	{
		double e=(double)excellent/(double)count;
		double vg=(double)very_good/(double)count;
		double g=(double)good/(double)count;
		double m=(double)moderate/(double)count;
		double vp=(double)very_poor/(double)count;
		double p=(double)poor/(double)count;
		
		
		System.out.println("excellent = : "+excellent+"Very_good:"+very_good
			+"Good: "+good+" Moderate : "+moderate+" Very_poor: "+very_poor+" Poor: "+poor+" Count : "+count);
		
		infoD=(-e)* Math.log(e)+ (-vg)*Math.log(vg) + (-g)*Math.log(g)+(-m)*Math.log(m)+(-vp)*Math.log(vp)+(-p)*Math.log(p);
		
		return infoD;
	}
	
	public double calculateInfoMale_Female()
	{
		//male 
		double x=(double)male/(double)count;
		double e_m=(double)excellent_male/(double)male;
		double vg_m=(double)very_good_male/(double)male;
		double g_m=(double)good_male/(double)male;
		double m_m=(double)moderate_male/(double)male;
		double vp_m=(double)very_poor_male/(double)male;
		double p_m=(double)poor_male/(double)male;
		//female
		double y=(double)female/(double)count;
		double e_f=(double)excellent_female/(double)female;
		double vg_f=(double)very_good_female/(double)female;
		double g_f=(double)good_female/(double)female;
		double m_f=(double)moderate_female/(double)female;
		double vp_f=(double)very_poor_female/(double)female;
		double p_f=(double)poor_female/(double)female;
		
		infoMaleFemale=x*((-e_m)*Math.log(e_m)+(-vg_m)*Math.log(vg_m)+(-g_m)*Math.log(g_m)+(-m_m)*Math.log(m_m)+
				(-vp_m)*Math.log(vp_m)+(-p_m)*Math.log(p_m))+y*((-e_f)*Math.log(e_f)+(-vg_f)*Math.log(vg_f)+(-g_f)*Math.log(g_f)+(-m_f)*Math.log(m_f)+
						(-vp_f)*Math.log(vp_f)+(-p_f)*Math.log(p_f));
		
		return infoMaleFemale;
	}
	
	
	public double calculateInfoCgpa()
	{
		
		
		return infoCgpa;
	}
	
	
	public double calculateCreditCompleteInfo()
	{
		double x=(double)term_complete/(double)count;
		double e_tc=(double)excellent_tc/(double)term_complete;
		if(e_tc==0)
		{
			e_tc=1;
		}
		double vg_tc=(double)very_good_tc/(double)term_complete;
		if(vg_tc==0)
		{
			vg_tc=1;
		}
		double g_tc=(double)good_tc/(double)term_complete;
		if(g_tc==0)
		{
			g_tc=1;
		}
		double m_tc=(double)moderate_tc/(double)term_complete;
		if( m_tc==0)
		{
			 m_tc=1;
		}
		double p_tc=(double)poor_tc/(double)term_complete;
		if(p_tc==0)
		{
			p_tc=1;
		}
		double vp_tc=(double)very_poor_tc/(double)term_complete;
		if(vp_tc==0)
		{
			vp_tc=1;
		}
		
		double y=(double)term_not_complete/(double)count;
		double m_ntc=(double)moderate_tnc/(double)term_not_complete;
		if(m_ntc==0)
		{
			m_ntc=1;
		}
		double vp_ntc=(double)very_poor_tnc/(double)term_not_complete;
		if(vp_ntc==0)
		{
			vp_ntc=1;
		}
		
		infoTermComplete=x*((-e_tc) *Math.log(e_tc)+(-vg_tc)*Math.log(vg_tc)+(-g_tc)*Math.log(g_tc)+(-m_tc)*Math.log(m_tc)+(-p_tc)*Math.log(p_tc)+(-vp_tc)*Math.log(vp_tc))+
				y*((-m_ntc)*Math.log(m_ntc)+(-vp_ntc)*Math.log(vp_ntc));
		
		return infoTermComplete;
	}
	
	
	 public double logOfBase(int base, int num) {
		    return Math.log(num) / Math.log(base);
		}


}
