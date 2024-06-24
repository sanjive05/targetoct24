package com.loose.coupling;

public class UserManager {
    private UserDataProvider userDataProvider;

    public void setUserDataProvider(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    public String getUserInfo(){
        return userDataProvider.getUserDetails();
    }
}
