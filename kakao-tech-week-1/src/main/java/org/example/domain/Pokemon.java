package org.example.domain;

public class Pokemon extends Creature {
    final private int earningRate; // 기본값 1
    final private int earningInterval; // 기본값 1
    protected int moneyPerSecond = 1;

    public Pokemon(String name, int price) {
        super(name, price);
        this.earningRate = 1;
        this.earningInterval = 1;
    }

    public int getEarningInterval() {
        return earningInterval;
    }

    public int getEarningRate() {
        return earningRate;
    }

    public void earnMoney(/* User user */) {
        // User와 상호 작용해서 돈을 번다.
        // earningInterval 마다 earningRate * level * moneyPerSecond
        int money = this.earningRate * this.level * this.moneyPerSecond;
    }
}
