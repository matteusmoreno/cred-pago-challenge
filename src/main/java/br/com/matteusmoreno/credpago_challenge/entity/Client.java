package br.com.matteusmoreno.credpago_challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String clientId;
    private String name;
}
