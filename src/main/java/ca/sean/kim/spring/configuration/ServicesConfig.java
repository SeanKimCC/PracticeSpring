package ca.sean.kim.spring.configuration;

/**
 * Created by 37264 on 5/17/16.
 */
import ca.sean.kim.spring.converters.StandingPopulator;
//import ca.sean.kim.spring.dao.StandingDao;
import ca.sean.kim.spring.service.StandingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "ca.sean.kim.spring.*")
public class ServicesConfig {


    @Bean
    public StandingService standingService() {
        return new StandingService();
    }

    @Bean
    public StandingPopulator standingPopulator() {
        return new StandingPopulator();
    }
}
