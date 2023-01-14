package com.achilles.themis.infrastructure.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.achilles.themis.domain.aggregate.ThemisTemplate;
import com.achilles.themis.domain.entity.ThemisRestNode;
import com.achilles.themis.domain.policy.ThemisExecutable;
import com.achilles.themis.domain.valueObject.ThemisInterpreterType;
import com.achilles.themis.domain.repository.ThemisTemplateServiceRepository;
import com.achilles.themis.domain.entity.ThemisAtomApi;
import com.achilles.themis.domain.valueObject.ThemisNodeParameterRelational;
import com.achilles.themis.domain.valueObject.ThemisNodeParameterRelationalConfig;
import com.achilles.themis.domain.valueObject.ThemisRestMethodType;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ThemisTemplateServiceRepositoryImpl implements ThemisTemplateServiceRepository {

    @Override
    public ThemisTemplate queryById(Long id) throws Exception {

        ThemisTemplate template = new ThemisTemplate();
        String dsl = "SERIAL(test1,test2,test3)";
        template.setDsl(dsl);
        template.setName("测试业务");
        template.setId(id);
        template.setInterpreterType(ThemisInterpreterType.QL_INTERPRETER.getType());


        List<ThemisExecutable> nodes = new ArrayList<>();

        ThemisAtomApi api1 = new ThemisAtomApi();
        Map<String,Long> b1 = new HashMap<>();
        b1.put("id",1L);
        api1.setBody(JSONObject.toJSONString(b1));
        api1.setMethodType(ThemisRestMethodType.POST);
        api1.setUrl("http://127.0.0.1:8097/flow/test/test1");
        ThemisRestNode test1 = new ThemisRestNode(api1);
        test1.setId("test1");


        ThemisAtomApi api2 = new ThemisAtomApi();
        Map<String,Long> b2 = new HashMap<>();
        api2.setBody(JSONObject.toJSONString(b2));
        api2.setMethodType(ThemisRestMethodType.POST);
        api2.setUrl("http://127.0.0.1:8097/flow/test/test2");
        ThemisRestNode test2 = new ThemisRestNode(api2);
        test2.setId("test2");


        ThemisAtomApi api3 = new ThemisAtomApi();
        Map<String,Long> b3 = new HashMap<>();
        api3.setBody(JSONObject.toJSONString(b3));
        api3.setMethodType(ThemisRestMethodType.GET);
        api3.setUrl("http://127.0.0.1:8097/flow/test/test3");
        ThemisRestNode test3 = new ThemisRestNode(api3);
        test3.setId("test3");

        nodes.add(test1);
        nodes.add(test2);
        nodes.add(test3);
        template.setNodes(nodes);

        Map<String, HashMap<String, List<ThemisNodeParameterRelational>>> parameterMap = new HashMap<>();
        HashMap<String, List<ThemisNodeParameterRelational>> m2 = new HashMap<>();
        List<ThemisNodeParameterRelational> l2 = new ArrayList<>();
        ThemisNodeParameterRelational r2 = new ThemisNodeParameterRelational();
        r2.setFromField("testId");
        r2.setSourceField("id");
        l2.add(r2);
        m2.put("test1",l2);
        parameterMap.put("test2",m2);

        HashMap<String, List<ThemisNodeParameterRelational>> m3 = new HashMap<>();
        List<ThemisNodeParameterRelational> l3 = new ArrayList<>();
        ThemisNodeParameterRelational r3 = new ThemisNodeParameterRelational();
        r3.setFromField("test2Id");
        r3.setSourceField("testId");
        l3.add(r3);
        m3.put("test2",l3);
        parameterMap.put("test3",m3);


        ThemisNodeParameterRelationalConfig config = new ThemisNodeParameterRelationalConfig();
        config.setParameterMap(parameterMap);
        template.setConfig(config);
        return template;
    }


}
