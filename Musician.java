package Inheritance;
public abstract class Musician {
    private int musicianID;
    private String name;
    private int age;
    private int experienceYear;
    private double monthlyFee;
    private Instructor instructor;

    private static int nextId = 1;

    public Musician(String name, int age, int experienceYear, double monthlyFee, Instructor instructor) {
        this.musicianID = generateId();
        this.name = name;
        this.age = age;
        this.experienceYear = experienceYear;
        this.monthlyFee = monthlyFee;
        this.instructor = instructor;
    }

    public static int generateId() {
        return nextId++;
    }

    public abstract void perform();

    public String getExperienceLevel() {
        if (experienceYear < 2) {
            return "Beginner";
        } else if (experienceYear <= 5) {
            return "Intermediate";
        } else {
            return "Advanced";
        }
    }

    public int getMusicianID() {
        return musicianID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return 
        		"======= ACADEMY STUDENT ENROLLMENT =======\n" +
        		"Musician ID: " + musicianID +
               "\nName: " + name +
               "\nAge: " + age +
               "\nExperience Year: " + experienceYear +
               "\nExperience Level: " + getExperienceLevel() +
               "\nMonthly Fee: " + monthlyFee +
               "\n" + instructor.toString();
    }
}