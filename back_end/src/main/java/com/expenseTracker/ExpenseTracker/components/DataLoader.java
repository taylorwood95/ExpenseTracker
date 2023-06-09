package com.expenseTracker.ExpenseTracker.components;


import com.expenseTracker.ExpenseTracker.models.Account;
import com.expenseTracker.ExpenseTracker.models.CategoryType;
import com.expenseTracker.ExpenseTracker.models.Expense;
import com.expenseTracker.ExpenseTracker.models.User;
import com.expenseTracker.ExpenseTracker.repositories.AccountRepository;
import com.expenseTracker.ExpenseTracker.repositories.ExpenseRepository;
import com.expenseTracker.ExpenseTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;
    public DataLoader(){}



    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Taylor");
        userRepository.save(user1);

        Account account1 = new Account("Everyday Account", 300,user1);
        accountRepository.save(account1);

        Account account2 = new Account("Savings", 3000, user1);
        accountRepository.save(account2);

        Expense expense1 = new Expense("Netflix", 15, CategoryType.SUBSCRIPTIONS, user1);
        expenseRepository.save(expense1);



    }


}
