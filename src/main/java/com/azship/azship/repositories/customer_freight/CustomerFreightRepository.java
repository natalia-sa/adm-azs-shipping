package com.azship.azship.repositories.customer_freight;

import com.azship.azship.models.customer.Customer;
import com.azship.azship.models.customer_freight.CustomerFreight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFreightRepository extends JpaRepository<CustomerFreight, Long> {
}
