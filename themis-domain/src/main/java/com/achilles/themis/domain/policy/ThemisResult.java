package com.achilles.themis.domain.policy;

public interface ThemisResult<T> {

    T getResult();

    void setResult(T t);

}
