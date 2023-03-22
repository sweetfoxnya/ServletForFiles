package servlet;

import java.util.HashMap;
import java.util.Map;

public class UserMethods {

    private static final Map<String, User> nameToUser  = new HashMap<>();
    private static final Map<String, User> sessionIdToUser = new HashMap<>();


    private UserMethods() {}

    public static void addNewUser(User user) {
        nameToUser.put(user.getName(), user);
    }

    public static User getUserByName(String name) {
        return nameToUser.get(name);
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
