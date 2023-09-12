package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.entities.ProductCategory;
import ZTI.project.SecureApplication.repository.ProductCategoryRepository;
import ZTI.project.SecureApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;

    public void addNewProductCategory(ProductCategory productCategory)
    {
        productCategoryRepository.save(productCategory);
    }

    public List<ProductCategory> getAllProductCategories()
    {
        return productCategoryRepository.findAll();
    }

//    public List<Product> listAllProductsFromCategory(long categoryId)
//    {
//        ProductCategory productCategory = productCategoryRepository.findById(categoryId).orElseThrow();
//        return productRepository.findAllByCategory(productCategory);
//    }
}
