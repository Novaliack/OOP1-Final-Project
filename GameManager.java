package com.batakers.thehungerbites;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private CharacterManager characterManager = new CharacterManager();
    private BattleSystem battleSystem = new BattleSystem();
    private boolean aiMode = false; // track if playing vs AI

    //ascii colors - main
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String green = "\u001B[32m";
    public static final String lightYellow = "\u001B[38;5;11m";
    public static final String gold = "\u001B[38;5;220m";

    //player colors
    public static final String purpleBold = "\u001B[1;35m";
    public static final String cyanBold = "\u001B[1;36m";

    //text art
    //bun
    public static final String goldenRod = "\u001B[38;5;214m";
    public static final String lightOrange = "\u001B[38;5;221m";
    public static final String lightMayo = "\u001B[38;5;222m";
    public static final String orange = "\u001B[38;5;215m";
    public static final String raisin = "\u001B[38;5;230m";
    //tomato
    public static final String peach = "\u001B[38;5;223m";
    public static final String redOrange = "\u001B[38;5;196m";
    public static final String berry = "\u001B[38;5;124m";
    public static final String mahogany = "\u001B[38;5;88m";

    //cheese
    public static final String mustardYellow = "\u001B[38;5;226m";
    //lettuce
    public static final String limeGreen = "\u001B[38;5;118m";
    public static final String neonGreen = "\u001B[38;5;82m";
    public static final String brightGreen = "\u001B[38;5;46m";
    public static final String springGreen = "\u001B[38;5;47m";
    public static final String lightGreen = "\u001B[38;5;120m";
    //patty
    public static final String brown = "\u001B[38;5;130m";
    public static final String reddishBrown = "\u001B[38;5;94m";


    public void startGame() {
        showMainMenu();
    }

    private void showMainMenu() {
        boolean running = true;

        //animated intro
        while (running) {
            clearScreen();
            showAnimatedTitle();


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
                System.out.print(blue + "\nReturn to main menu? (1=Yes, 2=No): " + reset);
                int returnChoice = getValidInput(1, 2);
                if (returnChoice == 2) {
                    running = false;
                    System.out.println(gold + "Thanks for playing The Hunger Bites!" + reset);
                }
            }
        }

        scanner.close();
    }

    //animated title screen
    private void showAnimatedTitle() {
        int consoleWidth = 120;

        //bun
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢀⣀⣠⣤⢤⣶⣶⠶⣶⣶⣶⣶⡶⠶⢦⣤⢤⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⢀⢀⣀⣀⣴⣯⣹⢯⣩⢍⣭" + lightMayo + "⣽⣿⣿⣿" + raisin + "⡿⠛⠻" + lightMayo + "⢿⣀" + lightOrange + "⣸⡿⠻⠿⣿⣾⣿⣿⣿⣿⣿" + goldenRod + "⣿⣿⣿⣿⣭⣽⣯⣙⣧⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣿⣽⣿" + lightMayo + "⢿⣿⣿⣿⡾⠉⠉⣉⣉⡉⠋⠉⠉⢀⣀⡀⠀⠀⠉" + lightOrange + "⠉⢱⢂⠐⡈" + raisin + "⢧⣀⣸" + lightOrange + "⡟⢻⡿⣿⡉⢉⣿⢿⣷" + orange + "⣻⣿⣿⣿⣯⣿" + raisin + "⣯⠙⠦" + goldenRod + "⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣰⣿" + lightMayo + "⢿⣿⣿⣽⠁" + raisin + "⠈⣹⡉⢉⡏⠁⠠⣟⠉⢉⣿⠀⠀⣞⠉⢙⣧⢀⠀" + lightOrange + "⠀⠀⢹⡆⠱⡈⣆⣹⣯⡇⠈⣷⠙⢿⣿⡹⢎⣳⡛" + orange + "⣿⣿" + raisin + "⡏⠉⢹⣿⣶⣶⣾" + lightOrange + "⣿" + goldenRod + "⣯⡱⣦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣦⣴" + lightMayo + "⡿⣷⣿⣷⣿⠋" + raisin + "⠀⠀⠀⠀⠀⠙⠙⠃⠀⠀⠉⠛⠛⠁⠀⠀⠈⠛⠛⠁⠀⠀" + lightOrange + "⠘⠛⠛⣀⠳" + raisin + "⣟⠉⠙⣷" + lightOrange + "⠟⠿⡃⠞⡸⢿⣵⢫⠶⣹⢦⡹" + orange + "⡽⢿⣿⣿⣻⣽⣳⢯⣿⣷⣶⣷⡽" + goldenRod + "⢦⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿" + lightMayo + "⣿⣿⠿⠿" + raisin + "⠻⣇⣀⡧⠀⡴⠖⢷⡆⠀⠀⠀⢀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⠀" + lightOrange + "⠀⢸⡄⠢" + raisin + "⢉⠷⠶⣛" + lightOrange + "⣮⣴⣡⡩⢐⠦" + raisin + "⣹⡿⠿⠷" + lightOrange + "⣾⡵⡹" + orange + "⣭⢛" + raisin + "⣿⠟⠻⢿" + orange + "⣿⣳⣯⢿⣽⣿⣿⣾" + goldenRod + "⣷⢲⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿" + lightMayo + "⣿⡿⠿⠇" + raisin + "⢀⡄⠀⠀⠉⠀⠀⠛⠶⠾⠁⠀⠀⣴⠋⢀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠸⣇⣀⡏⠀" + lightOrange + "⠀⢸⡇⠱⡈⢆⡑" + raisin + "⠸⣇⣀⣸" + lightOrange + "⣇⠣⢆⡩" + raisin + "⢳⢦⣤⣾" + lightOrange + "⢷⡹⣖" + orange + "⡫⢟" + raisin + "⣷⣤⣼⣿" + orange + "⢷⣻⡿⠾⠷⣿⣟⣿⣿" + goldenRod + "⣷⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣿" + lightMayo + "⣿⣿⠟⠃" + raisin + "⠀⠓⠞⠃⠀⠀⠀⠀⣀⡀⠀⠀⣠⣤⠾⠛⠳⠟⠓⠒⠚⠲⠓⢦⣀⣤⣤⡀⠀⠉⠀" + lightOrange + "⠠⠀⢸⡇⢂⡑⠢⢌⠡⢌⠛⡹⢨⠜⣢⠑⣆⢊⡌⣿⣶⡹" + orange + "⢶⣹⢫⣼⠙⢻⣽⣻⣿" + raisin + "⢿⣦⣤⣾" + orange + "⡿⣞⣿⣯" + goldenRod + "⣱⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣯" + lightMayo + "⣿⣿⠛⠉" + raisin + "⠀⠀⠀⠀⣀⣤⣀⠀⠀⣸⠋⠙⠶⠿⠿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠋⣀⣸⡇⠀⠀⠀⠀" + lightOrange + "⠀⠸⣇⠢⢌⡑⣈⠱⡈⢆⠱⠨⠜⣄⠫⣄⢣⢒⠉⢻⣗⡯⣖" + orange + "⣏⢾⡶⣾⣿⢧⡿⣿⣿⣻⢿⣽⡿⣽⡷⣿⢿⣯" + goldenRod + "⣹⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴" + lightMayo + "⣿⣿⡟⠉" + raisin + "⠀⠀⠀⠀⠀⠐⢯⣀⡹⣶⡞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠏⠉⢠⡶⠛⣷⠀" + lightOrange + "⠀⠐⠤⡁" + raisin + "⠦⠛⠻⣦" + lightOrange + "⠑⡌⢢⢑⠪⡔⢣⠜⡢⢍⣃⠻⣿⣴⠿⣬" + orange + "⢳⡝⣮⢿⣯⣽⢻⣿⣽⣯⣷⢿⣯⢿⣯⢿⣻⣷⡼" + goldenRod + "⠦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢠⣮" + lightMayo + "⣳⣿⠋" + raisin + "⠀⠀⠀⠀⠀⠀⠀⢀⡤⡽⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡴⠏⠁⠀⠀⠈⠷⠶⠟⠀⠀" + lightOrange + "⢸⠐⡀⠎" + raisin + "⠳⠶⠓" + lightOrange + "⡌⠰⡁⢎⠰⣉⠦⡙⡔⢣⠜⡢⢿⣏⡟⣼⢣⣟" + orange + "⣲⢻⣿⡞⣯⢿⣿⣾⣽⣯⢿⣯⣟⣿⣽⣯⣿⣇" + goldenRod + "⣳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢠⣯" + lightMayo + "⣭⡟⠃" + raisin + "⠀⠀⠀⠀⠀⠀⠀⠠⠾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠶⠶⠞⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⢸⠡⡘⢨⠱⢌⠱⢌⠱⣈⠦⠱⣌⠲⡱⢌⠣⢎⡱⣻⡞⣼⢣⡟⣦⢏⣿" + orange + "⡿⣽⡭⣟⣿⣷⣻⢾⣟⡷⣿⣽⢾⣳⣯⣿⣿⣭" + goldenRod + "⣽⡄⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢀⡾" + lightMayo + "⣹⡿⠁" + raisin + "⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⢸⠠⡁⢆⠣⢌⠒⣌⠒⣄⢪⡑⢆⡣⣑⢎⡱⢊⡔⣻⡝⢮⡳⣝⢮⡽⣿⣻⣵" + orange + "⡻⣭⢿⣿⡽⣯⣿⣻⣽⡾⣟⣯⣷⣯⢿⣿⣿⣯" + goldenRod + "⢳⡀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢠⣾" + lightMayo + "⣻⡿⠁" + raisin + "⠀⠀⠀⠀⠀⠀⠀⠀⢽⡄⠀⠀⠀⠀⠀⠀⣰⠶⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⢸⢀⠱⡈⠎⠤⢃⡌⠲⡄⢖⡩⢆⠵⣈⠦⣑⠣⣼⢷⡹⢧⡻⣜⢧⣿⣟⡷⢾⣝" + orange + "⡯⣟⣿⡽⣟⣾⢯⣷⢿⣻⣽⡾⣽⣻⣞⣿⣿" + goldenRod + "⣳⡀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢸⡷" + lightMayo + "⣿⡇" + raisin + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠒⠒⠒⠒⠒⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⢸⢀⠣⡑⣍⠚⡄⢎⡱⡘⢦⡑⢎⠲⣡⠚⡤⢳⡝⣮⡝⣧⢻⣜⣿⣻⣞⣽⡻⣮⢟" + orange + "⡽⣞⣿⢯⣿⣻⣯⣿⣻⡷⣿⢯⣿⣞⣿⣿" + goldenRod + "⣿⡇⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢸⣏" + lightMayo + "⣿⡇⣠⣀⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⢀⠀⡀⠀⠀⠀⠀⢀⠀" + lightOrange + "⠀⣀⠀⢠⢊⡔⣡⢂⡱⣈⢦⡱⣉⢦⡙⣌⠳⣄⠫⡔⣿⣹⣶⣹⣎⣷⣿⣯⢷⣞⣳" + orange + "⢿⣭⡿⣽⣻⣾⣟⣷⣯⣷⣻⡷⣟⣯⣿" + goldenRod + "⣳⡇⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢸⣷" + lightMayo + "⣿⡇⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠉⠁⠁⠈⠁⣸⣟⡱⢎⠳⣌⠧⣋⢖⡙⢦⠳" + orange + "⡜⡜⢦⠳⣌⢧⡹⣌⠳⣌⠳⡬⣽⣿" + goldenRod + "⣿⡇⠀⠀⠀⠀⠀");
        System.out.println(lightGreen + "⠀⠀⢠⣄⣰⣸⣟" + goldenRod + "⢿⣧⣀⣌⣉⣁⣉⣉⣉⣉⣉⣡⣈⣀⣄⣀⣈⣠⣁⣌⣈⣀⣁⣈⣈⣀⣉⣉⣉⣉⣁⣉⣉⣉⣁⣉⣈⣄⣠⣀⣀⣄⣀⣠⣀⣤⣧⣜⣦⣥⣣⣮⣔⣧⣜⣦⣹⣬⣽⣹⣯⣭⣽⣭⣟⣿⣽⣦⣽⣎⣷⣬⣷⣭⣮⣝⣮⣳⣭⣎⣷⣬⣳⣵⣻⠿" + lightGreen + "⣿⢧⣠⣄⡀⠀⠀");
        System.out.println(springGreen+ "⠀⣀⣸⡇⠀⠀⠈⠀⠻⣿⡟⠟⠻⠛⣿⣿⣿⣿⡿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⡿⣿⢿⡿⣿⠿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⡿⠿⢿⣿⣿⢿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⢿⡿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⡿⣷⣶⣸⣇⣀⠀");
        System.out.println(brightGreen+ "⢸⣏⡉⠁⠀⢹⡄⠈⢙⣿⣷⣴⠀⠀⢻⣇⠉⠉⢳⣶⣶⣦⠀⢉⠙⣿⣿⣽⣏⠀⣤⣴" + brightGreen + "⣦⠀⢸⠟⠘⣷⣍⠻⢿⣯⣟⡟⠙⠛⠋⠀" + mahogany + "⢱⣶⣮⡍⣾⣿⣿⣽" + brightGreen + "⠉⣹⣿⣿⣟⢻⣿⣳⡝⣭⢛" + mahogany + "⣿⣷⣿⣷⣯⣿⣿⢯⣿⣿⣿⣿" + brightGreen + "⣎⠿⣿⣿⣾⣷⣿⣝⣻⢻⣿⣿⣿⢯" + mahogany + "⣿⣾⣯" + brightGreen + "⣿⣞⣧⣽⡇");
        System.out.println(limeGreen  + "⢸⠘⠀⡀⢃⢌" + berry + "⣿⣶⣿⣿⣿⣿⣧⣀" + peach + "⢀⣸"+ berry + "⣿⣿⣿⣿⣿⣿⣿⡆⠀⠉⠀⠀⢹⣿⣿⣿⣿" + limeGreen + "⣀⡀⢸⣿⣿⣿⣿⣶⠉⠉" + berry + "⢁⣐⣤" + peach + "⣿⣿" + berry + "⣿⣿⣿⣿⣿⣿⣿⣿⣶" + limeGreen + "⣬⣍⢻⣿⣿⣞⣷⣻" + berry + "⣼⣿⣿⣿⣿⣿⣿⣿⣿" + peach + "⣿⣿" + berry + "⡿⣿⣿⣿⣿" + limeGreen + "⣶⣿⣿⣿⣿⣿⣴" + berry + "⣻⣻⣿⣿⣿" + mahogany + "⣿⣿⣿⣿⣿⣿⢾⡇");
        System.out.println(redOrange  + "⢸⣘⠶⡲⢈⣿⣿⣷⣾⣬⣝⣜⣫⣟" + peach + "⠾⠷" + redOrange + "⠿⠾⠷⠟⠿⠷⠻⠟⠿⢿⣻⣛⣟⣯⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣝⣏⡟" + peach + "⡙⠋⠛" + redOrange + "⣽⣩⣏⣽⣩⣛⣝⣯⣏⡞⣭⣿⣿⢿⣟⣿⣿⣷⣿⣯⣟⡿⣟⣿⣯" + peach + "⠙⠉⢃" + redOrange + "⣉⣙⣉⣋⣽⣻⣟⡿⣟⡿⣿⣿⡿⣿⣟⣿⣽" + mahogany + "⣿⣽⣿⣽⡉⣿⢻⡇");
        System.out.println(mustardYellow + "⠈⠻⠛⠟⠋⣿⢸⣿⣽⣻⢿⡿⣿⢿⡿⣿⣿⠲⣍⢿⣿⢿⡿⣿⢿⡿⣿⢿⡿⣿⢿⣿⣻⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⢮⡽⡗⣌⢹⡿⣽⣿⣻⢿⡿⣿⣟⡿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣻⣿⡽⣿⠀⠃⠤⣿⣿⢿⡿⣟⡿⣞⣿⣻⣽⣿⣿⣿⢿⣿⣿⣿⣿⡏⠛⠚⠁\n" + reset);


        String title =
                brown +
                        "████████" + reddishBrown + "╗" + brown + "██" + reddishBrown + "╗  " + brown + "██" + reddishBrown + "╗" + brown + "███████" + reddishBrown + "╗    " + brown + "██" + reddishBrown + "╗  " + brown + "██" + reddishBrown + "╗" + brown + "██" + reddishBrown + "╗   " + brown + "██" + reddishBrown + "╗" + brown + "███" + reddishBrown + "╗   " + brown + "██" + reddishBrown + "╗ " + brown + "██████" + reddishBrown + "╗ " + brown + "███████" + reddishBrown + "╗" + brown + "██████" + reddishBrown + "╗     " + brown + "██████" + reddishBrown + "╗ " + brown + "██" + reddishBrown + "╗" + brown + "████████" + reddishBrown + "╗" + brown + "███████" + reddishBrown + "╗" + brown + "███████" + reddishBrown + "╗\n" +
                        "╚══" + brown + "██" + reddishBrown + "╔══╝" + brown + "██" + reddishBrown + "║  " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "╔════╝    " + brown + "██" + reddishBrown + "║  " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║" + brown + "████" + reddishBrown + "╗  " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "╔════╝ " + brown + "██" + reddishBrown + "╔════╝" + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "╗    " + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "╗" + brown + "██" + reddishBrown + "║╚══" + brown + "██" + reddishBrown + "╔══╝" + brown + "██" + reddishBrown + "╔════╝" + brown + "██" + reddishBrown + "╔════╝\n" + brown +
                        "   ██" + reddishBrown + "║   " + brown + "███████" + reddishBrown + "║" + brown + "█████" + reddishBrown + "╗      " + brown + "███████" + reddishBrown + "║" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "╔" + brown + "██" + reddishBrown + "╗ " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "║  " + brown + "███" + reddishBrown + "╗" + brown + "█████" + reddishBrown + "╗  " + brown + "██████" + reddishBrown + "╔╝    " + brown + "██████" + reddishBrown + "╔╝" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║   " + brown + "█████" + reddishBrown + "╗  " + brown + "███████" + reddishBrown + "╗\n" + brown +
                        "   ██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "╔══╝      " + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "║╚" + brown + "██" + reddishBrown + "╗" + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║" + brown + "██" + reddishBrown + "╔══╝  " + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "╗    " + brown + "██" + reddishBrown + "╔══" + brown + "██" + reddishBrown + "╗" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "╔══╝  ╚════" + brown + "██" + reddishBrown + "║\n" + brown +
                        "   ██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║  " + brown + "██" + reddishBrown + "║" + brown + "███████" + reddishBrown + "╗    " + brown + "██" + reddishBrown + "║  " + brown + "██" + reddishBrown + "║╚" + brown + "██████" + reddishBrown + "╔╝" + brown + "██" + reddishBrown + "║ ╚" + brown + "████" + reddishBrown + "║╚" + brown + "██████" + reddishBrown + "╔╝" + brown + "███████" + reddishBrown + "╗" + brown + "██" + reddishBrown + "║  " + brown + "██" + reddishBrown + "║    " + brown + "██████" + reddishBrown + "╔╝" + brown + "██" + reddishBrown + "║   " + brown + "██" + reddishBrown + "║   " + brown + "███████" + reddishBrown + "╗" + brown + "███████" + reddishBrown + "║\n" +
                        "   ╚═╝   ╚═╝  ╚═╝╚══════╝    ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚═════╝ ╚═╝   ╚═╝   ╚══════╝╚══════╝\n" +
                limeGreen + "                                             🍟 Fast-Food Mascot Showdown 🍔" + reset;

        //Typing animation
        for (char c : title.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(1); // adjust speed (1–10 ms)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println(limeGreen + "⢸⠸⣿⡄⠒⢦⣧⠀⠘⠀⠰⠈⠌⠣⣝⠿⠿⠿⠿⠄⠢⣄⣀⠈⠀⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⢿⣿⢇⣄⣀⣀⡀⠀⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⠦⠀⠀⢀⠀⣀⠠⠄⡀⠾⠿⣿⣿⣿⣿⣿⣿⣿⡿⣿⠧⢀⠠⣤⣀⣤⣀⠿⢿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣳⣟⣾⣿⣷⣿⣿⡇");
        System.out.println(neonGreen + "⢸⢐⢻⡷⢤⡄⣸⣿⣷⣶⡀⠉⣆⠁⣀⠂⠐⡀⠠⢀⢰⣷⣾⣷⣶⣤⡄⠛⠛⠛⡏⠻⡙⣻⠟⠻⢀⠈⣷⣴⣾⣾⣶⣾⣿⣶⠀⠠⠸⠟⡛⢛⢻⣿⡟⠛⠛⠛⠃⢰⣶⣶⣶⣶⣶⣷⣞⣶⡆⠆⠉⡙⣿⣛⣟⡛⢛⠇⢀⠲⢦⠖⣿⣿⣾⣿⡄⠘⠛⠛⣟⣿⣿⣿⣿⣟⡷⣿⣿⣿⣿⣿⡟⡇");
        System.out.println(brightGreen + "⠘⠷⢻⣷⣾⣿⣿⣿⣿⣿⣧⣤⠀⠀⠀⠈⢂⢐⣀⣿⣾⣿⣿⣿⣿⡇⣁⠀⡀⠀⠙⠁⠀⠉⢀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣐⡀⠁⠐⠠⢸⣿⡇⠀⠀⣀⠠⢘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣹⣀⡰⠧⠇⠈⢱⣎⣞⠲⣎⣧⣿⣿⣿⣿⣿⣗⣶⣂⡔⢋⢸⣿⣿⣿⣾⣟⣿⣿⣿⣹⣿⢷⣶⠾");
        System.out.println(springGreen + "⠀⠀⠈⠷⠶⣾⣿⣿⡟⢽⠿⢿⣧⣁⣌⣈⣆⣿⣿" + lightMayo + "⡿⣿⣿⣿⣿⣿⣿" + springGreen + "⣿⣇⡁⠁⡀⢀⣨⣀⣿⣿" + lightMayo + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + springGreen + "⣿⣿⣀⡁⠂⡈⠉⢹⣷⡴⣼⣿" + lightOrange + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + springGreen + "⣿⣿⣀⣸⢏⣻" + lightOrange + "⢾⣽⣻⣿⣿⣿⣿" + orange + "⣿⣿⣿⣿⣿⣿" + springGreen + "⣿⣇⣼⣿⣿⣻⣿⣿⣿⣿⡗⠾⠃⠀⠀");
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⢸⣿" + lightMayo + "⣿⡇⢺⡇" + lightGreen + "⠀⠿⠿⣿⡿⣿⠿⣮" + lightMayo + "⠷⠟⠁⠀⠁⠈⠈⠉" + lightGreen + "⠿⢿⣿⣿⣿⣿⣿⠿⣏" + lightMayo + "⣷⠿⠏⠉⠉⠉⠉⠉⠉⠉⠉" + lightGreen + "⠉⠻⣿⣿⣿⣾⣷⣯⣷⣿⣿⣻" + lightOrange + "⡽⣳⠿⠾⢷⠻⢮⠷⠻⡼⢳⠯" + lightGreen + "⢿⣿⣿⣿⣿" + lightOrange + "⣿⣿⣿⣿⢯⣟⣯⣿⣟" + orange + "⣯⣿⣽⣻⣿⣿⣿" + lightGreen + "⣿⣿⣿⢿" + orange + "⣟⣿" + goldenRod + "⣿⣿⡇⠀⠀⠀⠀⠀");
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⢸⣿" + lightMayo + "⣿⡇⢹⣧⡀⠀⠀⠉⠉⠉⠋⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠛⠾⠳⠿⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣿" + lightOrange + "⣿⡟⠙⡷⢻⣯⢿⡽⣷⢿⡾⡛⢯⣉⠳⣌⠳⡌⢎⡱⢌⡣⢎⡹⣟⠽⣻⢿⣯⢿⡽⣞⡿⢾⣽⣷⣟⣯" + orange + "⣷⢿⣯⢿⣽⣻⣽⣯⢿⣟⣯⣿⣿" + goldenRod + "⣿⡇⠀⠀⠀⠀⠀");
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⠸⣿" + lightMayo + "⣿⢷⣤⡙⢻⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + lightOrange + "⢀⣤⠾⡙⠦⣌⠳⣌⠳⡘⣌⠶⣡⢛⡼⣓⢮⣛⣬⣻⣿⢯⣻⣽⢻⣯⣿⣟⣾⣟⣾⡿⣽⣯⢿⣽⣿⣿⣿" + orange + "⣿⣿⣿⣿⣿⣿⣳⡿⣯⣿⣽⣾⣿" + goldenRod + "⣿⠇⠀⠀⠀⠀⠀");
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⠀⠈⠻⣿" + lightMayo + "⣿⣷⣤⣉⢿⣄⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⡀⢀⢀⢀⣀⣀⣀⡀⡀⣀⣀⣀⣀⣀⢀⡀⣀⣀⣀⣀⡄" + lightOrange + "⠋⢁⠀⡀⢀⢀⣄⣠⡼⡏⢥⢣⡙⠲⣌⠳⣌⠱⡱⢌⡶⣡⢟⡼⣙⣮⣶⣷⡿⣯⣟⡷⣯⣿⣿⣻⣾⣟" + orange + "⣾⢯⣿⢯⣟⣯⣿⣽⣻⣷⣿⣿" + goldenRod + "⢿⡏⠁⠀⠀⠀⠀⠀⠀");
        System.out.println(goldenRod + "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣼" + lightMayo + "⣿⣣⣮⣼⣥⣦⣤⣴⣤⣤⣦⣤⣴⣤⣤⣥⣦⣤⣆⣤⣤⣤⣤⣥⣤⣴⣠⣤⣤⣦⣴⣤⣦⣬⣴⣤⣭" + lightOrange + "⣤⣦⣥⣦⣜⣾⣥⣳⣼⣬⣶⣩⣷⣌⣷⣌⣧⣵⣯⣞⣵⣫⣼⣷⣿⣿⣽⣽⣳⣯⣟⣿⣿⣳⣿⣷" + orange + "⣻⣯⣿⣟⣿⣯⣿⣳⣿⣿⢿" + goldenRod + "⣏⡿⠉⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠿⠿⣿⣿⢾⣷⣿⣾⣽⣾⣽⣷⣯⣿⣷⣿⣾⣽⣷⣿⣾⣷⣯⣿⣾⣽⣯⣿⣷⣯⣷⣯⣿⣾⣽⣯⣿⣷⣯⣿⣽⣯⣿⣿⣽⣯⣿⣿⣽⣿⣯⣿⣿⣯⣿⣿⣿⣿⣿⣿⣯⣿⣾⣿⣿⣿⣿⣯⣿⣿⣷⣿⣿⣽⣯⣿⣯⣷⣿⣟⣿⠿⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + reset);



        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n" + centerText("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄", consoleWidth));
        System.out.println(blue + centerText("⚔️  LET THE HUNGER GAMES BEGIN! ⚔️", consoleWidth) + reset);
        System.out.println(centerText("▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄", consoleWidth));

        String[] options = {
                "1. Player vs Player",
                "2. Player vs AI",
                "3. Exit",
        };
        int totalWidth = 120;

        for(String option : options) {
            int padding = (totalWidth - option.length()) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + option);
        }
        System.out.println(" ".repeat((totalWidth - 35) / 2) + "▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄");
        System.out.print(" ".repeat((totalWidth - 35) / 2) + blue + "Choose game mode (1-3): " + reset);
    }

    private void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    //Helper method for centering text
    private String centerText(String text, int width) {
        int padSize = Math.max((width - text.length()) / 2, 0);
        return " ".repeat(padSize) + text;
    }

    private void startPlayerVsPlayer() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        String[] lines = {
                green + "    ===  Player vs Player Mode  ===",
                blue + "     Welcome to The Hunger Bites!",
                red + "Skills:" + reset,
                "1 = Basic (low dmg, 0 mana)",
                "2 = Skill (med dmg, mana cost)",
                "3 = Ultimate (high dmg, high mana cost)",
                "4 = Rest (heal 20HP)",
                "━─━─────────────༺༻─────────────━─━"
        };

        int totalWidth = 120; // match this to your title width
        int blockWidth = 35; // approximate width of your text block

        for (String line : lines) {
            int padding = (totalWidth - blockWidth) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + line);
        }


        // Character selection with validation
        Character player1 = selectCharacterWithValidation(cyanBold + "Player 1" + reset);
        Character player2 = selectCharacterWithValidation(purpleBold + "Player 2" + reset);

        startBattle(player1, player2);
    }

    private void startPlayerVsAi(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        String[] lines = {
                green + "     === Player vs Ai Mode ===",
                blue + "    Welcome to The Hunger Bites!",
                red + "Skills:" + reset,
                "1 = Basic (low dmg, 0 mana)",
                "2 = Skill (med dmg, mana cost)",
                "3 = Ultimate (high dmg, high mana cost)",
                "4 = Rest (heal 20HP)",
                "━─━─────────────༺༻─────────────━─━"
        };

        int totalWidth = 120; // match this to your title width
        int blockWidth = 35; // approximate width of your text block

        for (String line : lines) {
            int padding = (totalWidth - blockWidth) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + line);
        }

        // Character selection with validation
        Character player1 = selectCharacterWithValidation(cyanBold + "Player 1");
        Character player2 = selectCharacterWithValidation(purpleBold + "AI");

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
        scanner.nextLine();
        return characterManager.selectCharacter(scanner, playerName);
    }


    private void startBattle(Character player1, Character player2) {
        System.out.println("\n" + cyanBold + player1.getName() + reset + " VS " + purpleBold + player2.getName() + reset + "!");
        System.out.println(red + "The battle begins!\n");

        Character[] players = {player1, player2};
        int currentTurn = 0;

        while (!battleSystem.isBattleOver(player1, player2)) {
            Character currentPlayer = players[currentTurn % 2];
            Character opponent = players[(currentTurn + 1) % 2];

            int skillChoice;

            if (aiMode && currentPlayer == player2) {
                skillChoice = (int) (Math.random() * 4) + 1; // random skill 1–3
                System.out.println(purpleBold + "\n--- AI's Turn ---" + reset);
                displayBattleStatus(currentPlayer);
                System.out.println(red + "AI chooses skill " + reset + skillChoice + "!");
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
        System.out.println(cyanBold + "\n--- " + currentPlayer.getName() + "'s Turn ---" + reset);
        displayBattleStatus(currentPlayer);
        System.out.print(blue + "Choose skill " + reset + "(1=Basic, 2=Skill, 3=Ultimate, 4=Rest): ");
        return getValidInput(1, 4);
    }

    private void displayBattleStatus(Character currentPlayer) {
        System.out.println(yellow + currentPlayer.getName() + ": " + reset +
                currentPlayer.getHealth() + "/" + currentPlayer.getMaxHealth() + " HP");
        System.out.println(yellow + currentPlayer.getName() + " Mana: " + reset +
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
        clearScreen();
        int consoleWidth = 120;

        String[] gameOver = {
                red +
                    "      ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ",
                    "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗",
                    "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝",
                    "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║██║   ██║██╔══╝  ██╔══██╗",
                    "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║",
                    "     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝"
                + reset
        };

        // Center the ASCII art
        for (String line : gameOver) {
            System.out.println(centerText(line, consoleWidth));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(centerText(loser.getName() + " has fallen!", consoleWidth));
        //will add a callout later
        System.out.println(lightYellow + centerText("═══ \uD80C\uDE86 YOU WON! \uD80C\uDE87 ═══", consoleWidth));
        //
        System.out.println(gold + centerText("\uD83D\uDC51 " + winner.getName() + " is the winner! \uD83D\uDC51", consoleWidth) + reset);
        System.out.println();
        System.out.println(lightOrange + centerText("Battle Statistics:", consoleWidth));
        System.out.println(limeGreen + centerText("Winner HP: " + winner.getHealth() + "/" + winner.getMaxHealth(), consoleWidth));
        System.out.println(limeGreen + centerText("Winner Mana: " + winner.getCurrentMana() + "/" + winner.getMaxMana(), consoleWidth) + reset);
    }
}