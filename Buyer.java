public class Buyer extends User {
    private String firstName;
    private String username;
    private String shippingAddress;

    public Buyer(String name, String firstName, String username, String email, String phone, String shippingAddress, String password) {
        super(name, email, phone, password);
        this.firstName = firstName;
        this.username = username;
        this.shippingAddress = shippingAddress;
    }

    // Constructor

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
