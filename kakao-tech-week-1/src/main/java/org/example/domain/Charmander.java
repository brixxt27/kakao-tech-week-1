package org.example.domain;

public class Charmander extends Pokemon{
    final private PokemonType pokemonType = PokemonType.CHARMANDER;

    public Charmander(String name, int price) {
        super(name, price);
        this.moneyPerSecond = 100;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public int getPointOfLevelUp() {
        return 100;
    }
}
