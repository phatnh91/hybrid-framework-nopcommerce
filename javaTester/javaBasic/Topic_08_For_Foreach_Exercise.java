package javaBasic;

import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_Foreach_Exercise {

	Scanner sc = new Scanner(System.in);

	public void TC_01() {

		int n;
		System.out.println("Nhập số n");
		n = sc.nextInt();

		for (int i = 1; i < n; i++) {

			System.out.print(i + " ");
		}

	}

	public void TC_02() {

		int a, b;
		System.out.println("Nhập số a và b:");
		a = sc.nextInt();
		b = sc.nextInt();

		if (a < b) {
			for (int i = a; i <= b; i++) {
				System.out.print(i + " ");

			}
		} else {
			System.out.println("Nhập số a bé hơn b");

		}

	}

	public void TC_03() {
		int s = 0;
		for (int i = 2; i <= 10; i += 2) {
			s += i;

		}
		System.out.println(s);
	}

	public void TC_04() {
		int a, b;
		int s = 0;
		System.out.println("Nhập số a và b: ");
		a = sc.nextInt();
		b = sc.nextInt();

		for (int i = a; i <= b; i++) {
			s += i;

		}
		System.out.println("Tổng các số từ " + a + "tới " + b + " là: " + s);
	}

	public void TC_05() {

		int n;
		int s = 0;
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0)
				s += i;

		}
		System.out.println("Tổng các số lẻ từ " + "0 " + "tới " + n + " là: " + s);
	}

	public void TC_06() {

		int a, b;
		System.out.println("Nhập a và b: ");
		a = sc.nextInt();
		b = sc.nextInt();

		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}

		}

	}

	@Test
	public void TC_07() {
		int n;
		int s = 1;
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			s = s * i;
		}
		System.out.println(n + " giai thừa là: " + s);

	}
}
