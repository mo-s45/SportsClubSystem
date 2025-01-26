import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClubManager clubManager = new ClubManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("--------------------------------------");
            System.out.println("Welcome to the Edinburgh Sports & Leisure Club!");
            System.out.println("Press the number corresponding to your choice of action and press Enter:");
            System.out.println("1. Member Sign-Up    2. Member Log-in    3. Staff Log-in    4. Exit");
            System.out.println("--------------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    boolean valid = false;
                    while (!valid) {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        if (username.trim().isEmpty()) {
                            System.out.println("Invalid username. Please try again.");
                            continue;
                        }

                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        if (password.length() < 6) {
                            System.out.println("Password must be at least 6 characters long. Please try again.");
                            continue;
                        }

                        System.out.print("Enter full name: ");
                        String fullName = scanner.nextLine();
                        if (fullName.trim().isEmpty()) {
                            System.out.println("Full name cannot be empty. Please try again.");
                            continue;
                        }

                        clubManager.registerMember(username, password, fullName);
                        System.out.println("Registration successful! You may now log in.");
                        valid = true;
                    }


                case 2:
                    // MEMBER LOG-IN
                    System.out.println("\nLogin");
                    System.out.print("Enter username: ");
                    String enteredUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String enteredPassword = scanner.nextLine();
                    Member loggedInMember = clubManager.login(enteredUsername, enteredPassword);
                    if (loggedInMember != null) {
                        System.out.println("Login successful!");
                        memberMenu(scanner, clubManager, loggedInMember); // Direct user to Member menu
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    // STAFF LOG-IN (to be implemented later)
                    System.out.println("Staff login is under development...Re-directing to main page...");
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting... Thank you for visiting the Edinburgh Sports & Leisure Club.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // MEMBER MENU - Member is directed to this menu upon successful log-in
    private static void memberMenu(Scanner scanner, ClubManager clubManager, Member loggedInMember) {
        boolean memberMenuRunning = true;
        while (memberMenuRunning) {
            System.out.println("\nMember Menu:");
            System.out.println("1. View Profile    2. Logout");
            System.out.print("Choose an action: ");
            int memberChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (memberChoice) {
                case 1:
                    clubManager.displayMemberInfo(loggedInMember);
                    break;
                case 2:
                    memberMenuRunning = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}