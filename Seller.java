public class Seller extends User {
    private String address;

    public Seller(String name, String email, String phone, String address, String password) {
        super(name, email, phone, password);
        this.address = address;
    }

    // Getter
    public String getAddress() {
        return address;
    }
}
