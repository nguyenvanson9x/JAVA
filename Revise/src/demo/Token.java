package demo;

import java.util.ArrayList;

public class Token {
	@Override
	public String toString() {
		return "Token [word=" + word + ",\t count=" + count + "]";
	}

	private String word;
	private int count;

	public Token(String in_word, int in_count) {
		word = in_word;
		count = in_count;
	}

	public static String[] Split(String a) {
		String[] s = null;
		s = a.split(" ");
		return s;
	}

	public static ArrayList<Token> initArray(String[] a) {
		ArrayList<Token> arl = new ArrayList<Token>();
		for (int i = 0; i < a.length; i++) {
			arl.add(new Token(a[i], 1));
		}
		return arl;
	}

	public static ArrayList<Token> ArrayListWithFreq(ArrayList<Token> tklist, ArrayList<Integer> flag) {
		ArrayList<Token> list = new ArrayList<>();
		int n = tklist.size();
		int i, j;
		for (i = 0; i < n; i++) {
			int count = 1;
			if (flag.get(i) == 1) {
				flag.set(i, 0);
				for (j = i + 1; j < n; j++) {
					if (tklist.get(j).word.equals(tklist.get(i).word)) {
						count++;

						flag.set(j, 0);
					}
				}
				list.add(new Token(tklist.get(i).word, count));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String a = "aa ss dd f aa ss dd as da as ds as ds aa sa da sd";
		String[] s = Split(a);
		ArrayList<Token> firstList = initArray(s);
		ArrayList<Integer> flag = new ArrayList<>();
		int n = firstList.size();
		for (int i = 0; i < n; i++) {
			flag.add(1);

		}
		for (Token t : firstList) {
			System.out.println(t.toString());
		}
		System.out.println("Ket qua:");
		ArrayList<Token> newList = ArrayListWithFreq(firstList, flag);
		for (Token t2 : newList) {
			System.out.println(t2.toString());
		}
	}
}
