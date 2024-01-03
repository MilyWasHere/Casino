import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account user = new Account();
        UserInterface n = new UserInterface(scanner, user);
        n.start();
    }
}