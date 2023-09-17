package servlet;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Logger;

public class HibernateUtil {

    private static final Logger logger = Logger.getLogger("");
    public static SessionFactory sessionFactory = createSessionFactory(createConfiguration());

    private static Configuration createConfiguration(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/user");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "dbrnjhbz");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }
    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


    public static void shutdown() {
        // Чистит кеш и закрывает соединение с БД
        sessionFactory.close();
    }

}
