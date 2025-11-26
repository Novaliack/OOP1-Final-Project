package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class TacoBell extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public TacoBell() {
        super("Taco Bell", 100, 90, 12);
        this.title = "Live Mas, Battle Harder!";
        this.backstory = "Taco Bell brings the heat with his spicy, unpredictable nature. Quick bursts of damage keep his enemies on their toes.";
        this.basicAttack = yellow + "Taco Toss" + reset + " – Deals 20-26 damage";
        this.skillAttack = yellow + "Bellstorm" + reset + " – Deals 30-38 damage";
        this.ultimateAttack = yellow + "Live Mas" + reset + " – Deals 45-58 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 20, 26, 0, "Taco Toss");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 30, 38, 30, "Bellstorm");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 45, 58, 50, "Live Mas");
    }

    public void rest(Character target) {
        performAttack(target, -25, -25, 0, "Rest");
    }
}
