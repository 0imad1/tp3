package ma.imadsprojects.billingservice;

import ma.imadsprojects.billingservice.Models.Customer;
import ma.imadsprojects.billingservice.Models.Product;
import ma.imadsprojects.billingservice.Repositories.BillRepository;
import ma.imadsprojects.billingservice.Repositories.ProductItemsRepository;
import ma.imadsprojects.billingservice.Services.CustomerRestClient;
import ma.imadsprojects.billingservice.Services.ProductItemRestClient;
import ma.imadsprojects.billingservice.entities.Bill;
import ma.imadsprojects.billingservice.entities.ProductItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemsRepository productItemsRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient){
        return args -> {
            Collection<Product> products = productItemRestClient.allProducts().getContent();
            Long customerId = 1L;
            Customer customer = customerRestClient.findCustomerById(customerId);
            if(customer == null)throw new RuntimeException("customer not found");
            Bill bill = new Bill();
            bill.setBillDate(new Date());
            bill.setCustomerId(customerId);
            Bill saavedBill = billRepository.save(bill);
            products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(saavedBill);
                productItem.setProductId(product.getId());
                productItem.setQuantity(1+new Random().nextInt(10));
                productItem.setPrice(product.getPrice());
                productItem.setDiscount(Math.random());
                productItemsRepository.save(productItem);
            });
        };
    }

}
