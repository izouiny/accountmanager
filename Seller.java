public class Seller extends User {
    private String address;

    public Seller(String name, String email, String phone, String address) {
        super(name, email, phone);
        this.address = address;
    }

    // Getters and setters

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
