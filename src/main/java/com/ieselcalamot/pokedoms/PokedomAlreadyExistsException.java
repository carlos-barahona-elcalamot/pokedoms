package com.ieselcalamot.pokedoms;

public class PokedomAlreadyExistsException extends Exception {
    public PokedomAlreadyExistsException(String nombrePokedom) {
        super("Pokedom "+nombrePokedom+" already exists. Try changing its name.");
    }
}
