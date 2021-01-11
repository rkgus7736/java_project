
public class Quest6 {
	/*                줄    공백     *
	 *       *        0      4     1
	 *      ***       1      3     3 
	 *                2      2     5     
	 *                3      1     7     
	 *                4      0     9                                        
	 */

	public static void main(String[] args) {
		for (int i=0;i<5;i++) {
			//공백 출력
			for (int j=0;j<4-i;j++){
				System.out.print(" ");
			}
		    for (int j=0;j<i*2+1;j++) {
			//*출력
				System.out.print("*");
			
			}
			System.out.println();
		}
		
		 

	}

}
