import javax.swing.JOptionPane;

public class Quest {

	public static void main(String[] args) {
		// 숫자 입력
		int n = Integer.parseInt(JOptionPane.showInputDialog("숫자입력"));
		// 반복문 1 ~ 5
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
			// 1 2 3 4 5
		}
		System.out.println(n + " ! = " + result);
//5입력하면 1~5까지 곱한 결과:팩토리얼
	}
}
