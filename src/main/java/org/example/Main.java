package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {

            System.out.println("What is speed in km per hour?");
            var speed = scanner.nextDouble();

            if (speed == 0)
                break;

            System.out.println("How much time do you spent in a ride?");
            var time = scanner.nextDouble();

            var result = speed*time;
            System.out.println("Result=" + result);
        }


    }
}