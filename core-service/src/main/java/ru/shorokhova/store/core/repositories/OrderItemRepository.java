package ru.shorokhova.store.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shorokhova.store.core.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
