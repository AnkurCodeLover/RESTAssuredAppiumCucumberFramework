package com.rest.restClasses;

public class TestDataBuild {


    public GoRestUsers createUserData(String name, String gender, String email) {

        GoRestUsers goRestUsers = new GoRestUsers();
        goRestUsers.setName(name);
        goRestUsers.setGender(gender);
        goRestUsers.setEmail(email);
        goRestUsers.setStatus("active");
        return goRestUsers;
    }
}