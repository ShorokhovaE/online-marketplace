package ru.shorokhova.store.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shorokhova.store.api.OrderDto;
import ru.shorokhova.store.core.converters.OrderConverter;
import ru.shorokhova.store.core.services.OrderService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestHeader String username) {
        orderService.createOrder(username);
    }

    @GetMapping
    public List<OrderDto> findAllOrders(@RequestHeader String username){
        List<OrderDto> orderDtos = orderService.findByUsername(username).stream()
                .map(orderConverter::entityToDto).collect(Collectors.toList());
        return orderDtos;
    }
}
