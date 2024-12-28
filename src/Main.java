import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();

    public static void addUser() {
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
                System.err.println("Invalid role choice. Try again.");
            }
        }

        Role rol = new Role(role);
        User user = new User(id, name, age, email, phone, password, rol);
        users.add(user);
        System.out.println("User added successfully!");
    }

    public static List<User> displayUsers() {
        return users;
    }

    public static void updateUser() {
        if (users.isEmpty()) {
            System.out.println("There are no users!");
            return;
        }

        System.out.print("Enter the User ID you want to modify: ");
        String id = scanner.nextLine();

        for (User user : users) {
            if (id.equals(user.getId())) {
                System.out.println("User found ");
                System.out.println(user);

                System.out.println("\n What do you want to modify:");
                System.out.println("1 - Name");
                System.out.println("2 - Age");
                System.out.println("3 - Phone Number");
                System.out.println("4 - Email");
                System.out.println("5 - Password");
                System.out.println("6 - Return");
                System.out.print("=> ");

                System.out.println("enter choice :");
                int choice=scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("New name: ");
                        String NewName=scanner.nextLine();
                        user.setName(NewName);
                        System.out.println("Updated!");
                        break;
                    case 2:
                        System.out.print("New age: ");
                        int newAge;
                        try {
                            newAge = scanner.nextInt();
                            user.setAge(newAge);
                            System.out.println("Updated!");
                        } catch (Exception e) {
                            System.out.println("Invalid age. Update canceled.");
                            scanner.nextLine();
                        }
                        break;
                    case 3:
                        System.out.print("New phone number: ");
                        user.setPhone(scanner.nextLine());
                        System.out.println("Updated!");
                        break;
                    case 4:
                        System.out.print("New email: ");
                        user.setEmail(scanner.nextLine());
                        System.out.println("Updated!");
                        break;
                    case 5:
                        System.out.print("New password: ");
                        user.setPassword(scanner.nextLine());
                        System.out.println("Updated!");
                        break;
                    case 6:
                        System.out.println("Returning to main menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Returning to main menu.");
                }
                break;
            }
        }

    }

    public static  void SearchUser(){
        System.out.println("enter id :");
        String id = scanner.nextLine();
        for ( User user :users ){
            if(id.equals(user.getId()) ){
                System.out.println(user);
            }
        }
    }

    public static  void DeleteUser(){
        if (users.isEmpty()) {
            System.out.println("There are no users!");
            return;
        }
        System.out.println("enter id user :");
        String id = scanner.nextLine();

        users.removeIf(user -> user.getId().equals(id));


        System.out.println("User with ID " + id + " delete succes!");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====================================");
            System.out.println("|             MAIN MENU            |");
            System.out.println("====================================");
            System.out.println("|  1. Add a User                   |");
            System.out.println("|  2. Display All Users            |");
            System.out.println("|  3. Update a User                |");
            System.out.println("|  4. Search User                   |");
            System.out.println("|  5. Delete User                  |");
            System.out.println("|  6. Exit                         |");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    for (User user : displayUsers()) {
                        System.out.println(user);
                    }
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    SearchUser();
                    break;
                case 5:
                    DeleteUser();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:

                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

