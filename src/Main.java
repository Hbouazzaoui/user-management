import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
        // TODO: generate id automatically
        System.out.print("Enter User ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter User Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("User Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("Select Role:");
        System.out.println("1 - Admin");
        System.out.println("2 - Employee");
        System.out.println("3 - Client");
        System.out.print("Enter the role number: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();
        String role;

        while (true) {
            if (roleChoice == 1) {
                role = "Admin";
                break;
            } else if (roleChoice == 2) {
                role = "Employee";
                break;
            } else if (roleChoice == 3) {
                role = "Client";
                break;
            } else {
                System.err.println("Invalid role choice. try again");
            }
        }
        Role rol = new Role(role);
        User user = new User(id,name,age,email,phone,password,rol);
        users.add(user);
        System.out.println("User added successfully!");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====================================");
            System.out.println("|             MAIN MENU            |");
            System.out.println("====================================");
            System.out.println("|  1. Add a User                   |");
            System.out.println("|  2. Display All Users            |");
            System.out.println("|  3. Exit                         |");
            System.out.println("====================================");
            System.out.print(" Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:

                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
