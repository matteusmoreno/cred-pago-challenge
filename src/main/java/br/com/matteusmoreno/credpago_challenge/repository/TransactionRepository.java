package br.com.matteusmoreno.credpago_challenge.repository;

import br.com.matteusmoreno.credpago_challenge.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
