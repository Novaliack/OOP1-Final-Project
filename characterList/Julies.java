package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Julies extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Julies() {
        super("Julie's", 120, 40, 5);

        this.title = "Freshly Baked, Fiercely Battle-Ready!";
        this.backstory = "Julie spreads joy through baked goods that can heal and harm with magic frosting.";

        this.basicAttack = yellow + "Rolling Pin Rampage" + reset + " – Moderate damage and reduces speed.";
        this.skillAttack = yellow + "Pastry Pile-Up" + reset + " – Heavy damage, may stun.";
        this.ultimateAttack = yellow + "Cake Smash" + reset + " – Cake explosion causing damage over time.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 17, 23, 0, "Rolling Pin Rampage");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 35, 30, "Pastry Pile-Up");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 42, 50, 60, "Cake Smash");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}