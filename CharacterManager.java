package com.batakers.thehungerbites;

import java.util.*;
//linked character files from CHARACTERLIST folder
//can use this "import com.batakers.thehungerbites.characterList.*;"
import com.batakers.thehungerbites.characterList.RonaldMcDonald;
import com.batakers.thehungerbites.characterList.Jollibee;
import com.batakers.thehungerbites.characterList.ColonelSanders;
import com.batakers.thehungerbites.characterList.BurgerKing;
import com.batakers.thehungerbites.characterList.TacoBell;
import com.batakers.thehungerbites.characterList.Wendys;
import com.batakers.thehungerbites.characterList.Poco;
import com.batakers.thehungerbites.characterList.Julies;

public class CharacterManager {
    private List<Character> mascots;

    public static final String reset = "\u001B[0m";
    public static final String blue = "\u001B[34m";
    public static final String green = "\u001B[32m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";

    public CharacterManager() {
        mascots = new ArrayList<>();
        mascots.add(new RonaldMcDonald());
        mascots.add(new Jollibee());
        mascots.add(new ColonelSanders());
        mascots.add(new BurgerKing());
        mascots.add(new TacoBell());
        mascots.add(new Wendys());
        mascots.add(new Poco());
        mascots.add(new Julies());
    }

    public Character selectCharacter(Scanner scanner, String playerName) {
        for (int i = 0; i < 6; i++) System.out.println();
        System.out.println(blue + "Welcome, " + green + playerName + blue + "! Choose your mascot!" + reset);

        while (true) {
            showCharacterList();

            System.out.print(blue + "Enter the mascot number or name to view details:" + reset);
            String input = scanner.nextLine().trim();

            Character selectedCharacter = null;
            int index = -1;

            for (int i = 0; i < mascots.size(); i++) {
                if (input.equalsIgnoreCase(mascots.get(i).getName()) || input.equals(String.valueOf(i + 1))) {
                    selectedCharacter = mascots.get(i);
                    index = i;
                    break;
                }
            }

            if (selectedCharacter == null) {
                System.out.println("Invalid choice. Please try again.\n");
                continue;
            }

            for (int i = 0; i < 6; i++) System.out.println();
            showMascotDetails(selectedCharacter);

            while (true) {
                System.out.print("Would you like to select this mascot? (Y/N): ");
                String decision = scanner.nextLine().trim().toLowerCase();

                if (decision.equals("y") || decision.equals("Y")) {
                    Character chosen = createCharacter(index + 1);
                    if (chosen != null) {
                        System.out.println("You have selected " + chosen.getName() + "!\n");
                        for (int i = 0; i < 6; i++) System.out.println();
                        return chosen;
                    } else {
                        System.out.println("Something went wrong. Returning to character list...\n");
                        break;
                    }
                } else if (decision.equals("n") || decision.equals("N")) {
                    System.out.println("Returning to character list...\n");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Y or N.");
                }
            }
        }
    }

    //creates instances based on player's choice
    public Character createCharacter(int choice) {
        switch (choice) {
            case 1: return new RonaldMcDonald();
            case 2: return new Jollibee();
            case 3: return new ColonelSanders();
            case 4: return new BurgerKing();
            case 5: return new TacoBell();
            case 6: return new Wendys();
            case 7: return new Poco();
            case 8: return new Julies();
            default:
                System.out.println("Invalid choice. No mascot selected.");
                return null;
        }
    }

    void showCharacterList() {
        System.out.println(red + "\nAvailable Mascots:" + reset);
        for (int i = 0; i < mascots.size(); i++) {
            String emoji = "";

            switch (mascots.get(i).getName()) {
                case "Ronald McDonald": emoji = "🍔"; break;
                case "Jollibee": emoji = "🐝"; break;
                case "Colonel Sanders": emoji = "🍗"; break;
                case "Burger King": emoji = "👑"; break;
                case "Taco Bell": emoji = "🌮"; break;
                case "Wendy's": emoji = "🍔"; break;
                case "Poco": emoji = "🥔"; break;
                case "Julie's": emoji = "🍞"; break;
            }
            System.out.println((i + 1) + ". " + emoji + " " + mascots.get(i).getName());
        }
        System.out.println("-------------------------");
    }

    //displays mascot/character details
    private void showMascotDetails(Character mascot) {
        System.out.println("\n────━─━━─━────༺༻────━─━────━─━");
        System.out.println(blue + " Mascot: " + reset + green + mascot.getName() + reset);
        System.out.println(yellow + " " + mascot.getTitle() + reset);
        System.out.println("────━─━━─━────༺༻────━─━────━─━");
        System.out.println(blue + "Backstory:\n" + reset + mascot.getBackstory());
        System.out.println(red + "\n--- Stats ---" + reset);
        System.out.println(blue + "Health: " + reset + mascot.getHealth() + "/" + mascot.getMaxHealth());
        System.out.println(blue + "Mana: " + reset + mascot.getCurrentMana() + "/" + mascot.getMaxMana());

        /* add this when included in CHARACTER.JAVA
        System.out.println("Power: " + mascot.getPower());
        System.out.println("Speed: " + mascot.getSpeed());
        System.out.println("Defense: " + mascot.getDefense());
        */

        System.out.println(red + "\n--- Abilities ---" + reset);
        System.out.println(blue + "Basic Attack: " + reset + mascot.basicAttack);
        System.out.println(blue + "Skill Attack: " + reset + mascot.skillAttack);
        System.out.println(blue + "Ultimate Attack: " + reset + mascot.ultimateAttack);
        System.out.println("────━─━━─━────༺༻────━─━────━─━\n");
    }
}