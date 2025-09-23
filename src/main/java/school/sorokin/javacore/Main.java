package school.sorokin.javacore;

import school.sorokin.javacore.exception.NotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                String input = scanner.nextLine().trim();
                switch (input) {
                    case "1" -> bookManager.addContact();
                    case "2" -> bookManager.removeContact();
                    case "3" -> bookManager.showAllContacts();
                    case "4" -> bookManager.findContactByName();
                    case "5" -> bookManager.showContactsByGroup();
                    case "6" -> {
                        System.out.println("Thank you for using app Address-book!");
                        return;
                    }
                    default -> throw new InputMismatchException("Input data mismatch. Please try again.");
                }
            } catch (InputMismatchException | NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Menu of commands:");
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Show all contacts");
        System.out.println("4. Find contact by name");
        System.out.println("5. Show contacts by group");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}