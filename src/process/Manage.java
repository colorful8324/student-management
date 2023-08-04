package process;

import java.time.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import model.*;

public class Manage {
    Student[] studentArray = new Student[100];
    int count = 0;
    Scanner sc = new Scanner(System.in);
    Validate validate = new Validate();

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private double height;
    private double weight;
    private String studentId;
    private String school;
    private int yearOfStudy;
    private double cpa;


    public Manage() {
        // pass few records to test
        studentArray[count++] = (new Student("Khanh", LocalDate.parse("2002-12-03"), "624 Minh Khai", 70.1,
                70.1, "2002031202", "HUS", 2020, 7.0));
        studentArray[count++] = (new Student("Phong", LocalDate.parse("2002-06-08"), "15 Tan Khai", 70.1,
                70.1, "2002080602", "HAU", 2020, 5.0));
        studentArray[count++] = (new Student("Duy", LocalDate.parse("1995-11-13"), "624 Minh Khai", 70.1,
                70.1, "1995131195", "HUST", 2013, 9.0));
        studentArray[count++] =(new Student("Tuan", LocalDate.parse("1995-11-13"), "624 Minh Khai", 70.1,
                70.1, "1960040160", "HUST", 1978, 9.0));
    }

    // option 0
    public void showStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println("Student " + (i + 1) + ": " + studentArray[i]);
        }
    }

    // option 1
    public void addStudent() throws Exception {
        try {
            inputName();
            inputDateOfBirth();
            inputAddress();
            inputHeight();
            inputWeight();
            inputStudentId();
            inputSchool();
            inputYearOfStudy();
            inputCpa();
            Student newStudent = new Student(name, dateOfBirth, address, height, weight, studentId, school, yearOfStudy,
                    cpa);
            studentArray[count++] = newStudent;
            System.out.println(newStudent);
        }
        catch (Exception exc) {
            System.out.println("Invalid input. Please enter the student's information again.");
            sc.nextLine();
            addStudent();
        }
    }

    // // name
    public void inputName() {
        System.out.println("Enter student's name: ");
        name = sc.nextLine();
        if (!validate.isValidName(name)) {
            System.out.println("Student's name should not be null and should be less than 100 letters");
            inputName();
        }
    }

    // // date of birth
    public void inputDateOfBirth() throws DateTimeException {
        try {
            System.out.println("Enter student's date of birth: ");
            String stringDateOfBirth = sc.nextLine();
            dateOfBirth = LocalDate.parse(stringDateOfBirth);
            if (!validate.isValidDateOfBirth(dateOfBirth)) {
                System.out.println("Student's date of birth should not be null and year of birth should be greater than or equal to 1900.");
                inputDateOfBirth();
            }
        }
        catch (DateTimeException e) {
            System.out.println("Invalid date time format, should be yyyy-mm-dd");
            inputDateOfBirth();
        }
    }

    // // address
    public void inputAddress() {
        System.out.println("Enter student's address: ");
        address = sc.nextLine();
        if (!validate.isValidAddress(address)) {
            System.out.println("Student's address should be less than 300 letters");
            inputAddress();
        }
    }

    // // height
    public void inputHeight() throws InputMismatchException {
        try {
            System.out.println("Enter student's height: ");
            height = sc.nextDouble();
            sc.nextLine();
            if (!validate.isValidHeight(height)) {
                System.out.println("Student's height should be between 50.0 and 300.0");
                inputHeight();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter again.");
            sc.nextLine(); // this consumes the invalid token
            inputHeight();
        }
    }

    // // weight
    public void inputWeight() throws InputMismatchException {
        try {
            System.out.println("Enter student's weight: ");
            weight = sc.nextDouble();
            sc.nextLine();
            if (!validate.isValidWeight(weight)) {
                System.out.println("Student's weight should be between 5.0 and 1000.0");
                inputWeight();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter again.");
            sc.nextLine(); // this consumes the invalid token
            inputWeight();
        }
    }

    // // student id
    public void inputStudentId() {
        System.out.println("Enter student's ID: ");
        studentId = sc.nextLine();
        if (!validate.isValidStudentId(studentId)) {
            System.out.println("Student's ID should not be null, should be 10-letter-length and unique");
            inputStudentId();
        }
    }

    // // school
    public void inputSchool() {
        System.out.println("Enter student's school: ");
        school = sc.nextLine();
        if (!validate.isValidSchool(school)) {
            System.out.println("Student's school should not be null and should be less than 200 letters");
            inputSchool();
        }
    }

    // // year of study
    public void inputYearOfStudy() throws InputMismatchException {
        try {
            System.out.println("Enter student's year of study: ");
            yearOfStudy = sc.nextInt();
            sc.nextLine();
            if (!validate.isValidYearOfStudy(yearOfStudy)) {
                System.out.println("Student's year of study should not be null and should be 4-digit number, starting from 1990");
                inputYearOfStudy();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter again.");
            sc.nextLine(); // this consumes the invalid token
            inputYearOfStudy();
        }
    }

    // // cpa
    public void inputCpa() {
        try {
            System.out.println("Enter student's cpa: ");
            cpa = sc.nextDouble();
            sc.nextLine();
            if (!validate.isValidCpa(cpa)) {
                System.out.println("Student's cpa should be between 0.0 and 10.0");
                inputCpa();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter again.");
            sc.nextLine(); // this consumes the invalid token
            inputCpa();
        }
    }

    // option 2
    public void findById() {
        System.out.println("Enter the student's id you want to find: ");
        int targetId = sc.nextInt();
        sc.nextLine();
        int targetIdx = getIndexById(targetId);
        if (targetIdx == -1) {
            System.out.println("No data");
        } else {
            System.out.println("Found " + studentArray[targetIdx]);
        }
    }

    // if found, return the target's index;
    // else, return -1
    public int getIndexById(int theId) {
        for (int i = 0; i < count; i++) {
            if (studentArray[i].getId() == theId) {
                return i;
            }
        }
        return -1;
    }

    // option 3
    public void update() throws InputMismatchException {
        // if the list is empty, return
        if (count == 0) {
            System.out.println("No student. Select option 1 to create");
        }
        // else, find the student's index in the array
        else {
            System.out.println("Enter the student's id you want to update: ");
            int targetId = sc.nextInt();
            sc.nextLine();
            // if no data, return
            int targetIdx = getIndexById(targetId);
            if (targetIdx == -1) {
                System.out.println("No data");
            }
            // if exists, modify
            else {
                System.out.println("Which field would you like to modify? ");
                System.out.println("1. Name");
                System.out.println("2. Date of birth");
                System.out.println("3. Address");
                System.out.println("4. Height");
                System.out.println("5. Weight");
                System.out.println("6. Student ID");
                System.out.println("7. School");
                System.out.println("8. Year of study");
                System.out.println("9. CPA");
                int opt = sc.nextInt();
                sc.nextLine();
                switch (opt) {
                    case 1 -> {
                        inputName();
                        studentArray[targetIdx].setName(name);
                    }
                    case 2 -> {
                        inputDateOfBirth();
                        studentArray[targetIdx].setDateOfBirth(dateOfBirth);
                    }
                    case 3 -> {
                        inputAddress();
                        studentArray[targetIdx].setAddress(address);
                    }
                    case 4 -> {
                        inputHeight();
                        studentArray[targetIdx].setHeight(height);
                    }
                    case 5 -> {
                        inputWeight();
                        studentArray[targetIdx].setWeight(weight);
                    }
                    case 6 -> {
                        inputStudentId();
                        studentArray[targetIdx].setStudentId(studentId);
                    }
                    case 7 -> {
                        inputSchool();
                        studentArray[targetIdx].setSchool(school);
                    }
                    case 8 -> {
                        inputYearOfStudy();
                        studentArray[targetIdx].setYearOfStudy(yearOfStudy);
                    }
                    case 9 -> {
                        inputCpa();
                        studentArray[targetIdx].setCpa(cpa);
                    }
                }
                System.out.println("The student's data after being updated is: " + studentArray[targetIdx]);
            }
        }
    }

    // option 4
    public void deleteById() {
        // if the list is empty, return
        if (count == 0) {
            System.out.println("No student. Select option 1 to create");
        }
        // else, find the student's index in the array
        else {
            System.out.println("Enter the student's id you want to delete: ");
            int targetId = sc.nextInt();
            sc.nextLine();
            // if no data, return
            int targetIdx = getIndexById(targetId);
            if (targetIdx == -1) {
                System.out.println("No data");
            }
            // if exists, delete
            else {
                Student deletedStudent = studentArray[targetIdx];
                studentArray[targetIdx] = null;
                count--;
                // update id
                for (int i = targetIdx; i < count; i++) {
                    studentArray[i] = studentArray[i + 1];
                    int currentId = studentArray[i].getId();
                    studentArray[i].setId(--currentId);
                }
                People.setCount(People.getCount() - 1);
                System.out.println("Deleted " + deletedStudent);
            }
        }
    }

    // option 5
    public void showRankPercent() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentArrayList.add(studentArray[i]);
        }
        // if the list is empty, return
        if (studentArrayList.isEmpty()) {
            System.out.println("No student. Select option 1 to create");
        } else {
            // create an object with fields (String) rankName, (Integer) quantity
            class RankQuantity implements Comparable<RankQuantity> {
                AcademicRank rank;
                Integer quantity;

                public RankQuantity(AcademicRank rank) {
                    super();
                    this.rank = rank;
                    this.quantity = 0;
                }

                public Integer getQuantity() {
                    return quantity;
                }

                public AcademicRank getRank() {
                    return rank;
                }

                @Override
                public int compareTo(RankQuantity o) {
                    return this.quantity.compareTo(o.quantity);
                }
            }
            RankQuantity poor = new RankQuantity(AcademicRank.POOR);
            RankQuantity weak = new RankQuantity(AcademicRank.WEAK);
            RankQuantity average = new RankQuantity(AcademicRank.AVERAGE);
            RankQuantity good = new RankQuantity(AcademicRank.GOOD);
            RankQuantity veryGood = new RankQuantity(AcademicRank.VERY_GOOD);
            RankQuantity excellent = new RankQuantity(AcademicRank.EXCELLENT);
            for (Student student : studentArrayList) {
                if (student.getRank().equals(AcademicRank.POOR)) {
                    poor.quantity++;
                } else if (student.getRank().equals(AcademicRank.WEAK)) {
                    weak.quantity++;
                } else if (student.getRank().equals(AcademicRank.AVERAGE)) {
                    average.quantity++;
                } else if (student.getRank().equals(AcademicRank.GOOD)) {
                    good.quantity++;
                } else if (student.getRank().equals(AcademicRank.VERY_GOOD)) {
                    veryGood.quantity++;
                } else {
                    excellent.quantity++;
                }
            }
            // create an arraylist of the previous object
            ArrayList<RankQuantity> al = new ArrayList<>();
            al.add(poor);
            al.add(weak);
            al.add(average);
            al.add(good);
            al.add(veryGood);
            al.add(excellent);
            // sort arraylist in desc order by object's value
            for (int i = 0; i < al.size() - 1; i++) {
                for (int j = i; j < al.size(); j++) {
                    if (al.get(i).compareTo(al.get(j)) < 0) {
                        Collections.swap(al, i, j);
                    }
                }
            }
            // print
            for (RankQuantity rankQuantity : al) {
                float percent = (float) rankQuantity.getQuantity() / studentArrayList.size() * 100;
                if (percent != 0.0) {
                    System.out.println(rankQuantity.getRank().name() + ": " + percent + "%");
                }
            }
        }
    }

    // option 6
    public void showCpaPercent() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentArrayList.add(studentArray[i]);
        }
        // if the list is empty, return
        if (studentArrayList.isEmpty()) {
            System.out.println("No student. Select option 1 to create");
        } else {
            // create hashmap to store cpa and occurrence
            TreeMap<Double, Integer> map = new TreeMap<>();
            // iterate through studentArrayList to update hashmap
            for (Student student : studentArrayList) {
                Double studentCpa = student.getCpa();
                // // if no record, set value to 1
                if (!map.containsKey(studentCpa)) {
                    map.put(studentCpa, 1);
                }
                // // else. value++
                else {
                    map.put(studentCpa, map.get(studentCpa) + 1);
                }
            }
            // print
            for (Map.Entry<Double, Integer> element : map.entrySet()) {
                System.out.println(
                        element.getKey() + ": " + ((float) element.getValue() / studentArrayList.size()) * 100 + "%");
            }
        }
    }

    // option 7
    public void showMenu7() {
        System.out.println("Academic ranks: ");
        System.out.println("1. Excellent");
        System.out.println("2. Very good");
        System.out.println("3. Good");
        System.out.println("4. Average");
        System.out.println("5. Weak");
        System.out.println("6. Poor");
    }

    public int inputOption7() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    public void showStudentsByRank() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentArrayList.add(studentArray[i]);
        }
        // if the list is empty, return
        if (studentArrayList.isEmpty()) {
            System.out.println("No student. Select option 1 to create");
        }
        // else, ask user for the rank they are looking forward to
        else {
            showMenu7();
            int opt = inputOption7();
            sc.nextLine();
            String targetRank = "";
            switch (opt) {
                case 1 -> targetRank = "excellent";
                case 2 -> targetRank = "very_good";
                case 3 -> targetRank = "good";
                case 4 -> targetRank = "average";
                case 5 -> targetRank = "weak";
                case 6 -> targetRank = "poor";
                default -> {
                }
            }
            // // traverse through the list to find the answer
            // // // if there is at least a record, print student
            boolean foundAStudent = false;
            for (Student student : studentArrayList) {
                if (student.getRank().name().equalsIgnoreCase(targetRank)) {
                    foundAStudent = true;
                    System.out.println(student);
                }
            }
            // // // if cannot find any student, return
            if (!foundAStudent) {
                System.out.println("No student in this rank");
            }

        }
    }

    // write file
    public void writeFile() throws IOException {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentArrayList.add(studentArray[i]);
        }
        if (!studentArrayList.isEmpty()) {
            File output = new File("output.txt");
            FileWriter fileWriter = new FileWriter(output);
            for (Student student : studentArrayList) {
                fileWriter.write(student.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
    }
}
