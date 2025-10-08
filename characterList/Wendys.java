package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Wendys extends Character {
    public Wendys() {
        super("Wendy's", 140, 50, 5);

        this.title = "Fresh, Never Frozen!";
        this.backstory = "Wendy’s focuses on precision and the ability to outlast opponents with a balance of healing and damage.";

        this.basicAttack = "Burger Bash – Moderate damage, 15% chance to cause bleeding.";
        this.skillAttack = "Spicy Nugget Storm – Reduces enemy defense by 10%.";
        this.ultimateAttack = "Frosty Freeze – Massive damage and heals herself.";
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
        performAttack(target, 40, 52, 60, "Frosty Freeze");
    }
}