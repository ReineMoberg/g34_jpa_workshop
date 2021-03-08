package se.lexicon.jpa_workshop.dao;

import se.lexicon.jpa_workshop.entity.ProductOrder;

import java.time.LocalDate;
import java.util.List;

public interface ProductOrderDao {

    ProductOrder create(ProductOrder productOrder);

    ProductOrder findById(int id);

    List<ProductOrder> findAll();

    void remove(int id);

    ProductOrder update(ProductOrder productOrder);

    List<ProductOrder> saveAll(List<ProductOrder> productOrders);



    List<ProductOrder> findByDate(LocalDate date);

    List<ProductOrder> findByProductId(int productId);

    List<ProductOrder> findByAppUserid(int appUserId);



}
