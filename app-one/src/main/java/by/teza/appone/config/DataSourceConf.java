package by.teza.appone.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {

    @RefreshScope
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        return dataSource;
    }
}
