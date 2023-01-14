package com.achilles.themis.domain.entity;

import com.achilles.themis.domain.policy.ThemisExecutable;
import com.achilles.themis.domain.valueObject.ThemisChainContext;
import com.achilles.themis.domain.valueObject.ThemisExecutableState;
import lombok.Data;

@Data
public abstract class ThemisBaseNode implements ThemisExecutable, Cloneable {

    protected String id;

    protected ThemisExecutableState state = ThemisExecutableState.INITIALIZE;

    @Override
    public String execute(ThemisChainContext chainContext) throws Exception {
        before(chainContext);
        String execute = this.doExecute(chainContext);
        after(chainContext, execute);
        return execute;
    }

    protected abstract void before(ThemisChainContext chainContext) throws Exception;

    protected abstract void after(ThemisChainContext chainContext, String value) throws Exception;

    protected abstract String doExecute(ThemisChainContext chainContext) throws Exception;


    public ThemisBaseNode copy() throws Exception {
        return (ThemisBaseNode) super.clone();
    }


}
