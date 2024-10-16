package br.com.matteusmoreno.credpago_challenge.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateCreditCardRequest(
        @NotBlank(message = "Card number is required")
        @Pattern(regexp = "^\\d{16}$", message = "Card number must have 16 digits")
        String cardNumber,
        @NotBlank(message = "Card holder name is required")
        String cardHolderName,
        @NotBlank(message = "CVV is required")
        @Pattern(regexp = "^\\d{3}$", message = "CVV must have 3 digits")
        String cvv,
        @NotBlank(message = "Expiration date is required")
        @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{4}$", message = "Expiration date must be in the format MM/yyyy")
        String expDate) {
}
