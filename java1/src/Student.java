public class Student {
	int id;
	String name;
	int numCredits = 0;
	float averageScore = 0;

	Student() {

	}

	Student(int studentId, String studentName) {
		id = studentId;
		name = studentName;
	}

	void addScore(int credits, float score) {

		float newScore = (averageScore * numCredits + score * credits)
				/ (numCredits + credits);
		averageScore = newScore;
		numCredits += credits;
	}

	String printString() {
		return name + "\t" + numCredits + "\t" + averageScore;
	}

	void sing() {
		System.out.println(name + " sings");
	}

	static void sing(Student aStd) {
		System.out.println(aStd.name + " sings");
	}

	static void doSomething(int x, int[] ys, Student s) {
		x = 99;
		ys[0] = 99;
		s.name = "Minh";
	}
}
