package com.achilles.themis.domain.policy.operate.ql;

import com.achilles.themis.domain.policy.ThemisExecutable;
import com.achilles.themis.domain.policy.condition.ThemisSerialCondition;

public class ThemisSerialOperator extends ThemisBaseOperator<ThemisSerialCondition>{

    @Override
    public ThemisSerialCondition build(Object[] objects) throws Exception {
        ThemisSerialCondition themisSerialCondition = new ThemisSerialCondition();
        themisSerialCondition.setId(ThemisOperatorHelper.createUUID());
        for(Object o : objects){
            themisSerialCondition.addNode(ThemisOperatorHelper.convert(o, ThemisExecutable.class));
        }
        return themisSerialCondition;
    }

}
