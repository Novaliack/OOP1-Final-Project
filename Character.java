
package com.batakers.thehungerbites;

import java.util.*;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int currMana;
    protected int maxMana;
    protected int regenMana;
    protected Random random;
    protected String title;
    protected String backstory;
    protected String basicAttack;
    protected String skillAttack;
    protected String ultimateAttack;
    private double damageMultiplier = 1.0;
    private boolean isPlayer;

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
        // Handle Rest separately
        if(skillName.equals("Rest")) {
            System.out.println(this.name + " heals themselves! +"+ (int)Math.floor((this.maxHp*.10))+" HP!");
            this.hp = (int)Math.min(this.maxHp, this.hp + (this.maxHp * .10));
            System.out.println(this.name + " now has " + this.hp + "/" + this.maxHp + " HP!");
            return;
        }

        if (this.currMana < manaCost) {
            System.out.println(this.name + " does not have enough mana for " + skillName + "! (Costs " + manaCost + ", has " + this.currMana + ")");
            return;
        }
        this.currMana -= manaCost;

        // Apply damage multiplier
        int baseDamage = minDamage + this.random.nextInt(maxDamage - minDamage + 1);
        int finalDamage = (int)(baseDamage * this.damageMultiplier);
        target.takeDamage(finalDamage);
        System.out.println(this.name + " uses " + skillName + " and deals " + finalDamage + " damage to " + target.name + "!");

        // Show damage boost
        if (this.damageMultiplier > 1.0) {
            System.out.println("\u001B[33m" + "(+" + (int)((this.damageMultiplier - 1.0) * 100) + "% damage boost!)" + "\u001B[0m");
        }
    }
    
    public abstract void basicAttack(Character target);
    
    public abstract void skillAttack(Character target);
    
    public abstract void ultimateAttack(Character target);

    //added
    public abstract void rest(Character target);

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
    public void setName(String name) {
        this.name = name;
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
    public String getTitle() { return this.title; }
    public String getBackstory() {
        return this.backstory;
    }
    public String getBasicAttack() { return this.basicAttack; }
    public String getSkillAttack() { return this.skillAttack; }
    public String getUltimateAttack() { return this.ultimateAttack; }
    public void setMaxHealth(int maxHealth) {
        this.maxHp = maxHealth;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void setHealth(int health) {
        this.hp = Math.max(0, Math.min(health, this.maxHp));
    }
    public void setCurrentMana(int mana) {
        this.currMana = Math.min(mana, this.maxMana);
    }
    public void increaseDamage(double multiplier) {
        this.damageMultiplier += multiplier;
    }
    public double getDamageMultiplier() {
        return this.damageMultiplier;
    }
    public boolean isPlayer() { return isPlayer; }
    public void setPlayer(boolean isPlayer) { this.isPlayer = isPlayer; }
}
