
public class Light implements OnOff {
	private boolean power;

	@Override
	public void powerOnOff() {
		power = !power;
		if (power)
			System.out.println("Light On");
		else
			System.out.println("Light Off");
		
		//public void powerOnOff() {
		//power = !power;
		//if (power)
		//	powerOff;
		//else
		//	powerOn;
		//간단하게 가능 (어차피 오버라이드로 아래 써줄것이라서)

	}

	@Override
	public void powerOn() {
		power = true;

	}

	@Override
	public void powerOff() {
		power = false;

	}

}
