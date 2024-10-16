package br.com.matteusmoreno.credpago_challenge.controller;

import br.com.matteusmoreno.credpago_challenge.entity.Transaction;
import br.com.matteusmoreno.credpago_challenge.request.CreateTransactionRequest;
import br.com.matteusmoreno.credpago_challenge.response.TransactionDetailsResponse;
import br.com.matteusmoreno.credpago_challenge.service.TransactionService;
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
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/buy")
    public ResponseEntity<TransactionDetailsResponse> create(@RequestBody @Valid CreateTransactionRequest request, UriComponentsBuilder uriBuilder) {
        Transaction transaction = transactionService.createTransaction(request);
        URI uri = uriBuilder.path("/store/api/v1/transaction/{id}").buildAndExpand(transaction.getTransactionId()).toUri();

        return ResponseEntity.created(uri).body(new TransactionDetailsResponse(transaction));
    }
}
