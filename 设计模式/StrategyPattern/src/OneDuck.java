
public class OneDuck extends Duck{
	
	public OneDuck() {
		quackBehavior = new Quack();			//����ʹ�ù�����������Ѽ�ӵ���Ϊ											
		flyBehavior = new FlyWithSwings();		
	}
	
	
	public void display() {
		System.out.println("I am a real duck!");
	}

}
