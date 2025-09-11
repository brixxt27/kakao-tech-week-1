package org.example.domain;

public class Creature {
    final private String name;
    protected int level;
    final private int price;
    final private int maxLevel = 10;

    public Creature(String name, int price) {
        this.name = name;
        this.level = 1;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
}
