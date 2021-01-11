
public class Aircon implements OnOff{
	private boolean power;
	@Override
	public void powerOnOff() {
		if(power)	powerOff();
		else		powerOn();
	}

	@Override
	public void powerOn() {
		power = true;
		System.out.println("Aircon On");
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("Aircon Off");
	}
	
}





