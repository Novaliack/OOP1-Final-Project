
package com.batakers.thehungerbites;


class sampleChar2 extends Character{
    public sampleChar2() {
        super("sample2", 70, 120, 20);
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 8, 12, 0, "basic"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 30, 20, "skill"); //target name, min dmg, max dmg, mana cost
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target, 50, 60, 70, "ult"); //target name, min dmg, max dmg, mana cost
    }
}
