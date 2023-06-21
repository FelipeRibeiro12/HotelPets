package br.inatel;

import java.util.*;

class Software {

    private ArrayList<User> users;

    public Software() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Nao existem usuarios");
        }
        else {
            System.out.println("Usuarios:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
