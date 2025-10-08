package com.batakers.thehungerbites.characterList;

import com.batakers.thehungerbites.Character;

public class Poco extends Character {
    public Poco() {
        super("Poco", 150, 60, 5);

        this.title = "Master of Fries!";
        this.backstory = "Potato Corner may be the underdog, but his crispy fries pack a punch with endurance and flavor.";

        this.basicAttack = "Fry Barrage – Moderate damage, lowers enemy speed.";
        this.skillAttack = "Seasoned Slam – Shockwave that lowers enemy attack.";
        this.ultimateAttack = "Fry Fortress – Shield that absorbs damage.";
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
}