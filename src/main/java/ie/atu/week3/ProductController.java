package ie.atu.week3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product ("1", "TV", "Electronics", 600.00));
        productList.add(new Product ("2", "Phone", "Electronics", 500.00));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productList;
    }
}
