package com.ieselcalamot;

import java.io.File;
import java.io.IOException;

import com.ieselcalamot.pokedoms.FileFormatException;
import com.ieselcalamot.pokedoms.Pokedom;
import com.ieselcalamot.pokedoms.PokedomAlreadyExistsException;
import com.ieselcalamot.pokedoms.PokedomsDb;
import com.ieselcalamot.pokedoms.UnknownPokedomException;

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

        PokedomsDb db = null;
        try {
            db = new PokedomsDb(new File(args[0]));
        } catch (IOException e) {
            System.out.println("ERROR: cannot accés database file.");
            e.printStackTrace();
            System.exit(1);
        } catch (FileFormatException e) {
            System.out.println("ERROR: format error in the database file.");
            e.printStackTrace();
            System.exit(2);
        }
        switch (args[1].toLowerCase()) {
            case "describe":
                Pokedom pokedomDemanat;
                try {
                    pokedomDemanat = db.find(args[2]);
                    System.out.println(pokedomDemanat);
                } catch (UnknownPokedomException e) {
                    System.out.println("ERROR: pokedom desconegut.");
                    e.printStackTrace();
                }
                break;
            case "add":
                Pokedom nuevPokedom = new Pokedom(args[2], args[3]);
                if (args.length >= 5 && args.length < 7) {
                    nuevPokedom.setAtaque(Float.parseFloat(args[4]));
                    if (args.length == 6) {
                        nuevPokedom.setDefensa(Float.parseFloat(args[5]));
                    }

                } else {
                    System.out.println("ERROR: incorrect number of arguments.");
                    System.exit(2);
                }
                try {
                    db.addPokedom(nuevPokedom);
                } catch (IOException e) {
                    System.out.println("ERROR: cannot write to database");
                    e.printStackTrace();
                    System.exit(3);
                } catch (PokedomAlreadyExistsException e) {
                    System.out.println("ERROR: this pokedom already exist. Try changing its name.");
                    e.printStackTrace();
                    System.exit(3);
                }
                break;

            default:
                System.out.println("ERROR: comanda desconeguda.");
                break;
        }
    }
}
