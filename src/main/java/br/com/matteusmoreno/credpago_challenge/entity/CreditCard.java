package br.com.matteusmoreno.credpago_challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_cards")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class CreditCard {

    @Id
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expDate;
}
