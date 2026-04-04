package codes;

import java.util.ArrayList;
import java.util.Scanner;

public class FInanceManager {
    ArrayList<String> finance = new ArrayList<>();
    double money;

    public void manageFinance(Scanner scanner) {
        System.out.println("Here in my app we help you manage and make good decisions with your finances");
        System.out.print("Enter amount of money: ");

        while (scanner.hasNextInt() && !scanner.hasNextDouble()) {
            System.out.println("Invalid! please enter a valid amount of money");
            scanner.next();
        }
        if (money < 0) {
            System.out.println("Invalid! please enter a valid amount of money");
            return;
        }
        money = scanner.nextDouble();
        // scanner.nextLine();

        System.out.println("Here is the best way to spend it based on analysis that's best suitable for you. ");
        System.out.println("\nMoney recieved is " + money);
        analyzeMoney(money);

    }

    private void analyzeMoney(double money) {
        System.out.println("1. Give to God " + 0.10 * money);
        System.out.println("2. Save  " + 0.15 * money);
        System.out.println("3. Buy want you need " + 0.30 * money);
        System.out.println("4. Get food " + 0.40 * money);
        System.out.println("5. Give to family/someone " + 0.05 * money);
    }
}
