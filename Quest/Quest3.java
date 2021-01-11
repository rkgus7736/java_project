import javax.swing.JOptionPane;
public class Quest3 {

	public static void main(String[] args) {
		int money = Integer.parseInt(JOptionPane.showInputDialog("금액 입력"));
		
		int ea = 50000;{
			boolean flag = true;
			while (ea > 5) {
				System.out.println(ea +"원 :" + money/ea +"개" );
				money %= ea;
				
				if (flag)
				ea /= 5;
				else
				ea /= 2;
				flag = !flag;
				
				
			}
		}
		
	    
	    
	}

}
