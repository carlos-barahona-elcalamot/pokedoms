package com.ieselcalamot;

public class Pokedom {
    private String nombre;
    private String familia;
    private float ataque;
    private float defensa;

    Pokedom(String nombre, String familia) {
        this(nombre,familia,0f,0f);
    }

    Pokedom(String nombre, String familia, float ataque, float defensa) {
        this.nombre=nombre;
        this.familia=familia;
        this.ataque=ataque;
        this.defensa=defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public float getAtaque() {
        return ataque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getDefensa() {
        return defensa;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

}
