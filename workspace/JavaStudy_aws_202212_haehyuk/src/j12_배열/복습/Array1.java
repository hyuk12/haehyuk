package j12_배열.복습;

public class Array1 {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int[] nums = new int[5];
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
        nums[4] = num5;


        for (int num : nums) {
            System.out.println(num);
        }

    }
}
