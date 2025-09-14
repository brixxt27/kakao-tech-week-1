package org.example.domain;

public class Squirtle extends Pokemon {
    final private PokemonType pokemonType = PokemonType.SQUIRTLE;

    public Squirtle(String name, int price) {
        super(name, price);
        this.moneyPerSecond = 1;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public int getPointOfLevelUp() {
        return 10;
    }
}
