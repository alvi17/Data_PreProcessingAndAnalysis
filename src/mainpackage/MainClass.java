package mainpackage;

import java.io.FileNotFoundException;

public class MainClass {

	public static void main(String[] args) {

//		PreprocessAttendance pra=new PreprocessAttendance();
//		pra.readCsv();
//		CheckLines ch=new CheckLines();

//		PreprocessAttendance pra=new PreprocessAttendance();
//		pra.readCsv();
//		
//		PrepateTrainigDataForCgpa cg=new PrepateTrainigDataForCgpa();
//		cg.create_training_Csv();
//		
//		PrepareTestData p=new PrepareTestData();
//		p.create_test_Csv();

//		FindInfoGain info=new FindInfoGain();
//		info.updateClassLabels();
//		System.out.println("InfoD = : "+info.calculateInfoD()+" InfomaleFemale : "+info.calculateInfoMale_Female()+" InfoCreditCompleted: "+info.calculateCreditCompleteInfo());

		Data_PreProcessing_CreditColumn dp=new Data_PreProcessing_CreditColumn();
		dp.create_Credit_Csv();
		
	}

}
