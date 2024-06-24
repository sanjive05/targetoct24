package com.loose.coupling;
public class LooseCouplingExample {
    public static void main(String[] args) {
        UserManager userManager = new UserManager(new CloudDatabase());
        System.out.println(userManager.getUserInfo());
    }
}
