
public abstract class Duck {
	
	QuackBehavior quackBehavior;
	FlyBehavior flyBehavior;
	//�����Զ��������Ľӿ�ʵ�ָ���ı仯
	//ÿһֻѼ�Ӷ�������ʵ����Щ�ӿڵĶ���
	
	public Duck() {
		
	}
	
	public abstract void display();		//�������า��
	
	public void swim() {
		System.out.println("I can swim");
	}
	
	public void performQuack() {
		quackBehavior.quack();		//Ѽ�Ӷ������Դ�����Ϊ�����ǽ���ʵ���ࡣ
	}
	
	public void performFly() {
		flyBehavior.fly();			//Ѽ�Ӷ������Դ�����Ϊ�����ǽ���ʵ���ࡣ
	}
	
	//set����,��̬�趨��Ϊ
	public void setFlyBehavior(FlyBehavior fb) {		//����ֱ�Ӵ���һ��
		flyBehavior = fb;								//FlyBehavior�ӿڵ�ʵ������Ϊ����		
	}
		
		
	//set����
	public void setQuackBehavior(QuackBehavior qb) {		//����ֱ�Ӵ���һ��
		quackBehavior = qb;								//QuackBehavior�ӿڵ�ʵ������Ϊ����		
	}
	
}
