package com.example.bank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
        TransactionService service = context.getBean(TransactionService.class);
        service.transferMoney(1, 2, 5000.0);
        context.close();
    }
}
