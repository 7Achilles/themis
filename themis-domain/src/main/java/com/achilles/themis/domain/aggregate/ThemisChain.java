package com.achilles.themis.domain.aggregate;

import com.achilles.themis.domain.policy.ThemisExecutable;
import com.achilles.themis.domain.policy.actuator.ThemisActuator;
import com.achilles.themis.domain.policy.actuator.factory.ThemisActuatorFactory;
import com.achilles.themis.domain.policy.operate.ql.ThemisOperatorHelper;
import com.achilles.themis.domain.valueObject.ThemisChainContext;
import com.achilles.themis.domain.valueObject.ThemisExecutableState;
import com.achilles.themis.domain.valueObject.ThemisNodeParameterRelationalConfig;
import lombok.Data;


@Data
public class ThemisChain {

    private String id;
    private ThemisChainContext chainContext;
    private ThemisExecutable start;

    private ThemisExecutableState state = ThemisExecutableState.INITIALIZE;
    private ThemisActuator actuator;
    public ThemisChain(ThemisExecutable node, String actuatorType, ThemisNodeParameterRelationalConfig config) {
        id = ThemisOperatorHelper.createUUID();
        chainContext = new ThemisChainContext();
        chainContext.setParameterMap(config.getParameterMap());
        start = node;
        actuator = ThemisActuatorFactory.getInstance().getActuator(actuatorType);
    }

    public String start(){
        return run();
    }

    private String run(){
       return actuator.runTask(this);
    }

}
