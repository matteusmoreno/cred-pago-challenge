package br.com.matteusmoreno.credpago_challenge.service;

import br.com.matteusmoreno.credpago_challenge.entity.Client;
import br.com.matteusmoreno.credpago_challenge.entity.CreditCard;
import br.com.matteusmoreno.credpago_challenge.repository.ClientRepository;
import br.com.matteusmoreno.credpago_challenge.repository.CreditCardRepository;
import br.com.matteusmoreno.credpago_challenge.request.CreateClientRequest;
import br.com.matteusmoreno.credpago_challenge.request.CreateCreditCardRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final CreditCardRepository creditCardRepository;

    public ClientService(ClientRepository clientRepository, CreditCardRepository creditCardRepository) {
        this.clientRepository = clientRepository;
        this.creditCardRepository = creditCardRepository;
    }

    @Transactional
    public Client createClient(CreateClientRequest request) {
        Client client = Client.builder()
                .name(request.clientName())
                .creditCard(addCreditCard(request.creditCard()))
                .build();

        return clientRepository.save(client);
    }

    @Transactional
    public CreditCard addCreditCard(CreateCreditCardRequest request) {
        CreditCard creditCard = CreditCard.builder()
                .cardNumber(request.cardNumber())
                .cardHolderName(request.cardHolderName())
                .expDate(request.expDate())
                .cvv(request.cvv())
                .build();

        return creditCardRepository.save(creditCard);
    }
}
