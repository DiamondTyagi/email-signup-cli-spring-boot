package com.example.email_signup;

import com.example.email_signup.service.EmailSignupService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EmailSignupApplication implements CommandLineRunner {

    private final EmailSignupService service;

    public EmailSignupApplication(EmailSignupService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmailSignupApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Email");
            System.out.println("2. View Registered Emails");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    service.registerEmail(email);
                }
                case 2 -> service.viewEmails();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
