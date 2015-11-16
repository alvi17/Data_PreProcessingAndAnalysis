package mainpackage;

import java.io.FileNotFoundException;

public class MainClass {

	public static void main(String[] args) {
<<<<<<< HEAD
		PreprocessAttendance pra=new PreprocessAttendance();
		pra.readCsv();
		CheckLines ch=new CheckLines();
=======
//		PreprocessAttendance pra=new PreprocessAttendance();
//		pra.readCsv();
//		
//		PrepateTrainigDataForCgpa cg=new PrepateTrainigDataForCgpa();
//		cg.create_training_Csv();
//		
//		PrepareTestData p=new PrepareTestData();
//		p.create_test_Csv();

		FindInfoGain info=new FindInfoGain();
		info.updateClassLabels();
		System.out.println("InfoD= : "+info.calculateInfoD()+" InfomaleFemale : "+info.calculateInfoMale_Female()+" InfoCreditCompleted: "+info.calculateCreditCompleteInfo());
>>>>>>> 52106de4c773365de1262b41fb521aa5ca021332
		
	}

}
