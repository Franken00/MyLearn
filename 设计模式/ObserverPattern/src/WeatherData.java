import java.util.ArrayList;

/*
 * WeatherDataʵ����Subject�ӿ�
 * */
public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);		//ע��Ĺ۲���ֱ������ں��漴��

	}


	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);		//�ҵ�������ɾ��
		if(i >= 0) {
			observers.remove(i);
		}
	}


	public void notifyOvbserver() {
		for(int i = 0; i < observers.size(); i++) {				//ѭ��ȡ���۲��߲�����һ֪ͨ
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementChanged() {
		notifyOvbserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}
}
