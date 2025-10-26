package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class TacoBell extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public TacoBell() {
        super("Taco Bell", 120, 55, 5);

        this.title = "Live Mas, Battle Harder!";
        this.backstory = "Taco Bell brings the heat with his spicy, unpredictable nature. Quick bursts of damage keep his enemies on their toes.";

        this.basicAttack = yellow + "Taco Toss" + reset + " – Throws taco, moderate damage, lowers speed.";
        this.skillAttack = yellow + "Fire Sauce Fury" + reset + " – Burst of fire sauce, damage over time, lowers attack.";
        this.ultimateAttack = yellow + "Bellstorm" + reset + " – Whirlwind of tacos and burritos causing confusion.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 16, 22, 0, "Taco Toss");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 24, 32, 30, "Fire Sauce Fury");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 48, 60, "Bellstorm");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}