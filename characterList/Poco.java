package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Poco extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Poco() {
        super("Poco", 150, 60, 5);

        this.title = "Master of Fries!";
        this.backstory = "Potato Corner may be the underdog, but his crispy fries pack a punch with endurance and flavor.";

        this.basicAttack = yellow + "Fry Barrage" + reset + " – Moderate damage, lowers enemy speed.";
        this.skillAttack = yellow + "Seasoned Slam" + reset + " – Shockwave that lowers enemy attack.";
        this.ultimateAttack = yellow + "Fry Fortress" + reset + " – Shield that absorbs damage.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 20, 25, 0, "Fry Barrage");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 26, 36, 30, "Seasoned Slam");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 52, 60, "Fry Fortress");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}