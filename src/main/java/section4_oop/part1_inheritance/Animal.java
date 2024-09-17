/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section4_oop.part1_inheritance;

/**
 *
 * @author Michiel Noback [michiel.noback@gmail.com]
 * @version 0.0.1
 */
public abstract class Animal {
    protected String name;
    protected double maxSpeed; // Maximum speed in km/h
    protected int maxAge; // Maximum age in years
    protected String movementType;
    protected int currentAge;

    public Animal(String name, double maxSpeed, int maxAge, String movementType, int currentAge) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxAge = maxAge;
        this.movementType = movementType;
        setAge(currentAge); // Ensures valid age
    }

    public String getName() {
        return name;
    }

    public String getMovementType() {
        return movementType;
    }

    public double getSpeed() {
        return maxSpeed * (0.5 + 0.5 * ((maxAge - currentAge) / (double) maxAge));
    }

    public void setAge(int age) {
        if (age < 0 || age > maxAge) {
            throw new IllegalArgumentException("maximum age of Mouse is " + maxAge + " years. Please give new values");
        }
        this.currentAge = age;
    }
}
