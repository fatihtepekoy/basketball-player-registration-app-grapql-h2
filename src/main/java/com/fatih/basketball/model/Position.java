package com.fatih.basketball.model;

public enum Position {
    PG("Point guard"),
    SG("Shooting guard"),
    SF("Small forward"),
    PF("Power forward"),
    C("Center");


    private final String desc;

    Position(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


}
