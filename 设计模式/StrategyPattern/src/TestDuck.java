
public class TestDuck {

	public static void main(String[] args) {
		Duck aduck = new OneDuck();
		
		//���״̬
		aduck.display();
		System.out.println("����һֻѼ�ӣ�һ��ʼ���ǻ�ɵģ�");
		aduck.performFly();
		System.out.println("��Ҳ�ǻ�еģ�");
		aduck.performQuack();
		
		//��̬�趨��Ϊ��ʹѼ�Ӳ����
		System.out.println("��һ�죬�ҵĳ���۶��ˣ��Ҳ�����ˣ�");
		aduck.setFlyBehavior(new FlyNoWay());
		aduck.performFly();
		
	}
	
}
