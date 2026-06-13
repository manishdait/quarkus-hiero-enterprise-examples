package io.github.manishdait.account;

import com.openelements.hiero.base.AccountClient;
import com.openelements.hiero.base.HieroException;
import com.openelements.hiero.base.data.Account;
import com.openelements.hiero.base.data.AccountInfo;
import com.openelements.hiero.base.mirrornode.AccountRepository;
import io.github.manishdait.Example;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetAccountInfoExample implements Example {
  @Inject private AccountClient accountClient;

  @Inject private AccountRepository accountRepository;

  @Override
  public void run() throws HieroException {
    IO.println("Running GetAccountInfo example...");

    // Create a mock account
    IO.println("\nCreating an account...");

    final int initialBalance = 1;
    final Account account = accountClient.createAccount(initialBalance);

    IO.println("Account created successfully.");
    IO.println("Account ID: " + account.accountId());

    // Retrieve the accountInfo
    IO.println("\nRetrieving account information...");

    AccountInfo accountInfo =
        accountRepository
            .findById(account.accountId())
            .orElseThrow(
                () ->
                    new RuntimeException(
                        "Unable to retrieve information for account " + account.accountId()));

    IO.println("Account information retrieved successfully:");
    IO.println(accountInfo);
  }
}
