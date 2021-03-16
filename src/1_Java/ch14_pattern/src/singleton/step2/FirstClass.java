package singleton.step2;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("FirstClass형 객체 생성");
		System.out.println(singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("변경 후 i 값(FirstClass에서) " + singletonObject.getI());
		System.out.println("FirstClass형 생성자 끝");
	}
}