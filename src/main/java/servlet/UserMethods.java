package servlet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserMethods {
    private static final Map<String, User> sessionIdToUser = new HashMap<>();
    private static final UserBD userBD;

    static {
        try {
            userBD = new UserBD(ConnectionPro.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean addNewUser(User user) {
        return
        userBD.saveUser(user);

    }

    public static User getUserByName(String name) throws SQLException {
        return userBD.getUser(name);
    }

    public static User getUserBySessionId(String sessionId) {
        return sessionIdToUser.get(sessionId);
    }

    public static void addSession(String sessionId, User userProfile) {
        sessionIdToUser.put(sessionId, userProfile);
    }

    public static void deleteSession(String sessionId) {
        sessionIdToUser.remove(sessionId);
    }

}
