package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();
        userDao.saveUser("John", "Black", (byte) 27);
        userDao.saveUser("Bob", "White", (byte) 33);
        userDao.saveUser("Mark", "Green", (byte) 18);
        userDao.saveUser("Tom", "Brown", (byte) 49);

        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

        Util.getSessionFactory().close();
       /* Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser("John", "Black", (byte) 27);
        userDao.saveUser("Bob", "White", (byte) 33);
        userDao.saveUser("Mark", "Green", (byte) 18);
        userDao.saveUser("Tom", "Brown", (byte) 49);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }

        */
    }
}
