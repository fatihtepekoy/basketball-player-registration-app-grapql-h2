package com.fatih.basketball.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Position {
    PG("Point guard"),
    SG("Shooting guard"),
    SF("Small forward"),
    PF("Power forward"),
    C("Center");


    private String desc;

    Position(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


}
