package com.masgotcode.northwind.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTaxStatusRepository extends JpaRepository<OrderTaxStatus,Long> {
}
