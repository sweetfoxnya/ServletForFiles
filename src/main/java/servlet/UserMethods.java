package servlet;


import org.hibernate.Session;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static servlet.HibernateUtil.sessionFactory;

public class UserMethods {
    private static final Map<String, User> sessionIdToUser = new HashMap<>();

    public static boolean addNewUser(User user) {
        Session session = sessionFactory.openSession();
        UserBD userBD = new UserBD(session);
        return
        userBD.saveUser(user);
    }
    public static User getUserByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        UserBD userBD = new UserBD(session);
        return userBD.getUser(name);
    }

    public static User getUserBySessionId(String sessionId) {
        return sessionIdToUser.get(sessionId);
    }

    public static void addSession(String sessionId, User userProfile) {
        sessionIdToUser.put(sessionId, userProfile);
    }



}
