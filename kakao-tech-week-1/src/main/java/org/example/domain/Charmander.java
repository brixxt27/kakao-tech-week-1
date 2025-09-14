package org.example.domain;

public class Charmander extends Pokemon implements Runnable{
    private final PokemonType pokemonType = PokemonType.CHARMANDER;
    private final User user;

    public Charmander(String name, int price, User user) {
        super(name, price);
        this.moneyPerSecond = 100;
        this.user = user;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public int getPointOfLevelUp() {
        return 100;
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
