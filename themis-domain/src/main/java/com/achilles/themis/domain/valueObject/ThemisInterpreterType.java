package com.achilles.themis.domain.valueObject;

public enum ThemisInterpreterType {

    QL_INTERPRETER("QL_INTERPRETER");

    private final String type;

    ThemisInterpreterType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}
