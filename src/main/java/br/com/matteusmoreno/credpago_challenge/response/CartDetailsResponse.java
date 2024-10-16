package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.Cart;

public record CartDetailsResponse(
        String cartId,
        String clientId,
        String productId,
        String date,
        String time) {

    public CartDetailsResponse(Cart cart) {
        this(
                cart.getCartId(),
                cart.getClient().getClientId(),
                cart.getProduct().getProductId(),
                cart.getDate(),
                cart.getTime()
        );
    }
}
