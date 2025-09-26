
package com.batakers.thehungerbites;

import java.util.*;

abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int currMana;
    protected int maxMana;
    protected int regenMana;
    protected Random random;
    
    //constructor
    public Character(String name, int maxHp, int maxMana, int regenMana){
    this.name = name;
    this.maxHp = maxHp;
    this.hp = maxHp;
    this.maxMana = maxMana;
    this.currMana = maxMana;
    this.regenMana = regenMana;
    this.random = new Random();
    }
    
    //method for regen mana
    public void regenerateMana(){
        this.currMana = Math.min(this.maxMana, this.currMana + this.regenMana);
    }
    
    //perform atks
    protected void performAttack(Character target, int minDamage, int maxDamage, int manaCost, String skillName) {
        if (this.currMana < manaCost) {
            System.out.println(this.name + " does not have enough mana for " + skillName + "! (Costs " + manaCost + ", has " + this.currMana + ")");
            return;
        }
        this.currMana -= manaCost;
        int damage = minDamage + this.random.nextInt(maxDamage - minDamage + 1);
        target.takeDamage(damage);
        System.out.println(this.name + " uses " + skillName + " and deals " + damage + " damage to " + target.name + "!");
    }
    
    public abstract void basicAttack(Character target);
    
    public abstract void skillAttack(Character target);
    
    public abstract void ultimateAttack(Character target);
    
    //method to take damage
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }
    //check if char is alive
    public boolean isAlive() {
        return this.hp > 0;
    }
    //getters
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.hp;
    }
    public int getMaxHealth() {
        return this.maxHp;
    }
    public int getCurrentMana() {
        return this.currMana;
    }
    public int getMaxMana() {
        return this.maxMana;
    }
    
}
