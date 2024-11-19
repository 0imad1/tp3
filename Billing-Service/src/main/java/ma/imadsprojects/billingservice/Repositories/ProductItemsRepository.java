package ma.imadsprojects.billingservice.Repositories;

import ma.imadsprojects.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemsRepository extends JpaRepository<ProductItem,Long> {
}
