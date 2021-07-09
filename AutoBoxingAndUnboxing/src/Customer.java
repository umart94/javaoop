import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransactionAmount) {
        this.name = name;
        transactions = new ArrayList<Double>();
        addTransaction(initialTransactionAmount);
    }

    public String getName() {
        return name;
    }

    public void addTransaction(double amount){

        this.transactions.add(amount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
