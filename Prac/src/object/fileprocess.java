package object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class fileprocess {

	public static HocSinh[] loadFromFilebyObject(String filename)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		HocSinh[] hocsinh = null;

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				filename));
		int count = ois.readInt();
		hocsinh = new HocSinh[count];
		for (int i = 0; i < count; i++) {
			hocsinh[i] = (HocSinh) ois.readObject();
		}
		ois.close();
		return hocsinh;
	}

	public void saveToFilebyObject(HocSinh[] hocsinh, String filename) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(filename));
			oos.writeInt(hocsinh.length);
			for (int i = 0; i < hocsinh.length; i++) {
				oos.writeObject(hocsinh[i]);
			}
			oos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<HocSinh> loadFromFile(String filename) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		int count = ois.readInt();
		ArrayList<HocSinh> temp = new ArrayList<HocSinh>();
		for (int i = 0; i < count; i++) {
			temp.add((HocSinh) ois.readObject()); 
		}
		
		ois.close();
		
		return temp;
		
	}
	
	
	
	
}
