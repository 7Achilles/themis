package com.achilles.themis.domain.repository;


import com.achilles.themis.domain.aggregate.ThemisTemplate;

public interface ThemisTemplateServiceRepository {

    ThemisTemplate queryById(Long id) throws Exception;


}
