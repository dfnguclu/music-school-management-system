package Inheritance;
import Interfaces.Playable;

public class Guitarist extends Musician implements Playable {
    private String guitarType;
    private int fretCount;
    private String stringMaterial;

    public Guitarist(String name, int age, int experienceYear, double monthlyFee,
                     Instructor instructor, String guitarType, int fretCount, String stringMaterial) {
        super(name, age, experienceYear, monthlyFee, instructor);
        this.guitarType = guitarType;
        this.fretCount = fretCount;
        this.stringMaterial = stringMaterial;
    }

    public String getGuitarType() {
        return guitarType;
    }

    public int getFretCount() {
        return fretCount;
    }

    public String getStringMaterial() {
        return stringMaterial;
    }

    @Override
    public void perform() {
        System.out.println(getName() + " is performing as a guitarist.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing the guitar.");
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nInstrument: Guitar" +
               "\nGuitar Type: " + guitarType +
               "\nFret Count: " + fretCount +
               "\nString Material: " + stringMaterial;
    }
}