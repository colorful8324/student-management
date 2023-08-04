package model;

import java.time.LocalDate;
import java.util.HashMap;

public class Student extends People {
    private static HashMap<String, Integer> ht = new HashMap<>();
    //	- Sinh viên kế thừa Người, gồm thêm các thông tin:
//        + Mã sinh viên - Chuỗi 10 kí tự không trùng, không null
//        + Trường đang theo học - chuỗi < 200 kí tự, không null
//        + Năm bắt đầu học đại học: số 4 chữ số từ 1900, không null
//        + Điểm trung bình tích luỹ - từ 0.0 đến 10.0"
    private String studentId;
    private String school;
    private Integer yearOfStudy;
    private Double cpa;
    private AcademicRank rank;

    public Student(String name, LocalDate dateOfBirth, String address, Double height, Double weight,
                   String studentId, String school, Integer yearOfStudy, Double cpa) {
        super(name, dateOfBirth, address, height, weight);
        this.studentId = studentId;
        ht.put(studentId, 1);
        this.school = school;
        this.yearOfStudy = yearOfStudy;
        this.cpa = cpa;
        academicRank();
    }

    public static HashMap<String, Integer> getHt() {
        return ht;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Double getCpa() {
        return cpa;
    }

    public void setCpa(Double cpa) {
        this.cpa = cpa;
        academicRank();
    }

    public AcademicRank getRank() {
        return rank;
    }

    public void academicRank() {
        if (cpa < 3) {
            rank = AcademicRank.POOR;
        } else if (cpa >= 3 && cpa < 5) {
            rank = AcademicRank.WEAK;
        } else if (cpa >= 5 && cpa < 6.5) {
            rank = AcademicRank.AVERAGE;
        } else if (cpa >= 6.5 && cpa < 7.5) {
            rank = AcademicRank.GOOD;
        } else if (cpa >= 7.5 && cpa < 9) {
            rank = AcademicRank.VERY_GOOD;
        } else {
            rank = AcademicRank.EXCELLENT;
        }
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", school=" + school + ", yearOfStudy=" + yearOfStudy + ", cpa="
                + cpa + ", rank=" + rank + ", " + super.toString() + "]";
    }


}
