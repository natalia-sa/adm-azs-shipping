package com.azship.azship.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(
            name = "CREATED_AT",
            insertable = false,
            updatable = false
    )
    private LocalDateTime createdAt;

    @Column(
            name = "UPDATED_AT",
            insertable = false,
            updatable = false
    )

    private LocalDateTime updatedAt;

    private String name;

    private String cnpj;

    public Customer(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }
}
