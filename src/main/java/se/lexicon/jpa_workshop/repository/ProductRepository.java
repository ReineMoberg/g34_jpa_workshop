package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_workshop.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    List<Product> findByNameIgnoreCase(String name);

}
