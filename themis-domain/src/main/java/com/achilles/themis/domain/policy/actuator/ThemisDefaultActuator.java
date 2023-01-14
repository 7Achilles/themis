package com.achilles.themis.domain.policy.actuator;

import com.achilles.themis.domain.aggregate.ThemisChain;
import com.achilles.themis.domain.valueObject.ThemisExecutableState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThemisDefaultActuator extends ThemisBaseActuator {

    private static final Logger logger = LoggerFactory.getLogger(ThemisDefaultActuator.class);

    private static final ThemisDefaultActuator INSTANCE = new ThemisDefaultActuator();

    private ThemisDefaultActuator() {
    }

    public static ThemisDefaultActuator getInstance() {
        return INSTANCE;
    }

    @Override
    public void before(ThemisChain chain) {
        chain.setState(ThemisExecutableState.RUNNING);
        logger.info(String.format("start execute pre chain id by %s",chain.getId()));
    }

    @Override
    public void after(ThemisChain chain) {
        chain.setState(ThemisExecutableState.SUCCESS);
        logger.info(String.format("start execute post chain id by %s",chain.getId()));
    }

    @Override
    public void throwException(ThemisChain chain,Exception exception) {
        chain.setState(ThemisExecutableState.ERROR);
        logger.info(String.format("start execute error chain id by %s",chain.getId()));
    }
}
