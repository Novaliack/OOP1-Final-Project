package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Jollibee extends Character {
    public Jollibee(){
        super("Jollibee", 140, 50, 5);

        this.title = "The Bee of Victory!";
        this.backstory = "Jollibee is the lively and spirited mascot who prides himself on showing that fast food can win hearts.\n" +
                "His combination of speed, attack power, and charm allows him to deliver swift, decisive blows.";

        this.basicAttack = "Chicken Joy Fury – Flurry of fried chicken that deals moderate damage and reduces defense.";
        this.skillAttack = "Honeycomb Havoc – Swarm of bees dealing damage over time and lowering attack.";
        this.ultimateAttack = "Sweet Victory – Honey-chicken storm that boosts attack power and drains stamina.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 18, 24, 0, "Chicken Joy Fury");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 35, 30, "Honeycomb Havoc");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target,40, 50, 60, "Sweet Victory");
    }
}
