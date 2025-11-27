package com.batakers.thehungerbites;

public class BattleSystem {

    public BattleSystem() {
    }

    /**
     * Execute a player's turn with the chosen skill
     * @param current The character whose turn it is
     * @param opponent The target character
     * @param skillChoice The skill to use (1=Basic, 2=Skill, 3=Ultimate)
     */
    public void executePlayerTurn(Character current, Character opponent, int skillChoice) {
        // mana regen every start sa turn
        // Execute the chosen skill
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
            case 4:
                current.rest(current);
                break;
            default:
                System.out.println("Invalid skill choice! Skipping turn.");
                break;
        }
    }


    //Check if the battle is over

    public boolean isBattleOver(Character player1, Character player2) {
        return !player1.isAlive() || !player2.isAlive();
    }

    /**
     * gets the winner of the battle
     * returns the winning character, or null if battle is not over or it's a draw
     */
    public Character getWinner(Character player1, Character player2) {
        if (player1.isAlive() && !player2.isAlive()) {
            return player1;
        } else if (!player1.isAlive() && player2.isAlive()) {
            return player2;
        } else {
            return null; // Battle not over or both dead (draw)
        }
    }

    /**
     * Display current battle status (optional pero pwede rani e move sa GameManager)
     */
    public void displayBattleStatus(Character player1, Character player2) {
        System.out.println("\n=== Battle Status ===");
        System.out.println(player1.getName() + ": " +
                (player1.isAlive() ? player1.getHealth() + "/" + player1.getMaxHealth() + " HP" : "DEAD"));
        System.out.println(player2.getName() + ": " +
                (player2.isAlive() ? player2.getHealth() + "/" + player2.getMaxHealth() + " HP" : "DEAD"));
        System.out.println(player1.getName() + " Mana: " + player1.getCurrentMana() + "/" + player1.getMaxMana());
        System.out.println(player2.getName() + " Mana: " + player2.getCurrentMana() + "/" + player2.getMaxMana());
    }
}
