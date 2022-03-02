package service;

import model.Transaction;

import java.util.List;

import static data.TransactionDummy.getDummyTransactions;

public class TransactionService {
    private List<Transaction> transactions = getDummyTransactions();


    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public boolean addTransaction(Transaction transaction) {
        return this.transactions.add(transaction);
    }
}
