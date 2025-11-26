package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Jollibee extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Jollibee(){
        super("Jollibee", 150, 100, 13);
        this.title = "The Bee of Victory!";
        this.backstory = "Jollibee is the lively and spirited mascot who prides himself on showing that fast food can win hearts.";
        this.basicAttack = yellow + "Chicken Joy Slap" + reset + " – Deals 16-22 damage";
        this.skillAttack = yellow + "Spaghetti ni Sir Khai" + reset + " – Deals 24-32 damage";
        this.ultimateAttack = yellow + "Bida Ang Saya!" + reset + " – Deals 38-48 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 16, 22, 0, "Chicken Joy Slap");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 24, 32, 30, "Spaghetti ni Sir Khai");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 38, 48, 50, "Bida Ang Saya!");
    }

    public void rest(Character target) {
        performAttack(target, -40, -40, 0, "Rest");
    }
}
