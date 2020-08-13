package com.company.role;

public enum CustomerRole {
	ADMIN, USER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
