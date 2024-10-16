package br.com.matteusmoreno.credpago_challenge.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCartRequest(
        @NotBlank(message = "Client id is required")
        String clientId,
        @NotBlank(message = "Product id is required")
        String productId) {
}
