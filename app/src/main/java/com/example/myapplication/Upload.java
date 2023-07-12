package com.example.myapplication;

public class Upload {

    String id;
    String date;
    String time;
    String nameString;
    String numberString;
    public Upload(String id,String date, String time,String nameString,String numberString) {
        this.date = date;
        this.time = time;
        this.nameString=nameString;
        this.numberString=numberString;
    }

    public String getNumberString() {
        return numberString;
    }

    public String getDate() {
        return date;
    }

    public String getNameString() {
        return nameString;
    }

    public String getTime() {
        return time;
    }

    public String getId(){
        return id;
    }
}
