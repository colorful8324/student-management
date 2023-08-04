package main;

import java.io.IOException;
import java.util.Scanner;
import process.Manage;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static int inputOption() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    static void showMenu() {
        System.out.println("----------------- Student Management Menu -----------------");
        System.out.println("0. List all students");
        System.out.println("1. Create a student");
        System.out.println("2. Find a student by ID");
        System.out.println("3. Update a student by ID");
        System.out.println("4. Delete a student by ID");
        System.out.println("5. Show the percentage of students' academic rank in DESC order");
        System.out.println("6. Show the percentage of students' average score by score in ASC order");
        System.out.println("7. Show all students in an academic rank");
        System.out.println("8. Exit");
    }

	public static void main(String[] args) throws Exception {
		Manage mn = new Manage();
		while (true) {
			showMenu();
			int opt = inputOption();
			if (opt == 8) {
				mn.writeFile();
				sc.close();
				break;
			}
			switch (opt) {
				case 0 -> mn.showStudents();
				case 1 -> mn.addStudent();
				case 2 -> mn.findById();
				case 3 -> mn.update();
				case 4 -> mn.deleteById();
				case 5 -> mn.showRankPercent();
				case 6 -> mn.showCpaPercent();
				case 7 -> mn.showStudentsByRank();
				default -> {
				}
			}
		}
	}

}
