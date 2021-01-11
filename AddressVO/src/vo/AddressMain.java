package vo;

import java.util.Scanner;

import service.AddressService;

public class AddressMain {

	public static void main(String[] args) {
		AddressService service = new AddressService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			// 메뉴 출력
			System.out.println("주소록에 등록을 시작합니다.");
			System.out.println("1.주소록 등록:");
			System.out.println("2.주소록 삭제:");
			System.out.println("3.주소록 조회:");
			System.out.println("4.주소록 50세 이상 조회:");
			System.out.println("5.전체 주소록 조회");
			System.out.println("0.프로그램 종료.");
			System.out.print("원하시는 메뉴 번호를 입력하세요.");
			// 메뉴번호 입력
			int no = sc.nextInt();
			sc.nextLine();
			if (no == 0)
				break;
			// 해당 메서드 실행
			switch (no) {
			case 1:
				service.register(sc);
				break;
			case 2:
				service.deleteAddress(sc);
				break;
			case 3:
				service.deleteAddress(sc);
				break;
			case 4:
				service.searchAddressPrintText(no);
				break;
			case 5:
				service.printAllAddress();
				break;

			}
		}

	}

}
