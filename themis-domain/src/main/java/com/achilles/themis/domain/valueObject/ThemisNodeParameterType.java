package com.achilles.themis.domain.valueObject;

public enum ThemisNodeParameterType {

    HEADER("HEADER"), PARAMETER("PARAMETER"), BODY("PARAMETER");

    private final String type;

    ThemisNodeParameterType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
