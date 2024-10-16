package br.com.matteusmoreno.credpago_challenge.controller;

import br.com.matteusmoreno.credpago_challenge.entity.Client;
import br.com.matteusmoreno.credpago_challenge.request.CreateClientRequest;
import br.com.matteusmoreno.credpago_challenge.response.ClientDetailsResponse;
import br.com.matteusmoreno.credpago_challenge.service.ClientService;
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
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDetailsResponse> create(@RequestBody @Valid CreateClientRequest request, UriComponentsBuilder uriBuilder) {
        Client client = clientService.createClient(request);
        URI uri = uriBuilder.path("/store/api/v1/client/{id}").buildAndExpand(client.getClientId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsResponse(client));
    }
}
