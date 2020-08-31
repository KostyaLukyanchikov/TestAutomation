package configuration;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("epam-jdi-gradle/test-config/src/main/resources/config.properties")

public class AppConfig {


}
