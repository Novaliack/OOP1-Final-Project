package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Julies extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Julies() {
        super("Julie's", 110, 85, 12);
        this.title = "Freshly Baked, Fiercely Battle-Ready!";
        this.backstory = "Julie spreads joy through baked goods that can heal and harm with magic frosting.";
        this.basicAttack = yellow + "Ensaymada" + reset + " – Deals 19-25 damage";
        this.skillAttack = yellow + "Pan De Leche" + reset + " – Deals 28-36 damage";
        this.ultimateAttack = yellow + "Basta Julie's Fresh Yan" + reset + " – Deals 43-55 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 19, 25, 0, "Ensaymada");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 28, 36, 30, "Pan De Leche");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 43, 55, 50, "Basta Julie's Fresh Yan");
    }

    public void rest(Character target) {
        performAttack(target, -30, -30, 0, "Rest");
    }
}
