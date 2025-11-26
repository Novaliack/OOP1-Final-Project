package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class BurgerKing extends Character {

    public static final String reset = "\u001B[0m";
    public static final String yellow = "\u001B[33m";

    public BurgerKing() {
        super("Burger King", 150, 70, 5);

        this.title = "The King of Burgers Rules the Battlefield!";
        this.backstory = "Burger King is bold and confident, dominating the battlefield with brute force and control.";

        this.basicAttack = yellow + "Flame-Grilled Fury" + reset + " – Powerful punch that deals high damage and burns.";
        this.skillAttack = yellow + "Royal Whopper" + reset + " – Giant Whopper burger slams enemy, lowering defense.";
        this.ultimateAttack = yellow + "Kingdom of Flames" + reset + " – Flame eruption dealing massive magic damage.";
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 22, 28, 0, "Flame-Grilled Fury");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 30, 40, 30, "Royal Whopper");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 45, 55, 50, "Kingdom of Flames");
    }


    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}
