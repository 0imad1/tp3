package ma.imadsprojects.billingservice.Services;

import ma.imadsprojects.billingservice.Models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products/{id}")
    public  Product findProductById(@PathVariable Long id);
    @GetMapping(path = "/products")
    PagedModel<Product>  allProducts();
}
