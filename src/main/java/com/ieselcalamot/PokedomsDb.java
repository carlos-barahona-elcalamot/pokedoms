package com.ieselcalamot;

public class PokedomsDb {
    
    Pokedom pokedoms[];

    PokedomsDb(Pokedom[] listaPokedoms) {
        pokedoms=listaPokedoms;
    }

    Pokedom describe(String nombrePokedom) {
        Pokedom elPokedom=null;

        for(Pokedom p: pokedoms) {
            if (p.getNombre().equalsIgnoreCase(nombrePokedom))
                elPokedom=p;
        }

        return elPokedom;
    }
}
