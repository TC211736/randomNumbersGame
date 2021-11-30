package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to begin the game? y/n");
        String userInput = input.next();

        if (userInput.equals("n")) {
            System.exit(0);
        }
    }

    private static int randomNumber() {
        Random r = new Random();
        int low = 20;
        int high = 30;
        int randNum = r.nextInt(high - low) + low;
        System.out.println("Your number is " + randNum);
        return randNum;
    }

    private static int getComputerChoice(Random r) {
        int low = 1;
        int high = 4;

        int computerChoice = r.nextInt(high - low) + low;
        System.out.printf("The computer will take away " + computerChoice);
        return computerChoice;
    }

    private static int getUserChoice(Scanner input) {
        System.out.println("How much would you like to take away?");
        int userChoice = input.nextInt();

        if (userChoice > 3 || userChoice < 1) {
            System.out.println("Please choose a number between 1 and 3. How much would you like to take away?");
            userChoice = input.nextInt();
        }
        return userChoice;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        startGame();
        int randNum = randomNumber();
        boolean endWhile = false;

        while (!endWhile) {
            int userChoice = getUserChoice(input);
            randNum = randNum - userChoice;
            System.out.println("You have " + randNum + " left");
            if (randNum <= 0) {
                endWhile = true;
                System.out.println("You lost");
                System.exit(0);
            }


            int computerChoice = getComputerChoice(r);
            randNum = randNum - computerChoice;
            System.out.println(" You have " + randNum + " left");
            if (randNum <= 0) {
                endWhile = true;
                System.out.println("You won");
            }
        }
    }
}

