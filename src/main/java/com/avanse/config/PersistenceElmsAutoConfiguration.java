/*
 * package com.avanse.config;
 * 
 * import com.avanse.jpa.model.elms.ELMSView; import
 * com.zaxxer.hikari.HikariDataSource; import
 * javax.persistence.EntityManagerFactory; import javax.sql.DataSource; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.context.properties.ConfigurationProperties; import
 * org.springframework.boot.jdbc.DataSourceBuilder; import
 * org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.orm.jpa.JpaTransactionManager; import
 * org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @EnableTransactionManagement
 * 
 * @EnableJpaRepositories(basePackages = {"com.avanse.jpa.model.elms"},
 * entityManagerFactoryRef = "elmsEntityManager", transactionManagerRef =
 * "elmsTransactionManager") public class PersistenceElmsAutoConfiguration {
 * 
 * @Bean(name = {"elmsDataSource"})
 * 
 * @ConfigurationProperties("elms.datasource") public HikariDataSource
 * elmsDataSource() { return
 * (HikariDataSource)DataSourceBuilder.create().type(HikariDataSource.class).
 * build(); }
 * 
 * @Bean(name = {"elmsEntityManager"}) public
 * LocalContainerEntityManagerFactoryBean
 * elmsEntityManagerFactory(EntityManagerFactoryBuilder builder) { return
 * builder.dataSource((DataSource)elmsDataSource()).packages(new Class[] {
 * ELMSView.class }).persistenceUnit("oraclesqlPU").build(); }
 * 
 * @Bean(name = {"elmsTransactionManager"}) public PlatformTransactionManager
 * elmsTransactionManager(@Qualifier("elmsEntityManager") EntityManagerFactory
 * entityManagerFactory) { return (PlatformTransactionManager)new
 * JpaTransactionManager(entityManagerFactory); } }
 */