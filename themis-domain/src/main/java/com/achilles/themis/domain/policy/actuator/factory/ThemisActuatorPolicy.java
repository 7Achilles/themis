package com.achilles.themis.domain.policy.actuator.factory;

import com.achilles.themis.domain.policy.actuator.ThemisBaseActuator;
import com.achilles.themis.domain.policy.actuator.ThemisDefaultActuator;

public enum ThemisActuatorPolicy {

    DEFAULT("DEFAULT", ThemisDefaultActuator.getInstance());

    private final String type;

    private final ThemisBaseActuator actuator;

    ThemisActuatorPolicy(String type, ThemisBaseActuator actuator){
        this.type = type;
        this.actuator = actuator;
    }

    public String getType() {
        return type;
    }

    public ThemisBaseActuator getActuator() {
        return actuator;
    }
}
