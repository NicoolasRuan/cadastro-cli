package View;

import java.util.Scanner;

public class UserView {
    private Scanner scanner;

    public UserView() {
        scanner = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displayUser(String userInfo) {
        System.out.println(userInfo);
    }
}
