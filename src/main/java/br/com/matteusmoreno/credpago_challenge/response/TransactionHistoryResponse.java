package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.Transaction;

public record TransactionHistoryResponse(
        String clientId,
        String orderId,
        String cardNumber,
        Integer value,
        String date) {

    public TransactionHistoryResponse(Transaction transaction) {
        this(
                transaction.getClient().getClientId(),
                transaction.getTransactionId(),
                transaction.getCreditCard().getCardNumber(),
                transaction.getTotalToPay(),
                transaction.getDate()
        );
    }
}
