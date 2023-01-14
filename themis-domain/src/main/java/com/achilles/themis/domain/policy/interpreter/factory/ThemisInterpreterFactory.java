package com.achilles.themis.domain.policy.interpreter.factory;

import com.achilles.themis.domain.policy.interpreter.ThemisInterpreter;
import com.achilles.themis.domain.policy.interpreter.ThemisInterpreterHelper;
import com.achilles.themis.domain.policy.interpreter.ThemisQLInterpreter;
import com.achilles.themis.domain.valueObject.ThemisInterpreterType;

import java.util.HashMap;
import java.util.Map;

public class ThemisInterpreterFactory {

    private final Map<String, ThemisInterpreter> interpreters = new HashMap<>();

    private static final ThemisInterpreterFactory INSTANCE = new ThemisInterpreterFactory();

    private ThemisInterpreterFactory() {
        register();
    }

    private void register() {
        interpreters.put(ThemisInterpreterType.QL_INTERPRETER.getType(), new ThemisQLInterpreter());
    }

    public ThemisInterpreter getInterpreter(String type) {
        ThemisInterpreter interpreter = interpreters.get(type);
        ThemisInterpreterHelper.checkNullAble(interpreter);
        return interpreter;
    }

    public static ThemisInterpreterFactory getInstance() {
        return INSTANCE;
    }


}
