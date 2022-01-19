package javaBasic;



import org.testng.annotations.Test;

public class Topic_10_Break_Continue {

	
	@Test
	public void TC_01_For() {
		
//		for (int i = 0; i <= 10; ++i) {
//			System.out.println(i);
//		}
		
		String [] cityname = {"ha noi", "ha tinh", "sai gon"};
		for (int i = 0; i < cityname.length; i++) {
			
			System.out.println(cityname[i]);
			
		}
		
		for (String city : cityname) {
			
			if(city=="ha tinh") {
				System.out.println(city);
				break;
			}
			
		}
	}
}
