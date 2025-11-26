package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Poco extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public Poco() {
        super("Poco", 170, 80, 9);
        this.title = "Master of Fries!";
        this.backstory = "Potato Corner may be the underdog, but his crispy fries pack a punch with endurance and flavor.";
        this.basicAttack = yellow + "Fry Barrage" + reset + " – Deals 15-20 damage";
        this.skillAttack = yellow + "Giga Slam" + reset + " – Deals 22-28 damage";
        this.ultimateAttack = yellow + "Terra Storm" + reset + " – Deals 35-45 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 15, 20, 0, "Fry Barrage");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 22, 28, 30, "Giga Slam");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 35, 45, 50, "Terra Storm");
    }

    public void rest(Character target) {
        performAttack(target, -40, -40, 0, "Rest");
    }
}
