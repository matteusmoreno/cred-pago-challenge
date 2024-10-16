package br.com.matteusmoreno.credpago_challenge.controller;

import br.com.matteusmoreno.credpago_challenge.entity.Product;
import br.com.matteusmoreno.credpago_challenge.request.CreateProductRequest;
import br.com.matteusmoreno.credpago_challenge.response.ProductDetailsResponse;
import br.com.matteusmoreno.credpago_challenge.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDetailsResponse> create(@RequestBody @Valid CreateProductRequest request, UriComponentsBuilder uriBuilder) {
        Product product = productService.createProduct(request);
        URI uri = uriBuilder.path("/store/api/v1/product/{id}").buildAndExpand(product.getProductId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDetailsResponse(product));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDetailsResponse>> listAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }
}
