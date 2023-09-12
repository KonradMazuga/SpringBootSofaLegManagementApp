package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.dao.request.ProductRequest;
import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.entities.ProductCategory;
import ZTI.project.SecureApplication.repository.ProductCategoryRepository;
import ZTI.project.SecureApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

//    public void addNewProduct(ProductRequest productRequest)
//    {
//        System.out.println(productRequest);
//        Product product = new Product();
//        product.setName(productRequest.getProductName());
//        ProductCategory productCategory = productCategoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new ExpressionException(""));
//        product.setCategory(productCategory);
//        System.out.println(product);
//        productRepository.save(product);
//    }

    public void addNewProduct(Product product)
    {
//        System.out.println(productRequest);
//        Product product = new Product();
//        product.setProductName(productRequest.getProductName());
//        ProductCategory productCategory = productCategoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new ExpressionException(""));
//        product.setCategory(productCategory);
//        System.out.println(product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id)
    {
        return productRepository.getProductById(id);
    }
}
