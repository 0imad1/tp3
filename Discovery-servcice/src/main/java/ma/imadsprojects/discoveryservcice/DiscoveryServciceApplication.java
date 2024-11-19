package ma.imadsprojects.discoveryservcice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServciceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServciceApplication.class, args);
    }


}
