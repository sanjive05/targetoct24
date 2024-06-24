package com.loose.coupling;

public class CloudDatabase implements UserDataProvider {

    @Override
    public String getUserDetails(){
        return "User details from cloud database";
    }
}
