package ma.imadsprojects.billingservice.Services;

import ma.imadsprojects.billingservice.Models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerRestClient {
    @GetMapping(path="/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id );
}
