package com.batakers.thehungerbites;
import java.util.*;
import java.util.Scanner;

public class CharacterManager {

    public Character selectCharacter(Scanner scanner, String playerName) {
        System.out.println("Choose your fighter!");
        showCharacterList();
        System.out.print("\n" + playerName + ", choose your character (1-3): ");

        return createCharacter(scanner.nextInt());
    }

    public Character createCharacter(int choice) {
        switch (choice) {
            case 1: return new sampleChar1();
            case 2: return new sampleChar2();
            case 3: return new Jollibee();
            default: return new sampleChar1();
        }
    }

    void showCharacterList() {
        System.out.println("Available Characters:");
        System.out.println("1. sampleChar1");
        System.out.println("2. sampleChar2");
        System.out.println("3. Jollibee");
    }


}