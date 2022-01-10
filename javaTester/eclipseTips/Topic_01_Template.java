package eclipseTips;

import java.util.Scanner;

public class Topic_01_Template {

	
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Nhập dữ liệu
	        System.out.print("Nhập vào số nguyên n = ");
	        int n = sc.nextInt();

	        // Hien thị kết quả
	        System.out.println("Tổng từ 2 đến " + n + " theo cách dùng vòng lặp for là: " + cach1(n));
}

	private static int cach1(int n) {
		// TODO Auto-generated method stub
		int s = 0;
        for (int i = 2; i <= n; i += 2) {
            s += i;
        }

        return s;
    }
	
}
