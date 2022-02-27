package utilities;

import com.github.javafaker.Faker;

public class DataHelper {
	private Faker fake;
	public static DataHelper getData() {
		return new DataHelper();
	}
	public DataHelper(){
	fake = new Faker();
	}
	
	public String getFirstName() {
		
		return fake.name().firstName();
	}
	
	public String getLastName() {
		
		return fake.name().lastName();
	}
	
	public String getEmail() {
		return fake.internet().emailAddress();
	}
	
	public String getPassword() {
		
		return fake.internet().password();
	}

}
