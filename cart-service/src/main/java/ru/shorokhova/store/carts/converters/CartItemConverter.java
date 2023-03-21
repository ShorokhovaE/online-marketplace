package ru.shorokhova.store.carts.converters;

import org.springframework.stereotype.Component;
import ru.shorokhova.store.api.CartItemDto;
import ru.shorokhova.store.carts.model.CartItem;

@Component
public class CartItemConverter {

    public CartItemDto entityToDto(CartItem cartItem) {

        return CartItemDto.builder()
                .productTitle(cartItem.getProductTitle())
                .pricePerProduct(cartItem.getPricePerProduct())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .productId(cartItem.getProductId())
                .build();

    }
}
