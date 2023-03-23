package ru.shorokhova.store.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shorokhova.store.core.entities.Order;
import ru.shorokhova.store.core.entities.OrderItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUsername(String username);

    Optional<Order> findById(Long id);

}
