package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class RonaldMcDonald extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public RonaldMcDonald() {
        super("Ronald McDonald", 135, 80, 15);
        this.title = "I'm Lovin' It, and You Will Too!";
        this.backstory = "McDonald's is the undisputed king of fast food, a place where comfort food reigns supreme.";
        this.basicAttack = yellow + "Big Mac Barrage" + reset + " – Deals 17-23 damage";
        this.skillAttack = yellow + "McFlurry Storm" + reset + " – Deals 26-34 damage";
        this.ultimateAttack = yellow + "I'm Lovin' It" + reset + " – Deals 41-51 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 17, 23, 0, "Big Mac Barrage");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 26, 34, 30, "McFlurry Storm");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 41, 51, 50, "I'm Lovin' It");
    }

    public void rest(Character target) {
        performAttack(target, -35, -35, 0, "Rest");
    }
}
