package com.batakers.thehungerbites;

class Jollibee extends Character{
    public Jollibee(){ super("Jollibee", 120, 93, 10);
    }

    @Override
    public void basicAttack(Character target) {
        performAttack(target, 18, 24, 0, "basic");
    }

    @Override
    public void skillAttack(Character target) {
        performAttack(target, 25, 35, 30, "skill");
    }

    @Override
    public void ultimateAttack(Character target) {
        performAttack(target,40, 50, 60, "ultimate");
    }

    @Override
    public void rest(Character target) {
        performAttack(target,-20, -20, 0, "Rest");
    }
}
