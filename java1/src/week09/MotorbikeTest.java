package week09;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorbikeTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Motorbike> motos = new ArrayList<Motorbike>();
		int n = scan.nextInt();
		scan.nextLine();
		inputMotorbikes(motos, n);
		outputMotorbike(motos);
		findHonda(motos);
	}

	private static void inputMotorbikes(ArrayList<Motorbike> motos, int n) {
		int i;
		for (i = 0; i < n; i++) {
			Motorbike moto = new Motorbike();
			moto.setTen(scan.nextLine());
			moto.setMaso(scan.nextLine());
			moto.setHsx(scan.nextLine());
			moto.setNsx(scan.nextLine());
			moto.setSoluong(scan.nextInt());
			moto.setGia(scan.nextDouble());
			moto.setKhoiluong(scan.nextDouble());
			scan.nextLine();
			motos.add(moto);
		}
	}

	private static void outputMotorbike(ArrayList<Motorbike> motos) {
		int i;
		for (i = 0; i < motos.size(); i++) {
			System.out.println(motos.get(i));
		}
	}

	private static void findHonda(ArrayList<Motorbike> motos) {
		int i;

		for (i = 0; i < motos.size(); i++) {
			if (motos.get(i).getHsx().compareTo("Honda") == 0) {
				System.out.println(motos.get(i));
			}

		}
	}
	
	private static void maxWeight(ArrayList<Motorbike> motos){
		int i;
		int n = motos.size();
		double max = motos.get(0).getKhoiluong();
		for (i = 0; i < n; i++){
			if (motos.get(i).getKhoiluong()>max)
				max = motos.get(i).getKhoiluong();
		}
		
	}
}
