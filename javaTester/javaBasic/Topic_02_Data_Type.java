package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	//primitive type / value type: Nguyên thủy
	byte bNumber = 6;
	
	short sNumber = 15000;
	
	int iNumber = 65000;
	
	long lNumber = 65000;
	
	float fNumber = 15.98f;
	
	double dNumber = 15.98d;
	
	//reference type: Tham chiếu
	//String
	
	String address = "Ha Tinh";
	
	//Array
	
	String[] studentAddress = {"Ha Noi", "Sai gon", address};
	Integer[] studentNumber = {15,20,21};
	
	
	//Class
	
	Topic_02_Data_Type topic;
	
	//Interface
	
	WebDriver driver;
	
	//Object
	Object aOject;
	
	//Collection: List/Set/Queue/Map
	List<WebElement> homepageLinks = driver.findElements(By.tagName("a"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	
	public static void main(String[] args) {
	
	}

}
