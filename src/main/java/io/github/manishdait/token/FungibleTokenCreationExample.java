package io.github.manishdait.token;

import com.hedera.hashgraph.sdk.TokenId;
import com.openelements.hiero.base.FungibleTokenClient;
import com.openelements.hiero.base.HieroException;
import io.github.manishdait.Example;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FungibleTokenCreationExample implements Example {
  @Inject
  private FungibleTokenClient fungibleTokenClient;

  @Override
  public void run() throws HieroException {
    IO.println("Running FungibleTokenCreation example...");

    // Create a token
    IO.println("\nCreating a fungible token...");

    final String name = "Example Token";
    final String symbol = "ET";
    final TokenId tokenId = fungibleTokenClient.createToken(name, symbol);

    IO.println("Fungible token created successfully ID: " + tokenId);
  }
}
