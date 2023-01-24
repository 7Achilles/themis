package com.achilles.themis.command.service.impl;

import com.achilles.themis.command.service.ThemisChoreographyService;
import com.achilles.themis.domain.aggregate.ThemisChain;
import com.achilles.themis.domain.aggregate.ThemisTemplate;
import com.achilles.themis.domain.repository.ThemisTemplateServiceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class ThemisChoreographyServiceImpl implements ThemisChoreographyService {

    @Resource
    private ThemisTemplateServiceRepository themisLogicTemplateServiceRepository;

    @Override
    public String execute(Long id) throws Exception {
        ThemisTemplate template = themisLogicTemplateServiceRepository.queryById(id);
        ThemisChain chain = template.createChain();
        return chain.start();
    }



}
