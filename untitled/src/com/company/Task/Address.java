package com.company.Task;

public class Address {
    private String street; //Поле может быть null
    private String zipCode; //Поле не может быть null

    public Address(String street, String zipCode){
        this.street=street;
        this.zipCode=zipCode;
    }

    public String getZipCode(){
        return zipCode;
    }

    public String toString(){
        return "Address: {" + street + ", " + zipCode + "}";
    }
}