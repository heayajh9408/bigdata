package singleton.step1;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class AClass {
	private int intVar;
	private static AClass INSTANCE;

	public static AClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AClass();
		}
		return INSTANCE;
	}

	private AClass() {
	}

	public int getIntVar() {
		return intVar;
	}

	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
}