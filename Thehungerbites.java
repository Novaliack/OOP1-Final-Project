package com.batakers.thehungerbites;

import java.util.*;

public class Thehungerbites {

    public static void main(String[] args) {
        sampleChar1 char1 = new sampleChar1();
        sampleChar2 char2 = new sampleChar2();
        
        Character[] characters = {char1, char2};
        String[] names = {"sample1", "sample2"};
        
        Scanner scanner = new Scanner(System.in);
        int currentTurn = 0; //turn tracker
        System.out.println("Welcome to The Hunger Bites!");
        System.out.println("Skills: 1 = Basic (low dmg, 0 mana), 2 = Skill (med dmg, mana cost), 3 = Ultimate (high dmg, high mana cost)");
        System.out.println("Damage has a random range. Mana regenerates at the start of each turn.");
        System.out.println("The game ends when one character is defeated.\n");
        
        while (true) {
            //current char
            Character current = characters[currentTurn % 2];
            Character opponent = characters[(currentTurn + 1) % 2];
            if (!current.isAlive()) {
                //switch to opp if current is dead
                currentTurn++;
                continue;
            }
            //skip if opp dead
            if (!opponent.isAlive()) {
                break;
            }
            // Regenerate mana at start of turn
            current.regenerateMana();
            //display current status
            System.out.println("\n--- " + current.getName() + "'s Turn ---");
            System.out.println("Healths:");
            System.out.println(names[0] + ": " + (char1.isAlive() ? char1.getHealth() + "/" + char1.getMaxHealth() : "DEAD") + " HP");
            System.out.println(names[1] + ": " + (char2.isAlive() ? char2.getHealth() + "/" + char2.getMaxHealth() : "DEAD") + " HP");
            System.out.println("Mana - " + current.getName() + ": " + current.getCurrentMana() + "/" + current.getMaxMana());
            
            System.out.print("Choose skill (1=Basic, 2=Skill, 3=Ultimate): ");
            int skillChoice = scanner.nextInt();
            //skill execution
            switch (skillChoice) {
                case 1:
                    current.basicAttack(opponent);
                    break;
                case 2:
                    current.skillAttack(opponent);
                    break;
                case 3:
                    current.ultimateAttack(opponent);
                    break;
                default:
                    System.out.println("Invalid choice! Skipping turn.");
                    break;
            }
            //check win con
            if (!opponent.isAlive()) {
                System.out.println("\n--- Game Over! ---");
                System.out.println(current.getName() + " is the winner!");
                break;
            }
            currentTurn++;//next turn
        }
    }
}
