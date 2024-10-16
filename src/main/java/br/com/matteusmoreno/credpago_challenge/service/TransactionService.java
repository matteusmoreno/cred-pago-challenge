package br.com.matteusmoreno.credpago_challenge.service;

import br.com.matteusmoreno.credpago_challenge.entity.Cart;
import br.com.matteusmoreno.credpago_challenge.entity.Client;
import br.com.matteusmoreno.credpago_challenge.entity.Transaction;
import br.com.matteusmoreno.credpago_challenge.repository.CartRepository;
import br.com.matteusmoreno.credpago_challenge.repository.ClientRepository;
import br.com.matteusmoreno.credpago_challenge.repository.TransactionRepository;
import br.com.matteusmoreno.credpago_challenge.request.CreateTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;
    private final CartRepository cartRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ClientRepository clientRepository, CartRepository cartRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Transaction createTransaction(CreateTransactionRequest request) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Cart cart = cartRepository.findById(request.cartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Transaction transaction = Transaction.builder()
                .client(client)
                .cart(cart)
                .totalToPay(cart.getProduct().getPrice())
                .creditCard(client.getCreditCard())
                .date(LocalDate.now().format(dateFormatter))
                .build();

        return transactionRepository.save(transaction);

    }
}
