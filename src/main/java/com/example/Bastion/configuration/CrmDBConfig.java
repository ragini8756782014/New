package com.example.Bastion.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "crmEntityManagerFactory",
        transactionManagerRef = "crmTransactionManager",
        basePackages = { "com.example.Bastion.Repository.crmrepo" }
)
public class CrmDBConfig {


    @Bean(name="crmDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource crmDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "crmEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean crmEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("crmDataSource") DataSource crmDataSource) {
        return builder
                .dataSource(crmDataSource)
                .packages("com.example.Bastion.entitty.crmentity")
                .build();
    }

    @Bean(name = "crmTransactionManager")
    public PlatformTransactionManager crmTransactionManager(
            @Qualifier("crmEntityManagerFactory") EntityManagerFactory crmEntityManagerFactory) {
        return new JpaTransactionManager(crmEntityManagerFactory);
    }

}
