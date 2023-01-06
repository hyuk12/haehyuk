package j12_배열;

public class Array5 {
	
	// 기존 배열에 있는 값을 새로운 배열에 넣는 메소드
	public static void transferArray(int[] oldArray, int[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i]; // 새로운 배열에 기존의 배열에 있는 값을 옮기는 작업
		}
		
	}
	
	// 배열을 추가하는 메소드
	public static int[] addArrayLength(int[] array) {
		int[] newArray = new int[array.length + 1]; // 새로운 배열을 만듬 본래 배열의 길이 플러스 하나
		transferArray(array, newArray); // 기존의 배열과 새로운 배열을 넣어 작업한다.
		return newArray;
	}
	
	// 데이터를 추가하는 메소드
	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array); // 배열의 길이를 연장시키는 작업
		newArray[array.length] = data;
		return newArray;
	}

	public static void main(String[] args) {
		
		int[] nums = new int[0];
		
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		
	}
}
