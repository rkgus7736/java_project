
public class IotApp {
	private OnOff[] list;
	private int index;

	public IotApp() {
		list = new OnOff[5];
	}
	
	public void AddDevice(OnOff device) {
		if(index == list.length) return;
		list[index++] = device;
	}
	
	public void powerOn() {
		for(int i=0;i<index;i++)
			list[i].powerOn();
	}
	
	public void powerOff() {
		for(int i=0;i<index;i++)
			list[i].powerOff();
	}
	
}


