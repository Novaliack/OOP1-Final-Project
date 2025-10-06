package com.batakers.thehungerbites;

import java.util.*;

public class Thehungerbites {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The Hunger Bites!");
        System.out.println("Choose your fighters!");
        System.out.println("Skills: 1 = Basic (low dmg, 0 mana), 2 = Skill (med dmg, mana cost), 3 = Ultimate (high dmg, high mana cost)\n");

        //avail chars
        System.out.println("Available Characters:");
        System.out.println("1. sampleChar1");
        System.out.println("2. sampleChar2");
        System.out.println("3. Jollibee");

        // PLAYER 1 CHOICE
        System.out.print("\nPlayer 1, choose your character (1-8): ");
        int p1Choice = scanner.nextInt();
        Character char1 = chooseCharacter(p1Choice);

        //p2 choice
        System.out.print("Player 2, choose your character (1-8): ");
        int p2Choice = scanner.nextInt();
        Character char2 = chooseCharacter(p2Choice);

        System.out.println("\n" + char1.getName() + " VS " + char2.getName() + "!");
        System.out.println("The battle begins!\n");

        //turn setup
        Character[] characters = {char1, char2};
        int currentTurn = 0;

        while (true) {
            Character current = characters[currentTurn % 2];
            Character opponent = characters[(currentTurn + 1) % 2];

            if (!opponent.isAlive()) {
                System.out.println("\n--- Game Over! ---");
                System.out.println(current.getName() + " is the winner!");
                break;
            }

            current.regenerateMana();
            System.out.println("\n--- " + current.getName() + "'s Turn ---");
            System.out.println(char1.getName() + ": " + (char1.isAlive() ? char1.getHealth() + "/" + char1.getMaxHealth() : "DEAD") + " HP");
            System.out.println(char2.getName() + ": " + (char2.isAlive() ? char2.getHealth() + "/" + char2.getMaxHealth() : "DEAD") + " HP");
            System.out.println(current.getName() + " Mana: " + current.getCurrentMana() + "/" + current.getMaxMana());

            System.out.print("Choose skill (1=Basic, 2=Skill, 3=Ultimate): ");
            int skillChoice = scanner.nextInt();

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

            if(!opponent.isAlive()){
                System.out.println(opponent.getName()+ " has fallen!");
                System.out.println("\n--- Game Over! ---");
                System.out.println(current.getName() + " is the winner");
                break;
            }
            currentTurn++;
        }

        scanner.close();
    }

    // method for character selection (Pwede bani mabutang sa Character.java para mas clean?)
    public static Character chooseCharacter(int choice) {
        return switch (choice) {
            case 1 -> new sampleChar1();
            case 2 -> new sampleChar2();
            case 3 -> new Jollibee();
            default -> {
                System.out.println("Invalid choice! Defaulting to sampleChar1.");
                yield new sampleChar1();
            }
        };
    }
}
