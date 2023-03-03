package DefiningClasses.BankAccount;

import java.util.*;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();

        BiFunction<BankAccount, String, String> getInterestFunction = (b, s) -> {
            int years = Integer.parseInt(s);

            return String.format("%.2f", b.getInterest(years));
        };
        while (!input.equals("End")) {
            String[] commandData = input.split("\\s+");
            String command = commandData[0];
            switch (command) {
                case "Create":
                    BankAccount Account = new BankAccount();
                    System.out.println("Account ID" + Account.getId() + " created");
                    accounts.put(Account.getId(), Account);
                    break;
                case "Deposit":
                    int Id = Integer.parseInt(commandData[1]);
                    double amount = Double.parseDouble(commandData[2]);
                    BankAccount bankAccount = accounts.get(Id);
                    if (!accounts.containsKey(Id)) {
                        System.out.println("Account does not exist");
                    } else {
                        bankAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, Id);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(commandData[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    String outputGetInterest = executeOnBankAccount(commandData, accounts, getInterestFunction);
                    System.out.println(outputGetInterest);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static String executeOnBankAccount(String[] commandData, Map<Integer, BankAccount> accounts, BiFunction<BankAccount, String, String> function) {
        int id = Integer.parseInt(commandData[1]);
        BankAccount account = accounts.get(id);
        if (account == null) {
            return "Account does not exist";
        }
        return function.apply(account, commandData[2]);
    }

}



