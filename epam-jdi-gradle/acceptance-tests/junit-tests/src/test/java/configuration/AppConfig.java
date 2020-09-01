package configuration;


import org.springBddProject.qa.gui.configuration.WebDriverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@Import({WebDriverConfig.class})
@ComponentScans({
        @ComponentScan("org.springBddProject.qa.gui"),
        @ComponentScan("selenium.case2.steps")})
@PropertySource("classpath:/dev.properties")

public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
