package Prac;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileProcess {

	public static Student[] inputObject(String path)
			throws FileNotFoundException, IOException, ClassNotFoundException,
			NullPointerException,EOFException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		int i, n = ois.readInt();
		Student[] stu = new Student[n];
		for (i = 0; i < n; i++) {
			stu[i] = (Student) ois.readObject();
		}
		ois.close();

		return stu;
	}

	public static void inputFileByData(ArrayList<Student> stu, String path)
			throws IOException {

		String name, add, note;
		double point;

		FileReader fi = new FileReader(path);
		BufferedReader br = new BufferedReader(fi);
		String line = null;

		while ((line = br.readLine()) != null) {
			name = line;
			add = br.readLine();
			note = br.readLine();
			point = Double.parseDouble(br.readLine());
			Student stus = new Student(name, add, note, point);
			stu.add(stus);
		}
		br.close();

	}

	public static void saveToObjectFile(ArrayList<Student> stu, String path)
			throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				path));

		int i;
		oos.writeInt(stu.size());
		for (i = 0; i < stu.size(); i++) {
			oos.writeObject(stu.get(i));
		}
		oos.close();
	}

}
