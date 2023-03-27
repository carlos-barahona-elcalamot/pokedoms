package com.ieselcalamot.pokedoms;

public class Pokedom {
    private String nombre;
    private String familia;
    private float ataque;
    private float defensa;

    public Pokedom(String nombre, String familia) {
        this(nombre,familia,0f,0f);
    }

    public Pokedom(String nombre, String familia, float ataque, float defensa) {
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

    @Override
    public String toString() {
        return getNombre().toUpperCase()+"\nFamily: "+getFamilia()+"\nAttack power: "+getAtaque()+"\nDefense power: "+getDefensa()+"\n";
    }

}
