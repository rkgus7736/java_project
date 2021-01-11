
public class TestMain {

	public static void main(String[] args) {
		Aircon aircon = new Aircon();
		Boiler boiler = new Boiler();
		Light light = new Light();
		
		IotApp app = new IotApp();
		app.AddDevice(light);
		app.AddDevice(boiler);
		app.AddDevice(aircon);
		
		app.powerOn();
		app.powerOff();
		
	}

}

