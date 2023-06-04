package _ATM;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationIntr {
    private ATM atm = new ATM();
    private Map<Double, String> miniStmt = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                miniStmt.put(withdrawAmount, "Withdrawal");
                atm.setBalance(atm.getBalance() - withdrawAmount);
                System.out.println("Please collect the cash: " + withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Please enter the amount in multiples of 500");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        miniStmt.put(depositAmount, "Deposit");
        atm.setBalance(atm.getBalance() + depositAmount);
        System.out.println(depositAmount + " deposited successfully!");
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> entry : miniStmt.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
