package org.example.domain;

public class Pokemon extends Creature {
    final private int earningRate; // 기본값 1
    final private int earningInterval; // 기본값 1000ms
    protected int moneyPerSecond = 1;

    public Pokemon(String name, int price) {
        super(name, price);
        this.earningRate = 1;
        this.earningInterval = 1000;
    }

    public int getEarningInterval() {
        return earningInterval;
    }

    public int getEarningRate() {
        return earningRate;
    }

    protected void earnMoney(User user) {
        int point = this.earningRate * this.level * this.moneyPerSecond;
        user.increasePoint(point);
    }
}
