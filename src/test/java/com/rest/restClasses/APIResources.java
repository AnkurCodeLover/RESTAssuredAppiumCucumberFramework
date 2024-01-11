package com.rest.restClasses;

public enum APIResources {


    AddUserAPI("/public/v2/users/"),
    getUserAPI("/public/v2/users/"),
    deleteUserAPI("/public/v2/users/");
    private final String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }

}
