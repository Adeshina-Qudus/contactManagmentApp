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
}