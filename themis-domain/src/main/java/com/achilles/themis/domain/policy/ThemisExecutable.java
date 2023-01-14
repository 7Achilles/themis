package com.achilles.themis.domain.policy;

import com.achilles.themis.domain.valueObject.ThemisChainContext;

public interface ThemisExecutable extends ThemisNode {

    String execute(ThemisChainContext chainContext) throws Exception;


}
