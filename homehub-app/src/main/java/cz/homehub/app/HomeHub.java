package cz.homehub.app;

import cz.homehub.init.InitialDataSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"cz.homehub"})
@EntityScan("cz.homehub")
@EnableJpaRepositories("cz.homehub.repository")
public class HomeHub {

    @Autowired
    private InitialDataSet initialDataSet;

    public static void main(String[] args) {
        SpringApplication.run(HomeHub.class, args);
    }

    @Bean
    public InitializingBean init() {
        return initialDataSet.load();
    }
}
