package com.example.email_signup.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmailSignupService {

    private final Set<String> emails = new HashSet<>();

    public void registerEmail(String email) {
        email = email.toLowerCase();

        if (emails.contains(email)) {
            System.out.println("Email already registered!");
        } else {
            emails.add(email);
            System.out.println("Email registered successfully!");
        }
    }

    public void viewEmails() {
        if (emails.isEmpty()) {
            System.out.println("No emails registered yet.");
        } else {
            System.out.println("Registered Emails:");
            emails.forEach(System.out::println);
        }
    }
}
