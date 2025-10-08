package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Julies extends Character {
    public Julies() {
        super("Julie's", 120, 40, 5);

        this.title = "Freshly Baked, Fiercely Battle-Ready!";
        this.backstory = "Julie spreads joy through baked goods that can heal and harm with magic frosting.";

        this.basicAttack = "Rolling Pin Rampage – Moderate damage and reduces speed.";
        this.skillAttack = "Pastry Pile-Up – Heavy damage, may stun.";
        this.ultimateAttack = "Cake Smash – Cake explosion causing damage over time.";
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
}