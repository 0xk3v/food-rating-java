package pl.foodrating.utils;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> options;

    public Menu() {
        options = new ArrayList<String>();
    }

    public void addOption(String option_name) {
        this.options.add(option_name);
    }

    public void display() {

        System.out.println("======================================");
        System.out.println("");

        for (int i = 0; i < this.options.size(); i++) {
            System.out.println((i + 1) + ". " + this.options.get(i));
        }

        System.out.println("");

    }

}
