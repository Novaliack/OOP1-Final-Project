package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Jollibee extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Jollibee(){
        super("Jollibee", 140, 80, 5);

        this.title = "The Bee of Victory!";
        this.backstory = "Jollibee is the lively and spirited mascot who prides himself on showing that fast food can win hearts.\n" +
                "His combination of speed, attack power, and charm allows him to deliver swift, decisive blows.";

        this.basicAttack = yellow + "Chicken Joy Fury" + reset + " – Flurry of fried chicken that deals moderate damage and reduces defense.";
        this.skillAttack = yellow + "Honeycomb Havoc" + reset + " – Swarm of bees dealing damage over time and lowering attack.";
        this.ultimateAttack = yellow + "Sweet Victory" + reset + " – Honey-chicken storm that boosts attack power and drains stamina.";
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
        performAttack(target,40, 50, 55, "Sweet Victory");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}
