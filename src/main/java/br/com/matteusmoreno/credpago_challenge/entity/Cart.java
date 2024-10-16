package br.com.matteusmoreno.credpago_challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Cart {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String cartId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String date;
    private String time;
}
