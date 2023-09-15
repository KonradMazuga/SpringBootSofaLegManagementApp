package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.dao.request.ProductRequest;
import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Service implementing business layer for product handling
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Get all products from DB via repository
     * @return all products from DB
     */
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }


    /**
     * Save product to DB via repository
     * @param product product object
     */
    public void addNewProduct(Product product)
    {
        productRepository.save(product);
    }

    public Product updateProduct(Product product)
    {
        Product existingProduct = productRepository.findById(product.getId()).orElseThrow();
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());

        return productRepository.save(existingProduct);
    }

    /**
     * Delete product from DB via repository
     * @param id productId
     */
    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);
    }

    /**
     * Get product by productId from DB via repository
     * @param id productId
     * @return Product object
     */
    public Product getProductById(Long id)
    {
        return productRepository.getProductById(id);
    }
}
