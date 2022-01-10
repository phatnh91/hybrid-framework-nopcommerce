package javaBasic;

import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {

	public void TC_01() {

		int n;
		System.out.println("Chữ số n là: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		String result = (n % 2 == 0) ? "n là số chẵn" : "n là số lẻ";

		System.out.println(result);

	}

	public void TC_02() {

		int a, b;
		System.out.println("Nhập lần lượt a [khoảng cách] b: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();

		if (a > b) {

			System.out.println("a lớn hơn b");
		} else if (a == b) {

			System.out.println("a bằng b");

		} else {

			System.out.println("a bé hơn b");
		}

	}

	public void TC_03() {

		String name1, name2;

		Scanner sc = new Scanner(System.in);
		name1 = sc.next();
		name2 = sc.next();

		String result = (name1.equals(name2)) ? "2 người cùng tên" : "2 người khác tên";

		System.out.println(result);

	}

	public void TC_04() {

		int a, b, c;

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		if (a > b && a > c) {

			System.out.println("Số lớn nhất là: " + a);

		} else if (b > c) {

			System.out.println("Số lớn nhất là: " + b);
		} else {

			System.out.println("Số lớn nhất là: " + c);
		}

	}

	public void TC_05() {

		int a;

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số a: ");
		a = sc.nextInt();
		String result = (a <= 100 && a >= 10) ? (a + " nằm trong [10, 100]") : (a + " không nằm trong [10,100]");
		System.out.println(result);

	}

	public void TC_06() {

		double a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Điểm thi là: ");
		a = sc.nextDouble();

		if (a < 5) {
			System.out.println("Điểm D");
		} else if (a >= 5 && a < 7.5) {
			System.out.println("Điểm C");
		} else if (a >= 7.5 && a < 8.5) {
			System.out.println("Điểm B");
		} else if (a >= 8.5 && a <= 10) {
			System.out.println("Điểm A");
		}

	}

	@Test
	public void TC_07() {

		int thang;
		int nam;
		Scanner sc = new Scanner(System.in);
		System.out.println("Tháng: ");
		thang = sc.nextInt();
		System.out.println("Năm: ");
		nam = sc.nextInt();
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + thang + " có 31 ngày");
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng " + thang + " có 30 ngày");
			break;

		case 2:
			if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0))

				System.out.println("Tháng " + thang + " có 29 ngày");

			else
				System.out.println("Tháng " + thang + " có 28 ngày");
			break;

		default:
			System.out.println("Tháng không hợp lệ");
			break;

		}

	}

}
