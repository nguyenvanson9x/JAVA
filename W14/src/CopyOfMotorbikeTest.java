
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class CopyOfMotorbikeTest {
	private static Formatter output;

	public static void main(String[] args) throws IOException {
		ArrayList<Motorbike> moto = new ArrayList<Motorbike>();

		inputMotorbike(moto);
		System.out.print(search("SYM", moto).toString());
		printToFile(search("Honda", moto), "MotorbikesOutput.txt");
		printToFile(sort(moto), "sort.txt");
	}

	public static void inputMotorbike(ArrayList<Motorbike> motobikes)
			throws IOException {

		FileReader in = new FileReader("Motorbikes.txt");
		BufferedReader br  = new BufferedReader(in);
		String maso = null;
		while ((maso = br.readLine()) != null) {

			Motorbike motos = new Motorbike();
			motos.setMaso(maso);
			motos.setTen(br.readLine());
			motos.setHsx(br.readLine());
			motos.setSoluong(Integer.parseInt(br.readLine()));
			motos.setColor(br.readLine());
			motos.setGia(Double.parseDouble(br.readLine()));
			motos.setKhoiluong(Double.parseDouble(br.readLine()));
			motos.setNsx(br.readLine());
			motobikes.add(motos);
		}
		in.close();
	}

	public static ArrayList<Motorbike> search(String manu,
			ArrayList<Motorbike> motorbikes) throws IOException {

		int i;
		ArrayList<Motorbike> moto = new ArrayList<Motorbike>();
		for (i = 0; i < motorbikes.size(); i++) {
			if (motorbikes.get(i).getHsx().compareTo(manu) == 0) {
				moto.add(motorbikes.get(i));

			}
		}
		return moto;

	}

	public static void printToFile(ArrayList<Motorbike> motos, String path)
			throws IOException {

		int i;

		try {
			output = new Formatter(path);
			for (i = 0; i < motos.size(); i++) {
				output.format("%s%n", motos.get(i));

			}
		} catch (SecurityException securityException) {
			// System.err.println("You do not have write access to this file.");
			System.exit(1);
		} catch (FileNotFoundException filesNotFoundException) {
			// System.err.println("Error creating file.");
			System.exit(1);
		} finally {
			output.close();
		}
	}
	
	public static ArrayList<Motorbike> sort(ArrayList<Motorbike> motorbikes) {
		int i, j, n = motorbikes.size();
		Motorbike t;
		Motorbike temp = new Motorbike();
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				if (motorbikes.get(i).getHsx().compareTo(motorbikes.get(j).getHsx())<1) {
					
					
				}

			}
		}
		
		return motorbikes;
	}
	
}
