package br.com.matteusmoreno.credpago_challenge.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateProductRequest(
        @NotBlank(message = "Artist is required")
        String artist,
        @NotBlank(message = "Year is required")
        @Pattern(regexp = "^\\d{4}$", message = "Year must have 4 digits")
        String year,
        @NotBlank(message = "Album is required")
        String album,
        @NotNull(message = "Price is required")
        Integer price,
        String store,
        String thumb) {
}
