package com.azship.azship.repositories.freight;

import com.azship.azship.models.freight.Freight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreightRepository extends JpaRepository<Freight, Long> {

    @Query("SELECT f FROM Freight f WHERE CAST(f.properties AS String) LIKE CONCAT('%', :propertyName, '%')")
    Page<Freight> findByPropertyAndPagination(String propertyName, Pageable pageable);
}
