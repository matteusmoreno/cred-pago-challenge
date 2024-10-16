package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.Client;

public record ClientDetailsResponse(
        String clientId,
        String clientName,
        CreditCardDetailsResponse creditCard) {

    public ClientDetailsResponse(Client client) {
        this(
                client.getClientId(),
                client.getName(),
                new CreditCardDetailsResponse(client.getCreditCard())
        );
    }
}
