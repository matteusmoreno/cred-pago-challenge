package br.com.matteusmoreno.credpago_challenge.repository;

import br.com.matteusmoreno.credpago_challenge.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
}
