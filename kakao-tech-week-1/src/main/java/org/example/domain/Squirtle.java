package org.example.domain;

public class Squirtle extends Pokemon implements Runnable {
    private final PokemonType pokemonType = PokemonType.SQUIRTLE;
    private final User user;

    public Squirtle(String name, int price, User user) {
        super(name, price);
        this.moneyPerSecond = 1;
        this.user = user;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public int getPointOfLevelUp() {
        return 10;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.getEarningInterval());
                earnMoney(user);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
