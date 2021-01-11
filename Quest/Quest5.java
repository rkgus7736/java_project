
public class Quest5 {
	
	/*
	 * 1~100까지의 숫자 중 소수만 출력하는 코드
	 * 소수를 체크하는 부분을 메서드로 작성
	 */

	public static void main(String[] args) {
		 for(int i=1;i<=100;i++) {
			 int j;
			 for(j=2;j<=100;j++) {
				 if (i % j == 0)
					 break;
			 }
			 
			 if(i==j)
				 System.out.println(i);
		 }
		 }
		 
		 public static boolean isPrimeNumber(int num) {
			 boolean result = false;
			 for (int i=1;i<=100;i++) {
				 if (num % i == 0)
				 return false;
			 
		 }
             return true;
	}
     public static void main(String[] args) {
	   for(int i=1;i<=100;i++) {
		   if(isPrimeNumber(i))
			   System.out.println(i);
	   }
 }
}
