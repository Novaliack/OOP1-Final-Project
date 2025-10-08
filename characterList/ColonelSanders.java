package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class ColonelSanders extends Character {
    public ColonelSanders() {
        super("Colonel Sanders", 160, 50, 5);

        this.title = "Finger Lickin' Good Combat!";
        this.backstory = "KFC brings the heat with his secret recipe of abilities, offering a mix of high-damage attacks and powerful debuffs.";

        this.basicAttack = "Drumstick Bash – Deals moderate damage and reduces speed.";
        this.skillAttack = "Fire Chicken Fury – Fiery chicken wings explode for high damage and burn.";
        this.ultimateAttack = "Colonel’s Command – Barrage of chicken heals and deals massive damage.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 20, 26, 0, "Drumstick Bash");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 28, 36, 30, "Fire Chicken Fury");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 42, 55, 60, "Colonel's Command");
    }
}