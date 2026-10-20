package Inheritance;
import Interfaces.Playable;

public class Pianist extends Musician implements Playable {
    private String pianoType;
    private String techniqueLevel;

    public Pianist(String name, int age, int experienceYear, double monthlyFee,
                   Instructor instructor, String pianoType, String techniqueLevel) {
        super(name, age, experienceYear, monthlyFee, instructor);
        this.pianoType = pianoType;
        this.techniqueLevel = techniqueLevel;
    }

    public String getPianoType() {
        return pianoType;
    }

    public String getTechniqueLevel() {
        return techniqueLevel;
    }

    @Override
    public void perform() {
        System.out.println(getName() + " is performing as a pianist.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing the piano.");
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nInstrument: Piano" +
               "\nPiano Type: " + pianoType +
               "\nTechnique Level: " + techniqueLevel;
    }
}