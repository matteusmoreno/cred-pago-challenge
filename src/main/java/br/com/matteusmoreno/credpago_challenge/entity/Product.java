package br.com.matteusmoreno.credpago_challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    private String artist;
    private String year;
    private String album;
    private Integer price;
    private String store;
    private String thumb;
    private String date;
}
