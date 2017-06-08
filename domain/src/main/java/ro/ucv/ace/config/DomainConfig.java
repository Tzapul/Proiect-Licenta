package ro.ucv.ace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ro.ucv.ace.model.*;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.impl.JpaRepository;
import ro.ucv.ace.socket.impl.SocketManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * This class is used by the IoC Spring  container as a source for bean definitions. It contains the necessary beans
 * for JPA configuration.
 *
 * @author Georgian Vladutu
 */
@Configuration
@EnableTransactionManagement
@EnableSpringConfigured
@EnableScheduling
@ComponentScan({"ro.ucv.ace"})
@PropertySource(value = {"classpath:db.properties", "classpath:mail.properties", "classpath:socket.properties",
        "classpath:folder.properties"})
public class DomainConfig {

    @Autowired
    private Environment environment;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.import_files_sql_extractor",
                environment.getRequiredProperty("hibernate.hbm2ddl.import_files_sql_extractor"));

        return properties;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("ro.ucv.ace.*");
        em.setJpaProperties(hibernateProperties());
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setPersistenceUnitName("newPersistenceUnit");

        return em;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }


    @Bean(name = "innerUserRepository")
    IJpaRepository<User, Integer> iUserUserIntegerIJpaRepository() {
        return new JpaRepository<>(User.class);
    }

    @Bean(name = "innerSubgroupRepository")
    IJpaRepository<Subgroup, Integer> subgroupIntegerIJpaRepository() {
        return new JpaRepository<>(Subgroup.class);
    }

    @Bean(name = "socketManager")
    SocketManager socketManager() {
        return new SocketManager(
                environment.getRequiredProperty("socket.protocol"),
                environment.getRequiredProperty("socket.port"),
                environment.getRequiredProperty("socket.host")
        );
    }

    @Bean(name = "innerProfessorRepository")
    IJpaRepository<Professor, Integer> professorIntegerIJpaRepository() {
        return new JpaRepository<>(Professor.class);
    }

    @Bean(name = "innerStudentRepository")
    IJpaRepository<Student, Integer> studentIntegerIJpaRepository() {
        return new JpaRepository<>(Student.class);
    }

    @Bean(name = "innerTaskRepository")
    IJpaRepository<Task, Integer> taskIntegerIJpaRepository() {
        return new JpaRepository<>(Task.class);
    }

    @Bean(name = "innerTopicRepository")
    IJpaRepository<Topic, Integer> topicIntegerIJpaRepository() {
        return new JpaRepository<>(Topic.class);
    }

    @Bean(name = "innerSolutionRepository")
    IJpaRepository<Solution, Integer> solutionIntegerIJpaRepository() {
        return new JpaRepository<>(Solution.class);
    }

    @Bean(name = "nullPlagiarismRepository")
    IJpaRepository<NullPlagiarismAnalyser, Integer> nullPlagiarismAnalyserIntegerIJpaRepository() {
        return new JpaRepository<>(NullPlagiarismAnalyser.class);
    }

    @Bean(name = "defaultPlagiarismRepository")
    IJpaRepository<DefaultPlagiarismAnalyser, Integer> defaultPlagiarismAnalyserIntegerIJpaRepository() {
        return new JpaRepository<>(DefaultPlagiarismAnalyser.class);
    }

    @Bean(name = "innerNotificationRepository")
    IJpaRepository<Notification, Integer> notificationIntegerIJpaRepository() {
        return new JpaRepository<>(Notification.class);
    }

    @Bean(name = "innerPlagiarismResultRepository")
    IJpaRepository<PlagiarismResult, Integer> plagiarismResultIntegerIJpaRepository() {
        return new JpaRepository<>(PlagiarismResult.class);
    }
}
