package DefiningClasses.BankAccount;

public class BankAccount {

    private static double interestRate = 0.02;
    private static int bankAccountCount = 1;
    private int id;
    double balance;

    public BankAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;

    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
