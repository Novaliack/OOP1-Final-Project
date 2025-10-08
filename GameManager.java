package com.batakers.thehungerbites;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private CharacterManager characterManager = new CharacterManager();
    private BattleSystem battleSystem = new BattleSystem();
    private boolean aiMode = false; // track if playing vs AI

    public void startGame() {
        showMainMenu();
    }

    private void showMainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("====================================");
            System.out.println("       THE HUNGER BITES");
            System.out.println("====================================");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Ai");
            System.out.println("3. Exit");
            System.out.println("====================================");
            System.out.print("Choose game mode (1-3): ");


            int choice = getValidInput(1, 3);

            switch (choice) {
                case 1:
                    aiMode = false;
                    startPlayerVsPlayer();
                    break;
                case 2:
                    aiMode = true;
                    startPlayerVsAi();
                    break;
                case 3:
                    running = false;
                    System.out.println("Thanks for playing The Hunger Bites!");
                    break;
            }

            if (running) {
                System.out.print("\nReturn to main menu? (1=Yes, 2=No): ");
                int returnChoice = getValidInput(1, 2);
                if (returnChoice == 2) {
                    running = false;
                    System.out.println("Thanks for playing The Hunger Bites!");
                }
            }
        }

        scanner.close();
    }

    private void startPlayerVsPlayer() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n=== Player vs Player Mode ===");
        System.out.println("Welcome to The Hunger Bites!");
        System.out.println("Skills:");
        System.out.println("1 = Basic (low dmg, 0 mana)");
        System.out.println("2 = Skill (med dmg, mana cost)");
        System.out.println("3 = Ultimate (high dmg, high mana cost)");
        System.out.println("4 = Rest (heal 20HP)");
        System.out.println("====================================");


        // Character selection with validation
        Character player1 = selectCharacterWithValidation("Player 1");
        Character player2 = selectCharacterWithValidation("Player 2");

        startBattle(player1, player2);
    }

    private void startPlayerVsAi(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n=== Player vs Ai Mode ===");
        System.out.println("Welcome to The Hunger Bites!");
        System.out.println("Skills:");
        System.out.println("1 = Basic (low dmg, 0 mana)");
        System.out.println("2 = Skill (med dmg, mana cost)");
        System.out.println("3 = Ultimate (high dmg, high mana cost)");
        System.out.println("4 = Rest (heal 20HP)");
        System.out.println("====================================");


        // Character selection with validation
        Character player1 = selectCharacterWithValidation("Player 1");
        Character player2 = selectCharacterWithValidation("AI");

        startBattle(player1, player2);

    }
    public boolean isAi(){
        return aiMode;
    }
    /**
     * checks input for character
     */
    private Character selectCharacterWithValidation(String playerName) {
        // Let CharacterManager handle the character logic
        // But GameManager handles the input validation
        System.out.println("Choose your fighter!");
        characterManager.showCharacterList();
        System.out.print("\n" + playerName + ", choose your character (1-3): ");

        int choice = getValidInput(1, 3);
        return characterManager.createCharacter(choice);
    }


    private void startBattle(Character player1, Character player2) {
        System.out.println("\n" + player1.getName() + " VS " + player2.getName() + "!");
        System.out.println("The battle begins!\n");

        Character[] players = {player1, player2};
        int currentTurn = 0;

        while (!battleSystem.isBattleOver(player1, player2)) {
            Character currentPlayer = players[currentTurn % 2];
            Character opponent = players[(currentTurn + 1) % 2];

            int skillChoice;

            if (aiMode && currentPlayer == player2) {
                skillChoice = (int) (Math.random() * 4) + 1; // random skill 1–3
                System.out.println("\n--- AI's Turn ---");
                displayBattleStatus(currentPlayer);
                System.out.println("AI chooses skill " + skillChoice + "!");
            } else {
                skillChoice = getPlayerSkillChoice(currentPlayer);
            }

            battleSystem.executePlayerTurn(currentPlayer, opponent, skillChoice);

            if (!opponent.isAlive()) {
                endBattle(currentPlayer, opponent);
                break;
            }

            currentTurn++;
        }
    }

    private int getPlayerSkillChoice(Character currentPlayer) {
        System.out.println("\n--- " + currentPlayer.getName() + "'s Turn ---");
        displayBattleStatus(currentPlayer);
        System.out.print("Choose skill (1=Basic, 2=Skill, 3=Ultimate, 4=Rest): ");
        return getValidInput(1, 4);
    }

    private void displayBattleStatus(Character currentPlayer) {
        System.out.println(currentPlayer.getName() + ": " +
                currentPlayer.getHealth() + "/" + currentPlayer.getMaxHealth() + " HP");
        System.out.println(currentPlayer.getName() + " Mana: " +
                currentPlayer.getCurrentMana() + "/" + currentPlayer.getMaxMana());
    }

    /**
     * for checking general input
     */
    private int getValidInput(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.print("Invalid input! Please enter " + min + "-" + max + ": ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void endBattle(Character winner, Character loser) {
        System.out.println("\n" + loser.getName() + " has fallen!");
        System.out.println("--- Game Over! ---");
        System.out.println(winner.getName() + " is the winner!");

        System.out.println("\nBattle Statistics:");
        System.out.println("Winner HP: " + winner.getHealth() + "/" + winner.getMaxHealth());
        System.out.println("Winner Mana: " + winner.getCurrentMana() + "/" + winner.getMaxMana());
    }
}
