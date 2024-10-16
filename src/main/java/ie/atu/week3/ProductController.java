package ie.atu.week3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productList;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product) {
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<List> updateProduct (@PathVariable String id, @RequestBody Product product) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                productList.remove(p);
            }
        }
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable String id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                productList.remove(p);
            }
        }
        return ResponseEntity.ok(productList);
    }
}
