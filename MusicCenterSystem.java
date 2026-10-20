package MainAndSystem;
import java.util.ArrayList;
import java.util.HashSet;

import Inheritance.Pianist;
import Inheritance.Musician;
import Inheritance.Guitarist;

public class MusicCenterSystem {
    
    private static ArrayList<Musician> musicians = new ArrayList<>();
    private static HashSet<String> instruments = new HashSet<>();
    private static int totalMusicians = 0;


    public static void addMusician(Musician m) {
        musicians.add(m);
        totalMusicians++;

        if (m instanceof Guitarist) {
            instruments.add("Guitar");
        } else if (m instanceof Pianist) {
            instruments.add("Piano");
        }
    }

    public static boolean deleteMusician(int id) {
        for (int i = 0; i < musicians.size(); i++) {
            if (musicians.get(i).getMusicianID() == id) {
                musicians.remove(i);
                totalMusicians--;
                return true;
            }
        }
        return false;
    }

    public static Musician searchByName(String name) {
        for (Musician m : musicians) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public static Musician searchById(int id) {
        for (Musician m : musicians) {
            if (m.getMusicianID() == id) {
                return m;
            }
        }
        return null;
    }

    public static String displayAll() {
        StringBuilder result = new StringBuilder(); 

        for (Musician m : musicians) {
            result.append(m.toString());
            result.append("\n-----------------------------\n");
        }

        return result.toString();
    }
    
    public static Integer[] getAllIds() {
        Integer[] ids = new Integer[musicians.size()];
        for (int i = 0; i < musicians.size(); i++) {
            ids[i] = musicians.get(i).getMusicianID();
        }
        return ids;
    }

    public static double calculateTotalMonthlyRevenue() {
        double total = 0;
        for (Musician m : musicians) {
            total += m.getMonthlyFee();
        }
        return total;
    }

    public static int getTotalMusicians() {
        return totalMusicians;
    }

    public static String displayInstruments() {
        return instruments.toString();
    }
}