package com.yoneforcode.eczanedemo.repository;

import com.yoneforcode.eczanedemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
