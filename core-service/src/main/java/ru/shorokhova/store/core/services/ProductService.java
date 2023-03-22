package ru.shorokhova.store.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shorokhova.store.api.CreateNewProductDto;
import ru.shorokhova.store.core.entities.Feedback;
import ru.shorokhova.store.core.entities.Product;
import ru.shorokhova.store.core.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        System.out.println("Id " + id);
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void createNewProduct(CreateNewProductDto createNewProductDto) {
        Product product = new Product();
        product.setTitle(createNewProductDto.getTitle());
        product.setPrice(createNewProductDto.getPrice());
        product.setCompanyName(createNewProductDto.getCompanyName());
        product.setDescription(createNewProductDto.getDescription());
        product.setCount(createNewProductDto.getCount());
        productRepository.save(product);
    }

}
