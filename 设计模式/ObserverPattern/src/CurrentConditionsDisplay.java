
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	//�������������������֮һ��Ҳ��������һ���۲���
	
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	//���ﴫ��Subject��Ķ�����Ϊע��ʹ��
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	//displayչʾ�ڲ������
	public void display() {
		System.out.println("Current Conditions :" + temperature + "F degrees"
				+ " and " + humidity + "% humidity");
	}

}
