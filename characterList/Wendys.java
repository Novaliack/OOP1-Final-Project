package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Wendys extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Wendys() {
        super("Wendy's", 130, 75, 10);
        this.title = "Fresh, Never Frozen!";
        this.backstory = "Wendy's focuses on precision and the ability to outlast opponents with a balance of healing and damage.";
        this.basicAttack = yellow + "Burger Bash" + reset + " – Deals 18-26 damage";
        this.skillAttack = yellow + "Spicy Nugget Storm" + reset + " – Deals 25-33 damage";
        this.ultimateAttack = yellow + "Quality Is Our Recipe" + reset + " – Deals 40-52 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 18, 26, 0, "Burger Bash");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 33, 30, "Spicy Nugget Storm");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 52, 50, "Quality Is Our Recipe");
    }

    public void rest(Character target) {
        performAttack(target, -35, -35, 0, "Rest");
    }
}
