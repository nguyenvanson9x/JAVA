package linklist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		LinklistSymbolTable<String, Integer> list = read();
		for (String t : list.keys()) {
			System.out.println(t + "\t" + list.get(t));
		}

		System.out.println();
		local();
	}

	public static LinklistSymbolTable<String, Integer> read() {
		LinklistSymbolTable<String, Integer> list = new LinklistSymbolTable<>();
		try {
			Scanner scan = new Scanner(new File("output.txt"));
			while (scan.hasNext()) {
				String s = scan.next();
				if (list.contains(s)) {
					list.put(s, list.get(s) + 1);
				} else {
					list.put(s, 1);
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public static void local() {
		LinklistSymbolTable<String, ArrayList<Integer>> list = new LinklistSymbolTable<>();
		int count = 0;
		try {
			Scanner scan = new Scanner(new File("output.txt"));
			while (scan.hasNext()) {
				ArrayList<Integer> c = new ArrayList<>();
				c.add(count);
				String s = scan.next();
				if (list.contains(s)) {
					list.get(s).add(count);
				} else {
					list.put(s, c);
				}
				count++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
