package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Wendys extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Wendys() {
        super("Wendy's", 140, 70, 5);

        this.title = "Fresh, Never Frozen!";
        this.backstory = "Wendy’s focuses on precision and the ability to outlast opponents with a balance of healing and damage.";

        this.basicAttack = yellow + "Burger Bash" + reset + " – Moderate damage, 15% chance to cause bleeding.";
        this.skillAttack = yellow + "Spicy Nugget Storm" + reset + " – Reduces enemy defense by 10%.";
        this.ultimateAttack = yellow + "Frosty Freeze" + reset + " – Massive damage and heals herself.";
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
        performAttack(target, 40, 52, 55, "Frosty Freeze");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}
