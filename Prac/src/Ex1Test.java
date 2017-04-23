import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex1Test {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<EX1> acc = new ArrayList<EX1>();

		inputAcc(acc);
		//System.out.println(acc.toString());

		outputAcc(acc);
		ObjectOutput(acc);
		
		String path = "nhanvien.txt";
		ReadObject(path);
	}

	public static void inputAcc(ArrayList<EX1> acc) throws IOException {
		FileReader in = new FileReader("Account.txt");
		BufferedReader br = new BufferedReader(in);
		String line = null;

		while ((line = br.readLine()) != null) {
			EX1 addAcc = new EX1();
			addAcc.setTen(line);
			addAcc.setDiachi(br.readLine());
			addAcc.setTuoi(Integer.parseInt(br.readLine()));
			addAcc.setNam(Integer.parseInt(br.readLine()));
			acc.add(addAcc);
		}
	}

	public static void outputAcc(ArrayList<EX1> acc) throws IOException {

		FileWriter fw = new FileWriter("Output.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("Ten"+"\t\t"+"Year"+"\t"+"Address"+"\t\t"+"Tuoi");
		bw.newLine();
		int i;
		for (i = 0; i < acc.size(); i++) {
			bw.write(acc.get(i).getTen()+"\t"+acc.get(i).getNam()+"\t"+acc.get(i).getDiachi()+"\t\t"+acc.get(i).getTuoi());
			bw.newLine();
		}
		// bw.write("Son");
		bw.close();

	}

	public static void ObjectOutput(ArrayList<EX1> acc) {

		try {
			FileOutputStream fos = new FileOutputStream("nhanvien.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(acc);
			oos.close();
			fos.close();
		} catch (IOException er) {
			System.out.println();
		}
	}
	
	public static void ReadObject(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		ArrayList<EX1> input = new ArrayList<EX1>();
		input.add((EX1) ois.readObject());
		//System.out.println(input.get(0));
		ois.close();
	}
}
