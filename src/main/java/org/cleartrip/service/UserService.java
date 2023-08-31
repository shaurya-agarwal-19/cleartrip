package org.cleartrip.service;

import org.cleartrip.datastore.UserRegistry;
import org.cleartrip.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void addUser(User user) {
        UserRegistry.addUser(user);
    }
}
