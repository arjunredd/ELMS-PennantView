package com.avanse.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

import com.avanse.jpa.model.pennant.PennantView;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.avanse.jpa.model.pennant",
  entityManagerFactoryRef = "pennantEntityManager",
  transactionManagerRef = "pennantTransactionManager")
public class PersistencePennantAutoConfiguration {
     
    //@Primary
    @Bean(name="pennantDataSource")
    @ConfigurationProperties(prefix="pennant.datasource")
    public DataSource pennantDataSource() {
        return DataSourceBuilder.create().build();
    }
    
	//@Primary
    @Bean(name = "pennantEntityManager")
    public LocalContainerEntityManagerFactoryBean pennantEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                    .dataSource(pennantDataSource())
                    .packages(PennantView.class) // you can also give the package where the Entities are given rather than giving Entity class
                    .persistenceUnit("mssqlPU")
                    .build();
    }
 
    //@Primary
    @Bean(name = "pennantTransactionManager")
    public PlatformTransactionManager pennantTransactionManager(@Qualifier("pennantEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
    
}
