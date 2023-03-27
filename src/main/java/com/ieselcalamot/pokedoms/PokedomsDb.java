package com.ieselcalamot.pokedoms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PokedomsDb {
    
    final ArrayList<Pokedom> pokedoms=new ArrayList<Pokedom>();
    final File databaseFile;


    public PokedomsDb(File databaseFile) throws IOException, FileFormatException {
        if (! databaseFile.exists()) {
            databaseFile.createNewFile();
            this.databaseFile=databaseFile;
            // TODO: maybe throw unchecked exception to warn program that a new database file has been created.
        } else {
            this.databaseFile=databaseFile;
            readDatabase();
        }
    }

    private void readDatabase() throws IOException, FileFormatException {
        if (databaseFile == null)
            throw new IOException("Database file not initialized.");
        BufferedReader reader=new BufferedReader(new FileReader(databaseFile));
        String line=reader.readLine();
        while (line!=null) {
            String[] pkInfo=line.split(" ");
            if (pkInfo.length != 4) {
                reader.close();
                throw new FileFormatException();
            }
            pokedoms.add(new Pokedom(pkInfo[0], pkInfo[1], Float.parseFloat(pkInfo[2]), Float.parseFloat(pkInfo[3])));
            line=reader.readLine();
        }
        reader.close();
    }

    public void addPokedom(Pokedom unPokedom) throws IOException, PokedomAlreadyExistsException {
        try {
            find(unPokedom.getNombre());
            throw new PokedomAlreadyExistsException(unPokedom.getNombre());
        } catch (UnknownPokedomException e) {
            pokedoms.add(unPokedom);
            PrintWriter writer=null;
            try {
                writer=new PrintWriter(new FileWriter(databaseFile, true));
                writer.println(unPokedom.getNombre()+" "+unPokedom.getFamilia()+" "+unPokedom.getAtaque()+" "+unPokedom.getDefensa());
            } catch (FileNotFoundException e2) {
                throw new InternalError("Database file not created.");
            } finally {
                if (writer != null) writer.close();

            }   
        }
    }

    public Pokedom find(String nombrePokedom) throws UnknownPokedomException {
        Pokedom elPokedom=null;

        for(Pokedom p: pokedoms) {
            if (p.getNombre().equalsIgnoreCase(nombrePokedom))
                elPokedom=p;
        }

        if (elPokedom==null) {
            throw new UnknownPokedomException(nombrePokedom);
        }

        return elPokedom;
    }
}
