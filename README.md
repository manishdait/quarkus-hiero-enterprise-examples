# quarkus-hiero-enterprise-examples

This repository contains examples demonstrating how to use the Hiero Enterprise Java with Quarkus.

### Configuration

Configure the following environment variables before running the examples:

```bash
export HIERO_OPERATOR_ACCOUNT=<your-account-id>
export HIERO_OPERATOR_PRIVATE_KEY=<your-private-key>
export HIERO_NETWORK=hedera-testnet
```

Alternatively, Create a `.env` file in the project root:

```bash
HIERO_OPERATOR_ACCOUNT=<your-account-id>
HIERO_OPERATOR_PRIVATE_KEY=<your-private-key>
HIERO_NETWORK=hedera-testnet
```

## Running the Examples

Start the application:

```bash
./mvnw quarkus:run
```

or run in development mode:

```bash
./mvnw compile quarkus:dev
```