import java.io.*;

public class UserManager {
    private String csvFile;

    public UserManager(String csvFile) {
        this.csvFile = csvFile;
    }

    public void addUser(User user) {
        try (FileWriter fw = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            String userInfo = getUserInfo(user);
            out.println(userInfo);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
        }
    }

    private String getUserInfo(User user) {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append(user.getClass().getSimpleName()).append(",");
        userInfo.append(user.name).append(",");
        userInfo.append(user.email).append(",");
        userInfo.append(user.phone).append(",");
        userInfo.append(user.password);
    
        if (user instanceof Buyer) {
            Buyer buyer = (Buyer) user;
            userInfo.append(",").append(buyer.getFirstName());
            userInfo.append(",").append(buyer.getUsername());
            userInfo.append(",").append(buyer.getShippingAddress());
        } else if (user instanceof Seller) {
            Seller seller = (Seller) user;
            userInfo.append(",").append(seller.getAddress());
        }
    
        return userInfo.toString();
    }
    

    public boolean checkUser(String identifier, String password, String userType) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                boolean isUserMatch = false;
    
                if (userType.equals("Buyer") && values[0].equals(userType)) {
                    // Pour les acheteurs, vérifiez le username (supposons qu'il soit en 3ème position)
                    isUserMatch = values[6].equals(identifier);
                } else if (userType.equals("Seller") && values[0].equals(userType)) {
                    // Pour les revendeurs, vérifiez le name (supposons qu'il soit en 2ème position)
                    isUserMatch = values[1].equals(identifier);
                }
    
                if (isUserMatch && values[4].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
        }
        return false;
    }
    
}
