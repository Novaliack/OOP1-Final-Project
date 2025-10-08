package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class RonaldMcDonald extends Character {
    public RonaldMcDonald() {
        super("Ronald McDonald", 130, 45, 5);

        this.title = "I’m Lovin' It, and You Will Too!";
        this.backstory = "McDonald's is the undisputed king of fast food, a place where comfort food reigns supreme.\n" +
                "His abilities are all about versatility, with quick and satisfying moves that make him a threat in every turn.\n" +
                "He’s built for a balance of offense and defense, making him a reliable choice for any battle.";

        this.basicAttack = "Fry Strike – Throws fries dealing moderate physical damage and lowering attack by 5% for 2 turns.";
        this.skillAttack = "Big Mac Barrage – Summons Big Macs to deal moderate damage with 20% chance to confuse.";
        this.ultimateAttack = "McFlurry Storm – Cyclone of McFlurry cups, massive magic damage and freeze for 1 turn.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 18, 25, 0, "Fry Strike");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 35, 30, "Big Mac Barrage");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 50, 60, "McFlurry Storm");
    }
}
