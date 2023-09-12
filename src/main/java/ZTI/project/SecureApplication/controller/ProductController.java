package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.dao.request.ProductRequest;
import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> addNewProduct(@RequestBody ProductRequest productRequest)
//    {
//        System.out.println("Start adding new product");
//        productService.addNewProduct(productRequest);
//        return ResponseEntity.ok("Poduct has been added");
//    }
    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product)
    {
        System.out.println("Start adding new product");
        productService.addNewProduct(product);
        return product;
//        return ResponseEntity.ok("Poduct has been added");
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
   }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostConstruct
    public void addDefaultProduct()
    {
        Product product = new Product();
        product.setProductName("Leg K1234");
        product.setProductDescription("This is a solid leg");
        product.setProductPrice(1.23);
        productService.addNewProduct(product);

        Product product2 = new Product();
        product2.setProductName("Leg ABC");
        product2.setProductDescription("It is good option for chairs");
        product2.setProductPrice(2.47);
        productService.addNewProduct(product2);
    }
}