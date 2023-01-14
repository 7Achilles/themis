package com.achilles.themis.domain.policy.actuator.factory;

import com.achilles.themis.domain.policy.actuator.ThemisActuator;
import org.springframework.lang.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ThemisActuatorFactory {

    Map<String, ThemisActuator> actuators = new HashMap<>();

    private static final ThemisActuatorFactory INSTANCE = new ThemisActuatorFactory();

    private ThemisActuatorFactory(){
        register();
    }

    private void register() {
        for(ThemisActuatorPolicy actuator : ThemisActuatorPolicy.values()){
            actuators.put(actuator.getType(),actuator.getActuator());
        }
    }

    public ThemisActuator getActuator(@Nullable String type) throws NullPointerException{
        if(!Optional.ofNullable(type).isPresent()) return actuators.get(ThemisActuatorPolicy.DEFAULT.getType());
        ThemisActuator actuate = actuators.get(type);
        if(Optional.ofNullable(actuate).isPresent()) return actuate;
        throw new NullPointerException("no match actuator, please check your type config!");
    }

    public static ThemisActuatorFactory getInstance(){
        return INSTANCE;
    }

}
