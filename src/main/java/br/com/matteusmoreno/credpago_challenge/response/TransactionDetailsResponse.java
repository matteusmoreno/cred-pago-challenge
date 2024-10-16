package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.Transaction;

public record TransactionDetailsResponse(
        String clientId,
        String cartId,
        String clientName,
        Integer valueToPay,
        CreditCardDetailsResponse creditCard) {

    public TransactionDetailsResponse(Transaction transaction) {
        this(
                transaction.getClient().getClientId(),
                transaction.getCart().getCartId(),
                transaction.getClient().getName(),
                transaction.getTotalToPay(),
                new CreditCardDetailsResponse(transaction.getCreditCard())
        );
    }
}
