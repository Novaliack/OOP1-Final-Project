package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class BurgerKing extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public BurgerKing() {
        super("Burger King", 140, 70, 10);
        this.title = "The King of Burgers Rules the Battlefield!";
        this.backstory = "Burger King is bold and confident, dominating the battlefield with brute force and control.";
        this.basicAttack = yellow + "Jr Whopper Slap" + reset + " – Deals 22-28 damage";
        this.skillAttack = yellow + "Royal Whopper Slam" + reset + " – Deals 30-40 damage";
        this.ultimateAttack = yellow + "Flame-Grilled Fury" + reset + " – Deals 45-55 damage";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 22, 28, 0, "Jr Whopper Slap");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 30, 40, 30, "Royal Whopper Slam");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 45, 55, 50, "Flame-Grilled Fury");
    }

    public void rest(Character target) {
        performAttack(target, -35, -35, 0, "Rest");
    }
}
