package leaner;

import java.util.Scanner;

public class Main22 {

        public static void main(String[] args) {
        	Scanner sc=new Scanner(System.in);
        	int n = sc.nextInt();
            getNum(n);
        }

        private static void getNum(int num) {
            char a = 1;
            char b = 2;
            char c = 3;
            move(num, a, b, c);
        }

        private static void move(int moveNum, int a, int b, int c) {
            
            if (moveNum == 1) {
                System.out.println("Move " + moveNum + " from " + a + " to " + c);
            } else {
                
                move(moveNum - 1, a, c, b);
                System.out.println("Move " + moveNum + " from " + a + " to " + c);
                
                move(moveNum - 1, b, a, c);
            }
        }
    
}
