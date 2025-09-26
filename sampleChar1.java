
package com.batakers.thehungerbites;


class sampleChar1 extends Character{
    public sampleChar1() {
        super("sample1", 120, 80, 15); //character name, hp, mana, mana regen
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 10, 15, 0, "basic"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 20, 25, 20, "skill"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 40, 50, 50, "ult"); //target name, min dmg, max dmg, mana cost
    }
    
    
}

