package io.github.manishdait.token;

import com.hedera.hashgraph.sdk.PrivateKey;
import com.hedera.hashgraph.sdk.TokenId;
import com.openelements.hiero.base.FungibleTokenClient;
import com.openelements.hiero.base.HieroException;
import io.github.manishdait.Example;
import jakarta.inject.Inject;

public class FungibleTokenMintingExample implements Example {
  @Inject private FungibleTokenClient fungibleTokenClient;

  @Override
  public void run() throws HieroException {
    IO.println("Running FungibleTokenMinting example...");

    // Create token with supplyKey
    IO.println("\nCreating a fungible token...");

    final PrivateKey supplyKey = PrivateKey.generateED25519();
    final String name = "Example Token";
    final String symbol = "ET";

    final TokenId tokenId = fungibleTokenClient.createToken(name, symbol, supplyKey);

    IO.println("Fungible token created successfully ID: " + tokenId);

    // Mint additional supply
    IO.println("\nMint token...");
    long totalSupply = fungibleTokenClient.mintToken(tokenId, supplyKey, 10);

    IO.println("TotalSUpply for token: " + totalSupply);
  }
}
