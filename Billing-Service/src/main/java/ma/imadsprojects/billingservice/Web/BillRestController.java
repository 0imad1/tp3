package ma.imadsprojects.billingservice.Web;

import jakarta.ws.rs.Path;
import ma.imadsprojects.billingservice.Repositories.BillRepository;
import ma.imadsprojects.billingservice.Repositories.ProductItemsRepository;
import ma.imadsprojects.billingservice.Services.CustomerRestClient;
import ma.imadsprojects.billingservice.Services.ProductItemRestClient;
import ma.imadsprojects.billingservice.entities.Bill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemsRepository  productItemsRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillRestController(BillRepository billRepository, ProductItemsRepository productItemsRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemsRepository = productItemsRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productItemRestClient.findProductById(pi.getProductId()));
        });
        return bill;
    }
}
