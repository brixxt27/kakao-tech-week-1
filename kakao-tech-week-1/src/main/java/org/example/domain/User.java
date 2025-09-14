package org.example.domain;

public class User {
    private int point;
    private int monsterCount;

    public User() {
        point = 0;
        monsterCount = 0;
    }
    public synchronized int getPoint() {
        return point;
    }

    public synchronized void usePoint(int point) {
        this.point -= point;
    }

    public synchronized void increasePoint(int point) {
        this.point += point;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }
}
