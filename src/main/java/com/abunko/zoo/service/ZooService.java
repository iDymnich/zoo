package com.abunko.zoo.service;

import java.util.Scanner;

import com.abunko.zoo.service.role.Role;
import com.abunko.zoo.service.role.RoleType;
import com.abunko.zoo.service.role.RolesFactory;

public class ZooService {

    private final RolesFactory rolesFactory;

    public ZooService(RolesFactory rolesFactory) {
        this.rolesFactory = rolesFactory;
    }

    public void start() {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to ZOO!");
            System.out.println("Please choose your role:");
            System.out.println("1 - Administrator.\n2 - Guest");
            int roleId = Integer.valueOf(console.nextLine());
            RoleType roleType = RoleType.valueOf(roleId);

            Role role = rolesFactory.getRole(roleType);
            if (role == null) {
                System.out.println("Please specify correct Role!");
                continue;
            }

            if (RoleType.ADMINISTRATOR == roleType) {
                doAdministratorRole(console, role);
            }

            doGuestRole(console, role);

        }
    }

    private void doGuestRole(Scanner console, Role role) {
        while (true) {
            System.out.println("Please choose what to do");
            System.out.println("1 - show pets.\n0 - exit to main menu.");

            int choose = Integer.valueOf(console.nextLine());
            if (choose == 0) {
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println(role.showPets());
                    break;

                default:
                    System.out.println("Please specify correct choose");
                    break;
            }
        }
    }

    private void doAdministratorRole(Scanner console, Role role) {
        //TODO Please implement roles for administrator (show, add, and delete pets)
    }
}
