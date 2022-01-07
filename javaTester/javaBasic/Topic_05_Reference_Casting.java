package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_05_Reference_Casting {

	String name;
	int age;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public static void main(String[] args) {

//		Topic_05_Reference_Casting topic = new Topic_05_Reference_Casting();
//		
//		topic.setName("Hunter");
//		System.out.println(topic.getName());
//		topic.setAge(31);
//		System.out.println(topic.getAge());
//		
		int a, b;
		System.out.println("Nhập giá trị a và b: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		
		
		System.out.println("a = " + a); 
		System.out.println("b = " + b); 

	}
}