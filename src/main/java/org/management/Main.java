package org.management;

import org.management.controller.ContactAppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    private static void contactManagementMainMenu(){
        String menu = """
                ===============
                1 -> Register
                2 -> Login
                3 -> Add Contact
                4 -> Delete Contact
                5 -> Edit Profile
                6 -> Delete Profile
                7 -> Find Contact
                8 -> Find AllContact
                """;
        String response = input(menu);
        services(response);
    }

    private static void services(String response) {
        switch(response){
            case "1" -> register();
            case "2" -> login();
            case "3" -> addContact();
            case "4" -> deleteContact();
            case "5" -> editProfile();
            case "6" -> deleteProfile();
            case "7" -> findContact();
            case "8" -> findAllContact();
            case "9" -> exit();
        }
    }

    private static void exit() {
        System.exit(10);
    }

    private static void findAllContact() {
        String email = input("Enter mail");
    }

    private static void findContact() {
        String name = input("Enter name");
        String email = input("Enter mail");
    }

    private static void deleteProfile() {
        String email = input("Enter your mail");
    }

    private static void editProfile() {
        String name = input("Enter name");
        String email = input("Enter mail");
    }

    private static void deleteContact() {
        String name = input("Enter name");
        String email = input("Enter mail");
    }

    private static void addContact() {
        String name = input("Enter your name");
        String phoneNumber = input("Enter your phoneNumber");
        String email = input("Enter your mail");
    }

    private static void login() {
        String email = input("Enter your email");
        String password = input("Enter your password");
    }

    private static void register() {
        String name = input("Enter your name");
        String password = input("Enter your password");
        contactManagementMainMenu();
    }

    private static String input(String menu) {
        System.out.println(menu);
        return scanner.nextLine();
    }

}