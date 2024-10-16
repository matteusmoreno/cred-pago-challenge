package br.com.matteusmoreno.credpago_challenge.request;

import jakarta.validation.constraints.NotBlank;

public record CreateClientRequest(
        @NotBlank(message = "Client name is required")
        String clientName) {
}
