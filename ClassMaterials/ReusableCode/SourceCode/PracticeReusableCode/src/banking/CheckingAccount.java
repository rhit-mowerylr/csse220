package banking;

public class CheckingAccount extends BankAccount {
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 1.50;

    private int transactionCount;

    public CheckingAccount(){
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double amount){
        super.deposit(amount);
        this.transactionCount++;
    }

    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        this.transactionCount++;
    }

    /**
     * Deducts this month's transaction fees
     * from the balance and
     * resets the transaction count
     */
    public void deductFees(){
        double fees = this.calculateFee();
        this.withdraw(fees);
        this.transactionCount++;
    }

    private double calculateFee(){
        int excessTransactions = this.transactionCount -FREE_TRANSACTIONS;
        if (excessTransactions <= 0){
            return 0;
        }

        return excessTransactions* TRANSACTION_FEE;
    }
}
