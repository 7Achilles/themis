package com.achilles.themis.domain.valueObject;

public enum ThemisRestMethodType {

    POST("POST"),GET("GET");

    private final String type;

    ThemisRestMethodType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
