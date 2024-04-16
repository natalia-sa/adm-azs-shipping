package com.azship.azship.models.freight;

import com.azship.azship.models.customer_freight.CustomerFreight;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Table(name = "FREIGHT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Freight {

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
    @JoinColumn(name = "CUSTOMER_FREIGHT_ID")
    private CustomerFreight customerFreight;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "PROPERTIES", columnDefinition = "jsonb")
    private String properties;

    public Freight(CustomerFreight customerFreight, String properties) {
        this.customerFreight = customerFreight;
        this.properties = properties;
    }


}
