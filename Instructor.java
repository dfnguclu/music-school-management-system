package Inheritance;

public class Instructor {
    private String instructorName;
    private String specialization;
    private String phone;

    public Instructor(String instructorName, String specialization, String phone) {
        this.instructorName = instructorName;
        this.specialization = specialization;
        this.phone = phone;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "\n------- Educator Information -------\n" +"Instructor Name: " + instructorName +
               "\nSpecialization: " + specialization +
               "\nPhone: " + phone;
    }
}