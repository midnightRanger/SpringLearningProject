package com.testproject.testproject.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR;
    @Override
    public String getAuthority() {
        return name();
    }
}

