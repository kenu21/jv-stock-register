package com.smida.stockregister.service;

import com.smida.stockregister.entity.User;

public interface UserService {
    User findByUsername(String username);
}
