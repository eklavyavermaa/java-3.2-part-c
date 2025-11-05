package com.example.bank;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

@Service
public class TransactionService {

    private final SessionFactory sessionFactory;

    public TransactionService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Session session = sessionFactory.getCurrentSession();

        Account fromAcc = session.get(Account.class, fromId);
        Account toAcc = session.get(Account.class, toId);

        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);

        session.update(fromAcc);
        session.update(toAcc);

        System.out.println("Transfer successful from " + fromAcc.getName() + " to " + toAcc.getName());
    }
}
