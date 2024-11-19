package ma.imadsprojects.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder)€



}
