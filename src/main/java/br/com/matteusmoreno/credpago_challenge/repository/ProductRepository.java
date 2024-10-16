package br.com.matteusmoreno.credpago_challenge.repository;

import br.com.matteusmoreno.credpago_challenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
