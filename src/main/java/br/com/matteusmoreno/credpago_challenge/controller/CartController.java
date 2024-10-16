package br.com.matteusmoreno.credpago_challenge.controller;

import br.com.matteusmoreno.credpago_challenge.entity.Cart;
import br.com.matteusmoreno.credpago_challenge.request.CreateCartRequest;
import br.com.matteusmoreno.credpago_challenge.response.CartDetailsResponse;
import br.com.matteusmoreno.credpago_challenge.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/store/api/v1")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add_to_cart")
    public ResponseEntity<CartDetailsResponse> addToCart(@RequestBody @Valid CreateCartRequest request, UriComponentsBuilder uriBuilder) {
        Cart cart = cartService.addToCart(request);
        URI uri = uriBuilder.path("/store/api/v1/cart/{id}").buildAndExpand(cart.getCartId()).toUri();

        return ResponseEntity.created(uri).body(new CartDetailsResponse(cart));
    }
}
