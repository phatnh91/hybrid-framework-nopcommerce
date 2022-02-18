package javaOOP;

public class Student {
	private int studentID;
	public Student(int studentID, String studentName, float theoryScore, float practiceScore) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}
	private String studentName;
	private float theoryScore, practiceScore;
	
	protected int getStudentID() {
		return studentID;
	}
	
	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	protected String getStudentName() {
		return studentName;
	}
	
	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	protected double getTheoryScore() {
		return theoryScore;
	}
	
	protected void setTheoryScore(float theoryScore) {
		this.theoryScore = theoryScore;
	}
	
	protected double getPracticeScore() {
		return practiceScore;
	}
	
	protected void setPracticeScore(float practiceScore) {
		this.practiceScore = practiceScore;
	}
	
	protected float getAverageScore() {
		float countAverageScore = (theoryScore + practiceScore*2)/3;
		return countAverageScore;
		
	}
	
	protected void showStudentName() {
		System.out.println("Student ID is: " +studentID);
		System.out.println("Student name is: " +studentName);
		System.out.println("Student avarage score is: " + getAverageScore());
	}
	public static void main(String[] args) {
		
		Student std1 = new Student(001, "Nguyen Hung Phat", 9.5f, 10);
		Student std2 = new Student(002, "Tran Thi Thuy Van", 6.5f, 7.25f);
		Student std3 = new Student(003, "Tran Thi Thuy Tien", 7.5f, 8.75f);
		
		std1.showStudentName();
		std2.showStudentName();
		std3.showStudentName();
		
		
	}

}
