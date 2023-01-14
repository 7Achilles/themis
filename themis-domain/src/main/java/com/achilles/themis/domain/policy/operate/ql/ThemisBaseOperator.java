package com.achilles.themis.domain.policy.operate.ql;

import com.achilles.themis.domain.policy.ThemisExecutable;
import com.ql.util.express.Operator;

public abstract class ThemisBaseOperator<T extends ThemisExecutable> extends Operator {

    @Override
    public T executeInner(Object[] objects) throws Exception {
        ThemisOperatorHelper.checkNodeExist(objects);
        return build(objects);
    }

    public abstract T build(Object[] objects) throws Exception;
}
