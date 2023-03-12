package backjun_solved;

import java.util.Scanner;

public class Silver5_1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int myNumber = 64;
        int min = 0;

        int x= sc.nextInt();
        sc.nextLine();
        while (x > 0) {
           if(myNumber > x) {
               myNumber = myNumber/2;
           }else {
               min++;
               x -= myNumber;
           }
        }
        System.out.println(min);
    }
}
