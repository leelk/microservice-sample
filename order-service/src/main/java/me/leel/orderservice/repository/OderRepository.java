package me.leel.orderservice.repository;

import me.leel.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Order, Long> {
}
