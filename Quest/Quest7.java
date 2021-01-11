import javax.swing.JOptionPane;
public class Quest7 {

	public static void main(String[] args) {
		int num=Integer.parseInt(JOptionPane.showInputDialog("숫자 입력"));
		System.out.println("입력한 숫자 : " +num);
		
		int sum=0;
		for(int i=1;i<num;i++) {
			if(num % i == 0)
			sum += i;
		}
		
		if(sum ==num)
			System.out.println("이 숫자는 완전수 입니다.");

	}

}
