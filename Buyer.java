public class Buyer extends User {
    private String firstName;
    private String username;
    private String shippingAddress;

    public Buyer(String name, String firstName, String username, String email, String phone, String shippingAddress) {
        super(name, email, phone);
        this.firstName = firstName;
        this.username = username;
        this.shippingAddress = shippingAddress;
    }

    // Getters and setters

    public String getFirstName() { return firstName; }
    public String getUsername() { return username; }
    public String getShippingAddress() { return shippingAddress; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setUsername(String username) { this.username = username; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }
    
}
