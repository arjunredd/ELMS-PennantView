package com.avanse.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

import com.avanse.models.MstSourceMapping;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.avanse.models",
  entityManagerFactoryRef = "primeEntityManager",
  transactionManagerRef = "primeTransactionManager")
public class PersistenceDefaultAutoConfiguration {
    
   @Primary
   @Bean(name="primeDataSource")
   @ConfigurationProperties(prefix="spring.datasource")
   public DataSource primeDataSource() {
       return DataSourceBuilder.create().build();
   }
   
   @Primary
   @Bean(name = "primeEntityManager")
   public LocalContainerEntityManagerFactoryBean primeEntityManagerFactory(EntityManagerFactoryBuilder builder) {
       return builder
                   .dataSource(primeDataSource())
                   .packages(MstSourceMapping.class) // you can also give the package where the Entities are given rather than giving Entity class
                   .persistenceUnit("primemssqlPU")
                   .build();
   }

   @Primary
   @Bean(name = "primeTransactionManager")
   public PlatformTransactionManager primeTransactionManager(@Qualifier("primeEntityManager") EntityManagerFactory entityManagerFactory) {
       return new JpaTransactionManager(entityManagerFactory);
   }
   
}
