package com.achilles.themis.domain.policy.interpreter;

import com.achilles.themis.domain.aggregate.ThemisChain;
import com.achilles.themis.domain.aggregate.ThemisTemplate;
import com.achilles.themis.domain.policy.condition.ThemisCondition;
import com.achilles.themis.domain.policy.operate.ql.ThemisSerialOperator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import java.util.ArrayList;

public class ThemisQLInterpreter implements ThemisInterpreter {

    private final ExpressRunner runner = new ExpressRunner();

    public ThemisQLInterpreter() {
        init();
    }

    public void init() {
        register();
    }

    private void register() {
        runner.addFunction("SERIAL", new ThemisSerialOperator());
    }

    @Override
    public ThemisChain express(ThemisTemplate template) throws Exception {
        DefaultContext<String, Object> context = buildContext(template);
        ThemisCondition condition = (ThemisCondition) runner.execute((String) template.getDsl(), context, new ArrayList<>(), true, true);
        return new ThemisChain(condition,template.getActuatorType(),template.getConfig());

    }

    private DefaultContext<String, Object> buildContext(ThemisTemplate template){
        DefaultContext<String, Object> context = new DefaultContext<>();
        template.getNodes().forEach(a -> context.put(a.getId(), a));
        return context;
    }



}
