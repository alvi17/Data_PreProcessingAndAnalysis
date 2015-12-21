package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindInfoGain {
	
	String fileName="training_data.csv";
	
	double infoD;
	double infoMaleFemale;
	double infoCgpa;
	double infoTermComplete;
	
	int excellent,very_good,good,moderate,poor,very_poor,count,female,male;
	
	int excellent_female,very_good_female,good_female,moderate_female,poor_female,very_poor_female;
	int excellent_male,very_good_male,good_male,moderate_male,poor_male,very_poor_male;

	
	int excellent_cg,very_good_cg,good_cg,moderate_cg,poor_cg,very_poor_cg;
	int excellent_tc,very_good_tc,good_tc,moderate_tc,poor_tc,very_poor_tc;
	int excellent_tnc,very_good_tnc,good_tnc,moderate_tnc,poor_tnc,very_poor_tnc;
	int term_complete,term_not_complete;
	
	
	
	int cgpa_80=0,cgpa_30=0,cgpa_50=0,cgpa_60=0,cgpa_70=0,cgpa_20=0,cgpa_00=0,cgpa_10=0;
	int cgpa_30_excellent=0,cgpa_80_excellen=0,cgpa_50_excellent=0,
			cgpa_60_excellent=0,cgpa_70_excellent=0,cgpa_10_excellent=0,
			cgpa_00_excellent=0,cgpa20_excellent=0;
	int cgpa_30_verygood=0,cgpa_80_verygood=0,cgpa_50_verygood=0,
			cgpa_60_verygood=0,cgpa_70_verygood=0,cgpa_10_verygood=0,
			cgpa_00_verygood=0,cgpa20_verygood=0;
	int cgpa_30_good=0,cgpa_80_good=0,cgpa_50_good=0,
			cgpa_60_good=0,cgpa_70_good=0,cgpa_10_good=0,cgpa_00_good=0,cgpa20_good=0;
	int cgpa_30_moderate=0,cgpa_80_moderate=0,cgpa_50_moderate=0,cgpa_60_moderate=0,
			cgpa_70_moderate=0,cgpa_10_moderate=0,cgpa_00_moderate=0,cgpa20_moderate=0;
	int cgpa_30_verypoor=0,cgpa_80_verypoor=0,cgpa_50_verypoor=0,
			cgpa_60_verypoor=0,cgpa_70_verypoor=0,cgpa_10_verypoor=0,
			cgpa_00_verypoor=0,cgpa20_verypoor=0;
	int cgpa_30_poor=0,cgpa_80_poor=0,cgpa_50_poor=0,cgpa_60_poor=0,cgpa_70_poor=0,
			cgpa_10_poor=0,cgpa_00_poor=0,cgpa20_poor=0;
	
	
	
	int[] eee;
	int[] cse;
	int[] ipe,me,mme,name,wre,ce,urp,arch,che;
	
 	
	int dept_eee=0,dept_cse=0,dept_ipe=0,dept_me=0,dept_mme=0,dept_wre=0,dept_ce=0,
			dept_urp=0,dept_arch=0,dept_che=0,dept_name=0;
	
	ArrayList<Integer> att_list=new ArrayList<Integer>();
	
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
		
		eee=new int[6];
		cse=new int[6];
		ipe=new int[6];
		me=new int[6];
		mme=new int[6];
		name=new int[6];
		wre=new int[6];
		ce=new int[6];
		urp=new int[6];
		arch=new int[6];
		che=new int[6];
		
		for(int i=0;i<eee.length;i++)
		{
			eee[i]=1;
			cse[i]=1;
			ipe[i]=1;
			me[i]=1;
			mme[i]=1;
			name[i]=1;
			wre[i]=1;
			ce[i]=1;
			urp[i]=1;
			arch[i]=1;
			che[i]=1;
			att_list.add(i);
		}
				
	}

	public void calculteInfoD()
	{
		
		BufferedReader fileReader = null;		
		List id=new ArrayList();
		List attendance=new ArrayList();
		List totalCredit=new ArrayList();
		List completedCredit=new ArrayList();
		List cgpaList=new ArrayList();
		try 
		{
		String line = "";
		fileReader = new BufferedReader(new FileReader(fileName));

		fileReader.readLine();

		int i=1;
		int serial=100;
		int prev_serial=0;
		String[] tokens=null;
	//	String result_status="";
		while ((line = fileReader.readLine()) != null) {
			 String[] token = line.split(",");
			 String c_complete,result_status,t_status;
		}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
			fileReader.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			 
	}
	
	public double getInfoD()
	{
		
		double infod= -(double)(17.0/100.0)*logOfBase(2, (17.0/100.0))
				-(double)(34.0/100.0)*logOfBase(2, (34.0/100.0))
				-(double)(27.0/100.0)*logOfBase(2, (27.0/100.0))
				-(double)(11.0/100.0)*logOfBase(2, (11.0/100.0))
				-(double)(9.0/100.0)*logOfBase(2, (9.0/100.0))
				-(double)(2.0/100.0)*logOfBase(2, (2.0/100.0));
		
		return infod;
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
				String result_status=tokens[8];
				int male_female=Integer.parseInt(tokens[3]);
				int credit_complete=Integer.parseInt(tokens[7]);
				int dept=Integer.parseInt(tokens[1]);
				double cgpa=Double.parseDouble(tokens[6]);
				
				if(dept==1)
				{
					dept_eee++;
				}
				else if(dept==2)
				{
					dept_cse++;
				}
				else if(dept==3)
				{
					dept_ipe++;
				}
				else if(dept==4)
				{
					dept_me++;
				}
				else if(dept==5)
				{
					dept_ce++;
				}
				else if(dept==6)
				{
					dept_mme++;
				}
				else if(dept==7)
				{
					dept_che++;
				}
				else if(dept==8)
				{
					dept_name++;
				}
				else if(dept==9)
				{
					dept_urp++;
				}
				else if(dept==10)
				{
					dept_arch++;
				}
				else if(dept==11)
				{
					dept_wre++;
				}
				
								
				if(cgpa>=3.5)
				{
					cgpa_50++;
				}
				else
				{
					cgpa_00++;
				}
				
				if(credit_complete>=158)
				{
					term_complete++;
				}
				else
				{
					term_not_complete++;
				}
				
				if(male_female==1)
				{
					male++;
				}
				else
				{
					female++;
				}
				
				if(result_status.equals("Excellent"))
				{
					if(male_female==1)
					{
						excellent_male++;
					}
					else if(male_female==0)
					{
						excellent_female++;
					}
					
					if(credit_complete>=158)
					{
						excellent_tc++;
					}
					else
					{
						excellent_tnc++;
					}
					
					if(cgpa>=3.5)
					{
						cgpa_50_excellent++;
					}
					
					if(dept==1)
					{
						eee[0]++;
					}
					else if(dept==2)
					{
						cse[0]++;
					}
					else if(dept==3)
					{
						ipe[0]++;
					}
					else if(dept==4)
					{
						me[0]++;
					}
					else if(dept==5)
					{
						ce[0]++;
					}
					else if(dept==6)
					{
						mme[0]++;
					}
					else if(dept==8)
					{
						name[0]++;
					}
					else if(dept==9)
					{
						urp[0]++;
					}
					else if(dept==7)
					{
						che[0]++;
					}
					else if(dept==10)
					{
						arch[0]++;
					}
					else if(dept==11)
					{
						wre[0]++;
					}
					
					excellent++;
				}
				else if(result_status.equals("Very Good"))
				{
					if(male_female==1)
					{
						very_good_male++;
					}
					else if(male_female==0)
					{
						very_good_female++;
					}
					
					if(credit_complete>=158)
					{
						very_good_tc++;
					}
					else
					{
						very_good_tnc++;
					}
					if(cgpa>=3.5)
					{
						cgpa_50_verygood++;
					}
					
					if(dept==1)
					{
						eee[1]++;
					}
					else if(dept==2)
					{
						cse[1]++;
					}
					else if(dept==3)
					{
						ipe[1]++;
					}
					else if(dept==4)
					{
						me[1]++;
					}
					else if(dept==5)
					{
						ce[1]++;
					}
					else if(dept==6)
					{
						mme[1]++;
					}
					else if(dept==8)
					{
						name[1]++;
					}
					else if(dept==9)
					{
						urp[1]++;
					}
					else if(dept==7)
					{
						che[1]++;
					}
					else if(dept==10)
					{
						arch[1]++;
					}
					else if(dept==11)
					{
						wre[1]++;
					}
				
					very_good++;
				}
				else if(result_status.equals("Good"))
				{
					if(male_female==1)
					{
						good_male++;
					}
					else if(male_female==0)
					{
						good_female++;
					}
					if(credit_complete>=158)
					{
						good_tc++;
					}
					else
					{
						good_tnc++;
					}
					if(cgpa>=3.50)
					{
						cgpa_50_good++;
					}
					else
					{
						cgpa_00_good++;
					}
					
					if(dept==1)
					{
						eee[2]++;
					}
					else if(dept==2)
					{
						cse[2]++;
					}
					else if(dept==3)
					{
						ipe[2]++;
					}
					else if(dept==4)
					{
						me[2]++;
					}
					else if(dept==5)
					{
						ce[2]++;
					}
					else if(dept==6)
					{
						mme[2]++;
					}
					else if(dept==8)
					{
						name[2]++;
					}
					else if(dept==9)
					{
						urp[2]++;
					}
					else if(dept==7)
					{
						che[2]++;
					}
					else if(dept==10)
					{
						arch[2]++;
					}
					else if(dept==11)
					{
						wre[2]++;
					}
					
					
					good++;
				}
				else if(result_status.equals("Moderate"))
				{
					if(male_female==1)
					{
						moderate_male++;
					}
					else if(male_female==0)
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
					if(cgpa>=3.50)
					{
						cgpa_50_moderate++;
					}
					else
					{
						cgpa_00_moderate++;
					}
					
					if(dept==1)
					{
						eee[3]++;
					}
					else if(dept==2)
					{
						cse[3]++;
					}
					else if(dept==3)
					{
						ipe[3]++;
					}
					else if(dept==4)
					{
						me[3]++;
					}
					else if(dept==5)
					{
						ce[3]++;
					}
					else if(dept==6)
					{
						mme[3]++;
					}
					else if(dept==8)
					{
						name[3]++;
					}
					else if(dept==9)
					{
						urp[3]++;
					}
					else if(dept==7)
					{
						che[3]++;
					}
					else if(dept==10)
					{
						arch[3]++;
					}
					else if(dept==11)
					{
						wre[3]++;
					}
					moderate++;
				}
				else if(result_status.equals("Poor"))
				{
					if(male_female==1)
					{
						poor_male++;
					}
					else if(male_female==0)
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
					
					if(cgpa>=3.50)
					{
						cgpa_50_poor++;
					}
					else
					{
						cgpa_00_poor++;
					}
					
					if(dept==1)
					{
						eee[4]++;
					}
					else if(dept==2)
					{
						cse[4]++;
					}
					else if(dept==3)
					{
						ipe[4]++;
					}
					else if(dept==4)
					{
						me[4]++;
					}
					else if(dept==5)
					{
						ce[4]++;
					}
					else if(dept==6)
					{
						mme[4]++;
					}
					else if(dept==8)
					{
						name[4]++;
					}
					else if(dept==9)
					{
						urp[4]++;
					}
					else if(dept==7)
					{
						che[4]++;
					}
					else if(dept==10)
					{
						arch[4]++;
					}
					else if(dept==11)
					{
						wre[4]++;
					}
					poor++;
				}
				else if(result_status.equals("Very Poor"))
				{
					if(male_female==1)
					{
						very_poor_male++;
					}
					else if(male_female==0)
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
					if(cgpa>=3.50)
					{
						cgpa_50_verypoor++;
					}
					else
					{
						cgpa_00_verypoor++;
					}
					
					if(dept==1)
					{
						eee[5]++;
					}
					else if(dept==2)
					{
						cse[5]++;
					}
					else if(dept==3)
					{
						ipe[5]++;
					}
					else if(dept==4)
					{
						me[5]++;
					}
					else if(dept==5)
					{
						ce[5]++;
					}
					else if(dept==6)
					{
						mme[5]++;
					}
					else if(dept==8)
					{
						name[5]++;
					}
					else if(dept==9)
					{
						urp[5]++;
					}
					else if(dept==7)
					{
						che[5]++;
					}
					else if(dept==10)
					{
						arch[5]++;
					}
					else if(dept==11)
					{
						wre[5]++;
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
	
	public double calculateDeptInfo()
	{
		double eeeinfo=0;
		double cseinfo=0;
		double ipeinfo=0,nameinfo=0,meinfo=0,ceinfo=0,wreinfo=0,cheinfo=0,mmeinfo=0,archinfo=0,urpinfo=0;
		
		
		for(int i=0;i<eee.length;i++)
		{
			eeeinfo+=( (double)(-eee[i]/dept_eee)*(Math.log((double)(eee[i]/dept_eee))/Math.log(2)));
			cseinfo+=((double)(-cse[i]/dept_cse)*Math.log((double)(cse[i]/dept_cse))/Math.log(2));
			ipeinfo+=((double)(-ipe[i]/dept_ipe)*Math.log((double)(ipe[i]/dept_ipe))/Math.log(2));
			nameinfo+=((double)(-name[i]/dept_name)*Math.log((double)(name[i]/dept_name))/Math.log(2));
			meinfo+=((double)(-me[i]/dept_me)*Math.log((double)(me[i]/dept_me))/Math.log(2));
			ceinfo+=((double)(-ce[i]/dept_ce)*Math.log((double)(ce[i]/dept_ce))/Math.log(2));
			wreinfo+=((double)(-wre[i]/dept_wre)*Math.log((double)(wre[i]/dept_wre))/Math.log(2));
			cheinfo+=((double)(-che[i]/dept_che)*Math.log((double)(che[i]/dept_che))/Math.log(2));
			urpinfo+=((double)(-urp[i]/dept_urp)*Math.log((double)(urp[i]/dept_urp))/Math.log(2));
			archinfo+=((double)(-arch[i]/dept_arch)*Math.log((double)(arch[i]/dept_arch))/Math.log(2));
			mmeinfo+=((double)(-mme[i]/dept_mme)*Math.log((double)(mme[i]/dept_mme))/Math.log(2));
			
		}
		System.out.println("EEE info"+eeeinfo+ " "+dept_cse+" "+cse[0]+cse[1]+cse[2]+cse[3]+cse[4]+cse[5]);
		double infoDept=(double)(dept_eee/count)*eeeinfo+
				(double)(dept_cse/count)*cseinfo+
				(double)(dept_ipe/count)*ipeinfo+(double)(dept_name/count)*nameinfo+
				(double)(dept_me/count)*meinfo+(double)(dept_ce/count)*ceinfo+
				(double)(dept_wre/count)*wreinfo+(double)(dept_che/count)*cheinfo+
				(double)(dept_urp/count)*urpinfo+(double)(dept_arch/count)*archinfo+
				(double)(dept_mme/count)*mmeinfo;
		
		
		return infoDept;
	}
	

	public double calculateCgpaInfo()
	{
		double cg50=(double)cgpa_50/(double)count;
		double cg00=(double)cgpa_00/(double)count;
		System.out.println("Cg50"+cg50+" Cg00 "+cg00);
		double cg50_excellent=(double)cgpa_50_excellent/cgpa_50;
		double cg50_verygood=(double)cgpa_50_verygood/cgpa_50;
		double cg50_good=(double)cgpa_50_good/cgpa_50;
		double cg50_moderate=(double)cgpa_50_moderate/cgpa_50;
		double cg50_poor=(double)cgpa_50_poor/cgpa_50;
		
		double cg00_excellent=(double)cgpa_00_excellent/cgpa_00;
		double cg00_verygood=(double)cgpa_00_verygood/cgpa_00;
		double cg00_good=(double)cgpa_00_good/cgpa_00;
		double cg00_poor=(double)cgpa_00_poor/cgpa_00;
		double cg00_moderate=(double)cgpa_00_moderate/cgpa_00;
		double cg00_verypoor=(double)cgpa_00_verypoor/cgpa_00;
		
		if(cg50_poor==0)
		{
			cg50_poor=1;
		}
		if(cg00_excellent==0)
		{
			cg00_excellent=1;
		}
		
		
		double infoCgpa= cg50*((-cg50_excellent)*Math.log(cg50_excellent)/Math.log(2)+
				(-cg50_verygood)*Math.log(cg50_verygood)/Math.log(2)+
				(-cg50_good)*Math.log(cg50_good)/Math.log(2)+
				(-cg50_moderate)*Math.log(cg50_moderate)/Math.log(2)+
				(-cg50_poor)*Math.log(cg50_poor)/Math.log(2))+
				 cg00*((-cg00_moderate)*Math.log(cg00_moderate)/Math.log(2)+
				(-cg00_poor)*Math.log(cg00_poor)/Math.log(2)+(-cg00_verypoor)*Math.log(cg00_verypoor)/Math.log(2));
		
		return infoCgpa;
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
		
		infoD=(-e)* Math.log(e)/Math.log(2)+ (-vg)*Math.log(vg)/Math.log(2) 
				+ (-g)*Math.log(g)/Math.log(2)+
				(-m)*Math.log(m)/Math.log(2)+(-vp)*Math.log(vp)/Math.log(2)
				+(-p)*Math.log(p)/Math.log(2);
		
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
		
		infoMaleFemale=x*((-e_m)*Math.log(e_m)/Math.log(2)+(-vg_m)*Math.log(vg_m)/Math.log(2)
				+(-g_m)*Math.log(g_m)/Math.log(2)+(-m_m)*Math.log(m_m)/Math.log(2)+
				(-vp_m)*Math.log(vp_m)/Math.log(2)+(-p_m)*Math.log(p_m)/Math.log(2))
				+y*((-e_f)*Math.log(e_f)/Math.log(2)+(-vg_f)*Math.log(vg_f)/Math.log(2)
						+(-g_f)*Math.log(g_f)/Math.log(2)+(-m_f)*Math.log(m_f)/Math.log(2)+
						(-vp_f)*Math.log(vp_f)/Math.log(2)+(-p_f)*Math.log(p_f)/Math.log(2));
		
		return infoMaleFemale;
	}
	
	

	
	public double calculateCreditCompleteInfo()
	{
		double x=(double)term_complete/(double)count;
		double e_tc=(double)excellent_tc/(double)term_complete;
		if(e_tc==0)
		{
			//e_tc=1;
		}
		double vg_tc=(double)very_good_tc/(double)term_complete;
		if(vg_tc==0)
		{
			//vg_tc=1;
		}
		double g_tc=(double)good_tc/(double)term_complete;
		if(g_tc==0)
		{
			//g_tc=1;
		}
		double m_tc=(double)moderate_tc/(double)term_complete;
		if( m_tc==0)
		{
			// m_tc=1;
		}
		double p_tc=(double)poor_tc/(double)term_complete;
		if(p_tc==0)
		{
			//p_tc=1;
		}
		double vp_tc=(double)very_poor_tc/(double)term_complete;
		if(vp_tc==0)
		{
			//vp_tc=1;
		}
		
		double y=(double)term_not_complete/(double)count;
		double m_ntc=(double)moderate_tnc/(double)term_not_complete;
		if(m_ntc==0)
		{
		//	m_ntc=1;
		}
		double vp_ntc=(double)very_poor_tnc/(double)term_not_complete;
		if(vp_ntc==0)
		{
		//	vp_ntc=1;
		}
		
		infoTermComplete=x*((-e_tc) *Math.log(e_tc)/Math.log(2)+(-vg_tc)*Math.log(vg_tc)/Math.log(2)
				+(-g_tc)*Math.log(g_tc)/Math.log(2)+(-m_tc)*Math.log(m_tc)/Math.log(2)
				+(-p_tc)*Math.log(p_tc)/Math.log(2)
				+(-vp_tc)*Math.log(vp_tc))/Math.log(2)+
				y*((-m_ntc)*Math.log(m_ntc)/Math.log(2)+(-vp_ntc)*Math.log(vp_ntc)/Math.log(2));
		
		return infoTermComplete;
	}	
	ArrayList<Double> sortedList=new ArrayList<Double>();
	public void getArrtibute()
	{
		
		double gainCgpa=getInfoD()-1.86;
		sortedList.add(gainCgpa);
		double gainMaleFemale=getInfoD()-calculateInfoMale_Female();
		sortedList.add(gainMaleFemale);
		double gainDept=getInfoD()-calculateDeptInfo();
		sortedList.add(gainDept);
		double gainComplete=getInfoD()-calculateCreditCompleteInfo();
		sortedList.add(gainComplete);	
		
	}

	public int getSelectedAttribute()
	{
		double max=-999999;
		int selected_id=-1;
		double gain_cgpa=calculateInfoD()-calculateCgpaInfo();
		if(gain_cgpa>max && sortedList.contains(gain_cgpa))
		{
			max=gain_cgpa;
			selected_id=1;
			sortedList.remove(gain_cgpa);
		}
		
		double gain_malefemale=calculateInfoD()-calculateInfoMale_Female();
		if(max<gain_malefemale && sortedList.contains(gain_malefemale))
		{
			max=gain_malefemale;
			selected_id=2;
			sortedList.remove(gain_malefemale);
		}
		double gainDept=getInfoD()-calculateDeptInfo();
		
		if(gainDept>max && sortedList.contains(gainDept))
		{
			max=gainDept;
			selected_id=3;
			sortedList.remove(gainDept);
		}
		
		double gainComplete=getInfoD()-calculateCreditCompleteInfo();
		
		if(gainComplete>max && sortedList.contains(gainComplete))
		{
			max=gainComplete;
			selected_id=4;
			sortedList.remove(gainComplete);
		}
		
		return selected_id;
	}
	
	
	 public double logOfBase(int base, double num) {
		    return Math.log(num) / Math.log(base);
		}


}
