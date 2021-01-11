package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import vo.AddressVO;

public class AddressService {
	private ArrayList<AddressVO> list;

	public AddressService() {
		list = new ArrayList<AddressVO>();
		readFile();
		// readFile 안쓰면 읽어올수가 없다. 중요함!!!!!
	}

	public void readFile() {
		File file = new File("address.dat");
		if (!file.exists())
			return; // 파일이 없으면 강제종료
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			while (true) {
				AddressVO vo = (AddressVO) ois.readObject();
				if (vo != null)
					list.add(vo);
				// 원본 데이터 들어가는 곳에 null이 들어가면 안됨
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("파일 읽기 완료");
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();

			}

		}
	}

//주소록에 있는 정보 파일로 출력하는 부분
	public void writeFile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("address.dat");
			oos = new ObjectOutputStream(fos);
			// 파일 출력 부분
			for (int i = 0; i < list.size(); i++)
				oos.writeObject(list.get(i));
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 주소록 등록 부분
	public void register(Scanner sc) {
		System.out.println("주소록 등록을 시작합니다.....");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("연락처 : ");
		String tel = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		AddressVO vo = new AddressVO(name, tel, email, age);
		// 리스트 및 배열에 등록
		list.add(vo);
		// 파일에 최신화
		writeFile();
	}

//이름 입력 검색기능
	public void search(Scanner sc) {
		// DB에서는 search 말고 selectaddress로 씀
		System.out.println("주소록 검색을 시작합니다.");
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("연락처:");
		String tel = sc.nextLine();
		AddressVO vo = new AddressVO(name, tel, null, 0);
		int index = list.contains(vo) ? list.indexOf(vo) : -1;
		if (index != -1)
			vo.printInfo();
		else
			System.out.println("검색결과가 없습니다.");

	}

//주소록 정보 삭제하는 부분
	public void deleteAddress(Scanner sc) {
		System.out.println("주소록 삭제를 시작합니다.");
		System.out.println("이름:");
		String name = sc.nextLine();
		System.out.println("연락처:");
		String tel = sc.nextLine();
		AddressVO vo = new AddressVO(name, tel, null, 0);
		// equals를 만든이유가 리스트에 있는걸 편하게 검색하려고만든것이라 쓰면됨.
		if (list.remove(vo)) {
			System.out.println("삭제 완료");
			writeFile(); // 최신화

		} else
			System.out.println("삭제할 데이터가 없습니다.");
	}

	// 나이 50을 받아서 50세 이상 조회
	public void searchAddressPrintText(int age) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter("50age.txt");
			pw = new PrintWriter(fw);
			// 반복문 나이가 50이상인지 체크
			// String str = " ";
			for (int i = 0; i < list.size(); i++) {
				// addressvo 클래스에 getterandsetter-> age가 있어야 뽑을수있다.
				if (list.get(i).getAge() >= age) {
					list.get(i).toString();
					// 50세 이상이면 텍스트 파일로 출력
					// str += list.get(i).toString()+"\n";
					//// toString 리턴값 출력
					pw.println(list.get(i).toString());
					pw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			pw.close();

		}
	}

//전체 주소록 조회하는 부분
	public void printAllAddress() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
