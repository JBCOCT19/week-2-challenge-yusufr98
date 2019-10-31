package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static String[] rice = {"white rice", "brown rice", "no rice", "all rice"};
    private static String[] meat = {"chicken", "steak", "carnitas", "chorizo", "sofritas", "veggies", "no meat"};
    private static String[] beans = {"pinto beans", "black beans", "no beans"};
    private static String[] salsa = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
    private static String[] veggies = {"lettuce", "fajita veggies", "no veggies", "all veggies"};
    private static String[][] ing = {rice, meat, beans, salsa, veggies};
    private static int wRice = 0, bRice = 0, chick = 0, steak = 0, carn = 0, cho = 0, sof = 0, veg = 0, bBeans = 0, pBeans = 0, mild = 0, medium = 0, hot = 0;
    private static int fajita = 0, lettuce = 0, che = 0, gua = 0, que = 0, sc = 0;
    private static int[] allCounts={wRice, bRice, chick, steak, carn, cho, sof, veg, bBeans, pBeans, mild, medium, hot, fajita, lettuce, che, gua, que, sc};
    private static String[] allStrings={"white rice", "brown rice","chicken", "steak", "carnitas", "chorizo", "sofritas", "veggies(as meat)", "black beans", "pinto beans",
            "mild salsa", "medium salsa", "hot salsa", "fajita veggies", "lettuce","cheese", "guac", "queso", "sour cream"};
    private static double total = 0;
    private static boolean cheese, guac, queso, sourCream;
    private static boolean[] options = {cheese, guac, queso, sourCream};
    private static String[] optText = {"cheese", "guac", "queso", "sour cream"};
    private static Random r = new Random();

    public static void main(String[] args) {
        for (int i = 1; i <= 25; i++) {
            order(i);
        }
        System.out.print("This order has ");
        for (int i = 0; i < allCounts.length; i++) {
            System.out.print(allCounts[i] + " " + allStrings[i] + ", ");
        }
        System.out.println("and the sum is " + total + "0");
    }

    private static void order(int n) {
        System.out.print("Burrito " + n + ": ");
        double cost = 3.00;
        ArrayList<String> order = new ArrayList<>();
        for (String[] strings : ing) {
            String s = strings[r.nextInt(strings.length)];
            order.add(s);
            if (!s.contains("no")) {
                cost += .50;
            }
        }
        for (int i = 0; i < options.length; i++) {
            options[i] = r.nextBoolean();
            if (options[i]) {
                order.add(optText[i]);
                cost += .50;
            }
        }
        for (String s : order) {
            count(s);
            System.out.print(s + ", ");
        }
        System.out.println("$" + cost + "0");
        total+=cost;
    }

    private static void count(String s) {
        switch (s){
            case "white rice": allCounts[0]++; break;
            case "brown rice": allCounts[1]++; break;
            case "all rice": allCounts[0]++; allCounts[1]++; break;
            case "chicken": allCounts[2]++; break;
            case "carnitas": allCounts[4]++; break;
            case "steak": allCounts[3]++; break;
            case "chorizo": allCounts[5]++; break;
            case "sofritas": allCounts[6]++; break;
            case "veggies": allCounts[7]++; break;
            case "black beans": allCounts[8]++; break;
            case "pinto beans": allCounts[9]++; break;
            case "mild salsa": allCounts[10]++; break;
            case "medium salsa": allCounts[11]++; break;
            case "hot salsa": allCounts[12]++; break;
            case "all salsa": allCounts[10]++; allCounts[11]++; allCounts[12]++; break;
            case "fajitas": allCounts[13]++; break;
            case "lettuce": allCounts[14]++; break;
            case "all veggies": allCounts[14]++; allCounts[13]++; break;
            case "cheese": allCounts[15]++; break;
            case "guac": allCounts[16]++; break;
            case "sour cream": allCounts[18]++; break;
            case "queso": allCounts[17]++; break;
        }
    }
}


