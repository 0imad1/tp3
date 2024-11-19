package ma.imadsprojects.customerservice;

import ma.imadsprojects.customerservice.Repositories.CustomerRepository;
import ma.imadsprojects.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                                RepositoryRestConfiguration restconfiguration){
        return arg->{
            restconfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("imad").mail("imad@gmail.com").build(),
                            Customer.builder().name("rihab").mail("rihab@gmail.com").build(),
                            Customer.builder().name("wij").mail("wij@gmail.com").build()

                            )
            );
            customerRepository.findAll().forEach(c->{
                        System.out.println(c);
                    }
                    );
        };
    }

}
