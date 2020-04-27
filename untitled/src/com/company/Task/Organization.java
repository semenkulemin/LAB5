package com.company.Task;

import java.time.LocalDateTime;

public class Organization implements Comparable<Organization>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float annualTurnover; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address postalAddress; //Поле может быть null

    /*public Organization(String name, Coordinates coordinates, float annualTurnover, OrganizationType type, Address postalAddress){
        this.id = (long)(Math.abs(Math.random() * 1000000.0));
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = postalAddress;
    }*/
    public Organization(Long id, String name, Coordinates coordinates, float annualTurnover, OrganizationType type, Address postalAddress){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = postalAddress;
    }



    public Long getIdOfOrganization(){
        return id;
    }
    public String getNameOfOrganization(){
        return name;
    }
    public float getAnnualTurnover(){
        return annualTurnover;
    }
    public OrganizationType getType(){
        return type;
    }
    public Address getPostalAddress(){
        return postalAddress;
    }

    @Override
    public int compareTo(Organization anotherOrganization) {
        if(this.annualTurnover == anotherOrganization.getAnnualTurnover()){
            return 0;
        }
        else{
            if(this.annualTurnover > anotherOrganization.getAnnualTurnover()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

    @Override
    public String toString(){
        return "Org:" + " Id: " + id + " Name: " + name + " " + coordinates.toString() + " Data: " + creationDate + " AnnTurn: " + annualTurnover  + " Orgtype: " + type  + " " + postalAddress.toString();
    }
}