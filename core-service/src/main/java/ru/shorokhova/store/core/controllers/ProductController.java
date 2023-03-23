package ru.shorokhova.store.core.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.shorokhova.store.api.*;
import ru.shorokhova.store.core.converters.ProductConverter;
import ru.shorokhova.store.core.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Продукты", description = "Методы работы с продуктами")
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;


    @GetMapping
    public List<ProductDto> findAllProducts() {

        List<ProductDto> productDtos = productService.findAll().stream()
                .map(productConverter::entityToDto).collect(Collectors.toList());
        return productDtos;

    }


    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable @Parameter(description = "Идентификатор продукта", required = true) Long id) {
        return productService.findById(id)
                .map(productConverter::entityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody CreateNewProductDto createNewProductDto) {
        productService.createNewProduct(createNewProductDto);
    }

}
