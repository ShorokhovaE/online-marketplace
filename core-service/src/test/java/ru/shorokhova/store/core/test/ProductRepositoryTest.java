package ru.shorokhova.store.core.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.shorokhova.store.core.entities.Product;
import ru.shorokhova.store.core.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAllProductsTest(){
        Product product = new Product();
        product.setTitle("Печеньки");
        product.setId(1234567L);
        product.setDescription("Вкусные печеньки");
        product.setCompanyName("Магазин с печеньками");
        product.setPrice(BigDecimal.valueOf(25));
        product.setQuantity(17);

        entityManager.persist(product);
        entityManager.flush();;

        List<Product> products = productRepository.findAll();

        Assertions.assertEquals(4, products.size());
        Assertions.assertEquals("Печеньки", products.get(3).getTitle());


    }

}
