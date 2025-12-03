/*
 * Student.java
 * Student class for Registation.java
 * Isaac Tran
 * Mr. Campbell
 * 2022-12-16
 */
package Assignment2;
public class Student {
	// Class variables
	private String fullName;
	private String studId;
	private String login;

	/**
	 * When user inputs a full name and student ID it will save the information.
	 * Login will take first 4 letter of first name, first letter of last name and first three number of student ID
	 * @param fullName	First name + last name of the student enrolling
	 * @param studId	Collect the student ID
	 */
	Student(String fullName, String studId) {
		this.fullName = fullName;
		this.studId = studId;
		this.login = fullName.split(" ")[1].substring(0, 4) + fullName.split(" ")[0].substring(0,1) + studId.substring(0,3);
	}

	/**
	 * 
	 * @return login information
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * 
	 * @return Full name of the student enrolling
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * 
	 * @return Student ID of the student enrolling
	 */
	public String getstudId() {
		return studId;
	}
	/**
	 * The Login username
	 */
	void login() {
		login = fullName.split(" ")[1].substring(0, 4) + fullName.split(" ")[0].substring(0,1) + studId.substring(0,3);
	}
	/**
	 * Modify the enrolled student full name and ID
	 * @param fullName
	 * @param studId
	 */
	public void modify(String fullName, String studId) {
		this.fullName = fullName;
		this.studId = studId;
		this.login = fullName.split(" ")[1].substring(0, 4) + fullName.split(" ")[0].substring(0,1) + studId.substring(0,3);
	}
	/**
	 * Display the information of the student
	 */
	public void studentInfo() {
		System.out.println(fullName + (" ID: ") + studId);
		System.out.println(("Login: ") + login);
		System.out.println("-----------------------------");
	}
}
