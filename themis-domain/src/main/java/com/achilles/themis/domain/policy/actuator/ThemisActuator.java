package com.achilles.themis.domain.policy.actuator;

import com.achilles.themis.domain.aggregate.ThemisChain;

public interface ThemisActuator {

    String runTask(ThemisChain chain);

}
