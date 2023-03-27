package com.ieselcalamot.pokedoms;

public class UnknownPokedomException extends Exception {
    public UnknownPokedomException(String name) {
        super("Unkown pokedom: "+name);
    }
}
