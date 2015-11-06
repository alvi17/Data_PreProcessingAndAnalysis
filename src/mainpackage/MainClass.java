package mainpackage;

public class MainClass {

	public static void main(String[] args) {
		PreprocessAttendance pra=new PreprocessAttendance();
		pra.readCsv();
		
		
		PrepateTrainigDataForCgpa cg=new PrepateTrainigDataForCgpa();
		cg.create_training_Csv();

	}

}
