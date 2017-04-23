package w10;

public class sv_uutien extends Student {
	private double type;
	private static final double TYPE1 = 0.15;
	private static final double TYPE2 = 0.25;
	private static final double TYPE3 = 0.35;

	public sv_uutien() {
		super();
	}

	public double getType() {
		return type;
	}

	public void setType(double type) {
		this.type = type;
	}

	public double getFee() {
		if (type ==1)
			return super.getFee() * TYPE1;
		if (type == 2)
			return super.getFee() * TYPE2;
		if (type == 3)
			return super.getFee() * TYPE3;
		return super.getFee();
	}
}
