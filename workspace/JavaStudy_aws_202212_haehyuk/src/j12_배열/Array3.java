package j12_배열;

import java.util.Random;

public class Array3 {
	
	public static void main(String[] args) {
		
		// 선형 선택 알고리즘
		
		Random random = new Random();

		int[] nums = new int[10];
		// 랜덤한 값을 넣는데 같은 값이 들어가면 안된다.
		for(int i = 0; i < nums.length; i++) {
			while(true) {
				boolean numCheckFlag = true; // 탈출구 마련
				
				int randomNum = random.nextInt(nums.length) + 1;
				
				for(int j = 0; j < nums.length; j++) {
					if(nums[j] == randomNum) {
						numCheckFlag = false;
						break;
					}
				}
				
				if(numCheckFlag) {
					nums[i] = randomNum;
					break;
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		
		
	}
}
