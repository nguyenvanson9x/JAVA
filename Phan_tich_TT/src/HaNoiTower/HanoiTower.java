package HaNoiTower;

import java.util.Scanner;
import java.util.Stack;

public class HanoiTower {
	private static Stack<State> stack;
	private static Scanner scan;

	public static void main(String[] args) {
		stack = new Stack<State>();
		scan = new Scanner(System.in);

		String A, B, C;
		int N, m;

		System.out.print("Nhap M = ");
		m = scan.nextInt();

		State state = new State(m, "A", "B", "C");
		stack.push(state);

		while (!stack.isEmpty()) {
			state = stack.pop();
			A = state.a;
			B = state.b;
			C = state.c;
			if (state.n == 1) {
				System.out.println(A + " -> " + B);
			} else {
				N = state.n;

				State st1 = new State(N - 1, C, B, A);
				stack.push(st1);

				State st2 = new State(1, A, B, C);
				stack.push(st2);

				State st3 = new State(N - 1, A, C, B);
				stack.push(st3);
			}
		}
	}

	static class State {
		int n;
		String a, b, c;

		public State(int n, String a, String b, String c) {
			super();
			this.n = n;
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
