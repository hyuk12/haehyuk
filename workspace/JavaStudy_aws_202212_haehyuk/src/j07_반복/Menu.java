package j07_반복;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String name = "홍길동";
		System.out.println(name.charAt(0));
		
		boolean loopFlag1 = true;
		
		while (loopFlag1) {
			boolean loopFlag2 = true;
			char select = '\0';
			
			System.out.println("========<<식당 메뉴>>========");
			System.out.println("1. 김밥천국");
			System.out.println("2. 탄탄면");
			System.out.println("3. 홍대개미");
			System.out.println("4. 밥앤밥");
			System.out.println("=============================");
			System.out.println("q. 프로그램 종료");
			System.out.println("=============================");
			
			System.out.println("식당 선택: ");
			
			select = scanner.next().charAt(0);
			
			if (select == 'q' || select == 'Q') {
				loopFlag1 = false;
			}else if (select == '1') {
				
				while(loopFlag2) {
					System.out.println("========<<김밥천국 메뉴>>========");
					System.out.println("1. 라면");
					System.out.println("2. 돌솥비빔밥");
					System.out.println("3. 오므라이스");
					System.out.println("4. 김치볶음밥");
					System.out.println("=================================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("=================================");
					
					System.out.println("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if (select == 'b' || select == 'B') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("라면을 선택했습니다.");
					}else if (select == '2') {
						System.out.println("돌솥비빔밥을 선택했습니다.");
					}else if (select == '3') {
						System.out.println("오므라이스를 선택했습니다.");
					}else if (select == '4') {
						System.out.println("김치볶음밥을 선택했습니다.");
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			}else if (select == '2') {
				
				while(loopFlag2) {
					System.out.println("========<<탄탄면 메뉴>>========");
					System.out.println("1. 돈코츠라멘");
					System.out.println("2. 탄탄멘");
					System.out.println("3. 카츠동");
					System.out.println("4. 애비동");
					System.out.println("===============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("===============================");
					
					System.out.println("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if (select == 'b' || select == 'B') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("돈코츠라멘을 선택했습니다.");
					}else if (select == '2') {
						System.out.println("탄탄멘을 선택했습니다.");
					}else if (select == '3') {
						System.out.println("카츠동을 선택했습니다.");
					}else if (select == '4') {
						System.out.println("애비동을 선택했습니다.");
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			}else if (select == '3') {
				while(loopFlag2) {
					System.out.println("========<<홍대개미 메뉴>>========");
					System.out.println("1. 홍대일개미");
					System.out.println("2. 홍대왕개미");
					System.out.println("3. 홍대여왕개미");
					System.out.println("4. 홍대전사개미");
					System.out.println("=================================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("=================================");
					
					System.out.println("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if (select == 'b' || select == 'B') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("홍대일개미를 선택하셨습니다");
					}else if (select == '2') {
						System.out.println("홍대일개미를 선택하셨습니다");
					}else if (select == '3') {
						System.out.println("홍대일개미를 선택하셨습니다");
					}else if (select == '4') {
						System.out.println("홍대일개미를 선택하셨습니다");
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			}else if (select == '4') {
				while (loopFlag2) {
					System.out.println("========<<밥앤밥 메뉴>>========");
					System.out.println("1. 오징어덮밥");
					System.out.println("2. 제육덮밥");
					System.out.println("3. 카레밥");
					System.out.println("4. 현미밥");
					System.out.println("===============================");
					System.out.println("b. 뒤로가기");
					System.out.println("q. 프로그램 종료");
					System.out.println("===============================");
					
					System.out.println("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);
					
					if (select == 'b' || select == 'B') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("오징어 덮밥을 선택하셨습니다.");
					}else if (select == '2') {
						System.out.println("제육덮밥을 선택하셨습니다.");
					}else if (select == '3') {
						System.out.println("카레밥을 선택하셨습니다.");
					}else if (select == '4') {
						System.out.println("현미밥을 선택하셨습니다.");
					}else {
						System.out.println();
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요.");
						System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					}
					System.out.println();
				}
				
			}else {
				System.out.println();
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("사용할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요.");
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			}
			
			System.out.println();
		}
		System.out.println("프로그램이 정상 종료!");
	}
}
