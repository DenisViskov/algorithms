package com.company.dynamicProgramming;

import java.util.Objects;

public class Attraction {
    private final String name;
    private final Double timeInDays;
    private final int grade;

    public Attraction(String name, Double timeInDays, int grade) {
        this.name = name;
        this.timeInDays = timeInDays;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public Double getTimeInDays() {
        return timeInDays;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return grade == that.grade && name.equals(that.name) && timeInDays.equals(that.timeInDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timeInDays, grade);
    }
}
