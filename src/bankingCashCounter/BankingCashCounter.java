package bankingCashCounter;

import java.util.Scanner;

public class BankingCashCounter {
    static Scanner scanner = new Scanner(System.in);
    int balance = 0;
    MyQueue<Integer> people = new MyQueue<Integer>();

    public static void main(String[] args) {
        int choice = 0;

        BankingCashCounter counter = new BankingCashCounter();

        do {
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: People ahead of you");
            System.out.println("4: Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            counter.action(choice);
        } while (choice != 4);

        if (counter.balance == 0) {
            System.out.println("Expression is balanced");
        } else {
            System.out.println("Expression is not balanced");
        }
    }

    void action(int choice) {
        int money;
        switch (choice) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                money = scanner.nextInt();
                people.enqueue(money);
                balance += money;
                System.out.println();
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                money = scanner.nextInt() * -1;
                people.enqueue(money);
                balance += money;
                System.out.println();
                break;
            case 3:
                System.out.println("\n" + (people.size() - 1) + " people ahead of you\n");
                break;
            default:
        }
    }
}