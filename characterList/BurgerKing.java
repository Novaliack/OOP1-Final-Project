package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class BurgerKing extends Character {
    public BurgerKing() {
        super("Burger King", 150, 60, 5);

        this.title = "The King of Burgers Rules the Battlefield!";
        this.backstory = "Burger King is bold and confident, dominating the battlefield with brute force and control.";

        this.basicAttack = "Flame-Grilled Fury – Powerful punch that deals high damage and burns.";
        this.skillAttack = "Royal Whopper – Giant Whopper burger slams enemy, lowering defense.";
        this.ultimateAttack = "Kingdom of Flames – Flame eruption dealing massive magic damage.";
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
        performAttack(target, 45, 55, 60, "Kingdom of Flames");
    }
}
