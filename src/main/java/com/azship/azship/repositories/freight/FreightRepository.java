package com.azship.azship.repositories.freight;

import com.azship.azship.models.freight.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreightRepository extends JpaRepository<Freight, Long> {
}
