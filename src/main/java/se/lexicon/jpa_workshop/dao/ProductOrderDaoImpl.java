package se.lexicon.jpa_workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.entity.ProductOrder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ProductOrderDaoImpl implements ProductOrderDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public ProductOrder create(ProductOrder productOrder) {
        entityManager.persist(productOrder);
        return productOrder;
    }

    @Override
    public ProductOrder findById(int id) {
        return entityManager.find(ProductOrder.class, id);
    }

    @Override
    public List<ProductOrder> findAll() {
        Query query = entityManager.createQuery("select po from ProductOrder  po");
        List<ProductOrder> result = query.getResultList();
        return result;
    }

    @Override
    public void remove(int id) {
        ProductOrder result = findById(id);
        if (result != null) entityManager.remove(result);


    }

    @Override
    @Transactional
    public ProductOrder update(ProductOrder productOrder) {
        return entityManager.merge(productOrder);
    }

    @Override
    @Transactional
    public List<ProductOrder> saveAll(List<ProductOrder> productOrders) {
        for (ProductOrder productOrder : productOrders) {
            create(productOrder);
        }
        return productOrders;
    }

    @Override
    public List<ProductOrder> findByDate(LocalDate date) {
        Query query = entityManager.createQuery("select  po from ProductOrder po  where po.orderDate = :orderDate");
        query.setParameter("orderDate", date);
        List<ProductOrder> result = query.getResultList();
        return result;
    }

    @Override
    public List<ProductOrder> findByProductId(int productId) {
        Query query = entityManager.createQuery("select po from ProductOrder po inner join OrderItem oi on po.id = oi.productOrder.id where oi.product.id = :id");
        query.setParameter("id", productId);
        List<ProductOrder> result = query.getResultList();
        return result;
    }

    @Override
    public List<ProductOrder> findByAppUserid(int appUserId) {
        Query query = entityManager.createQuery("select po from ProductOrder po where po.customer.id = :appUserIdParam");
        query.setParameter("appUserIdParam", appUserId);

        List<ProductOrder> result = query.getResultList();
        return result;
    }
}
