package br.com.matteusmoreno.credpago_challenge.repository;

import br.com.matteusmoreno.credpago_challenge.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
