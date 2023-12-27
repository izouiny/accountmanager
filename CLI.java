import java.util.Scanner;

public class CLI {
    private UserManager userManager;
    private Scanner scanner;

    public CLI() {
        userManager = new UserManager("users.csv");
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Sign Up\n2. Log In\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void signUp() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.println("1. Buyer\n2. Seller");
        System.out.print("Choose type: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (type == 1) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter shipping address: ");
            String shippingAddress = scanner.nextLine();

            Buyer buyer = new Buyer(name, firstName, username, email, phone, shippingAddress);
            userManager.addUser(buyer);
        } else if (type == 2) {
            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            Seller seller = new Seller(name, email, phone, address);
            userManager.addUser(seller);
        } else {
            System.out.println("Invalid type.");
        }
    }

    private void logIn() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("1. Buyer\n2. Seller");
        System.out.print("Choose type: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String userType = (type == 1) ? "Buyer" : "Seller";
        if (userManager.checkUser(name, userType)) {
            System.out.println("Logged in successfully as " + userType);
        } else {
            System.out.println("User not found.");
        }
    }
}

