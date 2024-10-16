package br.com.matteusmoreno.credpago_challenge.controller;

import br.com.matteusmoreno.credpago_challenge.entity.Transaction;
import br.com.matteusmoreno.credpago_challenge.request.CreateTransactionRequest;
import br.com.matteusmoreno.credpago_challenge.response.TransactionDetailsResponse;
import br.com.matteusmoreno.credpago_challenge.response.TransactionHistoryResponse;
import br.com.matteusmoreno.credpago_challenge.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/history")
    public ResponseEntity<List<TransactionHistoryResponse>> findAll() {
        return ResponseEntity.ok(transactionService.findAllTransactions());
    }

    @GetMapping("/history/{clientId}")
    public ResponseEntity<List<TransactionHistoryResponse>> findAllByClientId(@PathVariable String clientId) {
        return ResponseEntity.ok(transactionService.findAllTransactionsByClientId(clientId));
    }
}
