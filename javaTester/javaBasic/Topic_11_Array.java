package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array {

	public void TC_01_Show_Biggest_Element() {

		int[] array = { 2, 7, 6, 8, 9 };
		int max = array[0];

		for (int num : array) {
			if (max < num) {
				max = num;
			}

		}
		System.out.println("số lớn nhất là: " + max);

	}

	public void TC_02_Total_First_And_Last_Number_of_() {

		int[] array = { 2, 7, 6, 8, 9 };
		int n = array.length;
		System.out.println("Tổng của số đầu tiên và số cuối cùng của mảng là: " + (array[0] + array[n - 1]));

	}

	public void TC_03_Show_Even_Number() {

		int[] array = { 2, 7, 6, 8, 9, 16, 17, 20 };
		for (int i : array) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

	}

	public void TC_04_Show_Total_Odd_Number() {

		int[] array = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int s = 0;
		for (int i : array) {
			if (i % 2 != 0 && i > 0) {
				s += i;
			}

		}
		System.out.println(s);
	}

	public void TC_05_Show_Number_Under_Conditional() {

		int[] array = { 3, -7, 2, 5, 9, -6, 10, 12 };
		for (int i : array) {
			if (i >= 0 && i <= 10) {
				System.out.println(i);
			}

		}
	}

	
	public void TC_06_Show_Total_And_Average() {

		double[] array = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		double s=0;
		int n = array.length;
		for (double i : array) {
			s+=i;
		}
		System.out.println("Tổng các chữ số trong mảng là: " +s);
		System.out.println("Trung bình cộng các chữ số trong mảng là: " +(s/n));
		
		

	}
	
	@Test 
	public void TC_07_Show_Student_Information() {
		
		Student student1 = new Student("1", "Hung Phat", 31, 10);
		Student student2 = new Student("2", "Thuy Van ", 29, 9);
		Student student3 = new Student("3", "Vy Nguyen", 30, 8);
		
		
		student1.display();
		student2.display();
		student3.display();
		
		
		
		
	}
	
	public class Student{
		String id, name;
		int age, score;
		
		public Student(String id, String name, int age, int score) {
			
			this.id = id;
			this.name = name;
			this.age = age;
			this.score = score;
		}
		
		public void display() {
			System.out.println("ID: " +id);
			System.out.println("Name: " +name);
			System.out.println("Age: " +age);
			System.out.println("Score: " +score);
		}
	}
	
	
}
