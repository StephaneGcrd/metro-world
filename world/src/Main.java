import world.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to metro world!");

        Line ligne1 = new Line(1);
        ligne1.addStation(new Station("Reuilly-diderot", 10));
        ligne1.addStation(new Station("Chatelet", 40));
        System.out.println(ligne1.toString());
    }
}