package singleton.step1;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println("�ʱ�ȭ�� i�� :" + obj1.getI());
		obj1.setI(999);
		System.out.println("obj1�� i���� ������ �� obj2�� �� : " + obj2.getI());
		System.out.println("=============");
		AClass aObj = AClass.getInstance();
		aObj.setIntVar(999);
		AClass bObj = AClass.getInstance();
		System.out.println(bObj.getIntVar());
	}
}
