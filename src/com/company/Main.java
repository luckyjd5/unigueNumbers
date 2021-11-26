package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        do {
            System.out.println("Enter the amount of players playing:");
            int amtPlayers = amtPlayersIn();
            if (amtPlayers > -1) {
                break;
            }
        } while(true);
        int indexPlayer = 0;
        String[] placeholders = new String[9];
        Random rand = new Random();
        int indexComputer = 0;
        int playerCount = 0;
        int compCount = 0;

        for (int i = 0; i < 4; i++) {
            do {
                System.out.println("Enter a number:");
                indexPlayer = numInput();
                if (indexPlayer != -1) {
                    break;
                }
            } while (true);
            if (placeholders[indexPlayer] == null) {
                placeholders[indexPlayer] = "P";
            }
            indexComputer = rand.nextInt(8);
            if (placeholders[indexComputer] == null) {
                placeholders[indexComputer] = "C";
            }
        }
        for (int i = 0; i < placeholders.length; i++) {
            if (placeholders[i].equals("P")) {
                playerCount += 1;
            }
            else if (placeholders[i].equals("C")) {
                compCount += 1;
            }
        }
        if (playerCount > compCount) {
            System.out.println("You win!\nYou got " + playerCount + ", computer got " + compCount);
        }
        else if (playerCount < compCount) {
            System.out.println("You lose!\nYou got " + playerCount + ", computer got " + compCount);
        }
        else {
            System.out.println("It was a draw!\nYou got " + playerCount + ", computer got " + compCount);
        }
    }

    public static int numInput() {
        Scanner input = new Scanner(System.in);
        try {
            int userIn = input.nextInt();
            if (userIn > 0 && userIn < 10) {
                return userIn;
            }
            else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Enter a valid input");
            return -1;
        }
    }
    public static int amtPlayersIn() {
        Scanner input = new Scanner(System.in);
        try {
            int userIn = input.nextInt();
            if (userIn > 0) {
                return userIn;
            }
            else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Enter a valid input");
            return -1;
        }
    }
}
