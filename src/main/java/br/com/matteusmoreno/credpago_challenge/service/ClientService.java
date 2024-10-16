package br.com.matteusmoreno.credpago_challenge.service;

import br.com.matteusmoreno.credpago_challenge.entity.Client;
import br.com.matteusmoreno.credpago_challenge.repository.ClientRepository;
import br.com.matteusmoreno.credpago_challenge.request.CreateClientRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client createClient(CreateClientRequest request) {
        Client client = Client.builder()
                .name(request.clientName())
                .build();

        return clientRepository.save(client);
    }
}
