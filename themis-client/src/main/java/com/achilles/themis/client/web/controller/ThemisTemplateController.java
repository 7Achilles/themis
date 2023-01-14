package com.achilles.themis.client.web.controller;

import com.achilles.themis.client.web.qo.ThemisBaseQO;
import com.achilles.themis.client.vo.ThemisResponse;
import com.achilles.themis.command.service.ThemisChoreographyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/web/template")
public class ThemisTemplateController {


    @Resource
    private ThemisChoreographyService themisChoreographyService;


    @PostMapping(value = "/execute",produces = "application/json")
    @ResponseBody
    public ThemisResponse<String> execute(@RequestBody ThemisBaseQO qo) throws Exception {
        Long id = qo.getId();
        String result = themisChoreographyService.execute(id);
        return ThemisResponse.success(result);
    }



}
