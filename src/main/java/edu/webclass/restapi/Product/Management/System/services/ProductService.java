package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.exceptions.EntityNotFoundException;
import edu.webclass.restapi.Product.Management.System.models.Product;
import edu.webclass.restapi.Product.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAllProducts();
    }

    public boolean addProduct(String title, String brand, int price){
        return productRepository.createNewProduct(new Product(title,brand,price));
    }


    /**
     * Find product by id
     * If the product is not exist, it will throw a EntityNotFoundException.
     */
    public Product findProductById(String id) throws EntityNotFoundException {
        Optional<Product> product = this.productRepository.findProductById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
