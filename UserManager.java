import java.io.*;
import java.util.*;

public class UserManager {
    private String csvFile;

    public UserManager(String csvFile) {
        this.csvFile = csvFile;
    }

    public void addUser(User user) {
        try (FileWriter fw = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getClass().getSimpleName() + "," + user.name + "," + user.email + "," + user.phone);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file.");
        }
    }

    public boolean checkUser(String name, String userType) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(userType) && values[1].equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
        }
        return false;
    }
}
