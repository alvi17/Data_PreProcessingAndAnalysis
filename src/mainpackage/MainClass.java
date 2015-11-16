package mainpackage;

import java.io.FileNotFoundException;

public class MainClass {

	public static void main(String[] args) {
		PreprocessAttendance pra=new PreprocessAttendance();
		pra.readCsv();
		CheckLines ch=new CheckLines();
		
	}

}
