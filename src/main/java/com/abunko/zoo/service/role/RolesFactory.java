package com.abunko.zoo.service.role;

import java.util.HashMap;
import java.util.Map;

import com.abunko.zoo.repository.PetsContainer;

public class RolesFactory {
    private final boolean isZooWorks;
    private final PetsContainer petsContainer;
    private final Map<RoleType, Role> roleTypes = new HashMap<RoleType, Role>();

    public RolesFactory(boolean isZooWorks, PetsContainer petsContainer) {
        this.isZooWorks = isZooWorks;
        this.petsContainer = petsContainer;
        initRoles(roleTypes);
    }

    private void initRoles(Map<RoleType, Role> roleTypes) {
        roleTypes.put(RoleType.ADMINISTRATOR, new Administrator(isZooWorks, petsContainer));
        roleTypes.put(RoleType.GUEST, new Guest(isZooWorks, petsContainer));
    }

    public Role getRole(RoleType roleType) {
        return roleTypes.getOrDefault(roleType, null);
    }
}
