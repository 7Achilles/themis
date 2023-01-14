package com.achilles.themis.domain.policy.condition;

import com.achilles.themis.domain.policy.ThemisExecutable;
import com.achilles.themis.domain.valueObject.ThemisChainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

public class ThemisSerialCondition extends ThemisCondition {

    private static final Logger logger = LoggerFactory.getLogger(ThemisSerialCondition.class);

    private List<ThemisExecutable> nodes = new ArrayList<>();

    @Override
    protected void before(ThemisChainContext chainContext) {
        logger.info(String.format("start execute pre serial condition id by %s",getId()));
    }

    @Override
    protected void after(ThemisChainContext chainContext, String value) {
        logger.info(String.format("start execute post serial condition id by %s",getId()));
    }

    @Override
    protected String doExecute(ThemisChainContext chainContext) throws Exception {
        String execute = null;
        for (ThemisExecutable node : nodes) {
            execute = node.execute(chainContext);
        }
        return execute;
    }

    public void addNode(ThemisExecutable node) {
        nodes.add(node);
    }

}
