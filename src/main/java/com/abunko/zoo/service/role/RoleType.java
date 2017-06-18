package com.abunko.zoo.service.role;

public enum RoleType {
    UNKNOWN(0),
    ADMINISTRATOR(1),
    GUEST(2);

    int roleId;

    RoleType(int roleId) {
        this.roleId = roleId;
    }

    public static RoleType valueOf(int roleId) {
        try {
            return RoleType.values()[roleId];
        } catch (ArrayIndexOutOfBoundsException e) {
            return UNKNOWN;
        }
    }
}