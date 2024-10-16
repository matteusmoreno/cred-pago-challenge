package br.com.matteusmoreno.credpago_challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private Integer totalToPay;
    @ManyToOne
    @JoinColumn(name = "credit_card_number")
    private CreditCard creditCard;
}
