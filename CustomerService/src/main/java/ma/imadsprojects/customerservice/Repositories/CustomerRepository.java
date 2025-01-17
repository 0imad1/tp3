package ma.imadsprojects.customerservice.Repositories;

import ma.imadsprojects.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
