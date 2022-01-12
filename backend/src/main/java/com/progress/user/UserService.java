package com.progress.user;

import com.progress.db.ServiceBase;

public interface UserService extends ServiceBase<User, Long> {
    User getByUsername(String username);
    User authenticate(String username, String password);
    User signUp(String username, String password, String gender);
}
