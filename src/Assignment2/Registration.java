/*
 * Registration.java
 * A java program that enrolls student in a school
 * Isaac Tran
 * Mr. Campbell
 * 2022-12-16
 * 
 */
package Assignment2;
import java.util.*;
public class Registration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// create an ArrayList that stores all the information of the enrolling student
		ArrayList<Student>Students = new ArrayList<Student>();

		boolean play = true;

		while (play) {
			// display welcoming and the rules
			System.out.println("1. Enroll a student");
			System.out.println("2. Display all student information");
			System.out.println("3. Quit");
			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			System.out.println("-----------------------------");

			if (choice == 1) {
				// if user choice is 1 collect students first and last
				System.out.print("Enter Student First And Last Name: ");
				String firstName = sc.next();
				String lastName = sc.next();
				String fullName = firstName + " " + lastName;
				// collect student ID
				System.out.print("Enter student ID: ");
				int ID = sc.nextInt();
				
				System.out.println("-----------------------------");
				// access the student class
				Student students = new Student(fullName, String.valueOf(ID));
				// add enrolling student to the ArrayList
				Students.add(students);
				continue;
			}
			else if (choice == 2) {
				// for the number of student, display all enrolled student's info from Student class
				for (Student info : Students) {
					info.studentInfo();
				}
				continue;
			}
			else if (choice == 3) {
				// exit case, break out of the loop
				play = false;
				break;
			}
			else
				System.out.println("Invalid choice");
			continue;
		}
		sc.close();
	}
}

