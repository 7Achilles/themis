package com.achilles.themis.domain.policy.actuator;

import com.achilles.themis.domain.aggregate.ThemisChain;


public abstract class ThemisBaseActuator implements ThemisActuator{

    @Override
    public String runTask(ThemisChain chain){

        try {
            before(chain);
            String execute = chain.getStart().execute(chain.getChainContext());
            after(chain);
            return execute;
        } catch (Exception e) {
            throwException(chain,e);
            throw new RuntimeException(e);
        }

    }

    public abstract void before(ThemisChain chain) throws Exception;

    public abstract void after(ThemisChain chain) throws Exception;

    public abstract void throwException(ThemisChain chain,Exception exception);

}
