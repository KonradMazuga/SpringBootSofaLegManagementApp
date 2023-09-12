package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.entities.ProductCategory;
import ZTI.project.SecureApplication.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product_category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewProductCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.addNewProductCategory(productCategory);
        return ResponseEntity.ok("New product category has been added");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories()
    {
        return ResponseEntity.ok(productCategoryService.getAllProductCategories());
    }
//    @GetMapping("/all/{categoryId}")
//    public ResponseEntity<List<Product>> listAllProductsFromCategory(@PathVariable Long categoryId)
//    {
//        return ResponseEntity.ok(productCategoryService.listAllProductsFromCategory(categoryId));
//    }
}
