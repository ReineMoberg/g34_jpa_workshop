package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_workshop.entity.ProductOrder;

import java.time.LocalTime;
import java.util.List;

public interface ProductOrderRepository extends CrudRepository<ProductOrder,Integer> {

    List<ProductOrder> findByOrderDate(String orderDate);
    List<ProductOrder> findByOrderTimeBetween(LocalTime startTime,LocalTime endTime);
    List<ProductOrder> findByCustomerId(int customerId);

    boolean deleteById(int id);

}
