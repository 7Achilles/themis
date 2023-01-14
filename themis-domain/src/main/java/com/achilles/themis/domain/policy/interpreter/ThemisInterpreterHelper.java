package com.achilles.themis.domain.policy.interpreter;

import java.util.Optional;

public class ThemisInterpreterHelper {


    public static void checkNullAble(Object o) throws NullPointerException{
        if(!Optional.ofNullable(o).isPresent()){
            throw new NullPointerException("the object is null,please check!");
        }
    }


}
