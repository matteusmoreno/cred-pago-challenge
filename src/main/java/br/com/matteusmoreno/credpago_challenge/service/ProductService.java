package br.com.matteusmoreno.credpago_challenge.service;

import br.com.matteusmoreno.credpago_challenge.entity.Product;
import br.com.matteusmoreno.credpago_challenge.repository.ProductRepository;
import br.com.matteusmoreno.credpago_challenge.request.CreateProductRequest;
import br.com.matteusmoreno.credpago_challenge.response.ProductDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(CreateProductRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Product product = Product.builder()
                .artist(request.artist())
                .year(request.year())
                .album(request.album())
                .price(request.price())
                .store(request.store())
                .thumb(request.thumb())
                .date(LocalDate.now().format(formatter))
                .build();

        return productRepository.save(product);
    }

    public List<ProductDetailsResponse> listAllProducts() {
        return productRepository.findAll().stream().map(ProductDetailsResponse::new).toList();
    }
}
