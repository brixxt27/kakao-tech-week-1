package org.example.domain;

public class User {
    private int money;
    private int monsterCount;

    public synchronized void levelUp(Creature creature) {
        int currentLevel = creature.getLevel();
        if (currentLevel == creature.getMaxLevel()) {
            // 에러 처리
        }
        creature.setLevel(currentLevel + 1);
    }

    public synchronized void buyMonster(Creature creature) {
        int price = creature.getPrice();
    }

    public void quit() {
        // 프로그램 종료
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }
}
