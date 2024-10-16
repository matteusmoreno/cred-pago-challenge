package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.CreditCard;

public record CreditCardDetailsResponse(
        String number,
        String cardHolderName,
        String cvv,
        String expDate) {

    public CreditCardDetailsResponse(CreditCard creditCard) {
        this(
                creditCard.getCardNumber(),
                creditCard.getCardHolderName(),
                creditCard.getCvv(),
                creditCard.getExpDate()
        );
    }
}
