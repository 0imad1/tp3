package ma.imadsprojects.inventoryservice;

import ma.imadsprojects.inventoryservice.Entities.Product;
import ma.imadsprojects.inventoryservice.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("laptop").price(20000).quantity(4).build(),
                            Product.builder().name("screen").price(2000).quantity(3).build(),
                            Product.builder().name("mouse").price(200).quantity(2).build()

                    )


            );
        };
    }
}
