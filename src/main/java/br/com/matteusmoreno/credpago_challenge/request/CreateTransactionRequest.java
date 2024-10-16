package br.com.matteusmoreno.credpago_challenge.request;

import jakarta.validation.constraints.NotBlank;

public record CreateTransactionRequest(
        @NotBlank(message = "Client id is required")
        String clientId,
        @NotBlank(message = "Cart id is required")
        String cartId) {
}
