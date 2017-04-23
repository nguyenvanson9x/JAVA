package NguyenVanSon_BT07;

public class ComplexNumber {
	double real, imaginary;

	public ComplexNumber(double thuc, double ao) {
		real = thuc;
		imaginary = ao;
	}

	public String toString() {
		if (imaginary == 0)
			return real + "";
		if (real == 0)
			return imaginary + "i";
		if (imaginary < 0)
			return real + " - " + (-imaginary) + "i";
		if (imaginary == 1)
			return real + " + i";
		if (imaginary == -1)
			return real + " - i";
		return real + " + " + imaginary + "i";

	}

	public ComplexNumber add(ComplexNumber other) {
		ComplexNumber a = this;
		double thuc = a.real + other.real;
		double ao = a.imaginary + other.imaginary;
		return new ComplexNumber(thuc, ao);
	}

	public ComplexNumber subtract(ComplexNumber other) {
		ComplexNumber a = this;
		double thuc = a.real - other.real;
		double ao = a.imaginary - other.imaginary;
		return new ComplexNumber(thuc, ao);
	}

	public ComplexNumber multiply(ComplexNumber other) {
		ComplexNumber a = this;
		double thuc = a.real * other.real - a.imaginary * other.imaginary;
		double ao = a.real * other.imaginary + a.imaginary * other.real;
		return new ComplexNumber(thuc, ao);
	}

	public ComplexNumber divide(ComplexNumber other) {
		ComplexNumber a = this;
		double m = a.real * other.real + a.imaginary * other.imaginary;
		double n = a.imaginary * other.real - a.real * other.imaginary;
		double t = other.real * other.real + other.imaginary * other.imaginary;
		double thuc = m / t;
		double ao = n / t;
		return new ComplexNumber(thuc, ao);
	}

	public ComplexNumber pow(double n) {
		ComplexNumber a = this;
		while (n != 1) {
			a = multiply(a);
			n--;
		}
		return a;
	}
}
