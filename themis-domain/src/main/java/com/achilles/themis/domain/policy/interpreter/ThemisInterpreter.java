package com.achilles.themis.domain.policy.interpreter;

import com.achilles.themis.domain.aggregate.ThemisChain;
import com.achilles.themis.domain.aggregate.ThemisTemplate;


public interface ThemisInterpreter{

    ThemisChain express(ThemisTemplate template) throws Exception;

}
