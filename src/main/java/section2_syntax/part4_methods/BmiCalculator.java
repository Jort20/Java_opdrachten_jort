/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */
package section2_syntax.part4_methods;

import java.util.Scanner;

/**
 *
 * @author michiel
 */
public class BmiCalculator {
    private Scanner keyboard = new Scanner(System.in);

    /**
     * The string messages to accompany BMI categories
     */
    public static final String[] MESSAGES = new String[]{
            "Ondergewicht",
            "Gezond gewicht",
            "Overgewicht",
            "Obesitas",
            "Morbide Obesitas"
    };

    /**
     * Starting point of your application.
     *
     * @param args the CL args
     */
    public static void main(String[] args) {
        // Implement top-level logic such as fetching user input and creating a feedback message to user
        BmiCalculator bc = new BmiCalculator();
        double userHeight = bc.getUserHeight();
        double userWeight = bc.getUserWeight();
        double userBMI = bc.calculateBMI(userWeight, userHeight);
        String label = bc.getMessage(userBMI);

        // generate output to user
        System.out.printf("Your BMI is: %.2f. Category: %s%n", userBMI, label);
    }

    /**
     * Fetches the height of the user.
     *
     * @return height the height in meters
     */
    public double getUserHeight() {
        System.out.print("Please give your height, in meters (e.g. 1.84): ");
        String input = keyboard.nextLine();
        double height = 0;
        try {
            height = Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            System.out.println("This is not a valid number! Aborting...");
            System.exit(0);
        }
        return height;
    }

    /**
     * Fetches the weight of the user.
     *
     * @return weight the weight in kilograms
     */
    public double getUserWeight() {
        System.out.print("Please give your weight, in kilograms (e.g. 75.5): ");
        String input = keyboard.nextLine();
        double weight = 0;
        try {
            weight = Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            System.out.println("This is not a valid number! Aborting...");
            System.exit(0);
        }
        return weight;
    }

    /**
     * Returns the BMI given a weight in kilograms and a height in meters.
     *
     * @param weight the weight in kilograms
     * @param height the height in meters
     * @return bmi the body mass index
     * @throws IllegalArgumentException when illegal (zero or below) values are
     * provided for weight and/or height
     */
    public double calculateBMI(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Error: both weight and height should be above 0. Given: weight="
                    + weight + ", height=" + height);
        }
        // Gewicht in kilogram / (Lengte in meter * Lengte in meter)
        return weight / (height * height);
    }

    /**
     * Will return an appropriate String representation belonging to a given BMI.
     *
     * BMI index categories:
     *   < 18.5 Ondergewicht
     *   18.5 - 25.0 Gezond gewicht
     *   25.0 - 30.0 Overgewicht
     *   30.0 - 40.0 Obesitas
     *   > 40 Morbide Obesitas
     *
     * @param bmi the BMI
     * @return message
     * @throws IllegalArgumentException when illegal (zero or below) BMI value is provided
     */
    public String getMessage(double bmi) {
        if (bmi <= 0) {
            throw new IllegalArgumentException("Invalid BMI value: " + bmi);
        }

        if (bmi < 18.5) {
            return MESSAGES[0]; // Ondergewicht
        } else if (bmi < 25.0) {
            return MESSAGES[1]; // Gezond gewicht
        } else if (bmi < 30.0) {
            return MESSAGES[2]; // Overgewicht
        } else if (bmi < 40.0) {
            return MESSAGES[3]; // Obesitas
        } else {
            return MESSAGES[4]; // Morbide Obesitas
        }
    }
}
