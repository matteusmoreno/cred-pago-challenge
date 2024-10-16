package br.com.matteusmoreno.credpago_challenge.service;

import br.com.matteusmoreno.credpago_challenge.entity.Cart;
import br.com.matteusmoreno.credpago_challenge.entity.Client;
import br.com.matteusmoreno.credpago_challenge.entity.Product;
import br.com.matteusmoreno.credpago_challenge.repository.CartRepository;
import br.com.matteusmoreno.credpago_challenge.repository.ClientRepository;
import br.com.matteusmoreno.credpago_challenge.repository.ProductRepository;
import br.com.matteusmoreno.credpago_challenge.request.CreateCartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ClientRepository clientRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Cart addToCart(CreateCartRequest request) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = Cart.builder()
                .client(client)
                .product(product)
                .date(LocalDate.now().format(dateFormatter))
                .time(LocalTime.now().format(timeFormatter))
                .build();

        return cartRepository.save(cart);
    }
}
