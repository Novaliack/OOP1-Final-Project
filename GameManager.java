package com.batakers.thehungerbites;

import java.util.InputMismatchException;
import java.util.Scanner;


public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private CharacterManager characterManager = new CharacterManager();
    private BattleSystem battleSystem = new BattleSystem();
    private boolean aiMode = false; // track if playing vs AI
    private boolean arcadeMode = false;
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


            int choice = getValidInput(1, 4);

            switch (choice) {
                case 1:
                    startPlayerVsPlayer();
                    break;
                case 2:
                    aiMode = true;
                    startPlayerVsAi();
                    break;
                case 3:
                    arcadeMode = true;
                    startArcade();
                    break;
                case 4:
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
                "3. Arcade Mode",
                "4. Exit",
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
                green + "   ===  Player vs Player Mode  ===",
                blue + "    Welcome to The Hunger Bites!",
                red + "Skills:" + reset,
                "1 = Basic (low dmg, 0 mana)",
                "2 = Skill (med dmg, mana cost)",
                "3 = Ultimate (high dmg, high mana cost)",
                "4 = Rest (heal 10% of max)",
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
        player1.setName("Player 1 (" + player1.getName() + ")");
        player2.setName("Player 2 (" + player2.getName() + ")");

        player1.setPlayer(true);
        player2.setPlayer(false);

        startBattle(player1, player2);
    }

    private void startArcade() {
        System.out.println("\n\n\n\n\n");
        String[] header = {
                green + "       ===  Arcade Mode  ===",
                blue + "    Welcome to The Hunger Bites!",
        };

        String[] skills = {
                red + "Skills:" + reset,
                "1 = Basic (low dmg, 0 mana)",
                "2 = Skill (med dmg, mana cost)",
                "3 = Ultimate (high dmg, high mana cost)",
                "4 = Rest (heal 10% of max)",
                "━─━─────────────༺༻─────────────━─━",
        };

        int totalWidth = 120;
        int blockWidth = 35;

        for (String line : header) {
            int padding = (totalWidth - blockWidth) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + line);
        }

        System.out.println(lightOrange + "               Pick your favorite food mascot and battle through a whole meal of rivals in one intense run!");
        System.out.println(lightOrange + "               Your health carries over between fights. So grab your power-ups after each victor to defeat");
        System.out.println(lightOrange + "                the GAME MASTERS favorites. If you fall, it's back to the start in this one-shot challenge");
        System.out.println(lightOrange + "                            where you conquer the gauntlet or start over from the beginning!");
        System.out.println();

        for (String line : skills) {
            int padding = (totalWidth - blockWidth) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + line);
        }


        // Select player character once
        Character player = selectCharacterWithValidation(cyanBold + "Player");


        // Create array of the 5 picks (1-5)
        int[] characterIds = {1, 2, 3, 4, 5};

        // Remove player's character ID from the array
        int playerId = -1;
        for (int i = 0; i < characterIds.length; i++) {
            Character testChar = characterManager.createCharacter(characterIds[i]);
            if (testChar.getName().equals(player.getName())) {
                playerId = characterIds[i];
                // Mark this ID as used (set to 0)
                characterIds[i] = 0;
                break;
            }
        }

        // Shuffle the remaining character IDs
        for (int i = 5 - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = characterIds[i];
            characterIds[i] = characterIds[j];
            characterIds[j] = temp;
        }

        int round = 1;
        boolean playerWonArcade = true;

        // Fight 5 unique AI characters
        for (int i = 0; i < 5 && round <= 5; i++) {
            if (characterIds[i] == 0 || characterIds[i] == playerId) continue;

            Character ai = characterManager.createCharacter(characterIds[i]);
            applyNameChange(ai);
            System.out.println(blue + "\n--- Round " + round + " ---" + reset);
            System.out.println("Next Battle: " + ai.getName() + " appears!\n");

            arcadeMode = true;

            // Start battle
            startBattle(player, ai);
            // Show reward selection after winning a round
            if (player.isAlive() && round < 5) {
                showRewardSelection(player);
            }
            if (!player.isAlive()) {
                playerWonArcade = false;
                break;
            }

            round++;

            if (round <= 5 && player.isAlive()) {
                System.out.print(blue + "\nPress Enter to continue to next round..." + reset);
                scanner.nextLine();
                scanner.nextLine(); // Extra nextLine to clear buffer
            }
        }

        // Final arcade result
        if (playerWonArcade && player.isAlive()) {
            System.out.println(gold + "\n ARCADE MODE COMPLETE! " + reset);
            System.out.println(green + "You defeated all 5 opponents! You are the ultimate champion!" + reset);
            arcadeMode = false;
        } else {
            System.out.println(red + "\n GAME OVER " + reset);
            System.out.println(yellow + "You made it to Round " + (round - 1) + ". Better luck next time!" + reset);
            arcadeMode = false;
        }
    }
    private void showRewardSelection(Character player) {
        System.out.println("\u001B[38;5;220m" + "\n ROUND COMPLETE! Choose your reward: " + "\u001B[0m");
        System.out.println("1. " + "\u001B[32m" + "Heal 50% HP & Full Mana" + "\u001B[0m");
        System.out.println("2. " + "\u001B[34m" + "+100% Damage Boost" + "\u001B[0m");
        System.out.println("3. " + "\u001B[1;35m" + "+25 Max Health" + "\u001B[0m");
        System.out.println("4. " + "\u001B[33m" + "+15 Max Mana" + "\u001B[0m");

        System.out.print("\u001B[34m" + "Choose reward (1-4): " + "\u001B[0m");
        int choice = getValidInput(1, 4);

        switch (choice) {
            case 1:
                // Heal max HP AND full mana restore
                int healAmount = (int)(player.getMaxHealth() * .5);
                int newHealth = Math.min(player.getHealth() + healAmount, player.getMaxHealth());
                player.setHealth(newHealth);
                player.setCurrentMana(player.getMaxMana()); // Full mana restore
                System.out.println("\u001B[32m" + "✓ Healed " + healAmount + " HP! (" + newHealth + "/" + player.getMaxHealth() + ")" + "\u001B[0m");
                System.out.println("\u001B[32m" + "✓ Mana fully restored! (" + player.getCurrentMana() + "/" + player.getMaxMana() + ")" + "\u001B[0m");
                break;
            case 2:
                // Damage boost
                player.increaseDamage(1);
                System.out.println("\u001B[34m" + "✓ Damage increased by 100%! (Total: +" +
                        (int)((player.getDamageMultiplier() - 1.0) * 100) + "%)" + "\u001B[0m");
                break;
            case 3:
                // Max health increase
                player.setMaxHealth(player.getMaxHealth() + 25);
                player.setHealth(player.getHealth() + 25); // Also heal the new HP
                System.out.println("\u001B[1;35m" + "✓ Max health increased by 25!" + "\u001B[0m");
                break;
            case 4:
                // Max mana increase
                player.setMaxMana(player.getMaxMana() + 15);
                player.setCurrentMana(player.getCurrentMana() + 15); // Also restore the new mana
                System.out.println("\u001B[33m" + "✓ Max mana increased by 15!" + "\u001B[0m");
                break;
        }

        // Show updated stats
        System.out.println("\u001B[32m" + "Current Stats - HP: " + player.getHealth() + "/" + player.getMaxHealth() +
                " | Mana: " + player.getCurrentMana() + "/" + player.getMaxMana() + "\u001B[0m");

        // Show damage multiplier if > 1.0
        if (player.getDamageMultiplier() > 1.0) {
            System.out.println("\u001B[34m" + "Damage Multiplier: " + player.getDamageMultiplier() + "x" + "\u001B[0m");
        }
    }
    private Character applyNameChange(Character character) {

        String originalName = character.getName();
        String changedName = getChangedName(originalName);

        if (!changedName.equals(originalName)) {
            character.setName(changedName);
        }

        return character;
    }

    private String getChangedName(String originalName) {
        if(arcadeMode){
            switch (originalName.toLowerCase()) {
                case "jollibee":
                    return "Geoffred's pick, Jollibee";
                case "ronald mcdonald":
                    return "Jandyll's pick, Ronald McDonald";
                case "burger king":
                    return "Kimjie's pick, The Burger King";
                case "julie's":
                    return "Louella's pick, Julie's the baker";
                case "poco":
                    return "Keeia's favourite, poco the potato";
                default:
                    return originalName;
            }
        }
        if(aiMode){
            switch (originalName.toLowerCase()) {
                case "jollibee":
                    return "AI Jollibee";
                case "ronald mcdonald":
                    return "AI Ronald McDonald";
                case "burger king":
                    return "AI Burger King";
                case "julie's":
                    return "AI Julie's";
                case "poco":
                    return "AI Poco";
                case "colonel sanders":
                    return "AI Colonel Sanders";
                case "taco bell":
                    return "AI Taco Bell";
                case "wendy's":
                    return "AI Wendy's";
                default:
                    return originalName;
            }
        }
        return originalName;
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
                "4 = Rest (heal 10% of max)",
                "━─━─────────────༺༻─────────────━─━"
        };

        int totalWidth = 120;
        int blockWidth = 35;

        for (String line : lines) {
            int padding = (totalWidth - blockWidth) / 2;
            System.out.println(" ".repeat(Math.max(0, padding)) + line);
        }

        // Character selection with validation
        Character player1 = selectCharacterWithValidation(cyanBold + "Player 1");
        Character player2 = selectCharacterWithValidation(purpleBold + "AI");

        player1.setPlayer(true);
        player2.setPlayer(false);

        applyNameChange(player2);
        startBattle(player1, player2);

    }
    // checks input for character
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
        int turnCounter = 1;

        while (!battleSystem.isBattleOver(player1, player2)) {
            System.out.println();
            System.out.println(yellow + "==== Turn " + turnCounter + " ====" + reset);

            Character currentPlayer = players[currentTurn % 2];
            Character opponent = players[(currentTurn + 1) % 2];

            int skillChoice;

            //AI FOR BATTLESS
            if ((aiMode || arcadeMode) && currentPlayer == player2) {
                currentPlayer.regenerateMana();

                skillChoice = (int) (Math.random() * 4) + 1;
                System.out.println(purpleBold + "\n--- " + currentPlayer.getName() + "'s Turn ---" + reset);
                displayBattleStatus(currentPlayer);
                System.out.println(red + currentPlayer.getName() + " chooses skill " + reset + skillChoice + "!");
            } else {
                skillChoice = getPlayerSkillChoice(currentPlayer);
            }

            battleSystem.executePlayerTurn(currentPlayer, opponent, skillChoice);

            if (!opponent.isAlive()) {
                if (!arcadeMode) {
                    endBattle(currentPlayer, opponent);
                } else {
                    System.out.println(gold + "\n ROUND WON! " + reset);
                    System.out.println(green + currentPlayer.getName() + " defeated " + opponent.getName() + "!" + reset);
                }
                break;
            }

            currentTurn++;
            turnCounter++;
        }
    }
    private int getPlayerSkillChoice(Character currentPlayer) {
        System.out.println(cyanBold + "\n--- " + currentPlayer.getName() + "'s Turn ---" + reset);
        currentPlayer.regenerateMana();
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

    // for checking general input
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

        if(winner.isPlayer()) {
            //player won
            System.out.println(lightYellow + centerText("═══ \uD80C\uDE86 YOU WON! \uD80C\uDE87 ═══", consoleWidth));
            System.out.println(gold + centerText("\uD83D\uDC51 " + winner.getName() + " is the winner! \uD83D\uDC51", consoleWidth) + reset);
        } else {
            //player lost
            System.out.println(redOrange + centerText("═══ \uD80C\uDE88 YOU LOST! \uD80C\uDE89 ═══", consoleWidth));
            System.out.println(gold + centerText("\uD83D\uDC51 " + winner.getName() + " is the winner! \uD83D\uDC51", consoleWidth) + reset);
        }

        System.out.println();
        System.out.println(lightOrange + centerText("Battle Statistics:", consoleWidth));
        System.out.println(limeGreen + centerText("Winner HP: " + winner.getHealth() + "/" + winner.getMaxHealth(), consoleWidth));
        System.out.println(limeGreen + centerText("Winner Mana: " + winner.getCurrentMana() + "/" + winner.getMaxMana(), consoleWidth) + reset);
    }
}