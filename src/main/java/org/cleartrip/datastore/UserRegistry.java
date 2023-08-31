package org.cleartrip.datastore;

import org.cleartrip.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public final class UserRegistry {
    private static final Map<String, User> USER_DIRECTORY = new HashMap<>();

    private UserRegistry() {

    }

    public static void addUser(User user) {
        USER_DIRECTORY.put(user.getUserId(), user);
    }

    public static Map<String, User> getUserDirectory() {
        return USER_DIRECTORY;
    }

    public static void updateUserWallet(String userId, int amount) {
        USER_DIRECTORY.get(userId).setFunds(amount);
    }
}
