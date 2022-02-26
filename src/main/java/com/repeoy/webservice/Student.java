package com.repeoy.webservice;

public class Student {
    private String fName;
    private String lName;
    private int number;
    private String address;
    private int opiskelijaID;


    public Student(String fName, String lName, int number, String address, int opiskelijaID) {
        this.fName = fName;
        this.lName = lName;
        this.number = number;
        this.address = address;
        this.opiskelijaID = opiskelijaID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public int getOpiskelijaID() { return opiskelijaID; } }