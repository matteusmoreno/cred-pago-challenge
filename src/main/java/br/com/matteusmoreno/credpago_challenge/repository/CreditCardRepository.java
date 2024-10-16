package br.com.matteusmoreno.credpago_challenge.repository;

import br.com.matteusmoreno.credpago_challenge.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
}
