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
        System.out.println("1. Buyer\n2. Seller");
        System.out.print("Choose type: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline
    
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        if (type == 1) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter shipping address: ");
            String shippingAddress = scanner.nextLine();
    
            Buyer buyer = new Buyer(name, firstName, username, email, phone, shippingAddress, password);
            userManager.addUser(buyer);
            System.out.println("Buyer account created successfully.");
        } else if (type == 2) {
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
    
            Seller seller = new Seller(name, email, phone, address, password);
            userManager.addUser(seller);
            System.out.println("Seller account created successfully.");
        } else {
            System.out.println("Invalid type.");
        }
    }    

    private void logIn() {
        System.out.println("1. Buyer\n2. Seller");
        System.out.print("Choose type: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline
    
        String identifier;
        if (type == 1) {
            System.out.print("Enter username: ");
            identifier = scanner.nextLine();
        } else {
            System.out.print("Enter name: ");
            identifier = scanner.nextLine();
        }
    
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        String userType = (type == 1) ? "Buyer" : "Seller";
        if (userManager.checkUser(identifier, password, userType)) {
            System.out.println("Logged in successfully as " + userType);
        } else {
            System.out.println("Incorrect username or password. Please try again.");
            start(); // Retour au menu principal
        }
    }
    
}
