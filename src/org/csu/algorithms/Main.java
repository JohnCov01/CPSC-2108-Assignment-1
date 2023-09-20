package org.csu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        SubwayRoute city = new SubwayRoute();
        String[][] subwayMap = {
                {"", "", "", "", "", "Germania", "", "Gu", ""},
                {"", "", "", "", "", "19", "", "Santiago", ""},
                {"", "", "", "", "", "Sabarna", "", "SENA", ""},
                {"140", "130", "Unicentro", "100", "30", "R", "Marsella", "Mu", "Bosa"},
                {"", "", "", "", "", "Esoec", "", "Timiza", ""},
                {"", "", "", "", "", "F", "", "", ""}};
        city.setSubwayMap(subwayMap);

        System.out.print("Please enter the station your starting at: ");
        String station1 = userInput.nextLine();
        city.setStop1(station1);
        city.findStop1Position();

        System.out.print("Please enter the station you want to go to: ");
        String station2 = userInput.nextLine();
        city.setStop2(station2);
        city.findStop2Position();

        System.out.println(city);
    }
}
