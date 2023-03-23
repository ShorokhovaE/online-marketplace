package ru.shorokhova.store.core.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.shorokhova.store.api.CartDto;
import ru.shorokhova.store.api.CartItemDto;
import ru.shorokhova.store.core.entities.Order;
import ru.shorokhova.store.core.entities.Product;
import ru.shorokhova.store.core.repositories.OrderRepository;
import ru.shorokhova.store.core.integrations.CartServiceIntegration;
import ru.shorokhova.store.core.services.OrderService;
import ru.shorokhova.store.core.services.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @MockBean
    private CartServiceIntegration cartServiceIntegration;
    @MockBean
    private ProductService productService;
    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void createOrderTest() {

        CartItemDto cartItemDto = CartItemDto.builder()
                .productTitle("Milk")
                .pricePerProduct(BigDecimal.valueOf(100))
                .quantity(2)
                .price(BigDecimal.valueOf(200))
                .productId(19267L)
                .build();

        CartDto cartDto = CartDto.builder()
                .totalPrice(BigDecimal.valueOf(200))
                .items(List.of(cartItemDto))
                .build();

        Mockito.doReturn(cartDto).when(cartServiceIntegration).getCurrentCart("1");

        Product product = new Product();
        product.setId(19267L);
        product.setPrice(BigDecimal.valueOf(100));
        product.setTitle("Milk");

        Mockito.doReturn(Optional.of(product)).when(productService).findById(19267L);

        Order order = orderService.createOrder("Bob");
        Assertions.assertEquals(order.getTotalPrice(), BigDecimal.valueOf(200));

        Mockito.verify(orderRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }


}
