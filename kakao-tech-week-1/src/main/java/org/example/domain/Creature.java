package org.example.domain;

public class Creature {
    final private String name;
    protected int level;
    final private int price;

    public Creature(String name, int price) {
        this.name = name;
        this.level = 1;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public synchronized int getLevel() {
        return level;
    }

    public synchronized void levelUp() {
        level++;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxLevel() {
        return 10;
    }
}
