package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class ColonelSanders extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public ColonelSanders() {
        super("Colonel Sanders", 180, 50, 9);
        this.title = "Finger Lickin' Good Combat!";
        this.backstory = "KFC brings the heat with his secret recipe of abilities, offering a mix of high-damage attacks and powerful debuffs.";
        this.basicAttack = yellow + "Kentucky's Best Punch" + reset + " – Deals 18-22 damage";
        this.skillAttack = yellow + "Colonel's Spice Shot" + reset + " – Deals 25-32 damage";
        this.ultimateAttack = yellow + "Finger Lickin Good" + reset + " – Deals 40-50 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 18, 22, 0, "Kentucky's Best Punch");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 32, 30, "Colonel's Spice Shot");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 50, 50, "Finger Lickin Good");
    }

    public void rest(Character target) {
        performAttack(target, -40, -40, 0, "Rest");
    }
}
