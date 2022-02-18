package javaOOP;

public class Topic_01_Getter_Setter {
	
	private String personName;
	private int personAge;
	private long personBankAccountAmount;
	protected String getPersonName() {
		return personName;
	}
	protected void setPersonName(String personName) {
		this.personName = personName;
	}
	protected int getPersonAge() {
		return personAge;
	}
	protected void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	protected long getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}
	protected void setPersonBankAccountAmount(long personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}
	

}
