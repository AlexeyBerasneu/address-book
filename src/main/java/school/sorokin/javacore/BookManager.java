package school.sorokin.javacore;

import school.sorokin.javacore.exception.NotFoundException;

import java.util.*;
import java.util.regex.Pattern;

public class BookManager {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Enum, List<Contact>> books = new HashMap<>();
    private final Set<Contact> listOfContacts = new LinkedHashSet<>();
    private static final String PHONE_REGEX = "^\\+?[0-9 .()-]{7,20}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String INVALID_MESSAGE = "Invalid %s try again.\n";
    private static final String ENTER_MESSAGE = "Enter %s : ";

    public void addContact() {
        String name = validName("Name");
        String phone = validEmailAndPhone("Phone", PHONE_REGEX);
        String email = validEmailAndPhone("Email", EMAIL_REGEX);
        Enum typeOfGroup = choiceOfGroup("group");
        Contact contact = new Contact(name, phone, email, typeOfGroup);
        if (!listOfContacts.add(contact)) {
            System.out.printf("Contact with email '%s' already exists.\n", contact.getEmail().toString());
        } else {
            books.computeIfAbsent(contact.getTypeOfGroup(), g -> new ArrayList<>()).add(contact);
            System.out.println("Contact added successfully.");
            ;
        }
    }

    public void removeContact() {
        String email = validEmailAndPhone("Email", EMAIL_REGEX).toLowerCase();
        int indicate = 0;
        Iterator<Contact> iterator = listOfContacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getEmail().toLowerCase().equals(email)) {
                iterator.remove();
                books.get(contact.getTypeOfGroup()).remove(contact);
                indicate++;
            }
        }
        checkQuantity(email, indicate);
        System.out.printf("Contact with email - '%s' has been removed.\n", email);
    }

    public void showAllContacts() {
        if (!listOfContacts.isEmpty()) {
            listOfContacts.forEach(System.out::println);
        } else {
            System.out.println("Address book is empty");
        }
    }

    public void findContactByName() {
        String name = validName("Name").toLowerCase();
        int indicate = 0;
        for (Contact contact : listOfContacts) {
            if (contact.getName().toLowerCase().equals(name)) {
                System.out.println(contact);
                indicate++;
            }
        }
        checkQuantity(name, indicate);
    }

    public void showContactsByGroup() {
        Enum group = choiceOfGroup("group");
        if (books.get(group) != null) {
            if (!(books.get(group).isEmpty())) {
                System.out.print("List of contacts in group " + group.toString() + ":\n");
                books.get(group).forEach(contact -> System.out.println(contact));
            } else {
                System.out.printf("The group %s is empty.\n", group);
            }
        } else {
            System.out.printf("The group %s is empty.\n", group);
        }
    }

    private Enum choiceOfGroup(String nameOfField) {
        while (true) {
            System.out.print("Choose group :\n" + "1. Family\n2. Work\n3. Friends\n Enter your choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                return Group.FAMILY;
            } else if (choice.equals("2")) {
                return Group.WORK;
            } else if (choice.equals("3")) {
                return Group.FRIENDS;
            }
            System.out.printf(INVALID_MESSAGE, nameOfField);
        }
    }

    //validate phone number and email according to REGEX
    private String validEmailAndPhone(String nameOfField, String regex) {
        System.out.print("\nExample email: xxxxx@xxx.xxx\nExample phone number: +17542757357(no less then 7 numbers)\n");
        System.out.println();
        while (true) {
            System.out.printf(ENTER_MESSAGE, nameOfField);
            String str = scanner.nextLine().trim();
            if (!str.isEmpty() && Pattern.matches(regex, str)) {
                return str;
            } else {
                System.out.printf(INVALID_MESSAGE, nameOfField);
            }
        }
    }

    //validate name
    private String validName(String nameOfField) {
        while (true) {
            System.out.printf(ENTER_MESSAGE, nameOfField);
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.printf(INVALID_MESSAGE, nameOfField);
            }
        }
    }

    //check quantity of Contact
    private void checkQuantity(String nameOfField, int indicate) {
        if (indicate == 0) {
            throw new NotFoundException(String.format("Contact with '%s' not found.", nameOfField));
        }
    }
}
