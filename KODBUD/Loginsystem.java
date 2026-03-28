import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Loginsystem {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> users = new HashMap<>();
        users.put("admin", "1234");
        users.put("sindhu", "sindhu123");
        users.put("user1", "abcd");
        System.out.println(" LOGIN SYSTEM ");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                System.out.println(" Login Successful! Welcome, " + username);
            } else {
                System.out.println(" Incorrect Password!");
            }
        } else {
            System.out.println(" Username not found!");
        }
        sc.close();
    }
}