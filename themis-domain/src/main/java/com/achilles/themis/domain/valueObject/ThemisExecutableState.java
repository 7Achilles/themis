package com.achilles.themis.domain.valueObject;

public enum ThemisExecutableState {

    RUNNING("RUNNING"), INITIALIZE("INITIALIZE"), SUCCESS("SUCCESS"), ERROR("SUCCESS");

    private final String state;

    ThemisExecutableState(String state) {
        this.state = state;
    }

}
