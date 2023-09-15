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

/**
 * Rest controller for product requests. Client entry point for product actions
 */
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Get all products from the DB via calling service layer function
     * @return list of products from the DB
     */
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /**
     * Add new product to the DB via calling service layer function. Passing product item in RequestBody
     * @param product RequestBody of Product type to be stored in DB
     * @return stored product data
     */
    @PostMapping("/add")
    public Product addNewProduct(@RequestBody Product product)
    {
        System.out.println("Start adding new product");
        productService.addNewProduct(product);
        return product;
//        return ResponseEntity.ok("Poduct has been added");
    }

    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        productService.updateProduct(product);
        return product;
    }

    /**
     * Delete product from the DB via calling service layer function. Passing product id in PathVariable
     * @param id id of product to be deleted from DB
     */
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
   }

    /**
     * Get product with specific ID from the DB via calling service layer function. Passing product id in PathVariable
     * @param id id of a product to be retrieved from DB
     * @return retrieved product data
     */
    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Create default products and store to the DB via calling service layer function
     */
    @PostConstruct
    public void addDefaultProduct()
    {
        try {
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
        catch (Exception e)
        {
            System.out.println("There is already a product with such data");
        }
    }
}
