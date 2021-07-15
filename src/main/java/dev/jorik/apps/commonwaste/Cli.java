package dev.jorik.apps.commonwaste;

import dev.jorik.apps.commonwaste.ui.Feature;

import java.util.Scanner;

public class Cli{

    public static void main(String[] args) {
        new Feature(new Scanner(System.in)).start();
    }
}
