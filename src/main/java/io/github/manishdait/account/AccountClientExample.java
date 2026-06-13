package io.github.manishdait.account;

import com.hedera.hashgraph.sdk.Hbar;
import com.openelements.hiero.base.AccountClient;
import com.openelements.hiero.base.HieroException;
import com.openelements.hiero.base.data.Account;
import io.github.manishdait.Example;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccountClientExample implements Example {
  @Inject private AccountClient accountClient;

  @Override
  public void run() throws HieroException {
    IO.println("Running AccountClient example...");

    // Creating an account
    IO.println("\nCreate an Account...");

    final int initialBalanceTinybar = 1;
    final Account account = accountClient.createAccount(initialBalanceTinybar);

    IO.println("Account created successfully:");
    IO.println("AccountID: " + account.accountId());
    IO.println("PublicKey: " + account.publicKey());
    IO.println("PrivateKey: " + account.privateKey());

    // Retrieve the account balance
    IO.println("\nRetrieving account balance...");
    final Hbar accountBalance = accountClient.getAccountBalance(account.accountId());

    IO.println(
        "Balance for account "
            + account.accountId()
            + ": "
            + accountBalance.toTinybars()
            + " tinybars");

    // Update Account
    IO.println("\nUpdating an account (not implemented)...");

    // Delete Account
    IO.println("\nDeleting the account...");
    IO.println("Creating a recipient account for the remaining balance...");

    final Account transferAccount = accountClient.createAccount();
    accountClient.deleteAccount(account, transferAccount);

    IO.println("Account deleted successfully.");
  }
}
