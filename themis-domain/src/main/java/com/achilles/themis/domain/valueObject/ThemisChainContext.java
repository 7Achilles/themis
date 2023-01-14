package com.achilles.themis.domain.valueObject;

import com.achilles.themis.domain.entity.ThemisAtomApi;
import com.achilles.themis.domain.entity.ThemisRestNode;
import com.achilles.themis.domain.policy.ThemisExecutable;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ThemisChainContext {
    Map<String, HashMap<String, List<ThemisNodeParameterRelational>>> parameterMap = new ConcurrentHashMap<>();

    Map<String, String> responseMap = new ConcurrentHashMap<>();

    public void addResponse(String id, String value) {
        responseMap.put(id, value);
    }

    public void checkAndPrepare(ThemisExecutable execute) {

        HashMap<String, List<ThemisNodeParameterRelational>> paramsMap = parameterMap.get(execute.getId());
        if (!Optional.ofNullable(paramsMap).isPresent()) return;

        Class<? extends ThemisExecutable> aClass = execute.getClass();
        if (aClass.equals(ThemisRestNode.class)) {
            ThemisRestNode restNode = (ThemisRestNode) execute;
            ThemisAtomApi atomApi = restNode.getAtomApi();
            Map<String, Object> parse = parse(paramsMap, responseMap);

            if (atomApi.getMethodType().equals(ThemisRestMethodType.GET)) {
                Map<String, String> parameter = atomApi.getParameter();
                parse.forEach((k, v) -> parameter.put(k, String.valueOf(v)));
            } else {
                String body = atomApi.getBody();
                JSONObject jsonObject = JSONObject.parseObject(body);
                jsonObject.putAll(parse);
                atomApi.setBody(JSONObject.toJSONString(jsonObject));
            }
        }
    }


    private Map<String, Object> parse(HashMap<String, List<ThemisNodeParameterRelational>> parameterMap, Map<String, String> responseMap) {
        Map<String, Object> map = new HashMap<>();
        parameterMap.forEach((k, v) -> {
            String res = responseMap.get(k);
            JSONObject jsonObject = JSONObject.parseObject(res);
            for (ThemisNodeParameterRelational relational : v) {
                String sourceField = relational.getSourceField();
                Object o = jsonObject.get(sourceField);
                if (Optional.ofNullable(o).isPresent()) {
                    map.put(relational.getFromField(), o);
                }
            }
        });
        return map;
    }
}
