package singleton.step2;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("���θ޼ҵ忡�� singObj���� i����");
		System.out.println(singObj.getI());
	}
}