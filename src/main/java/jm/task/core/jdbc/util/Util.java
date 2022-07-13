package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;



public class Util {
   /*
   private static final Connection connection;

    static {
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb";
            String USERNAME = "root";
            String PASSWORD = "root";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() {
        return connection;
    }
*/
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/mydb")
                    .setProperty(Environment.USER, "root")
                    .setProperty(Environment.PASS, "root")
                    .addAnnotatedClass(User.class);

            ServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


