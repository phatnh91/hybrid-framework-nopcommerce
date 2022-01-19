package javaBasic;

public class Topic_12_String {

	public static void main(String[] args) {
		String schoolName = "Automation Testing";
		String courseName = "AUTOMATION TESTING";
		String schoolAddress = "Đà Nẵng";

		System.out.println("Độ dài: " + schoolName.length());
		System.out.println("Lấy ra 1 ký tự: " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi: " + schoolName.equals(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi: " + schoolName.equals(courseName));
		System.out.println("Kiểm tra 2 chuỗi: " + schoolName.equalsIgnoreCase(courseName));
		
		
		System.out.println("Có bắt đầu bằng 1 ký tự/chuỗi ký tự: " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 ký tự/chuỗi ký tự: " + schoolName.endsWith("G"));
		System.out.println("Vị trí của ký tự/chuỗi ký tự: " + schoolName.indexOf("G"));
		
		//Sub-String
		
		System.out.println("Tách 1 ký tự/chuỗi ký tự: " + schoolName.substring(11));
	}

}
