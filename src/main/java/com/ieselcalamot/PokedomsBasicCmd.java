package com.ieselcalamot;

public class PokedomsBasicCmd {

    public static void main(String[] args) {
        String noms[] = new String[] {
                "Kandentium",
                "Demantima",
                "Eufrotructon",
                "Jokisuba"
        };

        String families[] = new String[] {
                "fuego",
                "tierra",
                "aire",
                "agua"
        };

        float atacs[] = new float[] { 7.4f, 7.5f, 0.6f, 7 };

        float defenses[] = new float[] { 2.6f, 2.5f, 9.4f, 3 };

        Pokedom lista[] = new Pokedom[noms.length];
        for (int i = 0; i < noms.length; i++) {
            lista[i] = new Pokedom(noms[i], families[i], atacs[i], defenses[i]);
        }

        PokedomsDb db = new PokedomsDb(lista);
        Pokedom pokedomDemanat=db.describe(args[0]);
        if (pokedomDemanat!=null) {
            System.out.println("Nom: "+pokedomDemanat.getNombre());
            System.out.println("Familía: "+pokedomDemanat.getFamilia());
            System.out.println("Atac: "+pokedomDemanat.getAtaque());
            System.out.println("Defensa: "+pokedomDemanat.getDefensa());
        } else {
            System.out.println("No conec aquest Pokedom.");
        }
    }
}
