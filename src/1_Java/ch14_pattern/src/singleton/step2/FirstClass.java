package singleton.step2;

/*
 * 2020.12.10~ Lim JaeHyun
 */
public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("FirstClass�� ��ü ����");
		System.out.println(singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("���� �� i ��(FirstClass����) " + singletonObject.getI());
		System.out.println("FirstClass�� ������ ��");
	}
}