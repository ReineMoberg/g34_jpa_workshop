package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_workshop.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {
}
