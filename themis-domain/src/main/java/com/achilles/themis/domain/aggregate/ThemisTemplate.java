package com.achilles.themis.domain.aggregate;

import com.achilles.themis.domain.policy.ThemisExecutable;

import com.achilles.themis.domain.policy.interpreter.ThemisInterpreter;
import com.achilles.themis.domain.policy.interpreter.factory.ThemisInterpreterFactory;
import com.achilles.themis.domain.valueObject.ThemisNodeParameterRelationalConfig;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ThemisTemplate {

    private Long id;

    private String name;

    private Object dsl;
    private String interpreterType;

    private String actuatorType;

    private List<ThemisExecutable> nodes = new ArrayList<>();

    private ThemisInterpreter interpreter;

    private ThemisNodeParameterRelationalConfig config;
    public ThemisChain createChain() throws Exception {
        setInterpreter();
        return interpreter.express(this);
    }

    public void setInterpreter(){
        this.interpreter = ThemisInterpreterFactory.getInstance().getInterpreter(this.interpreterType);
    }


}
