package com.achilles.themis.query.service.impl;


import com.achilles.themis.domain.aggregate.ThemisTemplate;
import com.achilles.themis.domain.repository.ThemisTemplateServiceRepository;
import com.achilles.themis.query.service.ThemisLogicQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ThemisLogicQueryImpl implements ThemisLogicQuery {

    @Resource
    private ThemisTemplateServiceRepository themisLogicTemplateServiceRepository;

    @Override
    public ThemisTemplate queryById(Long id) {
        return new ThemisTemplate();
    }


}
