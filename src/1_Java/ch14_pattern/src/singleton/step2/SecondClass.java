package singleton.step2;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("SecondClass ������");
		System.out.println(singletonObject.getI());
		System.out.println("SecondClass ������ �� ===");
	}
}