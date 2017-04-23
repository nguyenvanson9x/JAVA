package Prac;

import java.io.IOException;
import java.util.ArrayList;

public class StudentTest {
	private static Student[] stus2;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ArrayList<Student> stus = new ArrayList<Student>();
		FileProcess.inputFileByData(stus,"ImportStudent.txt");
		FileProcess.saveToObjectFile(stus, "OutPutObject.txt");
		
		int i;
		for (i = 0; i < stus.size(); i++) {
			System.out.println(stus.get(i));
		}
	
		stus2 = FileProcess.inputObject("OutPutObject.txt");
		
		for (i = 0; i < stus2.length; i++) {
			System.out.println(stus2[i].getName());
		}
	}
}
