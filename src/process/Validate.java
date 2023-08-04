package process;

import java.time.LocalDate;
import model.*;
import static constant.StudentConstants.*;
import static constant.PeopleConstants.*;

// check if the passed parameters are appropriate to create an instance
public class Validate {
    // // name
    public boolean isValidName(String name) {
        if (name == null || name.equals("") || name.length() >= MAX_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    // // date of birth
    public boolean isValidDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.getYear() < MIN_YEAR_OF_BIRTH) {
            return false;
        }
        return true;
    }

    // // address
    public boolean isValidAddress(String address) {
        if (address.length() >= MAX_ADDRESS_LENGTH) {
            return false;
        }
        return true;
    }

    // // height
    public boolean isValidHeight(Double height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            return false;
        }
        return true;
    }

    // // weight
    public boolean isValidWeight(Double weight) {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            return false;
        }
        return true;
    }

    // // student id
    public boolean isValidStudentId(String studentId) {
        // regex represent 10-integer-sequence
        String reg = "^\\d{10}$";
        if (studentId == null || studentId.equals("") || !studentId.matches(reg) || Student.getHt().containsKey(studentId)) {
            return false;
        }
        return true;
    }

    // // school
    public boolean isValidSchool(String school) {
        if (school == null || school.equals("") || school.length() >= MAX_SCHOOL_LENGTH) {
            return false;
        }
        return true;
    }

    // // year of study
    public boolean isValidYearOfStudy(Integer yearOFStudy) {
        if (yearOFStudy == null || yearOFStudy < MIN_YEAR_OF_STUDY || yearOFStudy > 9999) {
            return false;
        }
        return true;
    }

    // // cpa
    public boolean isValidCpa(Double cpa) {
        if (cpa < MIN_CPA || cpa > MAX_CPA) {
            return false;
        }
        return true;
    }
}









