package com.azship.azship.models.customer_freight;

import com.azship.azship.models.customer.Customer;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER_FREIGHT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerFreight {

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "FREIGHT_PROPERTIES", columnDefinition = "jsonb")
    private String freightProperties;

    public CustomerFreight(Customer customer, String freightProperties) {
        this.customer = customer;
        this.freightProperties = freightProperties;
    }

    @Override
    public String toString() {
        return "CustomerFreight{" +
                "id=" + id +
                ", customer=" + customer +
                ", freightProperties='" + freightProperties + '\'' +
                '}';
    }
}
