import java.util.Scanner;

class User {
    String username;
    String password;
    String role; // "user" or "admin"

    User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }

    boolean isAdmin() {
        return role.equalsIgnoreCase("admin");
    }
}

public class KidsMonitoringApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined users
        User admin = new User("admin", "admin123", "admin");
        User user = new User("child1", "pass123", "user");

        System.out.println("Welcome to Kids Monitoring App!");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        User loggedInUser = null;

        if (admin.login(inputUsername, inputPassword)) {
            loggedInUser = admin;
        } else if (user.login(inputUsername, inputPassword)) {
            loggedInUser = user;
        }

        if (loggedInUser != null) {
            System.out.println("Login successful. Hello, " + loggedInUser.username + "!");

            if (loggedInUser.isAdmin()) {
                System.out.println("Access granted to monitor kids.");
                System.out.println("Monitoring child1’s app usage...");
            } else {
                System.out.println("You are a regular user. Monitoring is not allowed.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }
}
