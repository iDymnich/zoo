package com.abunko.zoo;

import com.abunko.zoo.repository.FileSupportPetsContainer;
import com.abunko.zoo.repository.PetsContainer;
import com.abunko.zoo.service.ZooService;
import com.abunko.zoo.service.role.RolesFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Zoo {
    private static final boolean IS_ZOO_WORKS = true;

    //TODO Change for your file system
    private static final String ZOO_PATH = "/users/igor/workspace/zoo.json";
    private static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        PetsContainer repo = new FileSupportPetsContainer(ZOO_PATH, DEFAULT_MAPPER);
        RolesFactory rolesFactory = new RolesFactory(IS_ZOO_WORKS, repo);
        ZooService service = new ZooService(rolesFactory);
        service.start();
    }
}
