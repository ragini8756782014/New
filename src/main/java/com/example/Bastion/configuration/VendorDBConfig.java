package com.example.Bastion.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "vendorEntityManagerFactory",
        transactionManagerRef = "vendorTransactionManager",
        basePackages = { "com.example.Bastion.Repository.vendorrepo" }
)
public class VendorDBConfig {

    @Bean(name="vendorDataSource")
    @ConfigurationProperties(prefix="spring.vendordatasource")
    public DataSource vendorDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "vendorEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean vendorEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                @Qualifier("vendorDataSource") DataSource vendorDataSource) {
        return builder
                .dataSource(vendorDataSource)
                .packages("com.example.Bastion.entitty.vendorentity")
                .build();
    }

    @Bean(name = "vendorTransactionManager")
    public PlatformTransactionManager vendorTransactionManager(
            @Qualifier("vendorEntityManagerFactory") EntityManagerFactory vendorEntityManagerFactory) {
        return new JpaTransactionManager(vendorEntityManagerFactory);
    }


}
