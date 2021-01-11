
public class Quest4 {

	public static void main(String[] args) {

		for (int dan = 2; dan < 10; dan++) {
			if (dan % 2 == 1)
				continue;
			System.out.println(dan + "단");
			// 1~9까지 곱한 결과

			for (int is = 1; is < 10; is++) {

				System.out.println(dan + "*" + is + "=" + dan * is);

				if (dan == is)
					break;
			}
		}

		for (int dan = 2; dan < 10; dan += 2) {
			System.out.println(dan + "단");
			for (int is = 1; is < 10; is += 1) {
				System.out.println(is + "단");
			}
		}
	}

}
