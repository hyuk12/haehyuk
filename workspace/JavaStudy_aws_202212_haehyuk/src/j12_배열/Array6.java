package j12_배열;

public class Array6 {
	
	public static void main(String[] args) {
		
		String[] names = {"홍길동", "이순신", "김유신"};
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
			
		}
		
		// forEach 생성되면 임시 공간이 생기고 스택형식으로 쌓는다.
		// 그리고 반복이 돌면서 상위 부터 하나씩 꺼내지고 그 값은 대입되면 사라진다.
		//
		System.out.println("<<<<<<<<forEach>>>>>>>>");
		for (String name : names) {
			System.out.println(name);
			
		}
		
		int[] nums = {1, 2, 3, 4, 5};
		
		for(int i : nums) {
			System.out.println("i : " + i);
		}
	}

}
