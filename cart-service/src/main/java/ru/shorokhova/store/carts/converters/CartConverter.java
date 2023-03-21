package ru.shorokhova.store.carts.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.shorokhova.store.api.CartDto;
import ru.shorokhova.store.carts.model.Cart;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConverter {

    private final CartItemConverter cartItemConverter;

    public CartDto entityToDto(Cart cart) {

        return CartDto.builder()
                .totalPrice(cart.getTotalPrice())
                .items(cart.getItems().stream().map(cartItemConverter::entityToDto).collect(Collectors.toList()))
                .build();
    }
}
