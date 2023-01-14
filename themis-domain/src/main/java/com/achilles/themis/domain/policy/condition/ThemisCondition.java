package com.achilles.themis.domain.policy.condition;
import com.achilles.themis.domain.entity.ThemisBaseNode;
import com.achilles.themis.domain.policy.operate.ql.ThemisOperatorHelper;
import lombok.Data;


@Data

public abstract class ThemisCondition extends ThemisBaseNode {

    protected String id = ThemisOperatorHelper.createUUID();

}
